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
 * on 2018.05.19
 * @author peter
 */
public class QualificationSearchAdapter extends BaseAdapter {


    private Context mContext;
    private ViewHolder holder;
    private List list;

    public QualificationSearchAdapter(Context context, List list) {
        mContext = context;
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_qualification_list,
                    null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_tip_title)
        TextView tvTipTitle;
        @BindView(R.id.tv_show)
        TextView tvShow;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
