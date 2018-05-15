package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.presenter.ActionSelectListener;
import demo.third.com.exceldemo.ui.views.CustomActionWebView;
import demo.third.com.exceldemo.utils.Tools;

/**
 * @author peter
 */
public class MyWebActivity extends BaseWebActivity {


    @BindView(R.id.web_view)
    CustomActionWebView webView;
    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private List<String> menuList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_web_view;
    }

    @OnClick(R.id.iv_backup)
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            default:
                break;
        }

    }

    @Override
    protected void bindView() {
        super.bindView();
        tvTitle.setText(getResources().getString(R.string.txt_web_title));
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
