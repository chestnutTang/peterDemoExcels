package demo.third.com.exceldemo.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.SearchResultEntity;
import demo.third.com.exceldemo.ui.adapter.LandSpaceAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.ui.views.RadioGroupEx;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.Tools;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;
import static demo.third.com.exceldemo.utils.Link.CYJGGS;

/**
 * @author peter
 * 从业机构公示
 */
public class LandSpaceCyjggsActivity extends BaseActivity implements RadioGroupEx
        .OnCheckedChangeListener {


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
    private SearchResultEntity searchResultEntity;
    private SearchResultEntity.ResultBean resultBean;
    private LandSpaceAdapter infoAdapter;
    private String flag;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        progressDialog = initDialog(progressDialog, LandSpaceCyjggsActivity.this, "查询中...");
        searchZqgszgcp(flag);
    }

    @Override
    protected void initView() {
        super.initView();
        flag = getIntent().getStringExtra(INTENT_FLAG);
        if (!TextUtils.isEmpty(flag)) {
            tvTitle.setText(flag);
            switch (flag) {
                case "私募基金管理人分类公示":
                    break;
                case "基金管理公司":
                    tv2.setText(getResources().getString(R.string.tip_company_name));
                    tv3.setText(getResources().getString(R.string.txt_time_create));
                    tv4.setText(getResources().getString(R.string.tip_web));
                    tv5.setText(getResources().getString(R.string.title_lxdz));
                    tv6.setText(getResources().getString(R.string.txt_phone));
                    tv7.setText(getResources().getString(R.string.txt_xhhy));
                    break;
                case "基金托管人":
                    tv2.setText(getResources().getString(R.string.txt_tuo_name));
                    tv3.setText(getResources().getString(R.string.txt_sign_address));
                    tv4.setText(getResources().getString(R.string.btn_qdtgywzgsj));
                    tv5.setText(getResources().getString(R.string.tip_website));
                    tv6.setText(getResources().getString(R.string.btn_kf_phone));
                    tv7.setText("");
                    break;
                case "资产管理类机构":
                    tv2.setText(getResources().getString(R.string.txt_org_name));
                    tv3.setText(getResources().getString(R.string.txt_time_create));
                    tv4.setText(getResources().getString(R.string.tip_web));
                    tv5.setText(getResources().getString(R.string.title_lxdz));
                    tv6.setText(getResources().getString(R.string.txt_phone));
                    tv7.setText(getResources().getString(R.string.txt_xhhy));
                    break;
                case "基金销售机构":
                    tv2.setText(getResources().getString(R.string.btn_fund_comment_name));
                    tv3.setText(getResources().getString(R.string.btn_ywhzsj));
                    tv4.setText(getResources().getString(R.string.tip_web));
                    tv5.setText(getResources().getString(R.string.title_lxdz));
                    tv6.setText(getResources().getString(R.string.txt_phone));
                    tv7.setText(getResources().getString(R.string.txt_xhhy));
                    break;
                case "基金评价机构":
                    tv2.setText(getResources().getString(R.string.btn_fund_comment_name));
                    tv3.setText(getResources().getString(R.string.btn_ywhzsj));
                    tv4.setText(getResources().getString(R.string.tip_web));
                    tv5.setText(getResources().getString(R.string.title_lxdz));
                    tv6.setText(getResources().getString(R.string.txt_phone));
                    tv7.setText(getResources().getString(R.string.txt_xhhy));
                    break;
                case "支付结算机构":
                    tv2.setText(getResources().getString(R.string.btn_pay_org_name));
                    tv3.setText(getResources().getString(R.string.tip_basj));
                    tv4.setText(getResources().getString(R.string.tip_web));
                    tv5.setText(getResources().getString(R.string.title_lxdz));
                    tv6.setText(getResources().getString(R.string.txt_phone));
                    tv7.setText(getResources().getString(R.string.txt_xhhy));
                    break;
                case "律师事务所":
                    tv2.setText(getResources().getString(R.string.btn_lawyer_org_name));
                    tv3.setText(getResources().getString(R.string.txt_time_create));
                    tv4.setText(getResources().getString(R.string.tip_web));
                    tv5.setText(getResources().getString(R.string.title_lxdz));
                    tv6.setText(getResources().getString(R.string.txt_phone));
                    tv7.setText(getResources().getString(R.string.txt_xhhy));
                    break;
                case "会计师事务所":
                    tv2.setText(getResources().getString(R.string.btn_accountant_name));
                    tv3.setText(getResources().getString(R.string.txt_time_create));
                    tv4.setText(getResources().getString(R.string.tip_web));
                    tv5.setText(getResources().getString(R.string.title_lxdz));
                    tv6.setText(getResources().getString(R.string.txt_phone));
                    tv7.setText(getResources().getString(R.string.txt_xhhy));
                    break;
                case "信息技术系统服务机构":
                    tv2.setText(getResources().getString(R.string.btn_info_service_name));
                    tv3.setText(getResources().getString(R.string.txt_time_create));
                    tv4.setText(getResources().getString(R.string.tip_web));
                    tv5.setText(getResources().getString(R.string.title_lxdz));
                    tv6.setText(getResources().getString(R.string.txt_phone));
                    tv7.setText(getResources().getString(R.string.txt_xhhy));
                    break;
                case "证券公司私募投资基金":
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_landspace_cyjggs;
    }

    @OnClick({R.id.iv_backup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
//            case R.id.tv_search_all:
//                search(flag);
//                break;
//            // 清空条件
//            case R.id.tv_clear_condition:
//                clearAllCondition();
//                break;
//            // 搜索
//            case R.id.tv_search:
//                readySearch();
//                break;
            default:
                break;
        }
    }


    private void searchZqgszgcp(String workingState) {
        if (progressDialog != null) {
            progressDialog.show();
        }
        Map<String, String> params = new HashMap<>();
        params.put("pageIndex", "1");
        params.put("pageSize", "50");
        if (!TextUtils.isEmpty(workingState)) {
            params.put("workingState", workingState);
        }
        OkHttpUtils.get().url(CYJGGS).params(params)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if (progressDialog != null) {
                    progressDialog.cancel();
                }
            }

            @Override
            public void onResponse(String response, int id) {
                searchResultEntity = CustomGson.fromJson(response, SearchResultEntity.class);
                if (searchResultEntity != null) {
                    resultBean = searchResultEntity.getResult();
                    infoAdapter = new LandSpaceAdapter(LandSpaceCyjggsActivity.this, resultBean, flag);
                    lvPrivateFund.setAdapter(infoAdapter);
                    try {
                        if (resultBean.getPofSubfunds() == null || resultBean.getPofSubfunds().getList() == null
                                || resultBean.getPofSubfunds().getList().size() == 0) {
                            Tools.toast("暂无符合当前筛选条件的结果");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Tools.toast("暂无符合当前筛选条件的结果");
                    }
                    if (progressDialog != null) {
                        progressDialog.cancel();
                    }
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroupEx group, int checkedId) {
        RadioButton radioButton = findViewById(group.getCheckedRadioButtonId());
        switch (checkedId) {
            // 基金规模
            case R.id.rg_jjgm:
                break;
            // 提示事项
            case R.id.rg_tssx:
                break;
            // 诚信信息
            case R.id.rg_cxxx:
                break;
            default:
                break;
        }
    }
}
