package demo.third.com.exceldemo.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
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
import demo.third.com.exceldemo.service.entity.ZczcjhEntity;
import demo.third.com.exceldemo.ui.adapter.ProductsInfoAdapter;
import demo.third.com.exceldemo.ui.adapter.ZczczxAdapter;
import demo.third.com.exceldemo.ui.views.AutoRefreshLayout;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.JumpTools;
import demo.third.com.exceldemo.utils.Tools;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;
import static demo.third.com.exceldemo.utils.Link.SEARCH_AOIN;
import static demo.third.com.exceldemo.utils.Link.SEARCH_POF_FUTURES;
import static demo.third.com.exceldemo.utils.Link.SEARCH_POF_SECURITIES;
import static demo.third.com.exceldemo.utils.Link.ZXJH;


/**
 * @author peter
 * 资产支持专项计划信息公示
 */
public class LandZczcjhActivity extends BaseActivity implements SwipeRefreshLayout
        .OnRefreshListener,
        AutoRefreshLayout.OnLoadListener {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_pro_name)
    EditText etProName;
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
    /**
     * 直投子公司
     */
    @BindView(R.id.rl_ztzgs)
    RelativeLayout rl_ztzgs;
    @BindView(R.id.refresh_lay)
    AutoRefreshLayout mAutoRefresh;

    private ZczczxAdapter infoAdapter;
    private CommonSearchResultEntity searchResultEntity;
    private CommonSearchResultEntity.ResultBean resultBean;
    private String flag;
    private String url;
    private ProgressDialog progressDialog;
    private ZczcjhEntity zczcjhEntity;

    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        progressDialog = initDialog(progressDialog, LandZczcjhActivity.this, "查询中...");
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText(getResources().getString(R.string.txt_assert_support));
        mAutoRefresh.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent);
        mAutoRefresh.setOnRefreshListener(this);
        mAutoRefresh.setOnLoadListener(this);
        etProName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent
                        .ACTION_UP) {
                    //业务代码
                    readySearch(1);
                    return true;
                }
                return false;
            }
        });
        lvProductsInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (searchResultEntity != null) {
                    String url = "";
                    if (!TextUtils.isEmpty(flag)) {
                        switch (flag) {
                            case "证券公司资管产品":
                                url = searchResultEntity.getResult().getPofSecurities().getList().get(position).getUrl();
                                break;
                            case "证券公司直投基金":
                                url = searchResultEntity.getResult().getAoinProducts().getList().get(position).getUrl();
                                break;
                            case "期货公司资管产品":
                                url = searchResultEntity.getResult().getPofFutures().getList().get(position).getUrl();
                                break;
                            default:
                                break;
                        }
                    }
                    if (!TextUtils.isEmpty(url)) {
                        JumpTools.jumpWithUrl(LandZczcjhActivity.this, MyWebActivity.class, url, flag);
                    }

                }
            }
        });

    }

    /**
     * 搜索前的数据采集
     */
    private void readySearch(int page) {
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
        searchZqgszgcp(etProName.getText().toString(), time1, time2, page);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zczcjh;
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
                Tools.showDateChoice(LandZczcjhActivity.this, (TextView) view);
                break;
            case R.id.tv_search:
                readySearch(1);
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
     * @param foundDateFrom
     * @param foundDateTo   证券公司资管产品搜索
     */
    private void searchZqgszgcp(String productName, String foundDateFrom, String foundDateTo, final int page) {
        if (page == 1) {
            if (progressDialog != null) {
                progressDialog.show();
            }
        }

        Map<String, String> params = new HashMap<>();
        params.put("pageIndex", page + "");
        params.put("pageSize", "50");
        if (!TextUtils.isEmpty(productName)) {
            params.put("name", productName);
        }
        if (!TextUtils.isEmpty(foundDateFrom)) {
            params.put("createDateFrom", foundDateFrom);
        }
        if (!TextUtils.isEmpty(foundDateTo)) {
            params.put("createDateTo", foundDateTo);
        }


        OkHttpUtils.post().url(ZXJH).params(params)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if (progressDialog != null) {
                    progressDialog.cancel();
                }
                mAutoRefresh.setRefreshing(false);
                mAutoRefresh.setLoading(false);
            }

            @Override
            public void onResponse(String response, int id) {
                zczcjhEntity = CustomGson.fromJson(response, ZczcjhEntity.class);
                if (progressDialog != null) {
                    progressDialog.cancel();
                }
                if (zczcjhEntity != null) {
                    infoAdapter = new ZczczxAdapter(LandZczcjhActivity.this, zczcjhEntity.getResult().getData().getList());
                    lvProductsInfo.setAdapter(infoAdapter);
                }
            }
        });
    }

    private void clearAllCondition() {
        etProName.setText("");
        tvTime1.setText("");
        tvTime2.setText("");
    }

    @Override
    public void onRefresh() {
        mAutoRefresh.postDelayed(new Runnable() {
            @Override
            public void run() {
                readySearch(1);
            }
        }, 1000);

//        readySearch(1);
    }

    @Override
    public void onLoad() {
//        page++;
//        mAutoRefresh.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                readySearch(page);
//            }
//        }, 1000);

    }
}
