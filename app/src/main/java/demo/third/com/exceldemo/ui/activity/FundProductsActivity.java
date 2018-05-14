package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
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

/**
 * @author songzhengpeng
 */
public class FundProductsActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.lv_fund_products)
    MyListView lvFundProducts;

    private ListViewAdapter listViewAdapter;
    private List<Integer> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        if (listData != null) {
            listData.add(1);
            listData.add(1);
            listData.add(1);
            listData.add(1);
            listData.add(1);
            listData.add(1);
        }
        tvTitle.setText("基金产品");

        listViewAdapter = new ListViewAdapter(FundProductsActivity.this, listData, "fundproducts");
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
