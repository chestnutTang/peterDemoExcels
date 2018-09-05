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
import demo.third.com.exceldemo.service.entity.CyrygsInfoEntity;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.18
 */
public class LandSpaceCyrygsInfoAdapter extends BaseAdapter {


    private Context mContext;
    private ViewHolder holder;
    private CyrygsInfoEntity.ResultBean resultBean;
    private List<CyrygsInfoEntity.ResultBean.ListBean> dataList;


    public LandSpaceCyrygsInfoAdapter(Context context, CyrygsInfoEntity.ResultBean resultBean) {
        mContext = context;
        this.resultBean = resultBean;
    }

    @Override
    public int getCount() {
        if (resultBean != null && resultBean.getList() != null && resultBean.getList().size() > 0) {
            return resultBean.getList().size();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_land_cyrygs_info, null,
                    false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        initView(position);
        return convertView;
    }

    private void initView(int position) {
        if (resultBean != null && resultBean.getList() != null) {
            dataList = resultBean.getList();
            // 姓名
            holder.tvNumber2.setText(String.valueOf(position + 1));
            // 性别
            holder.tvSmjjglrmc2.setText(dataList.get(position).getSco_NAME());
            // 学历
            holder.tvProductsName2.setText(dataList.get(position).getEco_NAME());
            // 证书编号
            holder.tvZhuceAddress2.setText(dataList.get(position).getCer_NUM());
            // 从业机构
            holder.tvDengjiNumber2.setText(dataList.get(position).getAoi_NAME());
            // 从业资格类别
            holder.tvCreateTime2.setText(dataList.get(position).getCti_NAME());
            // 证书取得日期
            holder.tvSignTime2.setText(dataList.get(position).getPpp_GET_DATE());
            // 证书有效截止日期
            holder.tv_jjtzgw.setText(dataList.get(position).getPpp_END_DATE());
            // 注册变更记录
            holder.tv_jjjl.setText(dataList.get(position).getCountcer()+"条");
            // 诚信记录
            if (dataList.get(position).getCountcx() == null){
                holder.tv_tzjl.setText("无");
            }else {
                holder.tv_tzjl.setText(dataList.get(position).getCountcx().toString());
            }

        }
    }

    static class ViewHolder {
        @BindView(R.id.tv_number2)
        TextView tvNumber2;
        @BindView(R.id.tv_smjjglrmc2)
        TextView tvSmjjglrmc2;
        @BindView(R.id.tv_products_name2)
        TextView tvProductsName2;
        @BindView(R.id.tv_zhuce_address2)
        TextView tvZhuceAddress2;
        @BindView(R.id.tv_dengji_number2)
        TextView tvDengjiNumber2;
        @BindView(R.id.tv_create_time2)
        TextView tvCreateTime2;
        @BindView(R.id.tv_sign_time2)
        TextView tvSignTime2;
        @BindView(R.id.tv_jjtzgw)
        TextView tv_jjtzgw;
        @BindView(R.id.tv_jjjl)
        TextView tv_jjjl;
        @BindView(R.id.tv_tzjl)
        TextView tv_tzjl;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
