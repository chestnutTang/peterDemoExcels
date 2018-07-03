package demo.third.com.exceldemo.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.adapter.SearchResultAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.utils.JumpTools;

import static demo.third.com.exceldemo.utils.Constant.PRIVATEFUNDACTIVITY;

/**
 * 私募基金公示
 *
 * @author songzhengpeng
 */
public class PrivateFundActivity extends BaseActivity implements CompoundButton
        .OnCheckedChangeListener {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.iv_clear)
    ImageView ivClear;
    @BindView(R.id.ck_case_before)
    CheckBox ckCaseBefore;
    @BindView(R.id.ck_case_before2)
    CheckBox ckCaseBefore2;
    @BindView(R.id.ck_manage_entrust)
    CheckBox ckManageEntrust;
    @BindView(R.id.ck_manage_self)
    CheckBox ckManageSelf;
    @BindView(R.id.ck_manage_adviser)
    CheckBox ckManageAdviser;
    @BindView(R.id.ck_running)
    CheckBox ckRunning;
    @BindView(R.id.ck_liquidation_late)
    CheckBox ckLiquidationLate;
    @BindView(R.id.ck_liquidation_before)
    CheckBox ckLiquidationBefore;
    @BindView(R.id.ck_normal_liquidation)
    CheckBox ckNormalLiquidation;
    @BindView(R.id.ck_abnormal_liquidation)
    CheckBox ckAbnormalLiquidation;
    @BindView(R.id.ck_protocol_end)
    CheckBox ckProtocolEnd;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.tv_clear_condition)
    TextView tvClearCondition;
    @BindView(R.id.lv_private_fund)
    MyListView lvPrivateFund;

    private SearchResultAdapter resultAdapter;
    private List<String> listResult = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        bindListener();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_private_fund;
    }

    @Override
    protected void initView() {
        super.initView();
        lvPrivateFund.setFocusable(false);
        if (listResult != null) {
            listResult.add("");
            listResult.add("");
            listResult.add("");
            listResult.add("");
            listResult.add("");
            listResult.add("");
            listResult.add("");
        }
        resultAdapter = new SearchResultAdapter(PrivateFundActivity.this, listResult, PRIVATEFUNDACTIVITY);
        lvPrivateFund.setAdapter(resultAdapter);
    }

    @Override
    protected void bindListener() {
        super.bindListener();
        ckCaseBefore.setOnCheckedChangeListener(this);
        ckCaseBefore2.setOnCheckedChangeListener(this);
        ckManageEntrust.setOnCheckedChangeListener(this);
        ckManageSelf.setOnCheckedChangeListener(this);
        ckManageAdviser.setOnCheckedChangeListener(this);
        ckRunning.setOnCheckedChangeListener(this);
        ckLiquidationLate.setOnCheckedChangeListener(this);
        ckLiquidationBefore.setOnCheckedChangeListener(this);
        ckNormalLiquidation.setOnCheckedChangeListener(this);
        ckAbnormalLiquidation.setOnCheckedChangeListener(this);
        ckProtocolEnd.setOnCheckedChangeListener(this);
        lvPrivateFund.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                JumpTools.jumpOnly(PrivateFundActivity.this, PrivateFundDetailsActivity.class);
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
                break;
            case R.id.tv_clear_condition:
                clearAllCheckbox();
                break;
            default:
                break;
        }
    }

    private void clearAllCheckbox() {

        List<CheckBox> list = new ArrayList<>();
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

        for (CheckBox view : list) {
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
}
