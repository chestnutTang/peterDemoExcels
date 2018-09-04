package demo.third.com.exceldemo.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
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
import demo.third.com.exceldemo.ui.adapter.ProductsInfoAdapter;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.JumpTools;
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
    EditText etProName;
    EditText etManageOrg;
    EditText etProNumber;
    TextView tvTime1;
    TextView tvTime2;
    TextView tvSearch;
    TextView tvClearCondition;
    @BindView(R.id.lv_products_info)
    ListView lvProductsInfo;
    TextView tv_title2;
    /**
     * 直投子公司
     */
    RelativeLayout rl_ztzgs;
    @BindView(R.id.refresh_lay)
    SmartRefreshLayout mAutoRefresh;

    private ProductsInfoAdapter infoAdapter;
    private CommonSearchResultEntity searchResultEntity;
    private CommonSearchResultEntity.ResultBean resultBean;
    private String flag;
    private String url;
    private ProgressDialog progressDialog;

    private int page = 1;
    private View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initHeader();
        initView();
        bindListener();
        progressDialog = initDialog(progressDialog, ProductsInfoActivity.this, "查询中...");

    }

    private void initHeader() {
        infoAdapter = new ProductsInfoAdapter(ProductsInfoActivity.this,
                null, flag);
        headerView = LayoutInflater.from(this).inflate(R.layout.header_products_info, null);
        if (headerView != null)
            lvProductsInfo.addHeaderView(headerView);
        lvProductsInfo.setAdapter(infoAdapter);
    }

    @Override
    protected void bindListener() {
        super.bindListener();
        tvTime1.setOnClickListener(this);
        tvTime2.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
        tvClearCondition.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        super.initView();

        etProName = headerView.findViewById(R.id.et_pro_name);
        etManageOrg = headerView.findViewById(R.id.et_manage_org);
        etProNumber = headerView.findViewById(R.id.et_pro_number);
        tvTime1 = headerView.findViewById(R.id.tv_time1);
        tvTime2 = headerView.findViewById(R.id.tv_time2);
        tvSearch = headerView.findViewById(R.id.tv_search);
        tvClearCondition = headerView.findViewById(R.id.tv_clear_condition);
        rl_ztzgs = headerView.findViewById(R.id.rl_ztzgs);
        tv_title2 = headerView.findViewById(R.id.tv_title2);


        //设置 Header 为 贝塞尔雷达 样式
        mAutoRefresh.setRefreshHeader(new BezierRadarHeader(this).setEnableHorizontalDrag(true));
        //设置 Footer 为 球脉冲 样式
        mAutoRefresh.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.FixedBehind));
        mAutoRefresh.setEnableRefresh(true);
        mAutoRefresh.setEnableLoadMore(true);
        mAutoRefresh.setDragRate(0.5f);
        mAutoRefresh.setReboundDuration(300);
        mAutoRefresh.setHeaderHeight(50);
        mAutoRefresh.setHeaderMaxDragRate(2);
        mAutoRefresh.setHeaderTriggerRate(1);
        mAutoRefresh.setEnableNestedScroll(true);
        mAutoRefresh.setEnableLoadMoreWhenContentNotFull(false);
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
//        mAutoRefresh.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent);
//        mAutoRefresh.setOnRefreshListener(this);
//        mAutoRefresh.setOnLoadListener(this);
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
                    readySearch(1);
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
                    readySearch(1);
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
                                url = searchResultEntity.getResult().getPofSecurities()
                                        .getList().get(position % 50 - 1).getUrl();
                                break;
                            case "证券公司直投基金":
                                url = searchResultEntity.getResult().getAoinProducts()
                                        .getList().get(position % 50 - 1).getUrl();
                                break;
                            case "期货公司资管产品":
                                url = searchResultEntity.getResult().getPofFutures()
                                        .getList().get(position % 50 - 1).getUrl();
                                break;
                            default:
                                break;
                        }
                    }
                    if (!TextUtils.isEmpty(url)) {
                        JumpTools.jumpWithUrl(ProductsInfoActivity.this, MyWebActivity.class, url, flag);
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
        searchZqgszgcp(etProName.getText().toString(), etProNumber.getText().toString(),
                etManageOrg.getText().toString(), time1, time2, page);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_products_info;
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
                Tools.showDateChoice(ProductsInfoActivity.this, (TextView) v);
                break;
            case R.id.tv_search:
                readySearch(1);
                break;
            case R.id.tv_clear_condition:
                clearAllCondition();
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
            foundDateFrom, String foundDateTo, final int page) {
        if (page == 1) {
            if (progressDialog != null) {
                progressDialog.show();
            }
        }

        Map<String, String> params = new HashMap<>();
        params.put("pageIndex", page + "");
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
//                mAutoRefresh.setRefreshing(false);
//                mAutoRefresh.setLoading(false);
            }

            @Override
            public void onResponse(String response, int id) {
                searchResultEntity = CustomGson.fromJson(response, CommonSearchResultEntity.class);
                if (searchResultEntity != null) {
//                    mAutoRefresh.setRefreshing(false);
//                    mAutoRefresh.setLoading(false);
                    Tools.forceHideSoftWare(ProductsInfoActivity.this, etProName);
                    resultBean = searchResultEntity.getResult();
                    if (resultBean != null) {
                        if (page == 1) {
                            switch (flag) {
                                case "证券公司资管产品":
//                                    infoAdapter.addData(resultBean.getPofSecurities().getList());
                                    infoAdapter = new ProductsInfoAdapter(ProductsInfoActivity.this,
                                            resultBean.getPofSecurities().getList(), flag);
                                    break;
                                case "期货公司资管产品":
                                    infoAdapter = new ProductsInfoAdapter(ProductsInfoActivity.this,
                                            resultBean.getPofFutures().getList(), flag);
                                    break;
                                case "证券公司直投基金":
                                    infoAdapter = new ProductsInfoAdapter(ProductsInfoActivity.this,
                                            resultBean.getAoinProducts().getList(), flag);
                                    break;
                                default:
                                    break;
                            }
                            lvProductsInfo.setAdapter(infoAdapter);
                        } else {
                            switch (flag) {
                                case "证券公司资管产品":
                                    infoAdapter.addData(resultBean.getPofSecurities().getList());
                                    break;
                                case "期货公司资管产品":
                                    infoAdapter.addData(resultBean.getPofFutures().getList());
                                    break;
                                case "证券公司直投基金":
                                    infoAdapter.addData(resultBean.getAoinProducts().getList());
                                    break;
                                default:
                                    break;
                            }

                        }

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
