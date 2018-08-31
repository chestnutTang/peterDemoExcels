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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.utils.OpenFile;
import demo.third.com.exceldemo.utils.Tools;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.17
 * 下载列表适配器
 *
 * @author peter
 */
public class DownloadAdapter extends BaseAdapter {

    private Context context;
    //    private List list;
    private ViewHolder holder;
    private String data, name;
    private String[] dataArray;
    private String[] nameArray;

    public DownloadAdapter(Context context, String data, String name) {
        this.context = context;
        this.data = data;
        this.name = name;
        if (!TextUtils.isEmpty(data) && data.contains(";")) {
            this.dataArray = data.split(";");
        }
        if (!TextUtils.isEmpty(name) && name.contains(";")) {
            this.nameArray = name.split(";");
        }


    }

    @Override
    public int getCount() {
        int size;
        if (dataArray != null && dataArray.length > 0) {
            size = dataArray.length;
            ;
        } else {
            size = 0;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_download_list, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (nameArray != null && nameArray.length > 0) {
            holder.tvBlackTitle.setText(nameArray[position]);
            holder.tvBlackTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 调用WPS
                    context.startActivity(OpenFile.openFile(dataArray[position]));
                }
            });
            holder.tvBlackTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 调用WPS
                    context.startActivity(OpenFile.openFile(dataArray[position]));
                }
            });
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
