package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import demo.third.com.exceldemo.BuildConfig;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.fragment.ItemFragment;
import demo.third.com.exceldemo.ui.fragment.TextFragment;
import demo.third.com.exceldemo.ui.fragment.dummy.DummyContent;
import demo.third.com.exceldemo.service.entity.Book;
import demo.third.com.exceldemo.service.RetrofitService;
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
    ItemFragment itemFragment;

    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView();
        bindFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void bindView() {
        super.bindView();
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        String text;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                message.setText(R.string.title_home);
                text = "1111";
                switchFragmentText(text);
                getHttpData();
                break;
            case R.id.navigation_dashboard:
                message.setText(R.string.title_dashboard);
                text = "22222";
                switchFragmentText(text);
                getHttpData();
                break;
            case R.id.navigation_notifications:
                message.setText(R.string.title_notifications);
                switchFragmentText2();
                getHttpData();
                break;
            default:
                break;
        }

        return true;
    }

    private void bindFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        textFragment = new TextFragment();
        itemFragment = new ItemFragment();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, textFragment);
        transaction.commit();

        FragmentTransaction transaction2 = fragmentManager.beginTransaction();
        transaction2.replace(R.id.container, itemFragment);
        transaction2.commit();
    }

    private void switchFragmentText(String text) {
        textFragment.setTextShow(text);
        Toast.makeText(getApplicationContext(), "哈哈哈", Toast.LENGTH_SHORT).show();
    }

    private void switchFragmentText2() {
        Toast.makeText(getApplicationContext(), "123123", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Toast.makeText(getApplicationContext(), item.content, Toast.LENGTH_SHORT).show();
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
                                   message.setText(book.getBooks().get(0).getTags().toString());
                               }
                           });

//        Call<Book> call = service.getSearchBook("金瓶梅", null, 0, 1);
//        call.enqueue(new Callback<Book>() {
//            @Override
//            public void onResponse(Call<Book> call, Response<Book> response) {
//                Log.e("song",response.body()+"");
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
