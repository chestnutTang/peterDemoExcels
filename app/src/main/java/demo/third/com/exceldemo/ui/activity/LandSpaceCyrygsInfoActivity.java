package demo.third.com.exceldemo.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.CyrygsEntity;
import demo.third.com.exceldemo.ui.adapter.LandSpaceCyrygsAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.utils.Logger;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;
import static demo.third.com.exceldemo.utils.Link.SEARCHPERSONRPI;

/**
 * @author peter
 * 从业人员公示人员信息
 */
public class LandSpaceCyrygsInfoActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.tv_3)
    TextView tv3;
    @BindView(R.id.tv_4)
    TextView tv4;
    @BindView(R.id.tv_5)
    TextView tv5;
    @BindView(R.id.tv_6)
    TextView tv6;
    @BindView(R.id.tv_7)
    TextView tv7;
    @BindView(R.id.ll_red2)
    LinearLayout llRed2;
    @BindView(R.id.lv_private_fund)
    MyListView lvPrivateFund;

    private LandSpaceCyrygsAdapter infoAdapter;
    private String flag;
    private ProgressDialog progressDialog;
    private CyrygsEntity cyrygsEntity;
    private CyrygsEntity.ResultBean resultBean;
    private String aoiName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        getCyryInfo(aoiName);
    }

    @Override
    protected void initView() {
        super.initView();
        progressDialog = initDialog(progressDialog, LandSpaceCyrygsInfoActivity.this, "查询中...");
        aoiName = getIntent().getStringExtra(INTENT_FLAG);
        flag = getIntent().getStringExtra(INTENT_FLAG);
        if (!TextUtils.isEmpty(flag)) {
            tvTitle.setText(flag);
        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_cyrygs_info;
    }

    @OnClick({R.id.iv_backup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            default:
                break;
        }
    }

    private void getCyryInfo(String aoiName) {
        OkHttpUtils.post().url(SEARCHPERSONRPI).addParams("aoiName", aoiName)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Logger.e("niubi",response);
            }
        });
    }

}
