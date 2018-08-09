package demo.third.com.exceldemo.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.CyrygsEntity;
import demo.third.com.exceldemo.service.entity.SearchResultEntity;
import demo.third.com.exceldemo.utils.Tools;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.18
 */
public class LandSpaceCyrygsAdapter extends BaseAdapter {


    private Context mContext;
    private ViewHolder holder;
    private CyrygsEntity.ResultBean resultBean;
    private List<CyrygsEntity.ResultBean.DataBean.ListBean> dataList;
    private String flag;


    public LandSpaceCyrygsAdapter(Context context, CyrygsEntity.ResultBean resultBean, String
            flag) {
        mContext = context;
        this.resultBean = resultBean;
        this.flag = flag;
    }

    @Override
    public int getCount() {
        if (resultBean != null && resultBean.getData() != null
                && resultBean.getData().getList() != null
                && resultBean.getData().getList().size() > 0) {
            return resultBean.getData().getList().size();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_land_cyrygs, null,
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
        holder.tvNumber2.setText(String.valueOf(position + 1));
        holder.tvSmjjglrmc2.setText(resultBean.getData().getList().get(position).getAoiName());
        holder.tvProductsName2.setText(resultBean.getData().getList().get(position).getPr_COUNT_PERSON()+"");
        holder.tvDengjiNumber2.setText(resultBean.getData().getList().get(position).getPti2PERSON()+"");
        holder.tvZhuceAddress2.setText(resultBean.getData().getList().get(position).getPti0PERSON()+"");
        holder.tvCreateTime2.setText(resultBean.getData().getList().get(position).getPti4PERSON()+"");
        holder.tvSignTime2.setText(resultBean.getData().getList().get(position).getPti6PERSON()+"");
        holder.tv_jjtzgw.setText(resultBean.getData().getList().get(position).getPti7PERSON()+"");
        holder.tv_jjjl.setText(resultBean.getData().getList().get(position).getPti8PERSON()+"");
        holder.tv_tzjl.setText(resultBean.getData().getList().get(position).getPti9PERSON()+"");
        holder.tv_tzzj.setText(resultBean.getData().getList().get(position).getPti10PERSON()+"");

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
        @BindView(R.id.tv_tzzj)
        TextView tv_tzzj;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
