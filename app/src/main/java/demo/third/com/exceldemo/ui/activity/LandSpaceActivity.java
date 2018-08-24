package demo.third.com.exceldemo.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.BuildConfig;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.RetrofitHelper;
import demo.third.com.exceldemo.service.entity.SearchResultEntity;
import demo.third.com.exceldemo.ui.adapter.LandSpaceAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.ui.views.RadioGroupEx;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.JumpTools;
import demo.third.com.exceldemo.utils.Tools;
import okhttp3.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;
import static demo.third.com.exceldemo.utils.Link.POFMANAGER;
import static demo.third.com.exceldemo.utils.Link.SEARCH_POF_SUBFUND;

/**
 * @author peter
 */
public class LandSpaceActivity extends BaseActivity implements RadioGroupEx
        .OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ck_smzqjjzzfx)
    RadioButton ckSmzqjjzzfx;
    @BindView(R.id.ck_smzqjjgwgl)
    RadioButton ckSmzqjjgwgl;
    @BindView(R.id.ck_smgqjj)
    RadioButton ckSmgqjj;
    @BindView(R.id.ck_cytzzj)
    RadioButton ckCytzzj;
    @BindView(R.id.ck_smgqjj2)
    RadioButton ckSmgqjj2;
    @BindView(R.id.ck_scale_0)
    RadioButton ckScale0;
    @BindView(R.id.ck_scale_0_than)
    RadioButton ckScale0Than;
    @BindView(R.id.ck_low_capital)
    RadioButton ckLowCapital;
    @BindView(R.id.ck_low_100w)
    RadioButton ckLow100w;
    @BindView(R.id.ck_abnormal_liquidation)
    RadioButton ckAbnormalLiquidation;
    @BindView(R.id.ck_sljg)
    RadioButton ckSljg;
    @BindView(R.id.ck_ycjg)
    RadioButton ckYcjg;
    @BindView(R.id.ck_xjtb)
    RadioButton ckXjtb;
    @BindView(R.id.ck_zdyl)
    RadioButton ckZdyl;
    @BindView(R.id.ck_wfbtdx)
    RadioButton ckWfbtdx;
    @BindView(R.id.ck_xgztczblcxjl)
    RadioButton ckXgztczblcxjl;
    @BindView(R.id.tv_search_all)
    TextView tvSearchAll;
    @BindView(R.id.ll_search_all)
    LinearLayout ll_search_all;
    @BindView(R.id.tv_clear_condition)
    TextView tvClearCondition;
    @BindView(R.id.lv_private_fund)
    MyListView lvPrivateFund;
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
    @BindView(R.id.ll_condition1)
    LinearLayout llCondition1;
    @BindView(R.id.ll_condition2)
    LinearLayout llCondition2;
    @BindView(R.id.ll_condition3)
    LinearLayout llCondition3;
    @BindView(R.id.rg_jjgm)
    RadioGroupEx rgJjgm;
    @BindView(R.id.rg_tssx)
    RadioGroupEx rgTssx;
    @BindView(R.id.rg_cxxx)
    RadioGroupEx rgCxxx;
    @BindView(R.id.ll_top1)
    LinearLayout llTop1;
    @BindView(R.id.et_pro_name)
    EditText etProName;
    @BindView(R.id.tv_title2)
    TextView tvTitle2;
    @BindView(R.id.et_manage_org)
    EditText etManageOrg;
    @BindView(R.id.et_pro_number)
    EditText etProNumber;
    @BindView(R.id.tv_time1)
    TextView tvTime1;
    @BindView(R.id.tv_time2)
    TextView tvTime2;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.ll_top2)
    LinearLayout llTop2;
    @BindView(R.id.ll_red1)
    LinearLayout llRed1;
    @BindView(R.id.ll_red2)
    LinearLayout llRed2;
    @BindView(R.id.sp_zzfx)
    Spinner spZzfx;
    @BindView(R.id.sp_gwgl)
    Spinner spGwgl;
    @BindView(R.id.sp_smgqjj)
    Spinner spSmgqjj;
    @BindView(R.id.sp_cytzjj)
    Spinner spCytzjj;
    @BindView(R.id.sp_qtsmjj)
    Spinner spQtsmjj;
    @BindView(R.id.scroll_view)
    ScrollView scroll_view;

    private SearchResultEntity searchResultEntity;
    private SearchResultEntity.ResultBean resultBean;
    private LandSpaceAdapter infoAdapter;
    private String flag;
    private ProgressDialog progressDialog;
    private String fundType;
    private ArrayList<String> waringTipsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        progressDialog = initDialog(progressDialog, LandSpaceActivity.this, "查询中...");
        bindListener();
    }

    @Override
    protected void initView() {
        super.initView();
//        scroll_view.scrollTo(0,0);
        flag = getIntent().getStringExtra(INTENT_FLAG);
        if (!TextUtils.isEmpty(flag)) {
            tvTitle.setText(flag);
            if (getResources().getString(R.string.tip_smjjglrflgs).equals(flag)) {
                // 私募基金管理人分类公示
                llTop1.setVisibility(View.VISIBLE);
                llRed1.setVisibility(View.VISIBLE);
                llTop2.setVisibility(View.GONE);
                llRed2.setVisibility(View.GONE);
                search("");
            } else if (getResources().getString(R.string.txt_private_fund).equals(flag)) {
                // 证券公司私募投资基金
                llTop1.setVisibility(View.GONE);
                llRed1.setVisibility(View.GONE);
                llTop2.setVisibility(View.VISIBLE);
                llRed2.setVisibility(View.VISIBLE);

            } else {
                llTop1.setVisibility(View.VISIBLE);
                llRed1.setVisibility(View.VISIBLE);
                llTop2.setVisibility(View.GONE);
                llRed2.setVisibility(View.GONE);
                search("");
            }
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
        initSpinner();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_landspace;
    }

    @Override
    protected void bindListener() {
        super.bindListener();
        rgCxxx.setOnCheckedChangeListener(this);
        rgJjgm.setOnCheckedChangeListener(this);
        rgTssx.setOnCheckedChangeListener(this);
        etProName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent
                        .ACTION_UP) {
                    //业务代码
                    readySearch();
                    return true;
                }
                return false;
            }
        });
        etProNumber.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent
                        .ACTION_UP) {
                    //业务代码
                    readySearch();
                    return true;
                }
                return false;
            }
        });
        etManageOrg.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent
                        .ACTION_UP) {
                    //业务代码
                    readySearch();
                    return true;
                }
                return false;
            }
        });
        lvPrivateFund.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = "";
                switch (flag) {
                    case "证券公司私募投资基金":
                        url = resultBean.getPofSubfunds().getList().get(position).getUrl();
                        if (!TextUtils.isEmpty(url)) {
                            JumpTools.jumpWithUrl(LandSpaceActivity.this, MyWebActivity.class, url
                                    , getResources().getString(R.string.txt_direct_fund));
                        }
                        break;
                    case "私募基金管理人分类公示":
                        long pofMangerId = resultBean.getPOFManagers().getList().get(position).getId();
                        JumpTools.jumpWithdFlag(LandSpaceActivity.this, PrivateFundInfoActivity
                                .class, String.valueOf(pofMangerId));
                        break;
                    default:
                        break;
                }

            }
        });
    }

    private void initSpinner() {
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.sp_zzfx, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.sp_gwgl, R.layout.spinner_item);
        adapter2.setDropDownViewResource(R.layout.spinner_item);

        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.sp_smgqjj, R.layout.spinner_item);
        adapter3.setDropDownViewResource(R.layout.spinner_item);

        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(this, R.array.sp_cytzjj, R.layout.spinner_item);
        adapter4.setDropDownViewResource(R.layout.spinner_item);

        ArrayAdapter adapter5 = ArrayAdapter.createFromResource(this, R.array.sp_qtsmjj, R.layout.spinner_item);
        adapter5.setDropDownViewResource(R.layout.spinner_item);

        // 设置Spinner数据来源适配器
        spZzfx.setAdapter(adapter);
        spGwgl.setAdapter(adapter2);
        spSmgqjj.setAdapter(adapter3);
        spCytzjj.setAdapter(adapter4);
        spQtsmjj.setAdapter(adapter5);

        spZzfx.setOnItemSelectedListener(this);
        spGwgl.setOnItemSelectedListener(this);
        spSmgqjj.setOnItemSelectedListener(this);
        spCytzjj.setOnItemSelectedListener(this);
        spQtsmjj.setOnItemSelectedListener(this);
    }

    @Override
    protected void search(final String searchCondition) {
        Map<String, String> params = new HashMap<>();
        JSONObject object = null;
        try {
            object = new JSONObject();
            object.put("primaryInvestType", flag);
            object.put("keyword", searchCondition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        params.put("pageIndex", "1");
        params.put("pageSize", "50");
        params.put("query", object.toString());
        OkHttpUtils.post().url(POFMANAGER).params(params)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                searchResultEntity = CustomGson.fromJson(response, SearchResultEntity.class);
                if (searchResultEntity != null) {
                    resultBean = searchResultEntity.getResult();
                    infoAdapter = new LandSpaceAdapter(LandSpaceActivity.this, resultBean, flag);
                    lvPrivateFund.setAdapter(infoAdapter);
                }
            }
        });
    }

    @OnClick({R.id.iv_backup, R.id.tv_search_all, R.id.tv_clear_condition, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            case R.id.tv_search_all:
//                search(flag);
                JumpTools.jumpWithdFlag(LandSpaceActivity.this, SearchResultActivity.class, getResources().getString(R.string.tip_per_search_));
                break;
            // 清空条件
            case R.id.tv_clear_condition:
                clearAllCondition();
                break;
            // 搜索
            case R.id.tv_search:
                readySearch();
                break;
            default:
                break;
        }
    }

    private void searchPeople(JSONObject object) {
        if (progressDialog != null) {
            progressDialog.show();
        }
        Map<String, Object> params = new HashMap<>();
        params.put("pageIndex", "1");
        params.put("pageSize", "50");
        params.put("query", object);
        RetrofitHelper.getInstance(this).baseUrl(BuildConfig.HOST)
                .searchSmjjglrfl(POFMANAGER, params)
                .enqueue(new Callback<SearchResultEntity>() {
                    @Override
                    public void onResponse(retrofit2.Call<SearchResultEntity> call, Response<SearchResultEntity> response) {
                        searchResultEntity = response.body();
                        if (searchResultEntity != null) {
                            resultBean = searchResultEntity.getResult();
                            infoAdapter = new LandSpaceAdapter(LandSpaceActivity.this, resultBean, flag);
                            lvPrivateFund.setAdapter(infoAdapter);
                            try {
                                if (resultBean.getPOFManagers() == null || resultBean.getPOFManagers().getList() == null
                                        || resultBean.getPOFManagers().getList().size() == 0) {
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

                    @Override
                    public void onFailure(retrofit2.Call<SearchResultEntity> call, Throwable t) {
                        if (progressDialog != null) {
                            progressDialog.cancel();
                        }
                    }
                });
    }

    /**
     * 搜索前的数据采集
     */
    private void readySearch() {
        // 起始时间
        String time1 = tvTime1.getText().toString();
        // 结束时间
        String time2 = tvTime2.getText().toString();
        if (!TextUtils.isEmpty(time1)) {
            time1 = Tools.date2TimeStamp(time1);
        }
        if (!TextUtils.isEmpty(time2)) {
            time2 = Tools.date2TimeStamp(time2);
        }
        searchZqgszgcp(etProName.getText().toString(), etProNumber.getText().toString(),
                etManageOrg.getText().toString(), time1, time2);

    }


    private void clearAllCondition() {
        etProName.setText("");
        etManageOrg.setText("");
        etProNumber.setText("");
        tvTime1.setText("");
        tvTime2.setText("");
    }


    private void searchZqgszgcp(String productName, String productCode, String mgrName, String
            foundDateFrom, String foundDateTo) {
        if (progressDialog != null) {
            progressDialog.show();
        }
        Map<String, String> params = new HashMap<>();
        params.put("pageIndex", "1");
        params.put("pageSize", "50");
        if (!TextUtils.isEmpty(productName)) {
            params.put("productName", productName);
        }
        if (!TextUtils.isEmpty(productCode)) {
            params.put("productCode", productCode);
        }
        if (!TextUtils.isEmpty(mgrName)) {
            params.put("mgrName", mgrName);
        }
        if (!TextUtils.isEmpty(foundDateFrom)) {
            params.put("foundDateFrom", foundDateFrom);
        }
        if (!TextUtils.isEmpty(foundDateTo)) {
            params.put("foundDateTo", foundDateTo);
        }


        OkHttpUtils.post().url(SEARCH_POF_SUBFUND).params(params)
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
                    infoAdapter = new LandSpaceAdapter(LandSpaceActivity.this, resultBean, flag);
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
        JSONObject object = new JSONObject();
        switch (checkedId) {
            // 基金规模
            case R.id.rg_jjgm:

                break;
            // 提示事项
            case R.id.ck_scale_0:
            case R.id.ck_scale_0_than:
            case R.id.ck_low_capital:
            case R.id.ck_low_100w:
            case R.id.ck_abnormal_liquidation:
                waringTipsList.add(radioButton.getTag().toString());
                if (waringTipsList != null && waringTipsList.size() > 0) {
                    JSONArray jsonArray = new JSONArray(waringTipsList);
                    try {
                        object.put("waringTips", jsonArray);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    // 字符串转数字
                }
                searchPeople(object);
                break;
            // 诚信信息
            case R.id.ck_sljg:
            case R.id.ck_ycjg:
            case R.id.ck_xjtb:
            case R.id.ck_zdyl:
            case R.id.ck_wfbtdx:
            case R.id.ck_xgztczblcxjl:
                try {
                    object.put("creditInfo", radioButton.getTag().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                searchPeople(object);
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        JSONObject object = new JSONObject();
        JSONObject objectFundScale = new JSONObject();
        Spinner spinner = findViewById(parent.getId());
        // 当前选中的内容
        String selectedStr = parent.getItemAtPosition(position).toString();
        int from = -1;
        int to = -1;
        if (!TextUtils.isEmpty(selectedStr)) {
            switch (selectedStr) {
                case "全部":
                    break;
                case "100亿以上":
                    from = 1000000;
                    break;
                case "50亿以上":
                    from = 500000;
                    break;
                case "10亿以上":
                    from = 100000;
                    break;
                case "50-100亿":
                    from = 500000;
                    to = 1000000;
                    break;
                case "20-50亿":
                    from = 200000;
                    to = 500000;
                    break;
                case "10-20亿":
                    from = 100000;
                    to = 200000;
                    break;
                case "1-10亿":
                    from = 10000;
                    to = 100000;
                    break;
                case "0-1亿":
                    from = 0;
                    to = 10000;
                    break;
                case "0-20亿":
                    from = 0;
                    to = 200000;
                    break;
                case "5-10亿":
                    from = 50000;
                    to = 100000;
                    break;
                case "2-5亿":
                    from = 20000;
                    to = 50000;
                    break;
                case "0-2亿":
                    from = 0;
                    to = 20000;
                    break;
            }
            try {
                if (from > -1) {
                    objectFundScale.put("from", from);
                }
                if (to > -1) {
                    objectFundScale.put("to", to);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        try {
            object.put("fundType", spinner.getTag().toString());
            if (objectFundScale.has("from")) {
                object.put("fundScale", objectFundScale);
            }
            searchPeople(object);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
