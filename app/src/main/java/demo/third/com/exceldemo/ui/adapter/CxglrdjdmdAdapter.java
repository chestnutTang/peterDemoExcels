package demo.third.com.exceldemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.BlackListEntity;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.17
 * 撤销管理人登记的名单列表适配器
 *
 * @author peter
 */
public class CxglrdjdmdAdapter extends BaseAdapter {

    private Context context;
    //    private List list;
    private ViewHolder holder;
    //    private BlackListEntity blackListEntity;
    private String title;
    List<BlackListEntity.ResultBean.DataBean.ListBean> mData;

    public CxglrdjdmdAdapter(Context context, List<BlackListEntity.ResultBean.DataBean.ListBean> mData, String title) {
        this.context = context;
//        this.blackListEntity = blackListEntity;
        this.title = title;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    public void addData(List data) {
        mData.addAll(data);
        notifyDataSetChanged();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_cxglrdjdmd_list, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (mData != null && mData.size() > 0) {
            holder.tvBlackTitle.setText(title + "：" + mData.get(position).getTitle());
            holder.tvBlackTime.setText(mData.get(position).getDate());
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_black_title)
        TextView tvBlackTitle;
        @BindView(R.id.tv_black_time)
        TextView tvBlackTime;
        @BindView(R.id.rl_fund_products)
        RelativeLayout rlFundProducts;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
