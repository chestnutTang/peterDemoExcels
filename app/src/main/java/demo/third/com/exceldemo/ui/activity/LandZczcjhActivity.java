package demo.third.com.exceldemo.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
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

import static demo.third.com.exceldemo.utils.Constant.DEFAULT_COUNT;
import static demo.third.com.exceldemo.utils.Link.ZXJH;


/**
 * @author peter
 * 资产支持专项计划信息公示
 */
public class LandZczcjhActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    EditText etProName;
    TextView tvTime1;
    TextView tvTime2;
    TextView tvSearch;
    TextView tvClearCondition;
    @BindView(R.id.lv_products_info)
    ListView lvProductsInfo;
    /**
     * 直投子公司
     */
    RelativeLayout rl_ztzgs;
    @BindView(R.id.refresh_lay)
    SmartRefreshLayout mAutoRefresh;

    private ZczczxAdapter infoAdapter;
    private CommonSearchResultEntity searchResultEntity;
    private CommonSearchResultEntity.ResultBean resultBean;
    private String flag;
    private String url;
    private ProgressDialog progressDialog;
    private ZczcjhEntity zczcjhEntity;

    private int page = 1;
    private View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initHeader();
        initView();
        progressDialog = initDialog(progressDialog, LandZczcjhActivity.this, "查询中...");
    }

    private void initHeader() {
        infoAdapter = new ZczczxAdapter(LandZczcjhActivity.this, null);
        headerView = LayoutInflater.from(this).inflate(R.layout.header_zczcjh, null);
        if (headerView != null)
            lvProductsInfo.addHeaderView(headerView);
        lvProductsInfo.setAdapter(infoAdapter);
    }


    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText(getResources().getString(R.string.txt_assert_support));
        Tools.initAutoRefresh(LandZczcjhActivity.this, mAutoRefresh, true);

        etProName = headerView.findViewById(R.id.et_pro_name);
        tvTime1 = headerView.findViewById(R.id.tv_time1);
        tvTime2 = headerView.findViewById(R.id.tv_time2);
        tvSearch = headerView.findViewById(R.id.tv_search);
        tvClearCondition = headerView.findViewById(R.id.tv_clear_condition);
        rl_ztzgs = headerView.findViewById(R.id.rl_ztzgs);

        tvClearCondition.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
        tvTime1.setOnClickListener(this);
        tvTime2.setOnClickListener(this);


        mAutoRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                readySearch(1);
                refreshLayout.finishRefresh(0);
            }
        });
        mAutoRefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                readySearch(page);
                refreshLayout.finishLoadMore(0);
            }
        });
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

    @OnClick({R.id.iv_backup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_time1:
            case R.id.tv_time2:
                Tools.showDateChoice(LandZczcjhActivity.this, (TextView) v);
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
        params.put("pageSize", DEFAULT_COUNT + "");
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
            }

            @Override
            public void onResponse(String response, int id) {
                zczcjhEntity = CustomGson.fromJson(response, ZczcjhEntity.class);
                if (progressDialog != null) {
                    progressDialog.cancel();
                }
                if (zczcjhEntity != null) {
                    if (page == 1) {
                        infoAdapter = new ZczczxAdapter(LandZczcjhActivity.this, zczcjhEntity.getResult().getData().getList());
                        lvProductsInfo.setAdapter(infoAdapter);
                    } else {
                        if (zczcjhEntity.getResult() != null && zczcjhEntity.getResult().getData().getList() != null
                                && zczcjhEntity.getResult().getData().getList().size() > 0) {
                            infoAdapter.addData(zczcjhEntity.getResult().getData().getList());
                        }
                    }

                }
            }
        });
    }

    private void clearAllCondition() {
        etProName.setText("");
        tvTime1.setText("");
        tvTime2.setText("");
    }

}
