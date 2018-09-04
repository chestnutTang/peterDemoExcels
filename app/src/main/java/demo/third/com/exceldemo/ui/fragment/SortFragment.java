package demo.third.com.exceldemo.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
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

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.CyzgksjcdgEntity;
import demo.third.com.exceldemo.service.entity.XszhEntity;
import demo.third.com.exceldemo.ui.activity.BlackListActivity;
import demo.third.com.exceldemo.ui.activity.BydjjgActivity;
import demo.third.com.exceldemo.ui.activity.CxglrydjdmdActivity;
import demo.third.com.exceldemo.ui.activity.DownLoadWebActivity;
import demo.third.com.exceldemo.ui.activity.InstitutionalPubActivity;
import demo.third.com.exceldemo.ui.activity.JjzhcpgsActivity;
import demo.third.com.exceldemo.ui.activity.LandSpaceActivity;
import demo.third.com.exceldemo.ui.activity.LandSpaceCyrygsActivity;
import demo.third.com.exceldemo.ui.activity.LandZczcjhActivity;
import demo.third.com.exceldemo.ui.activity.MyWebActivity;
import demo.third.com.exceldemo.ui.activity.MyWebLanspaceActivity;
import demo.third.com.exceldemo.ui.activity.PrivateFundActivity;
import demo.third.com.exceldemo.ui.activity.PrivateProductsActivity;
import demo.third.com.exceldemo.ui.activity.ProductsInfoActivity;
import demo.third.com.exceldemo.ui.activity.QaRegisterActivity;
import demo.third.com.exceldemo.ui.activity.QualificationSearchActivity;
import demo.third.com.exceldemo.ui.activity.SearchResultActivity;
import demo.third.com.exceldemo.ui.adapter.ListViewAdapter;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.JumpTools;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Constant.DEFAULT_COUNT;
import static demo.third.com.exceldemo.utils.Link.BYDJJG;
import static demo.third.com.exceldemo.utils.Link.CYZGKSZkBM;
import static demo.third.com.exceldemo.utils.Link.DOWNLOADGMJJ;
import static demo.third.com.exceldemo.utils.Link.DOWNLOAD_TGYX;
import static demo.third.com.exceldemo.utils.Link.SEARCH_CXDJ;
import static demo.third.com.exceldemo.utils.Link.SEARCH_CYKSXX;
import static demo.third.com.exceldemo.utils.Link.SEARCH_JCDG;
import static demo.third.com.exceldemo.utils.Link.SEARCH_ZHGS;
import static demo.third.com.exceldemo.utils.Link.SMJJFWJGGS;

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
    private XszhEntity xszhEntity;
    private String xszhContent;
    private String cyzgksjcdgContent;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sort;
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
                            JumpTools.jumpWithdFlag(getActivity(), JjzhcpgsActivity.class,"");
//                            JumpTools.jumpWithdFlag(getActivity(), SearchResultActivity.class, getResources().getString(R.string.tip_product_public_));
//                            JumpTools.jumpWithdFlag(getActivity(), FundProductsActivity.class, "creditInfo");
                            break;
                        // 私募基金公示
                        case 2:
                            JumpTools.jumpWithdFlag(getActivity(), PrivateFundActivity.class, getResources().getString(R.string.txt_personal_pub));
