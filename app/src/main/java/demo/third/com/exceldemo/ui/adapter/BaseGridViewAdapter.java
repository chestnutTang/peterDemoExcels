package demo.third.com.exceldemo.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.04.10
 *
 * @author peter
 */
public class BaseGridViewAdapter extends BaseAdapter {


    private LayoutInflater inflater;
    private ViewHolder holder;
    private List mData;
    private Context mContext;
    private String[] title = {"私募基金", "管理人分类", "服务机构", "从业机构", "证券产品", "直投基金", "期货产品", "更多"};
    private int[] imgIdSet = {R.drawable.ic_smjj, R.drawable.ic_glrfl, R.drawable.ic_fwjg, R.drawable.ic_cyjg, R.drawable.ic_zqcp, R.drawable.ic_ztjj, R.drawable.ic_qhcp, R.drawable.ic_more};

    public BaseGridViewAdapter(Context context, List data) {
        inflater = LayoutInflater.from(context);
        mData = data;
        mContext = context;
    }


    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
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
            convertView = inflater.inflate(R.layout.item_home_page, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvBannerWelfare.setText(title[position]);
        Glide.with(mContext).load(imgIdSet[position]).into(holder.imgBannerWelfare);
//        Glide.with(mContext).load(bgIdSet[position]).into(holder.ivBg);
//        holder.rlGridViewBg.setBackgroundResource(bgIdSet[position]);
//        Glide.with(mContext).asBitmap().load(bgIdSet[position]).into(new SimpleTarget<Bitmap>() {
//            @Override
//            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
//                Drawable drawable = new BitmapDrawable(resource);
////                holder.rlGridViewBg.setBackground(drawable);
//                holder.ivBg.setImageBitmap(resource);
//            }
//        });
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.img_banner_welfare)
        ImageView imgBannerWelfare;
        @BindView(R.id.iv_bg)
        ImageView ivBg;
        @BindView(R.id.tv_banner_welfare_fabu)
        TextView tvBannerWelfareFabu;
        @BindView(R.id.rel_banner_welfare)
        RelativeLayout relBannerWelfare;
        @BindView(R.id.tv_banner_welfare)
        TextView tvBannerWelfare;
        @BindView(R.id.rl_gridview_bg)
        RelativeLayout rlGridViewBg;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
