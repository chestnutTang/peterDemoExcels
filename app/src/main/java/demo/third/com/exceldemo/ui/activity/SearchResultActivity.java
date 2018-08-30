package demo.third.com.exceldemo.ui.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citylist.Toast.ToastUtils;
import com.lljjcoder.style.citylist.utils.CityListLoader;
import com.lljjcoder.style.citypickerview.CityPickerView;
import com.lljjcoder.style.citythreelist.CityBean;
import com.lljjcoder.style.citythreelist.ProvinceActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.BuildConfig;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.RetrofitHelper;
import demo.third.com.exceldemo.service.entity.CityEntity;
import demo.third.com.exceldemo.service.entity.SearchResultEntity;
import demo.third.com.exceldemo.ui.adapter.SearchResultAdapter;
import demo.third.com.exceldemo.ui.views.RadioGroupEx;
import demo.third.com.exceldemo.utils.DensityUtil;
import demo.third.com.exceldemo.utils.JumpTools;
import demo.third.com.exceldemo.utils.Logger;
import demo.third.com.exceldemo.utils.Tools;
import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;
import retrofit2.Callback;
import retrofit2.Response;

import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;
import static demo.third.com.exceldemo.utils.Link.POFMANAGER;
import static demo.third.com.exceldemo.utils.Link.SEARCH;
import static demo.third.com.exceldemo.utils.Link.SEARCH_FUND;

/**
 * @author peter
 * 搜索的结果列表页
 */