//                            JumpTools.jumpWithdFlag(getActivity(), FundProductsActivity.class, "employee");
                            break;
                        // 从业机构公示
                        case 3:
                            JumpTools.jumpOnly(getActivity(), InstitutionalPubActivity.class);
                            break;
                        // 从业人员公示 横向滑动的列表
                        case 4:
                            JumpTools.jumpWithdFlag(getActivity(), LandSpaceCyrygsActivity.class, getResources().getString(R.string.txt_employee_publicity));
                            break;
                        // 不予登记机构
                        case 5:
                            JumpTools.jumpWithUrl(getActivity(), BydjjgActivity.class, BYDJJG, getResources().getString(R.string.txt_no_registration));
                            break;
                        // 纪律处分
                        case 6:
                            JumpTools.jumpWithdFlag(getActivity(), BlackListActivity.class, getResources().getString(R.string.txt_disciplinary_action));
                            break;
                        // 黑名单
                        case 7:
                            JumpTools.jumpWithdFlag(getActivity(), BlackListActivity.class, getResources().getString(R.string.txt_black_list));
                            break;
                        // 私募基金服务机构公示
                        case 8:
                            JumpTools.jumpWithUrl(getActivity(), MyWebLanspaceActivity.class, SMJJFWJGGS,getResources().getString(R.string.txt_personal_org_pub));
                            break;
                        // 证券公司私募产品备案确认函
                        case 9:
                            JumpTools.jumpOnly(getActivity(), PrivateProductsActivity.class);
                            break;
                        // 证券公司资管产品备案信息公示
                        case 10:
                            JumpTools.jumpWithdFlag(getActivity(), ProductsInfoActivity.class, getResources().getString(R.string.txt_zqgszgcp));
                            break;
                        // 资产支持专项计划信息公示
                        case 11:
                            JumpTools.jumpOnly(getActivity(), LandZczcjhActivity.class);
                            break;
                        // 资产支持专项计划备案确认函公示
                        case 12:
                            JumpTools.jumpWithdFlag(getActivity(), BlackListActivity.class, getResources().getString(R.string.txt_assert_support_enter));
                            break;
                        // 期货公司资管产品
                        case 13:
                            JumpTools.jumpWithdFlag(getActivity(), ProductsInfoActivity.class, getResources().getString(R.string.txt_future_products));
                            break;
                        // 证券公司直投基金公示信息
                        case 14:
                            JumpTools.jumpWithdFlag(getActivity(), ProductsInfoActivity.class, getResources().getString(R.string.txt_zqgsztjj));
                            break;
                        // 证券公司私募投资基金
                        case 15:
                            JumpTools.jumpWithdFlag(getActivity(), LandSpaceActivity.class, getResources().getString(R.string.txt_private_fund));
                            break;
                        // 公募基金管理人
                        case 16:
                            JumpTools.jumpWithUrl(getActivity(), DownLoadWebActivity.class, DOWNLOADGMJJ, getResources().getString(R.string.txt_pub_person));
                            break;
                        // 撤销管理人登记的名单
                        case 17:
                            JumpTools.jumpWithUrl(getActivity(), CxglrydjdmdActivity.class, SEARCH_CXDJ, getResources().getString(R.string.txt_cancel_manage));
                            break;
                        // 基金托管人
                        case 18:
                            JumpTools.jumpWithUrl(getActivity(), DownLoadWebActivity.class, DOWNLOAD_TGYX, getResources().getString(R.string.btn_fund_person));
                            break;
                        // 销售账户
                        case 19:
                            JumpTools.jumpWithUrl(getActivity(), BydjjgActivity.class, SEARCH_ZHGS, getResources().getString(R.string.txt_sale_count));
//                            getXszhData();
                            break;
                        default:
                            break;
                    }
                } else {
                    // 考试平台
                    switch (position) {
                        // 从业资格考试大纲
                        case 0:
                            JumpTools.jumpWithdFlag(getActivity(), BlackListActivity.class, getResources().getString(R.string.txt_qualification_menu));
                            break;
                        // 从业资格考试教材订购
                        case 1:
                            if(!TextUtils.isEmpty(cyzgksjcdgContent)){
                                JumpTools.jumpWithUrl(getActivity(), MyWebLanspaceActivity.class, cyzgksjcdgContent, "基金从业资格预约式考试周考网上报名");
                            }
                            break;
                        // 从业资格考试报名
                        case 2:
                            JumpTools.jumpOnly(getActivity(), QaRegisterActivity.class);
                            break;
                        // 从业资格考试信息
                        case 3:
                            JumpTools.jumpWithUrl(getActivity(), CxglrydjdmdActivity.class, SEARCH_CYKSXX, getResources().getString(R.string.txt_qualification_info));
//                            JumpTools.jumpOnly(getActivity(), QuaTestInfoActivity.class);
                            break;
                        // 从业资格考试成绩查询
                        case 4:
                            JumpTools.jumpOnly(getActivity(), QualificationSearchActivity.class);
                            break;
                        // 从业资格考试周考报名
                        case 5:
                            JumpTools.jumpWithUrl(getActivity(), MyWebActivity.class, CYZGKSZkBM, "基金从业资格预约式考试周考网上报名");
                            break;
                        default:
                            break;
                    }
                }
            }
        });
        getXszhData();
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

    private void getXszhData() {
        OkHttpUtils.post().url(SEARCH_JCDG).addParams("pageIndex", "1")
                .addParams("pageSize", DEFAULT_COUNT+"")
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                CyzgksjcdgEntity cyzgksjcdgEntity = CustomGson.fromJson(response, CyzgksjcdgEntity.class);
                if (cyzgksjcdgEntity != null && cyzgksjcdgEntity.getResult() != null && cyzgksjcdgEntity.getResult().getData() != null) {
                    cyzgksjcdgContent = cyzgksjcdgEntity.getResult().getData().getContent();
                }

            }
        });
    }

}
