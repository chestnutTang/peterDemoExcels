package demo.third.com.exceldemo.ui.activity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.SearchResultEntity;
import demo.third.com.exceldemo.ui.adapter.SearchResultAdapter;
import demo.third.com.exceldemo.ui.views.OkRequestParams;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.JumpTools;
import demo.third.com.exceldemo.utils.Tools;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;
import static demo.third.com.exceldemo.utils.Constant.SEARCHRESULTACTIVITY;
import static demo.third.com.exceldemo.utils.Link.SEARCH;

/**
 * @author songzhengpeng
 * 搜索的结果列表页
 */
public class SearchResultActivity extends BaseActivity implements CompoundButton
        .OnCheckedChangeListener {

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
    private String searchCondition;

    TextView tvSearch;
    TextView tvClearCondition;
    TextView tvTime1;
    TextView tvTime2;
    TextView tvTime3;
    TextView tvTime4;

    EditText etClearCondition;

    ImageView ivClose;

    CheckBox ck2Month;
    CheckBox ck1Year;
    CheckBox ck1Month;
    CheckBox ck3Month2;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void initView() {
        super.initView();
        searchCondition = getIntent().getStringExtra(INTENT_FLAG);
        if (!TextUtils.isEmpty(searchCondition)) {
            etSearch.setText(searchCondition);
            etSearch.setSelection(searchCondition.length());
            search(searchCondition);
        }
        etSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    //业务代码
                    search(etSearch.getText().toString());
                    return true;
                }
                return false;
            }
        });
        lvSearchResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long pofMangerId = searchResultEntity.getResult().getPOFManagers().getList().get
                        (position).getId();
                JumpTools.jumpWithdFlag(SearchResultActivity.this, PrivateFundDetailsActivity
                        .class, String.valueOf(pofMangerId));
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
            case R.id.rl_address:
                break;
            //更多筛选
            case R.id.rl_more:
                showScreenConditions();
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
        ck2Month.setOnCheckedChangeListener(this);
        ck1Year.setOnCheckedChangeListener(this);
        ck1Month.setOnCheckedChangeListener(this);
        ck3Month2.setOnCheckedChangeListener(this);
        ckScale0.setOnCheckedChangeListener(this);
        ckScale0Than.setOnCheckedChangeListener(this);
        ckLow100w.setOnCheckedChangeListener(this);
        ckLowCapital.setOnCheckedChangeListener(this);
        ckAbnormalLLiquidation.setOnCheckedChangeListener(this);
        ckWithoutLiquidation.setOnCheckedChangeListener(this);
        ckWithoutHint.setOnCheckedChangeListener(this);
        ckAdministrator.setOnCheckedChangeListener(this);
        ckAdministratorCreate.setOnCheckedChangeListener(this);
        ckAdministratorOther.setOnCheckedChangeListener(this);
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
        list.add(ckAdministrator);
        list.add(ckAdministratorCreate);
        list.add(ckAdministratorOther);

        for (CompoundButton view : list) {
            view.setBackgroundResource(R.drawable.edit_search_condition);
            view.setTextColor(Color.parseColor("#2F7DFB"));
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
    protected void search(String searchCondition) {
        Map<String, String> params = new HashMap<>();
        JSONObject object = null;
        List<CheckBox> checkBoxList = new ArrayList<>();
        checkBoxList.add(ckScale0);
        checkBoxList.add(ckScale0Than);
        checkBoxList.add(ckLow100w);
        checkBoxList.add(ckLowCapital);
        checkBoxList.add(ckAbnormalLLiquidation);
        checkBoxList.add(ckWithoutLiquidation);
        checkBoxList.add(ckWithoutHint);

        for (CheckBox view : checkBoxList) {
            if (view.isChecked()) {
                waringTipsList.add(view.getText().toString());
            }
        }
        try {
            object = new JSONObject();
            object.put("primaryInvestType", primaryInvestType);
            if (waringTipsList != null && waringTipsList.size() > 0) {
                String[] waringTips = new String[waringTipsList.size()];
                waringTipsList.toArray(waringTips);
                Log.e("waringTips",waringTips.toString());
                object.put("waringTips", waringTips);
            }
            object.put("keyword", searchCondition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        params.put("pageIndex", "1");
        params.put("pageSize", "50");
        params.put("query", object.toString());
        OkHttpUtils.post().url(SEARCH).params(params)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                searchResultEntity = CustomGson.fromJson(response, SearchResultEntity.class);
                if (searchResultEntity != null) {
                    Tools.forceHideSoftWare(SearchResultActivity.this, etSearch);
                    resultAdapter = new SearchResultAdapter(SearchResultActivity.this,
                            searchResultEntity.getResult(), SEARCHRESULTACTIVITY);
                    lvSearchResults.setAdapter(resultAdapter);
                    if (dialog != null) {
                        dialog.cancel();
                    }
                }
            }
        });
    }

    class TipThings implements CompoundButton.OnCheckedChangeListener {

        public TipThings() {

        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                waringTipsList.add(buttonView.getId(), buttonView.getText().toString());
            } else {
                waringTipsList.remove(buttonView.getId());
            }
        }
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_search:
//                Tools.toast("那棵树的房间里看电视");
                search(etClearCondition.getText().toString());
                break;
            //清空筛选条件
            case R.id.tv_clear_condition:
                clearAllCheckbox();
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
}
