package demo.third.com.exceldemo.ui.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.Unbinder;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.app.events.GoToSortEvent;
import demo.third.com.exceldemo.service.entity.HomePageEntity;
import demo.third.com.exceldemo.ui.activity.InstitutionalPubActivity;
import demo.third.com.exceldemo.ui.activity.LandSpaceActivity;
import demo.third.com.exceldemo.ui.activity.MyWebActivity;
import demo.third.com.exceldemo.ui.activity.PrivateFundActivity;
import demo.third.com.exceldemo.ui.activity.PrivateFundOrgActivity;
import demo.third.com.exceldemo.ui.activity.ProductsInfoActivity;
import demo.third.com.exceldemo.ui.activity.SearchResultActivity;
import demo.third.com.exceldemo.ui.adapter.BannerAdapter;
import demo.third.com.exceldemo.ui.adapter.BaseGridViewAdapter;
import demo.third.com.exceldemo.ui.adapter.ListViewAdapter;
import demo.third.com.exceldemo.ui.views.MyGridView;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.JumpTools;
import demo.third.com.exceldemo.utils.Link;
import demo.third.com.exceldemo.utils.Tools;
import okhttp3.Call;

/**
 * @author peter
 * @date 2017/11/25
 */

public class MainFragment extends BaseFragment {
    Unbinder unbinder;
    @BindView(R.id.grid_view)
    MyGridView gridView;
    @BindView(R.id.vp_banner)
    ViewPager vpBanner;
    @BindView(R.id.rg_dot)
    RadioGroup rgDot;
    Unbinder unbinder1;
    @BindView(R.id.et_search2)
    EditText etSearch;
    Unbinder unbinder2;
    @BindView(R.id.lv_main)
    MyListView lvMain;
    @BindView(R.id.iv_home_ads)
    ImageView iv_home_ads;

    private BaseGridViewAdapter adapterGrid;
    private BannerAdapter adapterBanner;
    private List data = new ArrayList<>();
    private List<ImageView> bannerData = new ArrayList<>();
    private List<Integer> listData = new ArrayList<>();
    private ListViewAdapter listViewAdapter;
    private HomePageEntity entity;
    private String targetUrl;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(getLayoutId(), container, false);
            unbinder = ButterKnife.bind(this, view);
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        unbinder2 = ButterKnife.bind(this, view);
        searchFromKeyBoard();
        return view;
    }

    private void getHomepageData() {
        OkHttpUtils.post().url(Link.HOMEPAGE).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        entity = CustomGson.fromJson(response, HomePageEntity.class);
                        if (entity != null) {
                            // 主列表
                            listViewAdapter = new ListViewAdapter(getActivity(), entity,
                                    "homepage");
                            lvMain.setAdapter(listViewAdapter);
                            // 固定banner
                            if (entity.getResult() != null && entity.getResult().getBanner() !=
                                    null) {
                                targetUrl = entity.getResult().getBanner().get(0).getTargetUrl();
                                Bitmap bitmap = Tools.convertStringToIcon(entity.getResult().getBanner().get(0).getImg());
                                if (bitmap != null) {
                                    Glide.with(getActivity()).load(bitmap).into(iv_home_ads);
                                }
                            }
                        }
                    }
                });
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder2.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_plus_one;
    }

    @Override
    protected void bindListener() {

    }

    void searchFromKeyBoard() {
//        etSearch.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
//                if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent
//                        .ACTION_UP) {
//                    //业务代码
//                    JumpTools.jumpWithdFlag(getActivity(), SearchResultActivity.class, "首页搜索");
//                    return true;
//                }
//                return false;
//            }
//        });
        iv_home_ads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(targetUrl)) {
//                    JumpTools.jumpWithUrl(getActivity(), MyWebActivity.class, "http://gs.amac.org" +
//                            ".cn/amac-infodisc/res/pof/fund/351000133588.html");
                    if (targetUrl.contains("http:") || targetUrl.contains("https:")) {
                        JumpTools.jumpWithUrl(getActivity(), MyWebActivity.class, targetUrl);
                    } else {
                        Tools.toast("链接地址无效");
                    }
                }
            }
        });
        etSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                JumpTools.jumpWithdFlag(getActivity(), SearchResultActivity.class, etSearch.getText().toString());
                JumpTools.jumpWithdFlag(getActivity(), SearchResultActivity.class, "首页搜索");
            }
        });
    }


    /**
     * @param position 可以绑定列表和网格的点击事件
     */
    @OnItemClick(R.id.grid_view)
    void onItemSelected(int position) {
        switch (position) {
            // 私募基金
            case 0:
                JumpTools.jumpWithdFlag(getActivity(), PrivateFundActivity.class, getResources().getString(R.string.txt_personal_pub));
                break;
            // 管理人分类
            case 1:
                JumpTools.jumpWithdFlag(getActivity(), LandSpaceActivity.class, getResources()
                        .getString(R.string.tip_smjjglrflgs));
//                JumpTools.jumpWithdFlag(getActivity(), FundProductsActivity.class, "creditInfo");
                break;
            // 服务机构
            case 2:
                JumpTools.jumpWithdFlag(getActivity(), PrivateFundOrgActivity.class, getResources().getString(R.string.txt_personal_org_pub));
                break;
            // 从业机构公示
            case 3:
                JumpTools.jumpOnly(getActivity(), InstitutionalPubActivity.class);
                break;
            // 证券产品
            case 4:
                JumpTools.jumpWithdFlag(getActivity(), ProductsInfoActivity.class, getResources()
                        .getString(R.string.txt_zqgszgcp));
                break;
            // 直投基金
            case 5:
                JumpTools.jumpWithdFlag(getActivity(), ProductsInfoActivity.class, getResources()
                        .getString(R.string.txt_zqgsztjj));
                break;
            // 期货产品
            case 6:
                JumpTools.jumpWithdFlag(getActivity(), ProductsInfoActivity.class, getResources()
                        .getString(R.string.txt_future_products));
                break;
            // 跳转到分类Tab页
            case 7:
                EventBus.getDefault().post(new GoToSortEvent(1));
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        gridView.setOnItemClickListener(this);

        if (data != null) {
            data.add(1);
            data.add(1);
            data.add(1);
            data.add(1);
            data.add(1);
            data.add(1);
            data.add(1);
            data.add(1);
        }
        adapterGrid = new BaseGridViewAdapter(getActivity(), data);
        gridView.setAdapter(adapterGrid);

        if (bannerData != null) {
            for (int i = 0; i < 5; i++) {
                ImageView imageView = new ImageView(getActivity());
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                        .MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                imageView.setLayoutParams(params);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(getActivity()).load(R.mipmap.icon_welcome_default).into(imageView);
                bannerData.add(imageView);
            }

        }
        adapterBanner = new BannerAdapter(bannerData);
        vpBanner.setAdapter(adapterBanner);
        vpBanner.setOnTouchListener(new View.OnTouchListener() {
            int flage = 0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        flage = 0;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        flage = 1;
                        break;
                    case MotionEvent.ACTION_UP:
                        if (flage == 0) {
                            int item = vpBanner.getCurrentItem();
//                            Tools.toast(entity.getResult().getTopBanner().get(item)
// .getTargetUrl());
                        }
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        if (listData != null) {
            listData.add(1);
            listData.add(1);
            listData.add(1);
            listData.add(1);
            listData.add(1);
            listData.add(1);
        }
        getHomepageData();
    }
}
