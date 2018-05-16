package demo.third.com.exceldemo.ui.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.adapter.SearchResultAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.utils.Tools;

import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;

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
    @BindView(R.id.tv_search_results_count)
    TextView tvSearchResultsCount;
    @BindView(R.id.lv_search_results)
    ListView lvSearchResults;

    private AlertDialog dialog;
    private String searchCondition;

    TextView tvSearch;
    TextView tvClearCondition;
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
    CheckBox ckAdministrator;
    CheckBox ckAdministratorCreate;
    CheckBox ckAdministratorOther;

    private SearchResultAdapter resultAdapter;
    private List<String> listResult = new ArrayList<>();

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
        if (listResult != null) {
            listResult.add("");
            listResult.add("");
            listResult.add("");
            listResult.add("");
            listResult.add("");
            listResult.add("");
            listResult.add("");
        }
        resultAdapter = new SearchResultAdapter(SearchResultActivity.this, listResult);
        lvSearchResults.setAdapter(resultAdapter);
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
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_search:
                Tools.toast("那棵树的房间里看电视");
                break;
            case R.id.tv_clear_condition:
                Tools.toast("那棵树的房间里看电视");
                break;
            case R.id.iv_close:
                dialog.dismiss();
                break;
            default:
                break;
        }
    }
}
