package demo.third.com.exceldemo.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
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
import demo.third.com.exceldemo.service.entity.SearchResultEntity;
import demo.third.com.exceldemo.ui.activity.JjzhcpgsActivity;
import demo.third.com.exceldemo.ui.activity.SearchResultActivity;
import demo.third.com.exceldemo.utils.JumpTools;
import demo.third.com.exceldemo.utils.Tools;

import static demo.third.com.exceldemo.utils.Constant.PRIVATEFUNDACTIVITY;
import static demo.third.com.exceldemo.utils.Constant.SEARCHRESULTACTIVITY;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.16
 *
 * @author peter
 */
public class SearchResultAdapter extends BaseAdapter implements View.OnClickListener {

    private Context mContext;
    private ViewHolder holder;
    private List list;
    private String flag;
    private SearchResultEntity.ResultBean resultBean;
    private List<SearchResultEntity.ResultBean.FundAccountsBean.ListBean> fundAcountListBeans;
    private List<SearchResultEntity.ResultBean.POFManagersBean.ListBeanX> pofManagersBeans;
    private List mData;

    public SearchResultAdapter(Context context, SearchResultEntity.ResultBean resultBean, String flag) {
        mContext = context;
        this.flag = flag;
        this.resultBean = resultBean;
        if (resultBean != null) {
            if (!TextUtils.isEmpty(flag)) {
                switch (flag) {
                    case "首页搜索":
//                        if (resultBean.getFundAccounts() != null && resultBean.getFundAccounts().getList() != null && resultBean.getFundAccounts().getList().size() > 0) {
//                            mData = resultBean.getFundAccounts().getList();
//                        }
                        if (resultBean.getPOFManagers() != null && resultBean.getPOFManagers().getList() != null && resultBean.getPOFManagers().getList().size() > 0) {
                            mData = resultBean.getPOFManagers().getList();
                        }
                        break;
                    case "私募基金管理人查询":
                        if (resultBean.getPOFManagers() != null && resultBean.getPOFManagers().getList() != null && resultBean.getPOFManagers().getList().size() > 0) {
                            mData = resultBean.getPOFManagers().getList();
                        }
                        break;
                    case "基金专户产品公示":
                        if (resultBean.getFundAccounts() != null && resultBean.getFundAccounts().getList() != null && resultBean.getFundAccounts().getList().size() > 0) {
                            mData = resultBean.getFundAccounts().getList();
                        }
                        break;
                    default:
                        break;
                }
            }
        }

    }

    @Override
    public int getCount() {
        int count = 0;
        if (resultBean != null) {
            switch (flag) {
                case "首页搜索":
                    if (resultBean.getFundAccounts() != null && resultBean.getFundAccounts().getList() != null && resultBean.getFundAccounts().getList().size() > 0) {
                        count = 1;
                    }
                    if (resultBean.getPOFManagers() != null && resultBean.getPOFManagers().getList() != null && resultBean.getPOFManagers().getList().size() > 0) {
                        count = 1 + resultBean.getPOFManagers().getList().size();
                    }
                    break;
                case "私募基金管理人查询":
                    if (resultBean.getPOFManagers() != null && resultBean.getPOFManagers().getList() != null && resultBean.getPOFManagers().getList().size() > 0) {
                        count = resultBean.getPOFManagers().getList().size();
                    }
                    break;
                case "基金专户产品公示":
                    if (resultBean.getFundAccounts() != null && resultBean.getFundAccounts().getList() != null && resultBean.getFundAccounts().getList().size() > 0) {
                        count = resultBean.getFundAccounts().getList().size();
                    }
                    break;
                default:
                    break;
            }
        }
        return count;
    }

