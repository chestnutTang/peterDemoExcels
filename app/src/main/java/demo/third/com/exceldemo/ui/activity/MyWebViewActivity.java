package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.presenter.ActionSelectListener;
import demo.third.com.exceldemo.ui.views.CustomActionWebView;
import demo.third.com.exceldemo.utils.Tools;

/**
 * @author songzhengpeng
 */
public class MyWebViewActivity extends WebViewBaseActivity {


    @BindView(R.id.web_view)
    CustomActionWebView webView;

    private List<String> menuList = new ArrayList<>();


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
        url = getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(url)) {
            initWebViewSetting(webView, url);
        }
        webView.setActionSelectListener(new ActionSelectListener() {
            @Override
            public void onClick(String title, String selectText) {
                Tools.toast(title + "\n" + selectText);
            }
        });
        menuList.add("111");
        menuList.add("222");
        menuList.add("333");
        webView.setActionList(menuList);
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
    }
}
