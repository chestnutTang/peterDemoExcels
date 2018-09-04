package demo.third.com.exceldemo.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.PrivateFundPublicEntity;
import demo.third.com.exceldemo.ui.adapter.PrivateSearchResultAdapter;
import demo.third.com.exceldemo.ui.views.AutoRefreshLayout;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.ui.views.RadioGroupEx;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.JumpTools;
import demo.third.com.exceldemo.utils.Tools;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Constant.DEFAULT_COUNT;
import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;
import static demo.third.com.exceldemo.utils.Link.POFMANAGER;
import static demo.third.com.exceldemo.utils.Link.SEARCH_POF;

/**
 * 私募基金公示
 *
 * @author peter
 */
public class PrivateFundActivity extends BaseActivity implements RadioGroupEx
        .OnCheckedChangeListener, SwipeRefreshLayout
        .OnRefreshListener,
        AutoRefreshLayout.OnLoadListener {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.iv_clear)
    ImageView ivClear;
    @BindView(R.id.ck_case_before)
    RadioButton ckCaseBefore;
    @BindView(R.id.ck_case_before2)
    RadioButton ckCaseBefore2;
    @BindView(R.id.ck_manage_entrust)
    RadioButton ckManageEntrust;
    @BindView(R.id.ck_manage_self)
    RadioButton ckManageSelf;
    @BindView(R.id.ck_manage_adviser)
    RadioButton ckManageAdviser;
    @BindView(R.id.ck_running)
    RadioButton ckRunning;
    @BindView(R.id.ck_liquidation_late)
    RadioButton ckLiquidationLate;
    @BindView(R.id.ck_liquidation_before)
    RadioButton ckLiquidationBefore;
    @BindView(R.id.ck_normal_liquidation)
    RadioButton ckNormalLiquidation;
    @BindView(R.id.ck_abnormal_liquidation)
    RadioButton ckAbnormalLiquidation;
    @BindView(R.id.ck_protocol_end)
    RadioButton ckProtocolEnd;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.tv_clear_condition)
    TextView tvClearCondition;
    @BindView(R.id.lv_private_fund)
    MyListView lvPrivateFund;
    @BindView(R.id.rg_beian)
    RadioGroupEx rgBeian;
    @BindView(R.id.rg_type)
    RadioGroupEx rgType;
    @BindView(R.id.rg_status)
    RadioGroupEx rgStatus;
    @BindView(R.id.refresh_lay)
    AutoRefreshLayout mAutoRefresh;

    private PrivateSearchResultAdapter resultAdapter;
    private PrivateFundPublicEntity searchResultEntity;
    private PrivateFundPublicEntity.ResultBean resultBean;

    private int putOnRecordPhase = -1;
    private String managerType, workingState;

    private ProgressDialog progressDialog;
    private String flag, url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        bindListener();
        progressDialog = initDialog(progressDialog, PrivateFundActivity.this, "查询中...");
    }

    @Override
    protected void initView() {
        super.initView();
        mAutoRefresh.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent);
        mAutoRefresh.setOnRefreshListener(this);
        mAutoRefresh.setOnLoadListener(this);
        flag = getIntent().getStringExtra(INTENT_FLAG);
        if (!TextUtils.isEmpty(flag)) {
            switch (flag) {
                case "私募基金管理人查询":
                    url = POFMANAGER;
                    break;
                case "私募基金公示":
                    url = SEARCH_POF;
                    break;
                default:
                    break;
            }
        }
        lvPrivateFund.setFocusable(false);
        etSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent
                        .ACTION_UP) {
                    //业务代码
                    search(etSearch.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_private_fund;
    }


    @Override
    protected void bindListener() {
        super.bindListener();
        rgBeian.setOnCheckedChangeListener(this);
        rgStatus.setOnCheckedChangeListener(this);
        rgType.setOnCheckedChangeListener(this);
        lvPrivateFund.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                JumpTools.jumpWithUrl(PrivateFundActivity.this, MyWebActivity.class
                        , searchResultEntity.getResult().getPofFunds().getList().get(position).getUrl()
                        , getResources().getString(R.string.txt_personal_pub_info));
            }
        });
    }

    @OnClick({R.id.iv_backup, R.id.iv_clear, R.id.tv_search, R.id.tv_clear_condition})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            case R.id.iv_clear:
                etSearch.setText("");
                break;
            case R.id.tv_search:
                search(etSearch.getText().toString());
                break;
            case R.id.tv_clear_condition:
                clearAllCheckbox();
                break;
            default:
                break;
        }
    }

    private void clearAllCheckbox() {

        List<RadioButton> list = new ArrayList<>();
        list.add(ckCaseBefore);
        list.add(ckCaseBefore2);
        list.add(ckManageEntrust);
        list.add(ckManageSelf);
        list.add(ckManageAdviser);
        list.add(ckRunning);
        list.add(ckLiquidationLate);
        list.add(ckLiquidationBefore);
        list.add(ckNormalLiquidation);
        list.add(ckAbnormalLiquidation);
        list.add(ckProtocolEnd);

        for (RadioButton view : list) {
            view.setChecked(false);
        }

        etSearch.setText("");
        putOnRecordPhase = -1;
        managerType = "";
        workingState = "";
    }

    @Override
    protected void search(final String searchCondition) {
        if (progressDialog != null) {
            progressDialog.show();
        }
        Map<String, String> params = new HashMap<>();
        params.put("pageIndex", "1");
        params.put("pageSize", DEFAULT_COUNT+"");
        if (!TextUtils.isEmpty(searchCondition)) {
            params.put("keyword", searchCondition);
        }
        if (putOnRecordPhase > -1) {
            params.put("putOnRecordPhase", putOnRecordPhase + "");
        }
        if (!TextUtils.isEmpty(managerType)) {
            params.put("managerType", managerType);
        }
        if (!TextUtils.isEmpty(workingState)) {
            params.put("workingState", workingState);
        }
        OkHttpUtils.post().url(url).params(params)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if (progressDialog != null) {
                    progressDialog.cancel();
                }
            }

            @Override
            public void onResponse(String response, int id) {
                searchResultEntity = CustomGson.fromJson(response, PrivateFundPublicEntity.class);
                if (searchResultEntity != null) {
                    Tools.forceHideSoftWare(PrivateFundActivity.this, etSearch);
                    resultBean = searchResultEntity.getResult();
                    if (resultBean != null) {
                        resultAdapter = new PrivateSearchResultAdapter(PrivateFundActivity.this, resultBean, flag);
                        lvPrivateFund.setAdapter(resultAdapter);
                        switch (flag) {
                            case "私募基金管理人查询":
                                if (resultBean.getPOFManagers() == null || resultBean.getPOFManagers().getList() == null
                                        || resultBean.getPOFManagers().getList().size() == 0) {
                                    Tools.toast("暂无符合当前筛选条件的结果");
                                }
                                break;
                            case "私募基金公示":
                                if (resultBean.getPofFunds() == null || resultBean.getPofFunds().getList() == null
                                        || resultBean.getPofFunds().getList().size() == 0) {
                                    Tools.toast("暂无符合当前筛选条件的结果");
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    if (progressDialog != null) {
                        progressDialog.cancel();
                    }
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (progressDialog != null) {
            progressDialog.cancel();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroupEx group, int checkedId) {
        RadioButton radioButton = findViewById(group.getCheckedRadioButtonId());
        switch (checkedId) {
            case R.id.ck_case_before:
                putOnRecordPhase = 0;
                break;
            case R.id.ck_case_before2:
                putOnRecordPhase = 1;
                break;
            case R.id.ck_manage_entrust:
            case R.id.ck_manage_self:
            case R.id.ck_manage_adviser:
                managerType = radioButton.getText().toString();
                break;
            case R.id.ck_running:
            case R.id.ck_liquidation_late:
            case R.id.ck_liquidation_before:
            case R.id.ck_normal_liquidation:
            case R.id.ck_abnormal_liquidation:
            case R.id.ck_protocol_end:
                workingState = radioButton.getText().toString();
                break;
            default:
                break;
        }
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoad() {

    }
}
