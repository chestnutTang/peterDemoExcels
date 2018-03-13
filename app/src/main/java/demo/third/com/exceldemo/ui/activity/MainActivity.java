package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import demo.third.com.exceldemo.BuildConfig;
import demo.third.com.exceldemo.ui.fragment.dummy.SettingFragment;
import demo.third.com.exceldemo.utils.Logger;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.presenter.BookPresenter;
import demo.third.com.exceldemo.service.view.BookView;
import demo.third.com.exceldemo.ui.fragment.ItemFragment;
import demo.third.com.exceldemo.ui.fragment.TextFragment;
import demo.third.com.exceldemo.ui.fragment.dummy.DummyContent;
import demo.third.com.exceldemo.service.entity.Book;
import demo.third.com.exceldemo.service.RetrofitService;
import demo.third.com.exceldemo.utils.Tools;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author peter
 */
public class MainActivity extends BaseActivity implements BottomNavigationView
        .OnNavigationItemSelectedListener, ItemFragment.OnListFragmentInteractionListener {

    @BindView(R.id.message)
    TextView message;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.container)
    RelativeLayout container;

    TextFragment textFragment;
    SettingFragment settingFragment;

    private Book book;

    private BookPresenter mBookPresenter = new BookPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBookPresenter.onStop();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void bindView() {
        super.bindView();
        navigation.setOnNavigationItemSelectedListener(this);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBookPresenter.getSearchBooks("金瓶梅", null, 0, 1);
            }
        });
        mBookPresenter.onCreate();
        mBookPresenter.attachView(mBookView);
    }

    private BookView mBookView = new BookView() {
        @Override
        public void onSuccess(Book mBook) {
            message.setText(mBook.getBooks().get(0).getAlt_title());
        }

        @Override
        public void onError(String result) {
            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                message.setText(R.string.title_home);
                //双击事件
                if (Tools.isFastDoubleClick()) {
                    Tools.toast("双击事件");
                } else {
                    Tools.toast("单击事件");
                }
                switchFragmentText(textFragment);
                break;
            case R.id.navigation_notifications:
                message.setText(R.string.title_notifications);
                switchFragmentText(settingFragment);
                break;
            default:
                break;
        }

        return true;
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        bindFragment();
    }

    private void bindFragment() {
        textFragment = new TextFragment();
        settingFragment = new SettingFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, textFragment);
        transaction.commit();


    }

    private void switchFragmentText(Fragment fragment) {
//        Tools.snackBar(container, "老铁双击666666", "好的");
        if (fragment instanceof TextFragment) {
            textFragment.setTextShow(MainActivity.this, "首页哦");
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction2 = fragmentManager.beginTransaction();
        transaction2.replace(R.id.container, fragment);
        transaction2.commit();


    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Tools.toast(item.content);
    }


    public void getHttpData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RxJava
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);

        Observable observable = service.getSearchBook("金瓶梅", null, 0, 1);
        observable.subscribeOn(Schedulers.io())//请求数据的事件发生在io线程
                .observeOn(AndroidSchedulers.mainThread())//请求完成后在主线程更显UI
                .subscribe(new Observer<Book>() {//订阅
                    @Override
                    public void onCompleted() {
                        //所有事件都完成，可以做些操作。。。
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace(); //请求过程中发生错误
                    }

                    @Override
                    public void onNext(Book book) {//这里的book就是我们请求接口返回的实体类
                        message.setText(book.getBooks().get(0).getAuthor_intro());
                        Logger.e("peter", (book.getBooks().get(0).getTags().toString()));
                    }
                });

//        Call<Book> call = service.getSearchBook("金瓶梅", null, 0, 1);
//        call.enqueue(new Callback<Book>() {
//            @Override
//            public void onResponse(Call<Book> call, Response<Book> response) {
//                Logger.e("song",response.body()+"");
//                book = response.body();
//                int size = book.getBooks().size();
//                for (int i = 0;i<size;i++){
//                    message.setText(book.getBooks().get(i).getTags().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Book> call, Throwable t) {
//
//            }
//        });
    }

}
