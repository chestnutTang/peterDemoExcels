package demo.third.com.exceldemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.ref.WeakReference;

import demo.third.com.exceldemo.BuildConfig;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.retrofit.Book;
import demo.third.com.exceldemo.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WelcomeActivity extends BaseActivity {

    private static final int KEY_SUCCESS = 1;

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
                        Intent intent = new Intent(welcomeActivity, MainActivity.class);
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
        handler.sendEmptyMessageDelayed(KEY_SUCCESS, 3000);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

}
