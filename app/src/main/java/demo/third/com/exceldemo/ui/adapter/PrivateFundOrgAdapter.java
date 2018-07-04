package demo.third.com.exceldemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.18
 */
public class PrivateFundOrgAdapter extends BaseAdapter {


    private Context mContext;
    private ViewHolder holder;
    private List<String> list;

    public PrivateFundOrgAdapter(Context context, List<String> list) {
        mContext = context;
        if (this.list == null) {
            this.list = new ArrayList<>();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_fund_org, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvProductsName.setText(list.get(position));
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_number)
        TextView tvNumber;
        @BindView(R.id.tv_products_number)
        TextView tvProductsNumber;
        @BindView(R.id.tv_products_name)
        TextView tvProductsName;
        @BindView(R.id.tv_manage_org)
        TextView tvManageOrg;
        @BindView(R.id.tv_create_time)
        TextView tvCreateTime;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
