package demo.third.com.exceldemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.CommonSearchResultEntity;
import demo.third.com.exceldemo.utils.Tools;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.18
 */
public class ProductsInfoAdapter extends BaseAdapter {


    private Context mContext;
    private ViewHolder holder;
    private CommonSearchResultEntity.ResultBean resultBean;
    private String flag;
    private List<CommonSearchResultEntity.ResultBean.PofSecuritiesBean.ListBeanX> dataListPofSecurities;
    private List<CommonSearchResultEntity.ResultBean.PofFuturesBean.ListBean> dataListPofFutures;
    private List<CommonSearchResultEntity.ResultBean.AoinProductsBean.ListBeanXX> dataListAoinProducts;

    public ProductsInfoAdapter(Context context, CommonSearchResultEntity.ResultBean resultBean, String flag) {
        mContext = context;
        this.resultBean = resultBean;
        this.flag = flag;
    }


    @Override
    public int getCount() {

        int count = 0;
        switch (flag) {
            case "证券公司资管产品":
                if (resultBean != null && resultBean.getPofSecurities() != null && resultBean.getPofSecurities().getList() != null) {
                    count = resultBean.getPofSecurities().getList().size();
                }
                break;
            case "期货公司资管产品":
                if (resultBean != null && resultBean.getPofFutures() != null && resultBean.getPofFutures().getList() != null) {
                    count = resultBean.getPofFutures().getList().size();
                }
                break;
            case "证券公司直投基金":
                if (resultBean != null && resultBean.getAoinProducts() != null && resultBean.getAoinProducts().getList() != null) {
                    count = resultBean.getAoinProducts().getList().size();
                }
                break;
            default:
                break;
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
            if (resultBean.getPofSecurities() != null) {
                dataListPofSecurities = resultBean.getPofSecurities().getList();
                holder.tvNumber.setText(String.valueOf(postition + 1));
                holder.tvProductsNumber.setText(dataListPofSecurities.get(postition).getCpbm());
                holder.tvProductsName.setText(dataListPofSecurities.get(postition).getCpmc());
                holder.tvManageOrg.setText(dataListPofSecurities.get(postition).getGljg());
                holder.tvCreateTime.setText(dataListPofSecurities.get(postition).getSlrq());
            }
            if (resultBean.getPofFutures() != null) {
                dataListPofFutures = resultBean.getPofFutures().getList();
                holder.tvNumber.setText(String.valueOf(postition + 1));
                holder.tvProductsNumber.setText(dataListPofFutures.get(postition).getMpiProductCode());
                holder.tvProductsName.setText(dataListPofFutures.get(postition).getAoiName());
                holder.tvManageOrg.setText(dataListPofFutures.get(postition).getMpiTrustee());
                holder.tvCreateTime.setText(dataListPofFutures.get(postition).getMpiCreateDate());
            }
            if (resultBean.getAoinProducts() != null) {
                dataListAoinProducts = resultBean.getAoinProducts().getList();
                holder.tvNumber.setText(String.valueOf(postition + 1));
                holder.tvProductsNumber.setText(dataListAoinProducts.get(postition).getCode());
                holder.tvProductsName.setText(dataListAoinProducts.get(postition).getName());
                holder.tvManageOrg.setText(dataListAoinProducts.get(postition).getManagerName());
                holder.tv_ztzgs.setText(dataListAoinProducts.get(postition).getAoinName());
                holder.tvCreateTime.setText(Tools.timeStamp2Date(dataListAoinProducts.get(postition).getCreateDate() + "", ""));
            }
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
        /**
         * 直投子公司
         */
        @BindView(R.id.rl_ztzgs)
        RelativeLayout rl_ztzgs;
        @BindView(R.id.tv_ztzgs)
        TextView tv_ztzgs;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
