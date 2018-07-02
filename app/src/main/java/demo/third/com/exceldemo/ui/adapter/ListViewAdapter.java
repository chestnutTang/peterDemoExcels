package demo.third.com.exceldemo.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.HomePageEntity;
import demo.third.com.exceldemo.ui.activity.MyWebActivity;
import demo.third.com.exceldemo.utils.JumpTools;
import demo.third.com.exceldemo.utils.Tools;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.12
 *
 * @author songzhengpeng
 */
public class ListViewAdapter extends BaseAdapter implements View.OnClickListener {

    private Context context;
    private List list;
    private ViewHolder holder;
    private String flag;
    private HomePageEntity entity;

    public ListViewAdapter(Context context, HomePageEntity entity, String flag) {
        this.context = context;
        this.entity = entity;
        this.flag = flag;
    }

    public ListViewAdapter(Context context, List list, String flag) {
        this.context = context;
        this.flag = flag;
        if (this.list == null) {
            this.list = new ArrayList();
            this.list = list;
        } else {
            this.list = list;
        }
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        if (entity != null && entity.getResult() != null && entity.getResult().getNews() != null) {
            return entity.getResult().getNews().size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_main_list, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        bindListener();
        if (!TextUtils.isEmpty(flag)) {
            //首页
            if ("homepage".equals(flag)) {
                holder.llHomePage.setVisibility(View.VISIBLE);
                holder.rlFundProducts.setVisibility(View.GONE);
                if (entity != null && entity.getResult() != null && entity.getResult().getNews() != null) {
                    holder.tvTitle.setText(entity.getResult().getNews().get(position).getTitle());
                    String times = entity.getResult().getNews().get(position).getDate();
//                    String times = Tools.timeStamp2Date(entity.getResult().getNews().get(position).getDate(), "");
                    if (!TextUtils.isEmpty(times)) {
                        holder.tvTime.setText(times);
                    }
                }
            } else if ("fundProducts".equals(flag) || "creditInfo".equals(flag) || "employee".equals(flag) || "employeeOrg".equals(flag)) {
                holder.llHomePage.setVisibility(View.GONE);
                holder.rlFundProducts.setVisibility(View.VISIBLE);
                holder.tvTitleFund.setText(list.get(position).toString());
            }
        }
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JumpTools.jumpWithUrl(context, MyWebActivity.class, entity.getResult().getNews().get(position).getContent());
            }
        });
        holder.tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JumpTools.jumpWithUrl(context, MyWebActivity.class, entity.getResult().getNews().get(position).getContent());
            }
        });


        return convertView;
    }

    void bindListener() {
        holder.llComment.setOnClickListener(this);
        holder.llShare.setOnClickListener(this);
        holder.tvFocused.setOnClickListener(this);
//        holder.tvTitle.setOnClickListener(this);
//        holder.tvTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_share:
                openShare();
                break;
            case R.id.tv_focused:
                break;
            //模拟onItemClick点击事件，跳转详情页
//            case R.id.tv_title:
//            case R.id.tv_time:
//                Tools.toast("进入详情页");
////                JumpTools.jumpWithUrl(context, MyWebActivity.class, "http://gs.amac.org.cn/amac-infodisc/res/pof/fund/351000133588.html");
//                JumpTools.jumpWithUrl(context, MyWebActivity.class, entity.getResult().getNews().get(0).getContent());
//                break;
            default:
                break;
        }
    }

    /**
     * 分享功能
     */
    private void openShare() {
        UMWeb web = new UMWeb("https://www.baidu.com/");
        //标题
        web.setTitle("牛逼不用解释");
        //描述
        web.setDescription("sldfjsdk");
        new ShareAction((Activity) context)
                .withMedia(web)
                .setDisplayList(SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN,
                        SHARE_MEDIA.QZONE)
                .setCallback(shareListener).open();
    }

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(context, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(context, "失 败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(context, "取消了", Toast.LENGTH_LONG).show();
        }
    };

    static class ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_focused)
        TextView tvFocused;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_read_counts)
        TextView tvReadCounts;
        @BindView(R.id.tv_praise_count)
        TextView tvPraiseCount;
        @BindView(R.id.ll_praise)
        LinearLayout llPraise;
        @BindView(R.id.ll_comment)
        LinearLayout llComment;
        @BindView(R.id.ll_share)
        LinearLayout llShare;
        @BindView(R.id.line_bottom)
        View lineBottom;
        @BindView(R.id.tv_title_fund)
        TextView tvTitleFund;
        @BindView(R.id.ll_home_page)
        LinearLayout llHomePage;
        @BindView(R.id.rl_fund_products)
        RelativeLayout rlFundProducts;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
