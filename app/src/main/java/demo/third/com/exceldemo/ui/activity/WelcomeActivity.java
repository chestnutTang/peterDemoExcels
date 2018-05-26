package demo.third.com.exceldemo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.utils.MyTimer;

/**
 * 欢迎页
 *
 * @author songzhengpeng
 */
public class WelcomeActivity extends BaseActivity {

    private static final int KEY_SUCCESS = 1;
    private MyTimer time;
    @BindView(R.id.tv_jump_welcome)
    TextView tvJumpWelcome;


    @OnClick(R.id.tv_jump_welcome)
    public void onViewClicked() {
        handler.removeMessages(KEY_SUCCESS);
        //跳过当前页面
        handler.sendEmptyMessage(KEY_SUCCESS);
    }

    static class MyHandler extends Handler {
        WeakReference<WelcomeActivity> welcomeActivityWeakReference;
        Activity activity = null;

        MyHandler(WelcomeActivity activity) {
            welcomeActivityWeakReference = new WeakReference<>(activity);
            this.activity = activity;
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            WelcomeActivity welcomeActivity = welcomeActivityWeakReference.get();
            if (welcomeActivity != null) {
                switch (msg.what) {
                    case KEY_SUCCESS:
                        Intent intent = new Intent(welcomeActivity, LoginActivity.class);
                        welcomeActivity.startActivity(intent);
                        welcomeActivity.finish();
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private MyHandler handler = new MyHandler(WelcomeActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler.sendEmptyMessageDelayed(KEY_SUCCESS, 1000);
        time = new MyTimer(3 * 1000, 1000, tvJumpWelcome);
        time.start();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

}
