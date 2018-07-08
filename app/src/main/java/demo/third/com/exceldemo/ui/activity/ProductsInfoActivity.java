package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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
import demo.third.com.exceldemo.ui.adapter.ProductsInfoAdapter;
import demo.third.com.exceldemo.ui.adapter.SearchResultAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.Tools;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;
import static demo.third.com.exceldemo.utils.Constant.PRIVATEFUNDACTIVITY;
import static demo.third.com.exceldemo.utils.Link.SEARCH;


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
    private SearchResultEntity searchResultEntity;
    private SearchResultEntity.ResultBean resultBean;
    private String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        flag = getIntent().getStringExtra(INTENT_FLAG);
        switch (flag) {
            case "证券公司资管产品":
                tvTitle.setText(getResources().getString(R.string.txt_zqgszgcp));
                break;
            case "证券公司直投基金":
                tvTitle.setText(getResources().getString(R.string.txt_zqgsztjj));
                break;
            case "期货公司资管产品":
                tvTitle.setText(getResources().getString(R.string.txt_future_products));
                break;
            default:
                break;
        }

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
                search(etProName.getText().toString());
                break;
            case R.id.tv_clear_condition:
                clearAllCondition();
                break;
            default:
                break;
        }
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
        params.put("pageSize", "1000");
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
                    resultBean = searchResultEntity.getResult();
                    infoAdapter = new ProductsInfoAdapter(ProductsInfoActivity.this, resultBean);
                    lvProductsInfo.setAdapter(infoAdapter);
                }
            }
        });
    }

    private void clearAllCondition() {
        etProName.setText("");
        etManageOrg.setText("");
        etProNumber.setText("");
        tvTime1.setText("");
        tvTime2.setText("");
    }
}
