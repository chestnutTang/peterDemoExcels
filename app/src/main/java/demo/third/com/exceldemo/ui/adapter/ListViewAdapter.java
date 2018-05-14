package demo.third.com.exceldemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.12
 *
 * @author songzhengpeng
 */
public class ListViewAdapter extends BaseAdapter {

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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_main_list, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

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
