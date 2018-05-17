package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;

/**
 * @author songzhengpeng
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
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
                break;
            case R.id.tv_fund_person:
                break;
            case R.id.tv_assets_org:
                break;
            case R.id.tv_fund_sale:
                break;
            case R.id.tv_fund_comment:
                break;
            case R.id.tv_pay_org:
                break;
            case R.id.tv_lawyer_org:
                break;
            case R.id.tv_accountant:
                break;
            case R.id.tv_info_service:
                break;
            default:
                break;
        }
    }
}
