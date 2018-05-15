package demo.third.com.exceldemo.ui.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.views.MyListView;

import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;

/**
 * @author songzhengpeng
 * 搜索的结果列表页
 */
public class SearchResultActivity extends BaseActivity {

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
    MyListView lvSearchResults;

    private AlertDialog dialog;
    private String searchCondition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        searchCondition = getIntent().getStringExtra(INTENT_FLAG);
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

    private void showScreenConditions() {
        dialog = new AlertDialog.Builder(SearchResultActivity.this, R.style.dialog).create();
        dialog.setCancelable(false);
        dialog.show();
        Window window = dialog.getWindow();
        window.setContentView(R.layout.dialog_search_condition);
        WindowManager.LayoutParams lp = window.getAttributes();
        //这句就是设置dialog横向满屏了。
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        TextView tvSearch = window.findViewById(R.id.tv_search);
        TextView tvClearCondition = window.findViewById(R.id.tv_clear_condition);

        EditText etClearCondition = window.findViewById(R.id.et_search_condition);
        CheckBox ck2Month = window.findViewById(R.id.ck_3_month);
        CheckBox ck1Year = window.findViewById(R.id.ck_1_year);

        CheckBox ck1Month = window.findViewById(R.id.ck_1_month);
        CheckBox ck3Month2 = window.findViewById(R.id.ck_3_month2);
        CheckBox ckScale0 = window.findViewById(R.id.ck_scale_0);
        CheckBox ckScale0Than = window.findViewById(R.id.ck_scale_0_than);
        CheckBox ckLow100w = window.findViewById(R.id.ck_low_100w);
        CheckBox ckAbnormalLLiquidation = window.findViewById(R.id.ck_abnormal_liquidation);
        CheckBox ckWithoutLiquidation = window.findViewById(R.id.ck_without_qualifications);
        CheckBox ck_without_hint = window.findViewById(R.id.ck_without_hint);
        CheckBox ck_administrator = window.findViewById(R.id.ck_administrator);
        CheckBox ck_administrator_create = window.findViewById(R.id.ck_administrator_create);
        CheckBox ck_administrator_other = window.findViewById(R.id.ck_administrator_other);

    }
}
