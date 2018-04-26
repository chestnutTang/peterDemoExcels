package demo.third.com.exceldemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
        Glide.with(mContext).load(R.drawable.ic_home_checked).into(holder.imgBannerWelfare);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.img_banner_welfare)
        ImageView imgBannerWelfare;
        @BindView(R.id.tv_banner_welfare_fabu)
        TextView tvBannerWelfareFabu;
        @BindView(R.id.rel_banner_welfare)
        RelativeLayout relBannerWelfare;
        @BindView(R.id.tv_banner_welfare)
        TextView tvBannerWelfare;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
