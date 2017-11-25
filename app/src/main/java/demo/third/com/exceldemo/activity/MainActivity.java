package demo.third.com.exceldemo.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.fragment.TextFragment;

/**
 * @author songzhengpeng
 */
public class MainActivity extends BaseActivity implements BottomNavigationView
        .OnNavigationItemSelectedListener {

    @BindView(R.id.message)
    TextView message;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.container)
    RelativeLayout container;

    TextFragment textFragment;

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
        String text = "";
        switch (item.getItemId()) {
            case R.id.navigation_home:
                message.setText(R.string.title_home);
                text = "1111";
                break;
            case R.id.navigation_dashboard:
                message.setText(R.string.title_dashboard);
                text = "22222";
                break;
            case R.id.navigation_notifications:
                message.setText(R.string.title_notifications);
                text = "33333";
                break;
            default:
                break;
        }
        switchFragmentText(text);
        return true;
    }

    private void bindFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        textFragment = new TextFragment();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, textFragment);
        transaction.commit();
    }

    private void switchFragmentText(String text) {
        textFragment.setTextShow(text);
    }

}
