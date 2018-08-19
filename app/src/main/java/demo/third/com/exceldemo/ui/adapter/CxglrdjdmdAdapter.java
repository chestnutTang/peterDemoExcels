package demo.third.com.exceldemo.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.BlackListEntity;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.17
 * 黑名单列表适配器
 *
 * @author peter
 */
public class CxglrdjdmdAdapter extends BaseAdapter {

    private Context context;
    //    private List list;
    private ViewHolder holder;
    private BlackListEntity blackListEntity;
    private String flag;

    public CxglrdjdmdAdapter(Context context, BlackListEntity blackListEntity, String flag) {
        this.context = context;
        this.blackListEntity = blackListEntity;
        this.flag = flag;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_cxglrdjdmd_list, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (blackListEntity != null && blackListEntity.getResult() != null && blackListEntity.getResult().getData() != null
                && blackListEntity.getResult().getData().getList().size() > 0) {
            if (!TextUtils.isEmpty(flag)) {
                holder.tvBlackTitle.setText(flag + "：" + blackListEntity.getResult().getData().getList().get(position).getTitle());
            } else {
                holder.tvBlackTitle.setText(blackListEntity.getResult().getData().getList().get(position).getTitle());
            }
            holder.tvBlackTime.setText(blackListEntity.getResult().getData().getList().get(position).getDate());
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
