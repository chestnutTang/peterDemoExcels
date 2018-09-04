package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
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
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnItemClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.BlackListEntity;
import demo.third.com.exceldemo.ui.adapter.CxglrdjdmdAdapter;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.JumpTools;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Constant.DEFAULT_COUNT;


/**
 * @author peter
 * 撤销管理人登记的名单
 */
public class CxglrydjdmdActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_top_tip)
    TextView tvTopTip;
    @BindView(R.id.lv_black_list)
    ListView lvBlackList;
    @BindView(R.id.refresh_lay)
    SmartRefreshLayout mAutoRefresh;

    private BlackListEntity blackListEntity;
    private String url, title;
    private int page = 1;
    private CxglrdjdmdAdapter blackListAdapter;
    private List<BlackListEntity.ResultBean.DataBean.ListBean> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        getBlackList(1);
    }

    private void initRefresh(boolean isCanRefresh) {
        //设置 Header 为 贝塞尔雷达 样式
        mAutoRefresh.setRefreshHeader(new BezierRadarHeader(this).setEnableHorizontalDrag(true));
        //设置 Footer 为 球脉冲 样式
        mAutoRefresh.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.FixedBehind));
        mAutoRefresh.setEnableRefresh(isCanRefresh);
        mAutoRefresh.setEnableLoadMore(isCanRefresh);
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
                getBlackList(1);
                refreshLayout.finishRefresh(0);
            }
        });
        mAutoRefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                getBlackList(page);
                refreshLayout.finishLoadMore(0);
            }
        });
    }

    private void getBlackList(final int page) {
        Map<String, String> params = new HashMap<>();
        params.put("pageIndex", page + "");
        params.put("pageSize", DEFAULT_COUNT + "");
        OkHttpUtils.post().params(params).url(url)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                blackListEntity = CustomGson.fromJson(response, BlackListEntity.class);
                if (blackListEntity != null && blackListEntity.getResult() != null
                        && blackListEntity.getResult().getData() != null
                        && blackListEntity.getResult().getData().getList() != null
                        && blackListEntity.getResult().getData().getList().size() > 0) {
                    dataList = blackListEntity.getResult().getData().getList();
                    if (page == 1) {
                        blackListAdapter = new CxglrdjdmdAdapter(CxglrydjdmdActivity.this
                                , dataList, title);
                        lvBlackList.setAdapter(blackListAdapter);
                    } else {
                        blackListAdapter.addData(dataList);
                    }

                }
            }
        });
    }

    @Override
    protected void initView() {
        super.initView();
        lvBlackList.setFocusable(false);
        url = getIntent().getStringExtra("url");
        title = getIntent().getStringExtra("title");
        boolean isCanRefresh = false;
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setText(title);
            if (getResources().getString(R.string.txt_cancel_manage).equals(title)) {
                tvTopTip.setVisibility(View.VISIBLE);
                isCanRefresh = false;
            } else {
                tvTopTip.setVisibility(View.GONE);
                isCanRefresh = true;
            }
        }
        initRefresh(isCanRefresh);
        lvBlackList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    JumpTools.jumpWithUrl(CxglrydjdmdActivity.this, MyWebLanspaceActivity.class
                            , dataList.get(position % DEFAULT_COUNT).getContent()
                            , dataList.get(position % DEFAULT_COUNT).getTitle());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_cxglrdjdmd_list;
    }

    @OnItemClick(R.id.lv_black_list)
    void onItemtClicked(int position) {
//        Tools.toast("黑名单" + position);
    }

    @OnClick(R.id.iv_backup)
    public void onViewClicked() {
        finish();
    }
}
