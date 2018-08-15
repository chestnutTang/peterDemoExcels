package demo.third.com.exceldemo.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.CommonSearchResultEntity;
import demo.third.com.exceldemo.service.entity.ZczcjhEntity;
import demo.third.com.exceldemo.utils.Tools;
import demo.third.com.exceldemo.service.entity.ZczcjhEntity.ResultBean.DataBean.ListBean;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.18
 * 资产支持专项计划信息公示
 */
public class ZczczxAdapter extends BaseAdapter {


    private Context mContext;
    private ViewHolder holder;
    //    private CommonSearchResultEntity.ResultBean resultBean;
//    private String flag;
    private List<ListBean> mData;
//    private int type;

    public ZczczxAdapter(Context context,  List<ListBean> mData) {
        mContext = context;
        if (mData == null) {
            mData = new ArrayList<>();
            this.mData = mData;
        } else {
            this.mData = mData;
        }
//        this.flag = flag;
    }

    /**
     * @param data 加载用的，把新请求的数据添加到原来的列表中
     */
    public void addData(List data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }


    /**
     * @param data 刷新用的，先清空，再赋值
     */
    public void updateData(List data) {
        try {
            if (data != null) {
                mData.clear();
                Log.e("hahahahahaha", "updateData: " + data.size());
                mData.addAll(data);
                notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCount() {

//        int count = 0;
//        switch (flag) {
//            case "证券公司资管产品":
//                if (resultBean != null && resultBean.getPofSecurities() != null && resultBean.getPofSecurities().getList() != null) {
//                    count = resultBean.getPofSecurities().getList().size();
//                }
//                break;
//            case "期货公司资管产品":
//                if (resultBean != null && resultBean.getPofFutures() != null && resultBean.getPofFutures().getList() != null) {
//                    count = resultBean.getPofFutures().getList().size();
//                }
//                break;
//            case "证券公司直投基金":
//                if (resultBean != null && resultBean.getAoinProducts() != null && resultBean.getAoinProducts().getList() != null) {
//                    count = resultBean.getAoinProducts().getList().size();
//                }
//                break;
//            default:
//                break;
//        }

        return mData == null ? 0 : mData.size();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_zczczx, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        initView(position);
        return convertView;
    }


    private void initView(int postition) {
        if (mData != null) {
            holder.tvNumber.setText(String.valueOf(postition + 1));
            holder.tvProductsNumber.setText(mData.get(postition).getAspi_BA_NUMBER());
            holder.tvProductsName.setText(mData.get(postition).getAspi_NAME());
            holder.tvManageOrg.setText(mData.get(postition).getAspi_GL_NAME());
            holder.tv_ztzgs.setText(mData.get(postition).getAii_TGR());
            holder.tvCreateTime.setText(mData.get(postition).getAt_AUDIT_DATE());
//            holder.tvCreateTime.setText(Tools.timeStamp2Date(mData.get(postition).getAt_AUDIT_DATE_TIMESTAMP() + "", ""));
//            switch (flag) {
//                case "证券公司资管产品":
//                    holder.rl_ztzgs.setVisibility(View.GONE);
//                    dataListPofSecurities = mData;
//                    holder.tvNumber.setText(String.valueOf(postition + 1));
//                    holder.tvProductsNumber.setText(dataListPofSecurities.get(postition).getCpbm());
//                    holder.tvProductsName.setText(dataListPofSecurities.get(postition).getCpmc());
//                    holder.tvManageOrg.setText(dataListPofSecurities.get(postition).getGljg());
//                    holder.tvCreateTime.setText(dataListPofSecurities.get(postition).getSlrq());
//                    break;
//                case "期货公司资管产品":
//                    holder.rl_ztzgs.setVisibility(View.GONE);
//                    dataListPofFutures = mData;
//                    holder.tvNumber.setText(String.valueOf(postition + 1));
//                    holder.tvProductsNumber.setText(dataListPofFutures.get(postition).getMpiProductCode());
//                    holder.tvProductsName.setText(dataListPofFutures.get(postition).getAoiName());
//                    holder.tvManageOrg.setText(dataListPofFutures.get(postition).getMpiTrustee());
//                    holder.tvCreateTime.setText(dataListPofFutures.get(postition).getMpiCreateDate());
//                    break;
//                case "证券公司直投基金":
//                    holder.rl_ztzgs.setVisibility(View.VISIBLE);
//                    dataListAoinProducts = mData;
//                    holder.tvNumber.setText(String.valueOf(postition + 1));
//                    holder.tvProductsNumber.setText(dataListAoinProducts.get(postition).getCode());
//                    holder.tvProductsName.setText(dataListAoinProducts.get(postition).getName());
//                    holder.tvManageOrg.setText(dataListAoinProducts.get(postition).getManagerName());
//                    holder.tv_ztzgs.setText(dataListAoinProducts.get(postition).getAoinName());
//                    holder.tvCreateTime.setText(Tools.timeStamp2Date(dataListAoinProducts.get(postition).getCreateDate() + "", ""));
//
//                    break;
//                default:
//                    break;
//            }
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
