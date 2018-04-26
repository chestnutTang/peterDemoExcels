package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.Book;
import demo.third.com.exceldemo.service.presenter.BookPresenter;
import demo.third.com.exceldemo.service.view.BookView;
import demo.third.com.exceldemo.ui.fragment.DummyContent;
import demo.third.com.exceldemo.ui.fragment.ItemFragment;
import demo.third.com.exceldemo.ui.fragment.SettingFragment;
import demo.third.com.exceldemo.ui.fragment.TextFragment;
import demo.third.com.exceldemo.utils.Tools;

import static demo.third.com.exceldemo.utils.Tools.logoutSystem;

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
        switchFragmentText(0);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
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
                switchFragmentText(0);
                break;
            case R.id.navigation_notifications:
                message.setText(R.string.title_notifications);
                switchFragmentText(1);
                break;
            default:
                break;
        }

        return true;
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
//        bindFragment();
    }

    private void bindFragment() {
        textFragment = new TextFragment();
        settingFragment = new SettingFragment();

        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container, textFragment);
        transaction.commit();


    }

    private void switchFragmentText(int i) {
//        if (fragment instanceof TextFragment) {
//            textFragment.setTextShow(MainActivity.this, "首页哦");
//        }

        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        //开始之前隐藏所有的fragment
        hideFragment(transaction);

        switch (i) {
            case 0:
                if (textFragment == null) {
                    textFragment = new TextFragment();
                    transaction.add(R.id.container, textFragment);
                } else {
                    transaction.show(textFragment);
                }
                break;
            case 1:
                if (settingFragment == null) {
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.container, settingFragment);
                } else {
                    transaction.show(settingFragment);
                }
                break;
            default:
                break;
        }

//        if (fragment != null) {
//            transaction.show(fragment);
//        }
//
//        if (fragment instanceof  TextFragment){
//            transaction.add(R.id.container, fragment);
//        }

//        transaction.add(R.id.container, fragment);
//        transaction.show(fragment);
        transaction.commit();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction transaction2 = fragmentManager.beginTransaction();
//        transaction2.replace(R.id.container, fragment);
//        transaction2.commit();


    }

    private void hideFragment(android.app.FragmentTransaction fragmentTransaction) {
        if (textFragment != null) {
            fragmentTransaction.hide(textFragment);
        }
        if (settingFragment != null) {
            fragmentTransaction.hide(settingFragment);
        }
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Tools.toast(item.content);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        logoutSystem(this);
    }

}