    public void addData(SearchResultEntity.ResultBean resultBean) {
        List data;
        if (resultBean != null) {
            switch (flag) {
                case "首页搜索":
                    if (resultBean.getPOFManagers() != null && resultBean.getPOFManagers().getList() != null && resultBean.getPOFManagers().getList().size() > 0) {
                        data = resultBean.getPOFManagers().getList();
                        mData.addAll(data);
                        notifyDataSetChanged();
                    }
                    break;
                case "私募基金管理人查询":
                    if (resultBean.getPOFManagers() != null && resultBean.getPOFManagers().getList() != null && resultBean.getPOFManagers().getList().size() > 0) {
                        data = resultBean.getPOFManagers().getList();
                        mData.addAll(data);
                        notifyDataSetChanged();
                    }
                    break;
                case "基金专户产品公示":
                    if (resultBean.getFundAccounts() != null && resultBean.getFundAccounts().getList() != null && resultBean.getFundAccounts().getList().size() > 0) {
                        data = resultBean.getFundAccounts().getList();
                        mData.addAll(data);
                        notifyDataSetChanged();
                    }
                    break;
                default:
                    break;
            }
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_search_result, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        initView(position);
        bindListener();
        return convertView;
    }

    private void initView(int position) {
        if (!TextUtils.isEmpty(flag)) {
            switch (flag) {
                case "首页搜索":
                    //搜索的结果列表页
                    if (position == 0) {
                        holder.ll_daibiao_name.setVisibility(View.GONE);
                        holder.tvSearchResultsCount.setVisibility(View.VISIBLE);
                        holder.llLookAll.setVisibility(View.VISIBLE);
                        holder.lineBottom10.setVisibility(View.GONE);
                        holder.tvSearchResultsCount.setText("搜索到" + resultBean.getFundAccounts().getPage().getTotalCount() + "条基金专户备案信息");
                        // 基金专户备案信息
                        holder.tv1.setText(mContext.getResources().getString(R.string.txt_manage_name));
                        holder.tv2.setText(mContext.getResources().getString(R.string.txt_type_zhuanhu));
                        holder.tv3.setText(mContext.getResources().getString(R.string.txt_beian_number));
                        holder.tv4.setText(mContext.getResources().getString(R.string.txt_record_time));
                        fundAcountListBeans = resultBean.getFundAccounts().getList();
                        if (fundAcountListBeans != null && fundAcountListBeans.size() > 0) {
                            // 公司名称
                            holder.tvCompanyName.setText(fundAcountListBeans.get(position).getName());
                            // 管理人名称
                            holder.tvOrgType.setText(fundAcountListBeans.get(position).getManager());
                            // 专户类型
                            holder.tvSignNumber.setText(fundAcountListBeans.get(position).getType());
                            // 备案编码
                            holder.tvSignAddress.setText(fundAcountListBeans.get(position).getRegisterCode());
                            // 备案日期
                            String times = Tools.timeStamp2Date(fundAcountListBeans.get(position).getRegisterDate() + "", "");
                            holder.tvTimeSign.setText(times);
                        }
                    } else {
                        holder.ll_daibiao_name.setVisibility(View.VISIBLE);
                        holder.llLookAll.setVisibility(View.GONE);
                        if (position == 1) {
                            holder.lineBottom10.setVisibility(View.VISIBLE);
                            holder.tvSearchResultsCount.setVisibility(View.VISIBLE);
                            holder.tvSearchResultsCount.setText("搜索到" + resultBean.getPOFManagers().getPage().getTotalCount() + "条管理人信息");
                        } else {
                            holder.lineBottom10.setVisibility(View.VISIBLE);
                            holder.tvSearchResultsCount.setVisibility(View.GONE);
                        }
                        // 管理人信息
                        holder.tv1.setText(mContext.getResources().getString(R.string.txt_org_type));
                        holder.tv2.setText(mContext.getResources().getString(R.string.txt_sign_number));
                        holder.tv3.setText(mContext.getResources().getString(R.string.txt_sign_address));
                        holder.tv4.setText(mContext.getResources().getString(R.string.txt_time_sign));
                        pofManagersBeans = mData;
                        if (pofManagersBeans != null && pofManagersBeans.size() > 0) {
                            // 委派代表姓名
                            holder.tv_daibiao_name.setText(pofManagersBeans.get(position - 1).getArtificialPersonName());
                            // 公司名称
                            holder.tvCompanyName.setText(pofManagersBeans.get(position - 1).getManagerName());
                            // 机构类型
                            holder.tvOrgType.setText(pofManagersBeans.get(position - 1).getManagerName());
                            // 登记编号
                            holder.tvSignNumber.setText(pofManagersBeans.get(position - 1).getRegisterNo());
                            // 注册地
                            holder.tvSignAddress.setText(pofManagersBeans.get(position - 1).getRegisterAddress());
                            // 登记时间
                            String times = Tools.timeStamp2Date(pofManagersBeans.get(position - 1).getEstablishDate() + "", "");
                            holder.tvTimeSign.setText(times);
                        }
                    }
                    break;
                case "私募基金管理人查询":
                    //私募基金公示的适配器
                    holder.ll_daibiao_name.setVisibility(View.VISIBLE);
                    holder.llLookAll.setVisibility(View.GONE);
                    holder.lineBottom10.setVisibility(View.VISIBLE);
                    holder.tvSearchResultsCount.setVisibility(View.GONE);
                    // 管理人信息
                    holder.tv1.setText(mContext.getResources().getString(R.string.txt_org_type));
                    holder.tv2.setText(mContext.getResources().getString(R.string.txt_sign_number));
                    holder.tv3.setText(mContext.getResources().getString(R.string.txt_sign_address));
                    holder.tv4.setText(mContext.getResources().getString(R.string.txt_time_sign));
                    pofManagersBeans = mData;
                    if (pofManagersBeans != null && pofManagersBeans.size() > 0) {
                        // 委派代表姓名
                        holder.tv_daibiao_name.setText(pofManagersBeans.get(position).getArtificialPersonName());
                        // 公司名称
                        holder.tvCompanyName.setText(pofManagersBeans.get(position).getManagerName());
                        // 机构类型
                        holder.tvOrgType.setText(pofManagersBeans.get(position).getManagerName());
                        // 登记编号
                        holder.tvSignNumber.setText(pofManagersBeans.get(position).getRegisterNo());
                        // 注册地
                        holder.tvSignAddress.setText(pofManagersBeans.get(position).getRegisterAddress());
                        // 登记时间
                        String times = Tools.timeStamp2Date(pofManagersBeans.get(position).getEstablishDate() + "", "");
                        holder.tvTimeSign.setText(times);
                    }

                    break;
                case "基金专户产品公示":
                    holder.ll_daibiao_name.setVisibility(View.GONE);
                    holder.tvSearchResultsCount.setVisibility(View.GONE);
                    holder.llLookAll.setVisibility(View.GONE);
                    holder.lineBottom10.setVisibility(View.VISIBLE);
//                    holder.tvSearchResultsCount.setText("搜索到" + resultBean.getFundAccounts().getPage().getTotalCount() + "条基金专户备案信息");
                    // 基金专户备案信息
                    holder.tv1.setText(mContext.getResources().getString(R.string.txt_manage_name));
                    holder.tv2.setText(mContext.getResources().getString(R.string.txt_type_zhuanhu));
                    holder.tv3.setText(mContext.getResources().getString(R.string.txt_beian_number));
                    holder.tv4.setText(mContext.getResources().getString(R.string.txt_record_time));
                    fundAcountListBeans = mData;
                    if (fundAcountListBeans != null && fundAcountListBeans.size() > 0) {
                        // 公司名称
                        holder.tvCompanyName.setText(fundAcountListBeans.get(position).getName());
                        // 管理人名称
                        holder.tvOrgType.setText(fundAcountListBeans.get(position).getManager());
                        // 专户类型
                        holder.tvSignNumber.setText(fundAcountListBeans.get(position).getType());
                        // 备案编码
                        holder.tvSignAddress.setText(fundAcountListBeans.get(position).getRegisterCode());
                        // 备案日期
                        String times2 = Tools.timeStamp2Date(fundAcountListBeans.get(position).getRegisterDate() + "", "");
                        holder.tvTimeSign.setText(times2);
                    }

                    break;
                default:
                    break;
            }
        }


    }

    void bindListener() {
        holder.llLookAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_look_all:
                Tools.toast("查看全部2");
                JumpTools.jumpWithdFlag(mContext, JjzhcpgsActivity.class, "查看全部");
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
        @BindView(R.id.tv_1)
        TextView tv1;
        @BindView(R.id.tv_org_type)
        TextView tvOrgType;
        @BindView(R.id.tv_2)
        TextView tv2;
        @BindView(R.id.tv_sign_number)
        TextView tvSignNumber;
        @BindView(R.id.tv_3)
        TextView tv3;
        @BindView(R.id.tv_sign_address)
        TextView tvSignAddress;
        @BindView(R.id.tv_4)
        TextView tv4;
        @BindView(R.id.tv_time_sign)
        TextView tvTimeSign;
        @BindView(R.id.line_bottom_1)
        View lineBottom1;
        @BindView(R.id.line_bottom_10)
        View lineBottom10;
        @BindView(R.id.ll_look_all)
        LinearLayout llLookAll;
        @BindView(R.id.ll_daibiao_name)
        LinearLayout ll_daibiao_name;
        @BindView(R.id.tv_daibiao_name)
        TextView tv_daibiao_name;
        @BindView(R.id.tv_search_results_count)
        TextView tvSearchResultsCount;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