public class SearchResultActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener
        , RadioGroupEx.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener
        , OnWheelChangedListener, AdapterView.OnItemClickListener {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.iv_clear)
    ImageView ivClear;
    @BindView(R.id.ck_address)
    CheckBox ckAddress;
    @BindView(R.id.ck_address_triangle)
    CheckBox ckAddressTriangle;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    @BindView(R.id.ck_more)
    CheckBox ckMore;
    @BindView(R.id.ck_more_triangle)
    CheckBox ckMoreTriangle;
    @BindView(R.id.rl_more)
    RelativeLayout rlMore;
    @BindView(R.id.ll_screen)
    LinearLayout llScreen;
    @BindView(R.id.lv_search_results)
    ListView lvSearchResults;

    private AlertDialog dialog;

    TextView tvSearch;
    TextView tvClearCondition;
    TextView tvTime1;
    TextView tvTime2;
    TextView tvTime3;
    TextView tvTime4;

    EditText etClearCondition;

    ImageView ivClose;

    RadioGroup rg_time;// 时间
    RadioGroup rg_time_dj;// 时间
    RadioGroupEx rg_jglx;// 时间
    RadioButton ck2Month;
    RadioButton ck1Year;
    RadioButton ck_1_zjyjd;
    RadioButton ck1Month;
    RadioButton ck3Month2;
    CheckBox ckScale0;
    CheckBox ckScale0Than;
    CheckBox ckLow100w;
    CheckBox ckLowCapital;
    CheckBox ckAbnormalLLiquidation;
    CheckBox ckWithoutLiquidation;
    CheckBox ckWithoutHint;
    RadioButton ckAdministrator;
    RadioButton ckAdministratorCreate;
    RadioButton ckAdministratorOther;

    private SearchResultAdapter resultAdapter;
    private SearchResultEntity searchResultEntity;

    private String primaryInvestType;
    private ArrayList<String> waringTipsList = new ArrayList<>();
    private String flag, url;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;
    private CityEntity mShangshabanCityModel;
    private RadioGroup rg_address;
    private RadioButton rb_bgdcx;
    private RadioButton rb_zcdcx;
    WheelView mProvince;
    WheelView mCity;
    TextView city_true;
    TextView city_close;
    TextView tv_selected_city;

    AlertDialog dialogCity;


    CityPickerView mPicker = new CityPickerView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPicker.init(this);
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void initView() {
        super.initView();
        flag = getIntent().getStringExtra(INTENT_FLAG);
        if (!TextUtils.isEmpty(flag)) {
            switch (flag) {
                case "私募基金管理人查询":
                    url = POFMANAGER;
                    break;
                case "首页搜索":
                    url = SEARCH;
                    break;
                case "基金专户产品公示":
                    url = SEARCH_FUND;
                    break;
                default:
                    break;
            }
        }
//        searchCondition = getIntent().getStringExtra(INTENT_FLAG);
//        if (!TextUtils.isEmpty(searchCondition)) {
//            etSearch.setText(searchCondition);
//            etSearch.setSelection(searchCondition.length());
//            search(searchCondition);
//        }
        etSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    //业务代码
                    readySearch();
                    return true;
                }
                return false;
            }
        });
        lvSearchResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long pofMangerId = 0;
                switch (flag) {
                    case "私募基金管理人查询":
                        pofMangerId = searchResultEntity.getResult().getPOFManagers().getList().get(position).getId();
                        JumpTools.jumpWithdFlag(SearchResultActivity.this, PrivateFundInfoActivity
                                .class, String.valueOf(pofMangerId));
                        break;
                    case "基金专户产品公示":
                        pofMangerId = searchResultEntity.getResult().getFundAccounts().getList().get(position).getId();
                        JumpTools.jumpWithdFlag(SearchResultActivity.this, PrivateFundDetailsActivity
                                .class, String.valueOf(pofMangerId));
                        break;
                    case "首页搜索":
                        if (position > 0) {
                            pofMangerId = searchResultEntity.getResult().getPOFManagers().getList().get(position).getId();
                            JumpTools.jumpWithdFlag(SearchResultActivity.this, PrivateFundDetailsActivity
                                    .class, String.valueOf(pofMangerId));
                        }
                        break;
                    default:
                        break;
                }

            }
        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_result;
    }

    @OnClick({R.id.iv_backup, R.id.iv_clear, R.id.rl_address, R.id.rl_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            case R.id.iv_clear:
                etSearch.setText("");
                break;
            // 城市选择
            case R.id.rl_address:
                getCityArea();
//                //添加默认的配置，不需要自己定义
//                CityConfig cityConfig = new CityConfig.Builder().build();
//                mPicker.setConfig(cityConfig);
//                //监听选择点击事件及返回结果
//                mPicker.setOnCityItemClickListener(new OnCityItemClickListener() {
//
//                    @Override
//                    public void onSelected(ProvinceBean province, com.lljjcoder.bean.CityBean city, DistrictBean district) {
//                        super.onSelected(province, city, district);
//                        //省份
//                        if (province != null) {
//
//                        }
//
//                        //城市
//                        if (city != null) {
//
//                        }
//
//                        //地区
//                        if (district != null) {
//
//                        }
//                    }
//
//                    @Override
//                    public void onCancel() {
//                        ToastUtils.showLongToast(SearchResultActivity.this, "已取消");
//                    }
//                });
//
//                //显示
//                mPicker.showCityPicker();
                break;
            //更多筛选
            case R.id.rl_more:
                if (!TextUtils.isEmpty(flag)) {
                    switch (flag) {
                        case "私募基金管理人查询":
                        case "首页搜索":
                            showScreenConditions();
                            break;
                        case "基金专户产品公示":
                            showScreenConditionsJjzh();
                            break;
                        default:
                            break;
                    }
                }

                break;
            default:
                break;
        }
    }


    /**
     * 更多筛选
     */
    private void showScreenConditions() {
        dialog = new AlertDialog.Builder(SearchResultActivity.this, R.style.dialog).create();
        dialog.setCancelable(false);
        dialog.show();
        //让EditText能够弹出软键盘
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
//        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
//                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        Window window = dialog.getWindow();
        window.setContentView(R.layout.dialog_search_condition);
        WindowManager.LayoutParams lp = window.getAttributes();
        //这句就是设置dialog横向满屏了。
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);

        tvSearch = window.findViewById(R.id.tv_search);
        tvClearCondition = window.findViewById(R.id.tv_clear_condition);
        tvTime1 = window.findViewById(R.id.tv_time1);
        tvTime2 = window.findViewById(R.id.tv_time2);
        tvTime3 = window.findViewById(R.id.tv_time3);
        tvTime4 = window.findViewById(R.id.tv_time4);

        etClearCondition = window.findViewById(R.id.et_search_condition);

        ivClose = window.findViewById(R.id.iv_close);

        rg_time = window.findViewById(R.id.rg_time);
        rg_time_dj = window.findViewById(R.id.rg_time_dj);
        rg_jglx = window.findViewById(R.id.rg_jglx);
        ck2Month = window.findViewById(R.id.ck_3_month);
        ck1Year = window.findViewById(R.id.ck_1_year);
        ck1Month = window.findViewById(R.id.ck_1_month);
        ck3Month2 = window.findViewById(R.id.ck_3_month2);
        ckScale0 = window.findViewById(R.id.ck_scale_0);
        ckScale0Than = window.findViewById(R.id.ck_scale_0_than);
        ckLow100w = window.findViewById(R.id.ck_low_100w);
        ckLowCapital = window.findViewById(R.id.ck_low_capital);
        ckAbnormalLLiquidation = window.findViewById(R.id.ck_abnormal_liquidation);
        ckWithoutLiquidation = window.findViewById(R.id.ck_without_qualifications);
        ckWithoutHint = window.findViewById(R.id.ck_without_hint);
        ckAdministrator = window.findViewById(R.id.ck_administrator);
        ckAdministratorCreate = window.findViewById(R.id.ck_administrator_create);
        ckAdministratorOther = window.findViewById(R.id.ck_administrator_other);
        bindListener();
        etClearCondition.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    //业务代码
                    search(etClearCondition.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }

    private void showScreenConditionsJjzh() {
        dialog = new AlertDialog.Builder(SearchResultActivity.this, R.style.dialog).create();
        dialog.setCancelable(false);
        dialog.show();
        //让EditText能够弹出软键盘
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
//        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
//                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        Window window = dialog.getWindow();
        window.setContentView(R.layout.dialog_search_condition_jjzh);
        WindowManager.LayoutParams lp = window.getAttributes();
        //这句就是设置dialog横向满屏了。
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);

        tvSearch = window.findViewById(R.id.tv_search);
        tvClearCondition = window.findViewById(R.id.tv_clear_condition);

        tvTime1 = window.findViewById(R.id.tv_time1);
        tvTime2 = window.findViewById(R.id.tv_time2);

        etClearCondition = window.findViewById(R.id.et_search_condition);

        ivClose = window.findViewById(R.id.iv_close);

        rg_time = window.findViewById(R.id.rg_time);
        ck1Year = window.findViewById(R.id.ck_1_year);
        ck_1_zjyjd = window.findViewById(R.id.ck_1_zjyjd);

        bindListener2();
        etClearCondition.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    //业务代码
                    search(etClearCondition.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void bindListener() {
        super.bindListener();
        tvSearch.setOnClickListener(this);
        tvClearCondition.setOnClickListener(this);
        tvTime1.setOnClickListener(this);
        tvTime2.setOnClickListener(this);
        tvTime3.setOnClickListener(this);
        tvTime4.setOnClickListener(this);
        ivClose.setOnClickListener(this);
        //Checkbox的选中事件
        ckScale0.setOnCheckedChangeListener(this);
        ckScale0Than.setOnCheckedChangeListener(this);
        ckLow100w.setOnCheckedChangeListener(this);
        ckLowCapital.setOnCheckedChangeListener(this);
        ckAbnormalLLiquidation.setOnCheckedChangeListener(this);
        ckWithoutLiquidation.setOnCheckedChangeListener(this);
        ckWithoutHint.setOnCheckedChangeListener(this);

        rg_time.setOnCheckedChangeListener(this);
        rg_time_dj.setOnCheckedChangeListener(this);
        rg_jglx.setOnCheckedChangeListener(this);
    }

    protected void bindListener2() {
        super.bindListener();
        tvSearch.setOnClickListener(this);
        tvClearCondition.setOnClickListener(this);
        tvTime1.setOnClickListener(this);
        tvTime2.setOnClickListener(this);
        ivClose.setOnClickListener(this);
        //Checkbox的选中事件
//        ckScale0.setOnCheckedChangeListener(this);
//        ckScale0Than.setOnCheckedChangeListener(this);
//        ckLow100w.setOnCheckedChangeListener(this);
//        ckLowCapital.setOnCheckedChangeListener(this);
//        ckAbnormalLLiquidation.setOnCheckedChangeListener(this);
//        ckWithoutLiquidation.setOnCheckedChangeListener(this);
//        ckWithoutHint.setOnCheckedChangeListener(this);

        rg_time.setOnCheckedChangeListener(this);
    }

    private void clearAllCheckbox() {
        List<CompoundButton> list = new ArrayList<>();
        list.add(ck2Month);
        list.add(ck1Year);
        list.add(ck1Month);
        list.add(ck3Month2);
        list.add(ckScale0);
        list.add(ckScale0Than);
        list.add(ckLow100w);
        list.add(ckLowCapital);
        list.add(ckAbnormalLLiquidation);
        list.add(ckWithoutLiquidation);
        list.add(ckWithoutHint);

        List<RadioButton> list2 = new ArrayList<>();
        list2.add(ckAdministrator);
        list2.add(ckAdministratorCreate);
        list2.add(ckAdministratorOther);


        try {
            for (CompoundButton view : list) {
                view.setBackgroundResource(R.drawable.edit_search_condition);
                view.setTextColor(Color.parseColor("#2F7DFB"));
                view.setChecked(false);
            }

            for (RadioButton view2 : list2) {
                view2.setChecked(false);
            }

            tvTime1.setText("");
            tvTime2.setText("");
            tvTime3.setText("");
            tvTime4.setText("");
            etClearCondition.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void clearAllCheckbox2() {
        List<CompoundButton> list = new ArrayList<>();
        list.add(ck_1_zjyjd);
        list.add(ck1Year);

        try {
            for (CompoundButton view : list) {
                view.setBackgroundResource(R.drawable.edit_search_condition);
                view.setTextColor(Color.parseColor("#2F7DFB"));
                view.setChecked(false);
            }

            tvTime1.setText("");
            tvTime2.setText("");
            etClearCondition.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void clearTips() {
        List<CheckBox> checkBoxList = new ArrayList<>();
        checkBoxList.add(ckScale0);
        checkBoxList.add(ckScale0Than);
        checkBoxList.add(ckLow100w);
        checkBoxList.add(ckLowCapital);
        checkBoxList.add(ckAbnormalLLiquidation);
        checkBoxList.add(ckWithoutLiquidation);
        checkBoxList.add(ckWithoutHint);
        try {
            for (CompoundButton view : checkBoxList) {
//                view.setBackgroundResource(R.drawable.edit_search_condition);
//                view.setTextColor(Color.parseColor("#2F7DFB"));
                view.setChecked(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 搜索
     */
    private void readySearch() {
        if (tvTime1 == null || tvTime2 == null || tvTime3 == null || tvTime4 == null) {
            searchHomePage(etSearch.getText().toString(), "", "", "", "");
        } else {
            // 起始时间
            String time1 = tvTime1.getText().toString();
            // 结束时间
            String time2 = tvTime2.getText().toString();
            String time3 = tvTime3.getText().toString();
            String time4 = tvTime4.getText().toString();
            if (!TextUtils.isEmpty(time1)) {
                time1 = Tools.date2TimeStamp(time1);
            }
            if (!TextUtils.isEmpty(time2)) {
                time2 = Tools.date2TimeStamp(time2);
            }
            if (!TextUtils.isEmpty(time3)) {
                time3 = Tools.date2TimeStamp(time3);
            }
            if (!TextUtils.isEmpty(time4)) {
                time4 = Tools.date2TimeStamp(time4);
            }
            searchHomePage(etSearch.getText().toString(), time1, time2, time3, time4);
        }

    }

    protected void searchHomePage(String keyword, String time1, String time2, String time3, String time4) {
        Map<String, Object> params = new HashMap<>();
        JSONObject object = null;
        JSONObject establishDate, registerDate;
        List<CheckBox> checkBoxList = new ArrayList<>();
        checkBoxList.add(ckScale0);
        checkBoxList.add(ckScale0Than);
        checkBoxList.add(ckLow100w);
        checkBoxList.add(ckLowCapital);
        checkBoxList.add(ckAbnormalLLiquidation);
        checkBoxList.add(ckWithoutLiquidation);
        checkBoxList.add(ckWithoutHint);

        for (CheckBox view : checkBoxList) {
            if (view != null) {
                if (view.isChecked()) {
                    waringTipsList.add(view.getHint().toString());
                }
            }
        }
        try {
            object = new JSONObject();
            establishDate = new JSONObject();
            registerDate = new JSONObject();
            object.put("primaryInvestType", primaryInvestType);
            if (!TextUtils.isEmpty(keyword)) {
                object.put("keyword", keyword);
            }
            if (waringTipsList != null && waringTipsList.size() > 0) {
                JSONArray jsonArray = new JSONArray(waringTipsList);
                object.put("waringTips", jsonArray);
                // 字符串转数字
            }
            if (!TextUtils.isEmpty(time1) && Tools.isNumeric(time1)) {
                establishDate.put("from", Long.valueOf(time1));
            }
            if (!TextUtils.isEmpty(time2) && Tools.isNumeric(time2)) {
                establishDate.put("to", Long.valueOf(time2));
            }
            if (!TextUtils.isEmpty(time3) && Tools.isNumeric(time3)) {
                registerDate.put("from", Long.valueOf(time3));
            }
            if (!TextUtils.isEmpty(time4) && Tools.isNumeric(time4)) {
                registerDate.put("to", Long.valueOf(time4));
            }

            if (establishDate.has("from") && establishDate.getLong("from") != 0) {
                object.putOpt("establishDate", establishDate);
            }
            if (registerDate.has("from") && registerDate.getLong("from") != 0) {
                object.putOpt("registerDate", registerDate);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        params.put("pageIndex", "1");
        params.put("pageSize", "50");
        params.put("query", object);

        RetrofitHelper.getInstance(this).baseUrl(BuildConfig.HOST)
                .searchHomePage(url, params)
                .enqueue(new Callback<SearchResultEntity>() {
                    @Override
                    public void onResponse(retrofit2.Call<SearchResultEntity> call,
                                           Response<SearchResultEntity> response) {
                        searchResultEntity = response.body();
                        waringTipsList.clear();
                        if (!TextUtils.isEmpty(flag)) {
                            switch (flag) {
                                case "私募基金管理人查询":
                                case "首页搜索":
                                    clearAllCheckbox();
                                    break;
                                case "基金专户产品公示":
                                    clearAllCheckbox2();
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (searchResultEntity != null) {
                            Tools.forceHideSoftWare(SearchResultActivity.this, etSearch);
                            resultAdapter = new SearchResultAdapter(SearchResultActivity.this,
                                    searchResultEntity.getResult(), flag);
                            lvSearchResults.setAdapter(resultAdapter);
                            if (dialog != null) {
                                dialog.cancel();
                            }
                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<SearchResultEntity> call, Throwable t) {
                        waringTipsList.clear();
                        if (!TextUtils.isEmpty(flag)) {
                            switch (flag) {
                                case "私募基金管理人查询":
                                case "首页搜索":
                                    clearAllCheckbox();
                                    break;
                                case "基金专户产品公示":
                                    clearAllCheckbox2();
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_search:
                readySearch();
                break;
            //清空筛选条件
            case R.id.tv_clear_condition:
                if (!TextUtils.isEmpty(flag)) {
                    switch (flag) {
                        case "私募基金管理人查询":
                        case "首页搜索":
                            clearAllCheckbox();
                            break;
                        case "基金专户产品公示":
                            clearAllCheckbox2();
                            break;
                        default:
                            break;
                    }
                }
                break;
            case R.id.iv_close:
                dialog.dismiss();
                break;
            //选择起始时间
            case R.id.tv_time1:
            case R.id.tv_time2:
            case R.id.tv_time3:
            case R.id.tv_time4:
                Tools.showDateChoice(SearchResultActivity.this, (TextView) v);
                break;
            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.ck_3_month:
            case R.id.ck_1_zjyjd:
                fillContent(3, tvTime1, tvTime2);
                break;
            case R.id.ck_1_year:
                fillContent(12, tvTime1, tvTime2);
                break;
            case R.id.ck_1_month:
                fillContent(1, tvTime3, tvTime4);
                break;
            case R.id.ck_3_month2:
                fillContent(3, tvTime3, tvTime4);
                break;
            default:
                break;
        }
    }

    private void fillContent(int startDate, TextView tv1, TextView tv2) {
        String time = Tools.getMonthAgo(new Date(), startDate);
        String time2 = Tools.getMonthAgo(new Date(), 0);
        if (!TextUtils.isEmpty(time) && !TextUtils.isEmpty(time2)) {
            tv1.setText(time);
            tv2.setText(time2);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            buttonView.setBackgroundResource(R.drawable.edit_search_condition_checked);
            buttonView.setTextColor(Color.parseColor("#ffffff"));
        } else {
            buttonView.setBackgroundResource(R.drawable.edit_search_condition);
            buttonView.setTextColor(Color.parseColor("#2F7DFB"));
        }
    }

    @Override
    public void onCheckedChanged(RadioGroupEx group, int checkedId) {
        RadioButton radioButton = findViewById(group.getCheckedRadioButtonId());
        switch (checkedId) {
            case R.id.ck_without_hint:
                clearTips();
                break;
            case R.id.ck_case_before2:
                break;
            case R.id.ck_manage_entrust:
            case R.id.ck_manage_self:
            case R.id.ck_manage_adviser:
                break;
            case R.id.ck_running:
            case R.id.ck_liquidation_late:
            case R.id.ck_liquidation_before:
            case R.id.ck_normal_liquidation:
            case R.id.ck_abnormal_liquidation:
            case R.id.ck_protocol_end:
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ProvinceActivity.RESULT_DATA) {
            if (resultCode == RESULT_OK) {
                if (data == null) {
                    return;
                }
                //省份结果
                CityBean province = data.getParcelableExtra("province");
                //城市结果
                CityBean city = data.getParcelableExtra("city");
                //区域结果
                CityBean area = data.getParcelableExtra("area");
            }
        }
    }


    public void getCityArea() {
        if (dialogCity == null) {
            dialogCity = new AlertDialog.Builder(SearchResultActivity.this, R.style.dialog).create();
        }
        if (!dialogCity.isShowing()) {
            dialogCity.show();
        }
        dialogCity.setCancelable(true);
        dialogCity.setCanceledOnTouchOutside(true);
        Window window = dialogCity.getWindow();
        window.setContentView(R.layout.activity_city_choice);
        WindowManager.LayoutParams lp = window.getAttributes();
        //这句就是设置dialog横向满屏了。
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);

        initJsonData();
        mProvince = window.findViewById(R.id.id_province);
        mCity = window.findViewById(R.id.id_city);
//        mArea = (ListView) window.findViewById(R.id.id_area);
//        mCurrentAreaNameList = new ArrayList<>();
//        mCurrentAreaIdList = new ArrayList<>();
        city_true = window.findViewById(R.id.city_true);
        city_close = window.findViewById(R.id.city_close);
        tv_selected_city = window.findViewById(R.id.tv_selected_city);
        rg_address = window.findViewById(R.id.rg_address);
        rb_bgdcx = window.findViewById(R.id.rb_bgdcx);
        rb_zcdcx = window.findViewById(R.id.rb_zcdcx);
        rg_address.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    // 信息公示
                    case R.id.rb_bgdcx:
                        rb_bgdcx.setTextColor(getResources().getColor(R.color.white));
                        rb_bgdcx.setBackgroundColor(getResources().getColor(R.color.color_bf));
                        rb_zcdcx.setTextColor(getResources().getColor(R.color.black));
                        rb_zcdcx.setBackgroundColor(getResources().getColor(R.color.white));
                        break;
                    // 考试平台
                    case R.id.rb_zcdcx:
                        rb_zcdcx.setTextColor(getResources().getColor(R.color.white));
                        rb_zcdcx.setBackgroundColor(getResources().getColor(R.color.color_bf));
                        rb_bgdcx.setTextColor(getResources().getColor(R.color.black));
                        rb_bgdcx.setBackgroundColor(getResources().getColor(R.color.white));
                        break;
                    default:
                        break;
                }
            }
        });

        initDatas();
        mProvince.setViewAdapter(new ArrayWheelAdapter<>(SearchResultActivity.this,
                mProvinceDatas));
        // 添加change事件
        mProvince.addChangingListener(this);
        // 添加change事件
        mCity.addChangingListener(this);
        // 添加change事件
//        mArea.addChangingListener(this);
//        areaAdapter = new FiltrateAdapter(activity, null, R.layout.item_screen_address);
//        mArea.setAdapter(areaAdapter);
//        mArea.setOnItemClickListener(this);
        mProvince.setVisibleItems(5);
        mCity.setVisibleItems(5);
//        mArea.setVisibleItems(5);
        updateCities();
//        updateAreas();
//        if (provinceOld != null && cityOld != null) {
//            posLocation(provinceOld, cityOld, districtList);
//        } else {
//            initLocation();
//        }

        city_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(mCurrentCityName)){
                    ckAddress.setText(mCurrentCityName);
                }
                dialogCity.cancel();
            }
        });
        city_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCity.cancel();
            }
        });


    }


    private void initJsonData() {
        try {
            inputStreamReader = new InputStreamReader(getAssets().open("newcity.json"), "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            inputStreamReader.close();
            bufferedReader.close();
            Gson gson = new Gson();
            mShangshabanCityModel = gson.fromJson(stringBuilder.toString(), CityEntity
                    .class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String[] mProvinceDatas;
    int[] mProvinceIdDatas;
    Map<String, String[]> mCitisDatasMap = new HashMap<>();
    Map<Integer, int[]> mCitiesIdDatas = new HashMap<>();

    /**
     * 解析整个Json对象，完成后释放Json对象的内存
     */
    private void initDatas() {
        try {
//            JSONArray jsonArray = mJsonObj.getJSONArray("citylist");
            List<CityEntity.DetailBean.CitylistBean> citylist = mShangshabanCityModel
                    .getDetail().getCitylist();
            mProvinceDatas = new String[citylist.size()];
            mProvinceIdDatas = new int[citylist.size()];
            for (int i = 0; i < citylist.size(); i++) {
//                JSONObject jsonP = jsonArray.getJSONObject(i);// 每个省的json对象
//                String province = jsonP.getString("p");// 省名字
                String province = citylist.get(i).getP();
                int provinceId = citylist.get(i).getPid();
                mProvinceDatas[i] = province;
                mProvinceIdDatas[i] = provinceId;

                List<CityEntity.DetailBean.CitylistBean.CBean> jsonCs = citylist.get(i)
                        .getC();
                String[] mCitiesDatas = new String[jsonCs.size()];
                int[] mCitiesIdDatas = new int[jsonCs.size()];
                for (int j = 0; j < jsonCs.size(); j++) {
//                    JSONObject jsonCity = jsonCs.getJSONObject(j);
                    String city = jsonCs.get(j).getN();
                    int cityId = jsonCs.get(j).getNid();
                    mCitiesDatas[j] = city;
                    mCitiesIdDatas[j] = cityId;
                    List<CityEntity.DetailBean.CitylistBean.CBean.ABean> jsonAreas =
                            jsonCs.get(j).getA();
                    String[] mAreasDatas = new String[jsonAreas.size()];// 当前市的所有区
                    int[] mAreasIdDatas = new int[jsonAreas.size()];
                    for (int k = 0; k < jsonAreas.size(); k++) {
                        String area = jsonAreas.get(k).getS();
                        int areaId = jsonAreas.get(k).getSid();
                        mAreasDatas[k] = area;
                        mAreasIdDatas[k] = areaId;
                    }
//                    mAreaDatasMap.put(city, mAreasDatas);
//                    mAreaIdDatas.put(cityId, mAreasIdDatas);
                }
                mCitisDatasMap.put(province, mCitiesDatas);
                this.mCitiesIdDatas.put(provinceId, mCitiesIdDatas);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//        mJsonObj = null;
        mShangshabanCityModel = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    private String mCurrentCityName = "北京市";
    private int mCurrentCityId;

    @Override
    public void onChanged(WheelView wheel, int oldValue, int newValue) {
        try {
            if (wheel == mProvince) {
                updateCities();
                if (mCitisDatasMap != null
                        && mCitisDatasMap.get(mCurrentProviceName) != null
                        && mCitisDatasMap.get(mCurrentProviceName).length > 0) {
                    mCurrentCityName = mCitisDatasMap.get(mCurrentProviceName)[0];
                    mCurrentCityId = mCitiesIdDatas.get(mCurrentProviceId)[0];
                    tv_selected_city.setText("当前选择      " + mCurrentCityName);
                }
            } else if (wheel == mCity) {
                mCurrentCityName = mCitisDatasMap.get(mCurrentProviceName)[newValue];
                mCurrentCityId = mCitiesIdDatas.get(mCurrentProviceId)[newValue];
                tv_selected_city.setText("当前选择      " + mCurrentCityName);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 根据当前的省，更新市WheelView的信息
     */
    private String mCurrentProviceName;
    private int mCurrentProviceId;

    private void updateCities() {

        int pCurrent = mProvince.getCurrentItem();
        mCurrentProviceName = mProvinceDatas[pCurrent];
        mCurrentProviceId = mProvinceIdDatas[pCurrent];
        String[] cities = mCitisDatasMap.get(mCurrentProviceName);
        if (cities == null) {
            cities = new String[]{""};
        }
        mCity.setViewAdapter(new ArrayWheelAdapter<String>(SearchResultActivity.this, cities));
        mCity.setCurrentItem(0);
    }

}
