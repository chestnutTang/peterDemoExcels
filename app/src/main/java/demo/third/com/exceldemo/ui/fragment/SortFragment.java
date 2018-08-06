package demo.third.com.exceldemo.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import demo.third.com.exceldemo.ui.activity.BlackListActivity;
import demo.third.com.exceldemo.ui.activity.FundProductsActivity;
import demo.third.com.exceldemo.ui.activity.InstitutionalPubActivity;
import demo.third.com.exceldemo.ui.activity.LandSpaceActivity;
import demo.third.com.exceldemo.ui.activity.LandSpaceCyrygsActivity;
import demo.third.com.exceldemo.ui.activity.PrivateFundActivity;
import demo.third.com.exceldemo.ui.activity.PrivateProductsActivity;
import demo.third.com.exceldemo.ui.activity.QaRegisterActivity;
import demo.third.com.exceldemo.ui.activity.QuaTestInfoActivity;
import demo.third.com.exceldemo.ui.activity.QualificationSearchActivity;
import demo.third.com.exceldemo.ui.activity.SearchResultActivity;
import demo.third.com.exceldemo.ui.adapter.ListViewAdapter;
import demo.third.com.exceldemo.utils.JumpTools;

/**
 * @author peter
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
    private boolean isLeftChecked = true;

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
                        isLeftChecked = true;
                        rbInfoPublic.setTextColor(getActivity().getResources().getColor(R.color.white));
                        rbInfoPublic.setBackgroundColor(getActivity().getResources().getColor(R.color.color_bf));
                        rbTestPlatform.setTextColor(getActivity().getResources().getColor(R.color.color_bf));
                        rbTestPlatform.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
                        listViewAdapter = new ListViewAdapter(getActivity(), listInfoPublic, "employee");
                        lvMessage.setAdapter(listViewAdapter);
                        break;
                    // 考试平台
                    case R.id.rb_test_platform:
                        isLeftChecked = false;
                        rbTestPlatform.setTextColor(getActivity().getResources().getColor(R.color.white));
                        rbTestPlatform.setBackgroundColor(getActivity().getResources().getColor(R.color.color_bf));
                        rbInfoPublic.setTextColor(getActivity().getResources().getColor(R.color.color_bf));
                        rbInfoPublic.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
                        listViewAdapter = new ListViewAdapter(getActivity(), listTestPlatform, "employee");
                        lvMessage.setAdapter(listViewAdapter);
                        break;
                    default:
                        break;
                }
            }
        });
        listViewAdapter = new ListViewAdapter(getActivity(), listInfoPublic, "employee");
        lvMessage.setAdapter(listViewAdapter);
        lvMessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 信息公示
                if (isLeftChecked) {
                    switch (position) {
                        case 0:
                            // 私募基金管理人查询
                            JumpTools.jumpWithdFlag(getActivity(), SearchResultActivity.class, getResources().getString(R.string.tip_per_search_));
//                            JumpTools.jumpWithdFlag(getActivity(), FundProductsActivity.class, "fundProducts");
                            break;
                        // 基金专户产品公示 tip_product_public_
                        case 1:
                            JumpTools.jumpWithdFlag(getActivity(), SearchResultActivity.class, getResources().getString(R.string.tip_product_public_));
//                            JumpTools.jumpWithdFlag(getActivity(), FundProductsActivity.class, "creditInfo");
                            break;
                        case 2:
                            JumpTools.jumpWithdFlag(getActivity(), FundProductsActivity.class, "employee");
                            break;
                        // 从业机构公示
                        case 3:
                            JumpTools.jumpOnly(getActivity(), InstitutionalPubActivity.class);
                            break;
                        // 从业人员公示
                        case 4:
                            JumpTools.jumpOnly(getActivity(), LandSpaceCyrygsActivity.class);
                            break;
                        // 纪律处分
                        case 6:
                            JumpTools.jumpWithdFlag(getActivity(), BlackListActivity.class, getResources().getString(R.string.txt_disciplinary_action));
                            break;
                        // 黑名单
                        case 7:
                            JumpTools.jumpWithdFlag(getActivity(), BlackListActivity.class, getResources().getString(R.string.txt_black_list));
                            break;
                        // 证券公司私募产品备案确认函
                        case 9:
                            JumpTools.jumpOnly(getActivity(), PrivateProductsActivity.class);
                            break;
                        // 证券公司私募投资基金
                        case 15:
                            JumpTools.jumpWithdFlag(getActivity(), LandSpaceActivity.class, getResources().getString(R.string.txt_private_fund));
                            break;
                        default:
                            break;
                    }
                } else {
                    // 考试平台
                    switch (position) {
                        case 0:
                            break;
                        case 1:
                            break;
                        // 从业资格考试报名
                        case 2:
                            JumpTools.jumpOnly(getActivity(), QaRegisterActivity.class);
                            break;
                        // 从业资格考试信息
//                        case 3:
//                            JumpTools.jumpOnly(getActivity(), QuaTestInfoActivity.class);
//                            break;
//                        // 从业资格考试成绩查询
//                        case 4:
//                            JumpTools.jumpOnly(getActivity(), QualificationSearchActivity.class);
//                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        bindListener();
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
