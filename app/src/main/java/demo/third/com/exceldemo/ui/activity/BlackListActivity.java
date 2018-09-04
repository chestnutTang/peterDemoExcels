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
import demo.third.com.exceldemo.ui.adapter.BlackListAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.JumpTools;
import demo.third.com.exceldemo.utils.Tools;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Constant.DEFAULT_COUNT;
import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;
import static demo.third.com.exceldemo.utils.Link.SEARCHHMD;
import static demo.third.com.exceldemo.utils.Link.SEARCHJLCF;
import static demo.third.com.exceldemo.utils.Link.SEARCH_CYRYKS;
import static demo.third.com.exceldemo.utils.Link.ZCZCZXJHBAQRHGS;

/**
 * @author peter
 * 黑名单列表
 */
public class BlackListActivity extends BaseActivity {

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
    private String flag;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        getBlackList();
    }

    private void getBlackList() {
        Map<String, String> params = new HashMap<>();
        params.put("pageIndex", "1");
        params.put("pageSize", DEFAULT_COUNT+"");
        OkHttpUtils.post().params(params).url(url)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                blackListEntity = CustomGson.fromJson(response, BlackListEntity.class);
                if (blackListEntity != null) {
                    BlackListAdapter blackListAdapter = new BlackListAdapter(BlackListActivity.this, blackListEntity, flag);
                    lvBlackList.setAdapter(blackListAdapter);
                }
            }
        });
    }

    @Override
    protected void initView() {
        super.initView();
        flag = getIntent().getStringExtra(INTENT_FLAG);
        if (!TextUtils.isEmpty(flag)) {
            switch (flag) {
                case "纪律处分":
                    tvTopTip.setVisibility(View.GONE);
                    url = SEARCHJLCF;
                    break;
                case "黑名单":
                    tvTopTip.setVisibility(View.VISIBLE);
                    url = SEARCHHMD;
                    break;
                case "资产支持专项计划备案确认函公示":
                    tvTopTip.setVisibility(View.GONE);
                    url = ZCZCZXJHBAQRHGS;
                    break;
                case "从业资格考试大纲":
                    tvTopTip.setVisibility(View.GONE);
                    url = SEARCH_CYRYKS;
                    break;
                default:
                    break;
            }
            tvTitle.setText(flag);
        }
        lvBlackList.setFocusable(false);
        lvBlackList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                JumpTools.jumpWithUrl(BlackListActivity.this, MyWebLanspaceActivity.class
//                        , blackListEntity.getResult().getData().getList().get(position).getContent()
//                        , flag);
                if(!TextUtils.isEmpty(flag)&&"资产支持专项计划备案确认函公示".equals(flag)){
                    JumpTools.jumpWithUrl(BlackListActivity.this, MyWebActivity.class
                            , blackListEntity.getResult().getData().getList().get(position).getContent()
                            , blackListEntity.getResult().getData().getList().get(position).getTitle());
                }else {
                    JumpTools.jumpWithUrl(BlackListActivity.this, MyWebLanspaceActivity.class
                            , blackListEntity.getResult().getData().getList().get(position).getContent()
                            , blackListEntity.getResult().getData().getList().get(position).getTitle());
                }

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_black_list;
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
