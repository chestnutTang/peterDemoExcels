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
import demo.third.com.exceldemo.service.entity.SearchResultEntity;
import demo.third.com.exceldemo.utils.Tools;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.18
 */
public class ProductsInfoAdapter extends BaseAdapter {


    private Context mContext;
    private ViewHolder holder;
    private List list;
    private SearchResultEntity.ResultBean resultBean;
    private List<SearchResultEntity.ResultBean.FundAccountsBean.ListBean> dataList;

    public ProductsInfoAdapter(Context context, List list) {
        mContext = context;
        if (this.list == null) {
            this.list = new ArrayList();
            this.list = list;
        } else {
            this.list = list;
        }
    }

    public ProductsInfoAdapter(Context context, SearchResultEntity.ResultBean resultBean) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_pro_info, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        initView(position);
        return convertView;
    }

    private void initView(int postition) {
        if (resultBean != null) {
            dataList = resultBean.getFundAccounts().getList();
            holder.tvNumber.setText(String.valueOf(postition + 1));
            holder.tvProductsNumber.setText(dataList.get(postition).getRegisterCode());
            holder.tvProductsName.setText(dataList.get(postition).getManager());
            holder.tvManageOrg.setText(dataList.get(postition).getManager());
            holder.tvCreateTime.setText(Tools.timeStamp2Date(dataList.get(postition).getRegisterDate()+"",""));
        }

    }

    static class ViewHolder {
        @BindView(R.id.tv_number)
        TextView tvNumber;
        @BindView(R.id.tv_products_number)
        TextView tvProductsNumber;
        @BindView(R.id.tv_products_name)
        TextView tvProductsName;
        @BindView(R.id.tv_manage_org)
        TextView tvManageOrg;
        @BindView(R.id.tv_create_time)
        TextView tvCreateTime;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
