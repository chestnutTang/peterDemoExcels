package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.adapter.ProductsInfoAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.utils.Tools;


/**
 * @author songzhengpeng
 * 证券公司资管产品备案信息公示
 */
public class ProductsInfoActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_pro_name)
    EditText etProName;
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
    @BindView(R.id.tv_clear_condition)
    TextView tvClearCondition;
    @BindView(R.id.lv_products_info)
    MyListView lvProductsInfo;

    private ProductsInfoAdapter infoAdapter;
    private List<String> listResult = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText(getResources().getString(R.string.txt_asset_manage));
        if (listResult != null) {
            listResult.add("");
            listResult.add("");
            listResult.add("");
            listResult.add("");
            listResult.add("");
            listResult.add("");
            listResult.add("");
        }
        infoAdapter = new ProductsInfoAdapter(ProductsInfoActivity.this, listResult);
        lvProductsInfo.setAdapter(infoAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_products_info;
    }

    @OnClick({R.id.iv_backup, R.id.tv_time1, R.id.tv_time2, R.id.tv_search, R.id
            .tv_clear_condition})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            case R.id.tv_time1:
            case R.id.tv_time2:
                Tools.showDateChoice(ProductsInfoActivity.this, (TextView) view);
                break;
            case R.id.tv_search:
                break;
            case R.id.tv_clear_condition:
                clearAllCondition();
                break;
            default:
                break;
        }
    }

    private void clearAllCondition() {
        etProName.setText("");
        etManageOrg.setText("");
        etProNumber.setText("");
        tvTime1.setText("");
        tvTime2.setText("");
    }
}
