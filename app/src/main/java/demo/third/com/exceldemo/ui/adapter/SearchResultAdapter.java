package demo.third.com.exceldemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.utils.Tools;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.16
 *
 * @author songzhengpeng
 */
public class SearchResultAdapter extends BaseAdapter implements View.OnClickListener {

    private Context mContext;
    private ViewHolder holder;
    private List list;

    public SearchResultAdapter(Context context, List list) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_search_result, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        bindListener();
        return convertView;
    }

    void bindListener() {
        holder.llLookAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_look_all:
                Tools.toast("查看全部");
                break;
            default:
                break;
        }
    }

    static class ViewHolder {
        @BindView(R.id.iv_head_company)
        ImageView ivHeadCompany;
        @BindView(R.id.tv_company_name)
        TextView tvCompanyName;
        @BindView(R.id.tv_org_type)
        TextView tvOrgType;
        @BindView(R.id.tv_sign_number)
        TextView tvSignNumber;
        @BindView(R.id.tv_sign_address)
        TextView tvSignAddress;
        @BindView(R.id.tv_time_sign)
        TextView tvTimeSign;
        @BindView(R.id.line_bottom_1)
        View lineBottom1;
        @BindView(R.id.line_bottom_10)
        View lineBottom10;
        @BindView(R.id.ll_look_all)
        LinearLayout llLookAll;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
