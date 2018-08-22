package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.CyjggsEntity;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.JumpTools;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Link.CYJGGS;

/**
 * @author peter
 * 从业机构公示
 */
public class InstitutionalPubActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_fund_enterprise)
    TextView tvFundEnterprise;
    @BindView(R.id.tv_fund_person)
    TextView tvFundPerson;
    @BindView(R.id.tv_assets_org)
    TextView tvAssetsOrg;
    @BindView(R.id.tv_fund_sale)
    TextView tvFundSale;
    @BindView(R.id.tv_fund_comment)
    TextView tvFundComment;
    @BindView(R.id.tv_pay_org)
    TextView tvPayOrg;
    @BindView(R.id.tv_lawyer_org)
    TextView tvLawyerOrg;
    @BindView(R.id.tv_accountant)
    TextView tvAccountant;
    @BindView(R.id.tv_info_service)
    TextView tvInfoService;

    private CyjggsEntity cyjggsEntity;
    private String jjglgs, jjtgr, zcglljg, jjxsjg, jjpjjg, zfjsjg, lssws, kjssws, xxjsxtfwjg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        searchZqgszgcp();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_institutional_pub;
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText(getResources().getString(R.string.txt_org_pub));
    }

    @OnClick({R.id.iv_backup, R.id.tv_fund_enterprise, R.id.tv_fund_person, R.id.tv_assets_org, R
            .id.tv_fund_sale, R.id.tv_fund_comment, R.id.tv_pay_org, R.id.tv_lawyer_org, R.id
            .tv_accountant, R.id.tv_info_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            case R.id.tv_fund_enterprise:
                JumpTools.jumpWithUrl(this, MyWebLanspaceActivity.class, jjglgs, getResources().getString(R.string.btn_fund_enterprise));
                break;
            case R.id.tv_fund_person:
                JumpTools.jumpWithUrl(this, MyWebLanspaceActivity.class, jjtgr, getResources().getString(R.string.btn_fund_person));
                break;
            case R.id.tv_assets_org:
                JumpTools.jumpWithUrl(this, MyWebLanspaceActivity.class, zcglljg, getResources().getString(R.string.btn_assets_org));
                break;
            case R.id.tv_fund_sale:
                JumpTools.jumpWithUrl(this, MyWebLanspaceActivity.class, jjxsjg, getResources().getString(R.string.btn_fund_sale));
                break;
            case R.id.tv_fund_comment:
                JumpTools.jumpWithUrl(this, MyWebLanspaceActivity.class, jjpjjg, getResources().getString(R.string.btn_fund_comment));
                break;
            case R.id.tv_pay_org:
                JumpTools.jumpWithUrl(this, MyWebLanspaceActivity.class, zfjsjg, getResources().getString(R.string.btn_pay_org));
                break;
            case R.id.tv_lawyer_org:
                JumpTools.jumpWithUrl(this, MyWebLanspaceActivity.class, lssws, getResources().getString(R.string.btn_lawyer_org));
                break;
            case R.id.tv_accountant:
                JumpTools.jumpWithUrl(this, MyWebLanspaceActivity.class, kjssws, getResources().getString(R.string.btn_accountant));
                break;
            case R.id.tv_info_service:
                JumpTools.jumpWithUrl(this, MyWebLanspaceActivity.class, xxjsxtfwjg, getResources().getString(R.string.btn_info_service));
                break;
            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void searchZqgszgcp() {
        Map<String, String> params = new HashMap<>();
        params.put("pageIndex", "1");
        params.put("pageSize", "50");

        OkHttpUtils.get().url(CYJGGS).params(params)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {
                cyjggsEntity = CustomGson.fromJson(response, CyjggsEntity.class);
                if (cyjggsEntity != null) {
                    jjglgs = cyjggsEntity.getResult().getCYJGGSjjglgs();
                    jjtgr = cyjggsEntity.getResult().getCYJGGSjjtgr();
                    zcglljg = cyjggsEntity.getResult().getCYJGGSzcglljg();
                    jjxsjg = cyjggsEntity.getResult().getCYJGGSjjxsjg();
                    jjpjjg = cyjggsEntity.getResult().getCYJGGSjjpjjg();
                    zfjsjg = cyjggsEntity.getResult().getCYJGGSzfjsjg();
                    lssws = cyjggsEntity.getResult().getCYJGGSlssws();
                    kjssws = cyjggsEntity.getResult().getCYJGGShjsws();
                    xxjsxtfwjg = cyjggsEntity.getResult().getCYJGGSxxjsxtfwjg();
                }
            }
        });
    }
}
