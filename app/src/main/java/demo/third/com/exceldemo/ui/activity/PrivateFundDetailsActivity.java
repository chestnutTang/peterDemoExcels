package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.adapter.FundDetailAdapter;
import demo.third.com.exceldemo.ui.views.MyListView;

/**
 * 私募基金公示详情页
 *
 * @author songzhengpeng
 */
public class PrivateFundDetailsActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.lv_pri_fund_detail)
    MyListView lvPriFundDetail;
    @BindView(R.id.lv_pri_fund_detail2)
    MyListView lvPriFundDetail2;
    private List<String> list = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();
    private FundDetailAdapter adapter;
    private FundDetailAdapter adapter2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText(getResources().getString(R.string.txt_personal_pub_info));

        list.add(getResources().getString(R.string.tip_private_name));
        list.add(getResources().getString(R.string.tip_private_number));
        list.add(getResources().getString(R.string.txt_time_create));
        list.add(getResources().getString(R.string.tip_basj));
        list.add(getResources().getString(R.string.btn_fund_record));
        list.add(getResources().getString(R.string.tip_fund_type));
        list.add(getResources().getString(R.string.tip_money_type));
        list.add(getResources().getString(R.string.tip_manage_name));
        list.add(getResources().getString(R.string.btn_manage_type));
        list.add(getResources().getString(R.string.txt_tuo_name));
        list.add(getResources().getString(R.string.btn_run_state));
        list.add(getResources().getString(R.string.tip_last_time));
        list.add(getResources().getString(R.string.tip_special));

        list2.add(getResources().getString(R.string.tip_month_bao));
        list2.add(getResources().getString(R.string.tip_half_year_bao));
        list2.add(getResources().getString(R.string.tip_year_bao));
        list2.add(getResources().getString(R.string.tip_ji_bao));

        adapter = new FundDetailAdapter(PrivateFundDetailsActivity.this, list);
        adapter2 = new FundDetailAdapter(PrivateFundDetailsActivity.this, list2);
        lvPriFundDetail.setAdapter(adapter);
        lvPriFundDetail2.setAdapter(adapter2);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_private_fund_details;
    }

    @OnClick(R.id.iv_backup)
    public void onViewClicked() {
        finish();
    }
}