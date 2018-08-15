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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.BlackListEntity;
import demo.third.com.exceldemo.service.entity.GzllEntity;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.17
 * 黑名单列表适配器
 *
 * @author peter
 */
public class GzllAdapter extends BaseAdapter {

    private Context context;
    //    private List list;
    private ViewHolder holder;
    private List<GzllEntity.GoodBean> list;
    private String flag;

    public GzllAdapter(Context context, List<GzllEntity.GoodBean> list, String flag) {
        this.context = context;
        this.list = list;
        this.flag = flag;
    }

    @Override
    public int getCount() {
        int size = 0;
        try {
            size = list == null ? 0 : list.size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gzll, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (list != null && list.size() > 0) {
            holder.tv_time.setText(list.get(position).get时间());
            holder.tv_rzdw.setText(list.get(position).get任职单位());
            holder.tv_zw.setText(list.get(position).get职务());
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_time)
        TextView tv_time;
        @BindView(R.id.tv_rzdw)
        TextView tv_rzdw;
        @BindView(R.id.tv_zw)
        TextView tv_zw;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
