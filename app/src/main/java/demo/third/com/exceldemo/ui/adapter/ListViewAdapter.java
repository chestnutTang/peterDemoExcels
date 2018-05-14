package demo.third.com.exceldemo.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
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

    public ListViewAdapter(Context context, List list) {
        this.context = context;
        if (list == null) {
            this.list = new ArrayList();
            this.list = list;
        } else {
            this.list = list;
        }
    }

    @Override
    public int getCount() {
        return list.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_main_list, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        bindListener();

        return convertView;
    }

    void bindListener() {
        holder.llComment.setOnClickListener(this);
        holder.llShare.setOnClickListener(this);
        holder.tvFocused.setOnClickListener(this);
        holder.tvTitle.setOnClickListener(this);
        holder.tvTime.setOnClickListener(this);
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
            case R.id.tv_title:
            case R.id.tv_time:
                Tools.toast("进入详情页");
                break;
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
                .setDisplayList(SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.QZONE)
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

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
