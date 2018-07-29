package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.SearchResultEntity;
import demo.third.com.exceldemo.ui.adapter.PrivateFundOrgAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.Tools;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;
import static demo.third.com.exceldemo.utils.Link.SEARCH;


/**
 * @author peter
 * 证券公司资管产品备案信息公示
 */
public class PrivateFundOrgActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_pro_name)
    EditText etProName;
    @BindView(R.id.et_manage_org)
    EditText etManageOrg;
    //    @BindView(R.id.et_pro_number)
//    EditText etProNumber;
//    @BindView(R.id.tv_time1)
//    TextView tvTime1;
//    @BindView(R.id.tv_time2)
//    TextView tvTime2;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    //    @BindView(R.id.tv_clear_condition)
//    TextView tvClearCondition;
    @BindView(R.id.lv_products_info)
    MyListView lvProductsInfo;

    private PrivateFundOrgAdapter infoAdapter;
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
        if (!TextUtils.isEmpty(flag)) {
            tvTitle.setText(flag);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fund_manage;
    }

    @OnClick({R.id.iv_backup, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            case R.id.tv_clear_condition:
                clearAllCondition();
                break;
            // 搜索
            case R.id.tv_search:
                search(etProName.getText().toString());
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
                    Tools.forceHideSoftWare(PrivateFundOrgActivity.this, etProName);
                    resultBean = searchResultEntity.getResult();
                    infoAdapter = new PrivateFundOrgAdapter(PrivateFundOrgActivity.this, resultBean);
                    lvProductsInfo.setAdapter(infoAdapter);
                }
            }
        });
    }

    private void clearAllCondition() {
        etProName.setText("");
        etManageOrg.setText("");
//        etProNumber.setText("");
//        tvTime1.setText("");
//        tvTime2.setText("");
    }
}
