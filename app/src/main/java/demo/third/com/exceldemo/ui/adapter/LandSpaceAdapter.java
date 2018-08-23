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
    private String flag;


    public LandSpaceAdapter(Context context, SearchResultEntity.ResultBean resultBean, String flag) {
        mContext = context;
        this.resultBean = resultBean;
        this.flag = flag;
    }

    @Override
    public int getCount() {
        int size = 0;
        if (!TextUtils.isEmpty(flag)) {
            switch (flag) {
                case "私募基金管理人分类公示":
                    size = resultBean == null || resultBean.getPOFManagers() == null
                            || resultBean.getPOFManagers().getList() == null ? 0 : resultBean.getPOFManagers().getList().size();
                    break;
                case "证券公司私募投资基金":
                    size = resultBean == null || resultBean.getPofSubfunds() == null
                            || resultBean.getPofSubfunds().getList() == null ? 0 : resultBean.getPofSubfunds().getList().size();
                    break;
                default:
                    size = 0;
                    break;
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
        if (!TextUtils.isEmpty(flag)) {
            switch (flag) {
                case "私募基金管理人分类公示":
                    holder.ll_top1.setVisibility(View.VISIBLE);
                    holder.ll_top2.setVisibility(View.GONE);
                    holder.tvNumber.setText(String.valueOf(position + 1));
                    holder.tvSmjjglrmc.setText(resultBean.getPOFManagers().getList().get(position).getManagerName());
                    holder.tvProductsName.setText(resultBean.getPOFManagers().getList().get(position).getArtificialPersonName());
                    holder.tvDengjiNumber.setText(resultBean.getPOFManagers().getList().get(position).getRegisterProvince());
                    holder.tvZhuceAddress.setText(resultBean.getPOFManagers().getList().get(position).getRegisterNo());
                    holder.tvCreateTime.setText(Tools.timeStamp2Date(resultBean.getPOFManagers().getList().get(position).getEstablishDate() + "", ""));
                    holder.tvSignTime.setText(Tools.timeStamp2Date(resultBean.getPOFManagers().getList().get(position).getRegisterDate() + "", ""));
                    break;
                case "证券公司私募投资基金":
                    holder.ll_top1.setVisibility(View.GONE);
                    holder.ll_top2.setVisibility(View.VISIBLE);
                    holder.tvNumber2.setText(String.valueOf(position + 1));
                    holder.tvSmjjglrmc2.setText(resultBean.getPofSubfunds().getList().get(position).getProductCode());
                    holder.tvProductsName2.setText(resultBean.getPofSubfunds().getList().get(position).getProductName());
                    holder.tvDengjiNumber2.setText(resultBean.getPofSubfunds().getList().get(position).getMgrName());
                    holder.tvZhuceAddress2.setText(resultBean.getPofSubfunds().getList().get(position).getTrustee());
                    holder.tvCreateTime2.setText(Tools.timeStamp2Date(resultBean.getPofSubfunds().getList().get(position).getFoundDate() + "", ""));
                    holder.tvSignTime2.setText(Tools.timeStamp2Date(resultBean.getPofSubfunds().getList().get(position).getRegisteredDate() + "", ""));

                    break;
                default:
                    holder.ll_top1.setVisibility(View.VISIBLE);
                    holder.ll_top2.setVisibility(View.GONE);
                    holder.tvNumber.setText(String.valueOf(position + 1));
                    holder.tvSmjjglrmc.setText(resultBean.getFundAccounts().getList().get(position).getName());
                    holder.tvProductsName.setText(resultBean.getFundAccounts().getList().get(position).getRegisterCode());
                    holder.tvDengjiNumber.setText(resultBean.getFundAccounts().getList().get(position).getRegisterCode());
                    holder.tvZhuceAddress.setText(Tools.timeStamp2Date(resultBean.getFundAccounts().getList().get(position).getRegisterDate() + "", ""));
                    holder.tvCreateTime.setText(Tools.timeStamp2Date(resultBean.getFundAccounts().getList().get(position).getRegisterDate() + "", ""));
                    holder.tvSignTime.setText(Tools.timeStamp2Date(resultBean.getFundAccounts().getList().get(position).getGmtCreate() + "", ""));
                    break;
            }
        }
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

        @BindView(R.id.ll_top1)
        LinearLayout ll_top1;
        @BindView(R.id.ll_top2)
        LinearLayout ll_top2;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
