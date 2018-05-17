package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.adapter.PrivateProductsAdapter;

/**
 * 证券公司私募产品备案
 */
public class PrivateProductsActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.lv_private_products)
    ListView lvPrivateProducts;

    private PrivateProductsAdapter productsAdapter;
    private List<String> listResult = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        if (listResult != null) {
            listResult.add("");
            listResult.add("");
            listResult.add("");
            listResult.add("");
            listResult.add("");
            listResult.add("");
            listResult.add("");
        }
        productsAdapter = new PrivateProductsAdapter(PrivateProductsActivity.this, listResult);
        lvPrivateProducts.setAdapter(productsAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_private_products;
    }

    @OnClick(R.id.iv_backup)
    public void onViewClicked() {
        finish();
    }
}
