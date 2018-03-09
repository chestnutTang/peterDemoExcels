package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.webkit.WebView;

import butterknife.BindView;
import demo.third.com.exceldemo.R;

public class MyWebViewActivity extends BaseActivity {

    @BindView(R.id.mSuperSafeWebView)
    WebView mSuperSafeWebView;

    private boolean mSafeBrowsingIsInitialized;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSuperSafeWebView.setWebViewClient(new MyWebViewClient());
        mSafeBrowsingIsInitialized = false;
//        mSuperSafeWebView.startSafeBrowsing(this, new ValueCallback<Boolean>() {
//            @Override
//            public void onReceiveValue(Boolean aBoolean) {
//                mSafeBrowsingIsInitialized = true;
//                if (!aBoolean){
//                    Logger.e("MY_APP_TAG", "Unable to initialize Safe Browsing!");
////                    BaseActivity.showCustomSnackbar(mSuperSafeWebView, "", "OK");
//                    Toast.makeText(getApplicationContext(),"Unable to initialize Safe Browsing!.",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_web_view;
    }
}
