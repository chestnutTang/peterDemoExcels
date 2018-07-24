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
 * 证券公司私募产品备案适配器
 * @author peter
 */
public class PrivateProductsAdapter extends BaseAdapter {

    private Context context;
    private List list;
    private ViewHolder holder;

    public PrivateProductsAdapter(Context context, List list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_private_products, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_product_title)
        TextView tvProductTitle;
        @BindView(R.id.tv_product_content)
        TextView tvProductContent;
        @BindView(R.id.tv_product_time)
        TextView tvProductTime;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
