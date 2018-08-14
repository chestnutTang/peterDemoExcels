package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.GzllEntity;
import demo.third.com.exceldemo.ui.adapter.GzllAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.utils.CustomGson;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;
import static demo.third.com.exceldemo.utils.Link.DETAIL;

/**
 * 私募基金公示信息
 *
 * @author peter
 */
public class PrivateFundInfoActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_jjglrqczw)
    TextView tv_jjglrqczw;
    @BindView(R.id.tv_jjglrqcyw)
    TextView tv_jjglrqcyw;
    @BindView(R.id.tv_djbh)
    TextView tv_djbh;
    @BindView(R.id.tv_zzjgdm)
    TextView tv_zzjgdm;
    @BindView(R.id.tv_djsj)
    TextView tv_djsj;
    @BindView(R.id.tv_zcdz)
    TextView tv_zcdz;
    @BindView(R.id.tv_bgdz)
    TextView tv_bgdz;
    @BindView(R.id.tv_zczb)
    TextView tv_zczb;
    @BindView(R.id.tv_sjzb)
    TextView tv_sjzb;
    @BindView(R.id.tv_qyxz)
    TextView tv_qyxz;
    @BindView(R.id.tv_zczbsjbl)
    TextView tv_zczbsjbl;
    @BindView(R.id.tv_gljjzylb)
    TextView tv_gljjzylb;
    @BindView(R.id.tv_sqdqtywlx)
    TextView tv_sqdqtywlx;
    @BindView(R.id.tv_ygrs)
    TextView tv_ygrs;
    @BindView(R.id.tv_jgwz)
    TextView tv_jgwz;
    @BindView(R.id.tv_sfwhy)
    TextView tv_sfwhy;
    @BindView(R.id.tv_flyjsxx)
    TextView tv_flyjsxx;
    @BindView(R.id.tv_flyjszt)
    TextView tv_flyjszt;
    @BindView(R.id.tv_lsswsmc)
    TextView tv_lsswsmc;
    @BindView(R.id.tv_lsxm)
    TextView tv_lsxm;
    @BindView(R.id.tv_fddbr)
    TextView tv_fddbr;
    @BindView(R.id.tv_sfycyzg)
    TextView tv_sfycyzg;
    @BindView(R.id.tv_zgqdfs)
    TextView tv_zgqdfs;
    @BindView(R.id.mlv_gzll)
    MyListView mlv_gzll;

    private String pofMangerId;
    private GzllAdapter gzllAdapter;
    private List<GzllEntity.GoodBean> gzllEntityList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        search(pofMangerId);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_private_fund_info;
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText(getResources().getString(R.string.tip_smjjglrgsxx));
        pofMangerId = getIntent().getStringExtra(INTENT_FLAG);
    }

    @Override
    protected void search(String searchCondition) {
        super.search(searchCondition);
        Map<String, String> params = new HashMap<>();
        params.put("pofMangerId", searchCondition);
        OkHttpUtils.post().url(DETAIL).params(params)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String result = jsonObject.optString("result");
                    JSONObject object = new JSONObject(result);
                    JSONObject data = object.getJSONObject("data");
                    try {
                        String haha = "{\"good\":"+data.getString("法定代表人/执行事务合伙人(委派代表)工作履历:")+"}";
                        GzllEntity customGson = CustomGson.fromJson(haha,GzllEntity.class);
                        gzllEntityList = customGson.getGood();
                        gzllAdapter = new GzllAdapter(PrivateFundInfoActivity.this,gzllEntityList,"");
                        mlv_gzll.setAdapter(gzllAdapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    setData(data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void setData(JSONObject data) {
        tv_jjglrqczw.setText(data.optString("基金管理人全称(中文):"));
        tv_jjglrqcyw.setText(data.optString("基金管理人全称(英文):"));
        tv_djbh.setText(data.optString("登记编号:"));
        tv_zzjgdm.setText(data.optString("组织机构代码:"));
        tv_djsj.setText(data.optString("登记时间:"));
        tv_zcdz.setText(data.optString("注册地址:"));
        tv_bgdz.setText(data.optString("办公地址:"));
        tv_zczb.setText(data.optString("注册资本(万元)(人民币):"));
        tv_sjzb.setText(data.optString("实缴资本(万元)(人民币):"));
        tv_qyxz.setText(data.optString("企业性质:"));
        tv_zczbsjbl.setText(data.optString("注册资本实缴比例:"));
        tv_gljjzylb.setText(data.optString("管理基金主要类别:"));
        tv_sqdqtywlx.setText(data.optString("申请的其他业务类型:"));
        tv_ygrs.setText(data.optString("员工人数:"));
        tv_jgwz.setText(data.optString("机构网址:"));
        tv_sfwhy.setText(data.optString("是否为会员:"));
        tv_flyjsxx.setText(data.optString("法律意见书信息:"));
        tv_flyjszt.setText(data.optString("法律意见书状态:"));
        tv_lsswsmc.setText(data.optString("律师事务所名称:"));
        tv_lsxm.setText(data.optString("律师姓名:"));
        tv_fddbr.setText(data.optString("法定代表人/执行事务合伙人(委派代表)姓名:"));
        tv_sfycyzg.setText(data.optString("是否有从业资格:"));
        tv_zgqdfs.setText(data.optString("资格取得方式:"));
    }

    @OnClick(R.id.iv_backup)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            default:
                break;
        }
    }
}