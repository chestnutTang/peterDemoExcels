package demo.third.com.exceldemo.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.MessageEntity;
import demo.third.com.exceldemo.utils.Tools;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.22
 *
 * @author peter
 */
public class MessageAdapter extends BaseAdapter {

    private Context context;
    private ViewHolder holder;
    private MessageEntity.ResultBean.DataBean dataBean;

    public MessageAdapter(Context context, MessageEntity.ResultBean.DataBean dataBean) {
        this.context = context;
        this.dataBean = dataBean;
    }

    @Override
    public int getCount() {
        if (dataBean != null && dataBean.getList() != null && dataBean.getList().size() > 0) {
            return dataBean.getList().size();
        } else {
            return 0;
        }
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_message, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (dataBean != null && dataBean.getList() != null && dataBean.getList().size() > 0) {
            String times = Tools.timeStamp2Date(dataBean.getList().get(position).getPublishTime(), "");
            if (!TextUtils.isEmpty(times)) {
                holder.tvTime.setText(times);
            }
            String content = dataBean.getList().get(position).getContent();
            if (!TextUtils.isEmpty(content)) {
                holder.tvContent.setText(content);
            }
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_content)
        TextView tvContent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
