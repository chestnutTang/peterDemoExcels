package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.webkit.WebView;

import butterknife.BindView;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.utils.Link;

/**
 *
 */
public class MyWebViewActivity extends WebViewBaseActivity {


    @BindView(R.id.web_view)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_web_view;
    }

    @Override
    protected void initView() {
        super.initView();
        initWebViewSetting(webView, Link.WEATHER);
    }
}
