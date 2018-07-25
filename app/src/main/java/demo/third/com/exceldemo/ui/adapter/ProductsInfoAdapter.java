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
import demo.third.com.exceldemo.service.entity.CommonSearchResultEntity;
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
    private CommonSearchResultEntity.ResultBean resultBean;
    private List<CommonSearchResultEntity.ResultBean.PofSecuritiesBean.ListBean> dataList;

    public ProductsInfoAdapter(Context context, CommonSearchResultEntity.ResultBean resultBean) {
        mContext = context;
        this.resultBean = resultBean;
    }


    @Override
    public int getCount() {

        int count = 0;
        if (resultBean != null && resultBean.getPofSecurities() != null && resultBean.getPofSecurities().getList() != null) {
            count = resultBean.getPofSecurities().getList().size();
        }
        return count;
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
            dataList = resultBean.getPofSecurities().getList();
            holder.tvNumber.setText(String.valueOf(postition + 1));
            holder.tvProductsNumber.setText(dataList.get(postition).getCpbm());
            holder.tvProductsName.setText(dataList.get(postition).getCpmc());
            holder.tvManageOrg.setText(dataList.get(postition).getGljg());
            holder.tvCreateTime.setText(dataList.get(postition).getSlrq());
//            holder.tvCreateTime.setText(Tools.timeStamp2Date(dataList.get(postition).getRegisterDate() + "", ""));
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
