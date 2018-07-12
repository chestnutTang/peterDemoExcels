package demo.third.com.exceldemo.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import demo.third.com.exceldemo.ui.adapter.LandSpaceAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.utils.CustomGson;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;
import static demo.third.com.exceldemo.utils.Link.SEARCH;

/**
 * @author peter
 */
public class LandSpaceActivity extends BaseActivity implements CompoundButton
        .OnCheckedChangeListener {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ck_smzqjjzzfx)
    CheckBox ckSmzqjjzzfx;
    @BindView(R.id.ck_smzqjjgwgl)
    CheckBox ckSmzqjjgwgl;
    @BindView(R.id.ck_smgqjj)
    CheckBox ckSmgqjj;
    @BindView(R.id.ck_cytzzj)
    CheckBox ckCytzzj;
    @BindView(R.id.ck_smgqjj2)
    CheckBox ckSmgqjj2;
    @BindView(R.id.ck_scale_0)
    CheckBox ckScale0;
    @BindView(R.id.ck_scale_0_than)
    CheckBox ckScale0Than;
    @BindView(R.id.ck_low_capital)
    CheckBox ckLowCapital;
    @BindView(R.id.ck_low_100w)
    CheckBox ckLow100w;
    @BindView(R.id.ck_abnormal_liquidation)
    CheckBox ckAbnormalLiquidation;
    @BindView(R.id.ck_sljg)
    CheckBox ckSljg;
    @BindView(R.id.ck_ycjg)
    CheckBox ckYcjg;
    @BindView(R.id.ck_xjtb)
    CheckBox ckXjtb;
    @BindView(R.id.ck_zdyl)
    CheckBox ckZdyl;
    @BindView(R.id.ck_wfbtdx)
    CheckBox ckWfbtdx;
    @BindView(R.id.ck_xgztczblcxjl)
    CheckBox ckXgztczblcxjl;
    @BindView(R.id.tv_search_all)
    TextView tvSearchAll;
    @BindView(R.id.ll_search_all)
    LinearLayout ll_search_all;
    @BindView(R.id.tv_clear_condition)
    TextView tvClearCondition;
    @BindView(R.id.lv_private_fund)
    MyListView lvPrivateFund;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.tv_3)
    TextView tv3;
    @BindView(R.id.tv_4)
    TextView tv4;
    @BindView(R.id.tv_5)
    TextView tv5;
    @BindView(R.id.tv_6)
    TextView tv6;
    @BindView(R.id.tv_7)
    TextView tv7;
    @BindView(R.id.ll_condition1)
    LinearLayout llCondition1;
    @BindView(R.id.ll_condition2)
    LinearLayout llCondition2;
    @BindView(R.id.ll_condition3)
    LinearLayout llCondition3;

    private SearchResultEntity searchResultEntity;
    private SearchResultEntity.ResultBean resultBean;
    private LandSpaceAdapter infoAdapter;
    private String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        bindListener();
    }

    @Override
    protected void initView() {
        super.initView();
        flag = getIntent().getStringExtra(INTENT_FLAG);
        if (!TextUtils.isEmpty(flag)) {
            tvTitle.setText(flag);
            if (getResources().getString(R.string.tip_smjjglrflgs).equals(flag)) {
                llCondition1.setVisibility(View.VISIBLE);
                llCondition2.setVisibility(View.VISIBLE);
                llCondition3.setVisibility(View.VISIBLE);
                ckAbnormalLiquidation.setVisibility(View.VISIBLE);
                ll_search_all.setVisibility(View.VISIBLE);
            } else {
                llCondition1.setVisibility(View.GONE);
                llCondition2.setVisibility(View.GONE);
                llCondition3.setVisibility(View.GONE);
                ckAbnormalLiquidation.setVisibility(View.GONE);
                ll_search_all.setVisibility(View.GONE);
                search("");
            }
            switch (flag) {
                case "私募基金管理人分类公示":
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_landspace;
    }

    @Override
    protected void bindListener() {
        super.bindListener();
        ckSmzqjjzzfx.setOnCheckedChangeListener(this);
        ckSmzqjjgwgl.setOnCheckedChangeListener(this);
        ckSmgqjj.setOnCheckedChangeListener(this);
        ckCytzzj.setOnCheckedChangeListener(this);
        ckSmgqjj2.setOnCheckedChangeListener(this);
        ckScale0.setOnCheckedChangeListener(this);
        ckScale0Than.setOnCheckedChangeListener(this);
        ckLowCapital.setOnCheckedChangeListener(this);
        ckLow100w.setOnCheckedChangeListener(this);
        ckAbnormalLiquidation.setOnCheckedChangeListener(this);
        ckSljg.setOnCheckedChangeListener(this);
        ckYcjg.setOnCheckedChangeListener(this);
        ckXjtb.setOnCheckedChangeListener(this);
        ckZdyl.setOnCheckedChangeListener(this);
        ckWfbtdx.setOnCheckedChangeListener(this);
        ckXgztczblcxjl.setOnCheckedChangeListener(this);
    }

    private void clearAllCheckbox() {

        List<CheckBox> list = new ArrayList<>();
        list.add(ckSmzqjjzzfx);
        list.add(ckSmzqjjgwgl);
        list.add(ckSmgqjj);
        list.add(ckCytzzj);
        list.add(ckSmgqjj2);
        list.add(ckScale0);
        list.add(ckScale0Than);
        list.add(ckLowCapital);
        list.add(ckLow100w);
        list.add(ckAbnormalLiquidation);
        list.add(ckSljg);
        list.add(ckYcjg);
        list.add(ckXjtb);
        list.add(ckZdyl);
        list.add(ckWfbtdx);
        list.add(ckXgztczblcxjl);

        for (CheckBox view : list) {
            view.setBackgroundResource(R.drawable.edit_search_condition);
            view.setTextColor(Color.parseColor("#2F7DFB"));
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
                    resultBean = searchResultEntity.getResult();
                    infoAdapter = new LandSpaceAdapter(LandSpaceActivity.this, resultBean);
                    lvPrivateFund.setAdapter(infoAdapter);
                }
            }
        });
    }

    @OnClick({R.id.iv_backup, R.id.tv_search_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            case R.id.tv_search_all:
                search("");
                break;
            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            buttonView.setBackgroundResource(R.drawable.edit_search_condition_checked);
            buttonView.setTextColor(Color.parseColor("#ffffff"));
        } else {
            buttonView.setBackgroundResource(R.drawable.edit_search_condition);
            buttonView.setTextColor(Color.parseColor("#2F7DFB"));
        }
    }
}
