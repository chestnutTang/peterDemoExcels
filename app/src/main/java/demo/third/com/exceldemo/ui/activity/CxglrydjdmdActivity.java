package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnItemClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.BlackListEntity;
import demo.third.com.exceldemo.ui.adapter.CxglrdjdmdAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.JumpTools;
import okhttp3.Call;


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
    MyListView lvBlackList;

    private List<String> listResult = new ArrayList<>();
    private BlackListEntity blackListEntity;
    private String url, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        getBlackList();
    }

    private void getBlackList() {
        Map<String, String> params = new HashMap<>();
        params.put("pageIndex", "1");
        params.put("pageSize", "50");
        OkHttpUtils.post().params(params).url(url)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                blackListEntity = CustomGson.fromJson(response, BlackListEntity.class);
                if (blackListEntity != null) {
                    CxglrdjdmdAdapter blackListAdapter = new CxglrdjdmdAdapter(CxglrydjdmdActivity.this, blackListEntity,title);
                    lvBlackList.setAdapter(blackListAdapter);
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
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setText(title);
            if (getResources().getString(R.string.txt_cancel_manage).equals(title)) {
                tvTopTip.setVisibility(View.VISIBLE);
            } else {
                tvTopTip.setVisibility(View.GONE);
            }
        }
        lvBlackList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                JumpTools.jumpWithUrl(CxglrydjdmdActivity.this, MyWebLanspaceActivity.class
                        , blackListEntity.getResult().getData().getList().get(position).getContent()
                        , blackListEntity.getResult().getData().getList().get(position).getTitle());
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
