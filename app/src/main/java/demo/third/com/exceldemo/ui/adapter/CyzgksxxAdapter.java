package demo.third.com.exceldemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.17
 * 黑名单列表适配器
 *
 * @author peter
 */
public class CyzgksxxAdapter extends BaseAdapter {

    private Context context;
    private List list;
    private ViewHolder holder;

    public CyzgksxxAdapter(Context context, List list) {
        this.context = context;
        if (this.list == null) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_cyzgks_list, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvBlackTitle.setText(list.get(position).toString());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_black_title)
        TextView tvBlackTitle;
        @BindView(R.id.tv_download)
        TextView tv_download;
        @BindView(R.id.rl_fund_products)
        RelativeLayout rlFundProducts;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
