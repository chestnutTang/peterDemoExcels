package demo.third.com.exceldemo.activity;

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
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.fragment.ItemFragment;
import demo.third.com.exceldemo.fragment.TextFragment;
import demo.third.com.exceldemo.fragment.dummy.DummyContent;

/**
 * @author songzhengpeng
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
                break;
            case R.id.navigation_dashboard:
                message.setText(R.string.title_dashboard);
                text = "22222";
                switchFragmentText(text);
                break;
            case R.id.navigation_notifications:
                message.setText(R.string.title_notifications);
                switchFragmentText2();
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
}
