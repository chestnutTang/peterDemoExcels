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
import demo.third.com.exceldemo.service.entity.BlackListEntity;

/**
 * 证券公司私募产品备案适配器
 *
 * @author peter
 */
public class PrivateProductsAdapter extends BaseAdapter {

    private Context context;
    private ViewHolder holder;
    private BlackListEntity blackListEntity;

    public PrivateProductsAdapter(Context context, BlackListEntity blackListEntity) {
        this.context = context;
        this.blackListEntity = blackListEntity;
    }

    @Override
    public int getCount() {
        int size = 0;
        try {
            size = blackListEntity.getResult().getData().getList().size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
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
        holder.tv_product_title.setText("证券公司私募产品备案确认函：" + blackListEntity.getResult().getData().getList().get(position).getTitle());
        holder.tvProductTime.setText(blackListEntity.getResult().getData().getList().get(position).getDate());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_product_title)
        TextView tv_product_title;
        @BindView(R.id.tv_product_content)
        TextView tvProductContent;
        @BindView(R.id.tv_product_time)
        TextView tvProductTime;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
