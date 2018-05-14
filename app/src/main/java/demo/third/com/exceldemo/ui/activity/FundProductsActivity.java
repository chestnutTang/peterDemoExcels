package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnItemClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.adapter.ListViewAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.utils.Tools;

import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;

/**
 * @author songzhengpeng
 * 诚信信息、基金产品
 */
public class FundProductsActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.lv_fund_products)
    MyListView lvFundProducts;

    private ListViewAdapter listViewAdapter;
    private List<String> listDataFund = new ArrayList<>();
    private List<String> listDataCredit = new ArrayList<>();
    private List<String> listDataEmployee = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        //诚信信息
        if (listDataFund != null) {
            listDataFund.add(getResources().getString(R.string.txt_private_products));
            listDataFund.add(getResources().getString(R.string.txt_asset_manage));
            listDataFund.add(getResources().getString(R.string.txt_assert_support));
            listDataFund.add(getResources().getString(R.string.txt_assert_support_enter));
            listDataFund.add(getResources().getString(R.string.txt_future_products));
            listDataFund.add(getResources().getString(R.string.txt_direct_fund));
            listDataFund.add(getResources().getString(R.string.txt_private_fund));
        }
        //基金产品
        if (listDataCredit != null) {
            listDataCredit.add(getResources().getString(R.string.txt_no_registration));
            listDataCredit.add(getResources().getString(R.string.txt_disciplinary_action));
            listDataCredit.add(getResources().getString(R.string.txt_black_list));
        }
        //从业人员
        if (listDataEmployee != null) {
            listDataEmployee.add(getResources().getString(R.string.txt_employee_publicity));
            listDataEmployee.add(getResources().getString(R.string.txt_qualification_menu));
            listDataEmployee.add(getResources().getString(R.string.txt_qualification_reserve));
            listDataEmployee.add(getResources().getString(R.string.txt_qualification_enroll));
            listDataEmployee.add(getResources().getString(R.string.txt_qualification_info));
            listDataEmployee.add(getResources().getString(R.string.txt_qualification_search));
            listDataEmployee.add(getResources().getString(R.string.txt_qualification__enroll_week));
        }
        String flag = getIntent().getStringExtra(INTENT_FLAG);
        if (!TextUtils.isEmpty(flag)) {
            if ("fundProducts".equals(flag)) {
                tvTitle.setText(getResources().getString(R.string.txt_fund_products));
                listViewAdapter = new ListViewAdapter(FundProductsActivity.this, listDataFund, "fundproducts");
            } else if ("creditInfo".equals(flag)) {
                tvTitle.setText(getResources().getString(R.string.txt_credit_info));
                listViewAdapter = new ListViewAdapter(FundProductsActivity.this, listDataCredit, "creditInfo");
            } else if ("employee".equals(flag)) {
                tvTitle.setText(getResources().getString(R.string.txt_practitioners));
                listViewAdapter = new ListViewAdapter(FundProductsActivity.this, listDataEmployee, "employee");
            }
        }


        lvFundProducts.setAdapter(listViewAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fund_products;
    }

    @OnItemClick(R.id.lv_fund_products)
    void onItemSelected(int position) {
        switch (position) {
            case 0:
                Tools.toast("FundProductsActivity" + position);
                break;
            default:
                break;
        }
    }

    @OnClick(R.id.iv_backup)
    public void onViewClicked() {
        finish();
    }
}
