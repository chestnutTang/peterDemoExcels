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
 * on 2018.07.03
 *
 * @author peter
 */
public class FundDetailAdapter extends BaseAdapter {

    private Context context;
    private ViewHolder holder;
    private List<String> list;

    public FundDetailAdapter(Context context, List<String> list) {
        this.context = context;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_fund_detail, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (list != null && list.size() > 0) {
            holder.tvTip.setText(list.get(position));
//            if (position == list.size() - 1) {
//                holder.line1.setVisibility(View.GONE);
//                holder.line2.setVisibility(View.GONE);
//            }
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_tip)
        TextView tvTip;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.line1)
        TextView line1;
        @BindView(R.id.line2)
        TextView line2;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
