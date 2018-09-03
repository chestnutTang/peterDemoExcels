package demo.third.com.exceldemo.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.utils.OpenFile;

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
    private String[] urlArray;
    private String[] nameArray;
    private String urlStr;
    private String nameStr;
    private String jumpUrl,showName;

    public DownloadAdapter(Context context, String data, String name) {
        this.context = context;
        this.data = data;
        this.name = name;
        if (!TextUtils.isEmpty(data)) {
            if (data.contains(";")) {
                this.urlArray = data.split(";");
            } else {
                this.urlStr = data;
            }
        }
        if (!TextUtils.isEmpty(name)) {
            if (name.contains(";")) {
                this.nameArray = name.split(";");
            } else {
                this.nameStr = name;
            }
        }


    }

    @Override
    public int getCount() {
        int size;
        if (urlArray != null && urlArray.length > 0) {
            size = urlArray.length;
        } else {
            if (!TextUtils.isEmpty(urlStr)) {
                size = 1;
            } else {
                size = 0;
            }
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
        } else {
            if (!TextUtils.isEmpty(nameStr)) {
                holder.tvBlackTitle.setText(nameStr);
            }
        }
        if (urlArray != null&& urlArray.length>0){
            jumpUrl = urlArray[position];
        }else {
            if(!TextUtils.isEmpty(urlStr)){
                jumpUrl = urlStr;
            }
        }
        holder.tvBlackTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 调用WPS
                context.startActivity(OpenFile.openFile(context,jumpUrl));
            }
        });
        holder.tvBlackTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 调用WPS
                context.startActivity(OpenFile.openFile(context,jumpUrl));
            }
        });
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
