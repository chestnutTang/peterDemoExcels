package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.BydjjgEntity;
import demo.third.com.exceldemo.service.entity.XszhEntity;
import demo.third.com.exceldemo.ui.views.CustomActionWebView;
import demo.third.com.exceldemo.utils.CustomGson;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Constant.DEFAULT_COUNT;
import static demo.third.com.exceldemo.utils.Link.BYDJJG;
import static demo.third.com.exceldemo.utils.Link.SEARCH_ZHGS;

/**
 * @author peter
 * 不予登记机构
 */
public class BydjjgActivity extends BaseWebActivity {

    @BindView(R.id.web_view)
    CustomActionWebView webView;
    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private String url,title;
    private XszhEntity xszhEntity;
    private BydjjgEntity bydjjgEntity;
    private String xszhContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView();
        getXszhData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_web_view;
    }

    @Override
    protected void bindView() {
        super.bindView();
        url = getIntent().getStringExtra("url");
        title = getIntent().getStringExtra("title");
        if(!TextUtils.isEmpty(title)){
            tvTitle.setText(title);
        }

    }


    private void getXszhData() {
        OkHttpUtils.post().url(url).addParams("pageIndex", "1")
                .addParams("pageSize", DEFAULT_COUNT+"")
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                // 销售账户公示
                if (SEARCH_ZHGS.equals(url)) {
                    xszhEntity = CustomGson.fromJson(response, XszhEntity.class);
                    if (xszhEntity != null && xszhEntity.getResult() != null) {
                        xszhContent = xszhEntity.getResult().getData().getContent();
                        if (!TextUtils.isEmpty(xszhContent)) {
                            initWebViewSetting(webView, xszhContent);
                        }
                    }
                }
                // 不予登记机构
                else if (BYDJJG.equals(url)) {
                    bydjjgEntity = CustomGson.fromJson(response, BydjjgEntity.class);
                    if (bydjjgEntity != null && bydjjgEntity.getResult() != null) {
                        xszhContent = bydjjgEntity.getResult().getData().getList().get(0).getContent();
                        if (!TextUtils.isEmpty(xszhContent)) {
                            initWebViewSetting(webView, xszhContent);
                        }
                    }
                }

            }
        });
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
