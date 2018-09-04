package demo.third.com.exceldemo.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
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
        .OnCheckedChangeListener {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.iv_clear)
    ImageView ivClear;

    RadioButton ckCaseBefore;
    RadioButton ckCaseBefore2;
    RadioButton ckManageEntrust;
    RadioButton ckManageSelf;
    RadioButton ckManageAdviser;
    RadioButton ckRunning;
    RadioButton ckLiquidationLate;
    RadioButton ckLiquidationBefore;
    RadioButton ckNormalLiquidation;
    RadioButton ckAbnormalLiquidation;
    RadioButton ckProtocolEnd;
    TextView tvSearch;
    TextView tvClearCondition;
    @BindView(R.id.lv_private_fund)
    ListView lvPrivateFund;
    RadioGroupEx rgBeian;
    RadioGroupEx rgType;
    RadioGroupEx rgStatus;
    @BindView(R.id.refresh_lay)
    SmartRefreshLayout mAutoRefresh;

    private PrivateSearchResultAdapter resultAdapter;
    private PrivateFundPublicEntity searchResultEntity;
    private PrivateFundPublicEntity.ResultBean resultBean;

    private int putOnRecordPhase = -1;
    private String managerType, workingState;

    private ProgressDialog progressDialog;
    private String flag, url;
    private int page = 1;
    private View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initHeader();
        initView();
        bindListener();
        progressDialog = initDialog(progressDialog, PrivateFundActivity.this, "查询中...");
    }

    private void initHeader() {
        resultAdapter = new PrivateSearchResultAdapter(PrivateFundActivity.this, null, flag);
        headerView = LayoutInflater.from(this).inflate(R.layout.header_private_fund, null);
        if (headerView != null)
            lvPrivateFund.addHeaderView(headerView);
        lvPrivateFund.setAdapter(resultAdapter);
    }

    @Override
    protected void initView() {
        super.initView();
        tvSearch = headerView.findViewById(R.id.tv_search);
        ckCaseBefore = headerView.findViewById(R.id.ck_case_before);
        ckCaseBefore2 = headerView.findViewById(R.id.ck_case_before2);
        ckManageEntrust = headerView.findViewById(R.id.ck_manage_entrust);
        ckManageSelf = headerView.findViewById(R.id.ck_manage_self);
        ckManageAdviser = headerView.findViewById(R.id.ck_manage_adviser);
        ckRunning = headerView.findViewById(R.id.ck_running);
        ckLiquidationLate = headerView.findViewById(R.id.ck_liquidation_late);
        ckLiquidationBefore = headerView.findViewById(R.id.ck_liquidation_before);
        ckNormalLiquidation = headerView.findViewById(R.id.ck_normal_liquidation);
        ckAbnormalLiquidation = headerView.findViewById(R.id.ck_abnormal_liquidation);
        ckProtocolEnd = headerView.findViewById(R.id.ck_protocol_end);
        tvClearCondition = headerView.findViewById(R.id.tv_clear_condition);
        rgBeian = headerView.findViewById(R.id.rg_beian);
        rgType = headerView.findViewById(R.id.rg_type);
        rgStatus = headerView.findViewById(R.id.rg_status);


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
        Tools.initAutoRefresh(PrivateFundActivity.this, mAutoRefresh, true);
        mAutoRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                search(etSearch.getText().toString(), 1);
                refreshLayout.finishRefresh(0);
            }
        });
        mAutoRefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                search(etSearch.getText().toString(), page);
                refreshLayout.finishLoadMore(0);
            }
        });
        lvPrivateFund.setFocusable(false);
        etSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent
                        .ACTION_UP) {
                    //业务代码
                    search(etSearch.getText().toString(), 1);
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
        tvSearch.setOnClickListener(this);
        tvClearCondition.setOnClickListener(this);
        rgBeian.setOnCheckedChangeListener(this);
        rgStatus.setOnCheckedChangeListener(this);
        rgType.setOnCheckedChangeListener(this);
        lvPrivateFund.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                JumpTools.jumpWithUrl(PrivateFundActivity.this, MyWebActivity.class
                        , searchResultEntity.getResult().getPofFunds().getList().get(position % DEFAULT_COUNT - 1).getUrl()
                        , searchResultEntity.getResult().getPofFunds().getList().get(position % DEFAULT_COUNT - 1).getFundName());
            }
        });
    }

    @OnClick({R.id.iv_backup, R.id.iv_clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            case R.id.iv_clear:
                etSearch.setText("");
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_search:
                search(etSearch.getText().toString(), 1);
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

    protected void search(final String searchCondition, final int page) {
        if (page == 1) {
            if (progressDialog != null && !progressDialog.isShowing()) {
                progressDialog.show();
            }
        }

        Map<String, String> params = new HashMap<>();
        params.put("pageIndex", page + "");
        params.put("pageSize", DEFAULT_COUNT + "");
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

                        if (page == 1) {
                            resultAdapter = new PrivateSearchResultAdapter(PrivateFundActivity.this, resultBean, flag);
                            lvPrivateFund.setAdapter(resultAdapter);
                        } else {
                            resultAdapter.addData(resultBean.getPofFunds().getList());
                        }


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
}
