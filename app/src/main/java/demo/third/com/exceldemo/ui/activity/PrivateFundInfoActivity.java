package demo.third.com.exceldemo.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.GgqkEntity;
import demo.third.com.exceldemo.service.entity.GzllEntity;
import demo.third.com.exceldemo.ui.adapter.GzllAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.JumpTools;
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
    @BindView(R.id.rl_gzll)
    RelativeLayout rl_gzll;
    @BindView(R.id.mlv_ggqk)
    MyListView mlv_ggqk;
    @BindView(R.id.tv_jgxxzhgxsj)
    TextView tv_jgxxzhgxsj;
    @BindView(R.id.tv_tbtsxx)
    TextView tv_tbtsxx;
    @BindView(R.id.tv_case_before)
    TextView tv_case_before;
    @BindView(R.id.tv_case_after)
    TextView tv_case_after;

    private String pofMangerId;
    private GzllAdapter gzllAdapter;
    private List<GzllEntity.GoodBean> gzllEntityList;
    private List<GgqkEntity.GgqkBean> ggqkEntityList;

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
                        String haha = "{\"good\":" + data.getString("法定代表人/执行事务合伙人(委派代表)工作履历:") + "}";
                        GzllEntity customGson = CustomGson.fromJson(haha, GzllEntity.class);
                        gzllEntityList = customGson.getGood();
                        gzllAdapter = new GzllAdapter(PrivateFundInfoActivity.this, gzllEntityList, "");
                        mlv_gzll.setAdapter(gzllAdapter);

                        String ggqk = "{\"ggqk\":" + data.getString("高管情况:") + "}";
                        GgqkEntity ggqkEntity = CustomGson.fromJson(ggqk, GgqkEntity.class);
                        ggqkEntityList = ggqkEntity.getGgqk();
                        gzllAdapter = new GzllAdapter(PrivateFundInfoActivity.this, ggqkEntityList);
                        mlv_ggqk.setAdapter(gzllAdapter);

                        String zxbf = data.getString("暂行办法实施前成立的基金:");
                        if(!TextUtils.isEmpty(zxbf)){
                            String showzxbf = zxbf.substring(2, zxbf.length() - 2);
                        CharSequence charSequence = Html.fromHtml(showzxbf);
//                            tv_case_before.setText(showzxbf);
                        tv_case_before.setText(charSequence);
//                        tv_case_before.setMovementMethod(LinkMovementMethod.getInstance());//点击的时候产生超链接

                        }

                        String zxbfh = data.getString("暂行办法实施后成立的基金:");
                        if(!TextUtils.isEmpty(zxbfh)){
                            String showzxbfh = zxbfh.substring(2, zxbf.length() - 2);
                        CharSequence charSequenceh = Html.fromHtml(showzxbfh);
//                            tv_case_after.setText(showzxbfh);
                        tv_case_after.setText(charSequenceh);
//                        tv_case_after.setMovementMethod(LinkMovementMethod.getInstance());//点击的时候产生超链接
                        }





//                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(show);
//                        Pattern pattern = Pattern.compile("([\\s>])([\\w]+?://[\\w\\\\x80-\\\\xff\\#$%&~/.\\-;:=,?@\\[\\]+]*)");
//
//                        Matcher m = pattern.matcher(spannableStringBuilder);
//                        SpannableString sss = new SpannableString(charSequence);
//                        int startPoint = 0;
//                        while (m.find(startPoint)) {
//                            int endPoint = m.end();
//                            String hit = m.group();
//                            ClickableSpan clickSpan = new NoLineClickSpan(hit);
//                            sss.setSpan(clickSpan, endPoint - hit.length(), endPoint, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);//用Span替换对应长度的url
//                            startPoint = endPoint;
//                        }
//
//                        tv_case_before.setText(sss);
//                        tv_case_before.setMovementMethod(LinkMovementMethod.getInstance());//点击的时候产生超链接
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
        tv_jgxxzhgxsj.setText(data.optString("机构信息最后更新时间:"));
        tv_tbtsxx.setText(data.optString("特别提示信息:"));
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


    class NoLineClickSpan extends ClickableSpan {
        String text;

        public NoLineClickSpan(String text) {
            super();
            this.text = text;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Color.parseColor("#ffffff"));//指定颜色值
            ds.setUnderlineText(false); // 去掉下划线
        }

        @Override
        public void onClick(View widget) {
            // 点击超链接时调用
            JumpTools.jumpWithUrl(PrivateFundInfoActivity.this, MyWebActivity.class, text);
        }
    }
}