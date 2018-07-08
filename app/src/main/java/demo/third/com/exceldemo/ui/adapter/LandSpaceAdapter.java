package demo.third.com.exceldemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.SearchResultEntity;
import demo.third.com.exceldemo.utils.Tools;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.18
 */
public class LandSpaceAdapter extends BaseAdapter {


    private Context mContext;
    private ViewHolder holder;
    private SearchResultEntity.ResultBean resultBean;
    private List<SearchResultEntity.ResultBean.FundAccountsBean.ListBean> dataList;


    public LandSpaceAdapter(Context context, SearchResultEntity.ResultBean resultBean) {
        mContext = context;
        this.resultBean = resultBean;
    }

    @Override
    public int getCount() {
        return resultBean == null ? 0 : resultBean.getFundAccounts().getList().size();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_land_space, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        initView(position);
        return convertView;
    }

    private void initView(int position) {
        holder.tvNumber.setText(String.valueOf(position + 1));
        holder.tvSmjjglrmc.setText(resultBean.getFundAccounts().getList().get(position).getName());
        holder.tvProductsName.setText(resultBean.getFundAccounts().getList().get(position).getRegisterCode());
        holder.tvDengjiNumber.setText(resultBean.getFundAccounts().getList().get(position).getRegisterCode());
        holder.tvZhuceAddress.setText(Tools.timeStamp2Date(resultBean.getFundAccounts().getList().get(position).getRegisterDate() + "", ""));
        holder.tvCreateTime.setText(Tools.timeStamp2Date(resultBean.getFundAccounts().getList().get(position).getRegisterDate() + "", ""));
        holder.tvSignTime.setText(Tools.timeStamp2Date(resultBean.getFundAccounts().getList().get(position).getGmtCreate() + "", ""));
    }

    static class ViewHolder {
        @BindView(R.id.tv_number)
        TextView tvNumber;
        @BindView(R.id.tv_smjjglrmc)
        TextView tvSmjjglrmc;
        @BindView(R.id.tv_products_name)
        TextView tvProductsName;
        @BindView(R.id.tv_zhuce_address)
        TextView tvZhuceAddress;
        @BindView(R.id.tv_dengji_number)
        TextView tvDengjiNumber;
        @BindView(R.id.tv_create_time)
        TextView tvCreateTime;
        @BindView(R.id.tv_sign_time)
        TextView tvSignTime;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
