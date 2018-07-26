package demo.third.com.exceldemo.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.CommonSearchResultEntity;
import demo.third.com.exceldemo.ui.adapter.ProductsInfoAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.Tools;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;
import static demo.third.com.exceldemo.utils.Link.SEARCH_AOIN;
import static demo.third.com.exceldemo.utils.Link.SEARCH_POF_FUTURES;
import static demo.third.com.exceldemo.utils.Link.SEARCH_POF_SECURITIES;


/**
 * @author peter
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
    @BindView(R.id.tv_title2)
    TextView tv_title2;
    /**
     * 直投子公司
     */
    @BindView(R.id.rl_ztzgs)
    RelativeLayout rl_ztzgs;

    private ProductsInfoAdapter infoAdapter;
    private CommonSearchResultEntity searchResultEntity;
    private CommonSearchResultEntity.ResultBean resultBean;
    private String flag;
    private String url;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        progressDialog = initDialog(progressDialog, ProductsInfoActivity.this, "查询中...");
    }

    @Override
    protected void initView() {
        super.initView();
        flag = getIntent().getStringExtra(INTENT_FLAG);
        if (!TextUtils.isEmpty(flag)) {
            switch (flag) {
                case "证券公司资管产品":
                    tvTitle.setText(getResources().getString(R.string.txt_zqgszgcp));
                    tv_title2.setText(getResources().getString(R.string.txt_manage_org));
                    url = SEARCH_POF_SECURITIES;
                    rl_ztzgs.setVisibility(View.GONE);
                    break;
                case "证券公司直投基金":
                    tvTitle.setText(getResources().getString(R.string.txt_zqgsztjj));
                    tv_title2.setText(getResources().getString(R.string.tip_ztzgs));
                    url = SEARCH_AOIN;
                    rl_ztzgs.setVisibility(View.VISIBLE);
                    break;
                case "期货公司资管产品":
                    tvTitle.setText(getResources().getString(R.string.txt_future_products));
                    tv_title2.setText(getResources().getString(R.string.txt_manage_org));
                    url = SEARCH_POF_FUTURES;
                    rl_ztzgs.setVisibility(View.GONE);
                    break;
                default:
                    break;
            }
        }
        etProName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent
                        .ACTION_UP) {
                    //业务代码
                    readySearch();
                    return true;
                }
                return false;
            }
        });
        etProNumber.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent
                        .ACTION_UP) {
                    //业务代码
                    readySearch();
                    return true;
                }
                return false;
            }
        });
        etManageOrg.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent
                        .ACTION_UP) {
                    //业务代码
                    readySearch();
                    return true;
                }
                return false;
            }
        });

    }

    /**
     * 搜索前的数据采集
     */
    private void readySearch() {
        // 起始时间
        String time1 = tvTime1.getText().toString();
        // 结束时间
        String time2 = tvTime2.getText().toString();
        if (!TextUtils.isEmpty(time1)) {
            time1 = Tools.date2TimeStamp(time1);
        }
        if (!TextUtils.isEmpty(time2)) {
            time2 = Tools.date2TimeStamp(time2);
        }
        searchZqgszgcp(etProName.getText().toString(), etProNumber.getText().toString(),
                etManageOrg.getText().toString(), time1, time2);

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
                readySearch();
                break;
            case R.id.tv_clear_condition:
                clearAllCondition();
                break;
            default:
                break;
        }
    }


    /**
     * @param productName
     * @param productCode
     * @param mgrName
     * @param foundDateFrom
     * @param foundDateTo   证券公司资管产品搜索
     */
    private void searchZqgszgcp(String productName, String productCode, String mgrName, String
            foundDateFrom, String foundDateTo) {
        if (progressDialog != null) {
            progressDialog.show();
        }
        Map<String, String> params = new HashMap<>();
        params.put("pageIndex", "1");
        params.put("pageSize", "50");

        switch (flag) {
            case "证券公司资管产品":
            case "期货公司资管产品":
                if (!TextUtils.isEmpty(productName)) {
                    params.put("productName", productName);
                }
                if (!TextUtils.isEmpty(productCode)) {
                    params.put("productCode", productCode);
                }
                if (!TextUtils.isEmpty(mgrName)) {
                    params.put("mgrName", mgrName);
                }
                if (!TextUtils.isEmpty(foundDateFrom)) {
                    params.put("foundDateFrom", foundDateFrom);
                }
                if (!TextUtils.isEmpty(foundDateTo)) {
                    params.put("foundDateTo", foundDateTo);
                }
                break;
            case "证券公司直投基金":
                if (!TextUtils.isEmpty(productName)) {
                    params.put("name", productName);
                }
                if (!TextUtils.isEmpty(productCode)) {
                    params.put("code", productCode);
                }
                if (!TextUtils.isEmpty(mgrName)) {
                    params.put("aoinName", mgrName);
                }
                if (!TextUtils.isEmpty(foundDateFrom)) {
                    params.put("createDateFrom", foundDateFrom);
                }
                if (!TextUtils.isEmpty(foundDateTo)) {
                    params.put("createDateTo", foundDateTo);
                }
                break;

            default:
                break;
        }


        OkHttpUtils.post().url(url).params(params)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if (progressDialog != null) {
                    progressDialog.cancel();
                }
            }

            @Override
            public void onResponse(String response, int id) {
                searchResultEntity = CustomGson.fromJson(response, CommonSearchResultEntity.class);
                if (searchResultEntity != null) {
                    Tools.forceHideSoftWare(ProductsInfoActivity.this, etProName);
                    resultBean = searchResultEntity.getResult();
                    if (resultBean != null) {
                        infoAdapter = new ProductsInfoAdapter(ProductsInfoActivity.this,
                                resultBean, flag);
                        lvProductsInfo.setAdapter(infoAdapter);
                        switch (flag) {
                            case "期货公司资管产品":
                                try {
                                    if (resultBean.getPofFutures() == null || resultBean
                                            .getPofFutures().getList() == null
                                            || resultBean.getPofFutures().getList().size() == 0) {
                                        Tools.toast("暂无符合当前筛选条件的结果");
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    Tools.toast("暂无符合当前筛选条件的结果");
                                }
                                break;
                            case "证券公司资管产品":
                                try {
                                    if (resultBean.getPofSecurities() == null || resultBean
                                            .getPofSecurities().getList() == null
                                            || resultBean.getPofSecurities().getList().size() ==
                                            0) {
                                        Tools.toast("暂无符合当前筛选条件的结果");
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    Tools.toast("暂无符合当前筛选条件的结果");
                                }
                                break;
                            case "证券公司直投基金":
                                try {
                                    if (resultBean.getAoinProducts() == null || resultBean
                                            .getAoinProducts().getList() == null
                                            || resultBean.getAoinProducts().getList().size() == 0) {
                                        Tools.toast("暂无符合当前筛选条件的结果");
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    Tools.toast("暂无符合当前筛选条件的结果");
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    if (progressDialog != null) {
                        progressDialog.cancel();
                    }
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
