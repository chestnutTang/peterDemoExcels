package demo.third.com.exceldemo.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.adapter.ListViewAdapter;

/**
 * @author songzhengpeng
 * 分类
 */
public class SortFragment extends BaseFragment {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.lv_message)
    ListView lvMessage;
    Unbinder unbinder;
    @BindView(R.id.rb_info_public)
    RadioButton rbInfoPublic;
    @BindView(R.id.rb_test_platform)
    RadioButton rbTestPlatform;
    @BindView(R.id.rg_sort)
    RadioGroup rgSort;
    @BindView(R.id.ll_message)
    LinearLayout llMessage;

    private List<String> listTestPlatform = new ArrayList<>();
    private List<String> listInfoPublic = new ArrayList<>();
    private ListViewAdapter listViewAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_message;
    }

    @Override
    protected void bindListener() {
        ivBackup.setVisibility(View.GONE);
        llMessage.setBackgroundColor(Color.parseColor("#ffffff"));
        tvTitle.setText(getResources().getString(R.string.title_sort));
        // 信息公示
        if (listInfoPublic != null) {
            listInfoPublic.add(getResources().getString(R.string.tip_per_search_));
            listInfoPublic.add(getResources().getString(R.string.tip_product_public_));
            listInfoPublic.add(getResources().getString(R.string.txt_personal_pub));
            listInfoPublic.add(getResources().getString(R.string.txt_org_pub));
            listInfoPublic.add(getResources().getString(R.string.txt_employee_publicity));
            listInfoPublic.add(getResources().getString(R.string.txt_no_registration));
            listInfoPublic.add(getResources().getString(R.string.txt_disciplinary_action));
            listInfoPublic.add(getResources().getString(R.string.txt_black_list));
            listInfoPublic.add(getResources().getString(R.string.txt_personal_org_pub));
            listInfoPublic.add(getResources().getString(R.string.txt_private_products_enter));
            listInfoPublic.add(getResources().getString(R.string.txt_asset_manage));
            listInfoPublic.add(getResources().getString(R.string.txt_assert_support));
            listInfoPublic.add(getResources().getString(R.string.txt_assert_support_enter));
            listInfoPublic.add(getResources().getString(R.string.txt_future_products));
            listInfoPublic.add(getResources().getString(R.string.txt_direct_fund));
            listInfoPublic.add(getResources().getString(R.string.txt_private_fund));
            listInfoPublic.add(getResources().getString(R.string.txt_pub_person));
            listInfoPublic.add(getResources().getString(R.string.txt_cancel_manage));
            listInfoPublic.add(getResources().getString(R.string.btn_fund_person));
            listInfoPublic.add(getResources().getString(R.string.txt_sale_count));
        }
        // 考试平台
        if (listTestPlatform != null) {
            listTestPlatform.add(getResources().getString(R.string.txt_qualification_menu));
            listTestPlatform.add(getResources().getString(R.string.txt_qualification_reserve));
            listTestPlatform.add(getResources().getString(R.string.txt_qualification_enroll));
            listTestPlatform.add(getResources().getString(R.string.txt_qualification_info));
            listTestPlatform.add(getResources().getString(R.string.txt_qualification_search));
            listTestPlatform.add(getResources().getString(R.string.txt_qualification__enroll_week));
        }
        rgSort.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    // 信息公示
                    case R.id.rb_info_public:
                        rbInfoPublic.setTextColor(getActivity().getResources().getColor(R.color.white));
                        rbInfoPublic.setBackgroundColor(getActivity().getResources().getColor(R.color.color_bf));
                        rbTestPlatform.setTextColor(getActivity().getResources().getColor(R.color.color_bf));
                        rbTestPlatform.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
                        listViewAdapter = new ListViewAdapter(getActivity(), listInfoPublic, "employee");
                        lvMessage.setAdapter(listViewAdapter);
                        break;
                    // 考试平台
                    case R.id.rb_test_platform:
                        rbTestPlatform.setTextColor(getActivity().getResources().getColor(R.color.white));
                        rbTestPlatform.setBackgroundColor(getActivity().getResources().getColor(R.color.color_bf));
                        rbInfoPublic.setTextColor(getActivity().getResources().getColor(R.color.color_bf));
                        rbInfoPublic.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
                        listViewAdapter = new ListViewAdapter(getActivity(), listTestPlatform, "employee");
                        lvMessage.setAdapter(listViewAdapter);
                        break;
                }
            }
        });
        listViewAdapter = new ListViewAdapter(getActivity(), listInfoPublic, "employee");
        lvMessage.setAdapter(listViewAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
//        bindListener();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.iv_backup)
    public void onViewClicked() {
    }
}
