package demo.third.com.exceldemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.Unbinder;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.activity.FundProductsActivity;
import demo.third.com.exceldemo.ui.activity.InstitutionalPubActivity;
import demo.third.com.exceldemo.ui.activity.LandSpaceWebWebActivity;
import demo.third.com.exceldemo.ui.activity.SearchResultActivity;
import demo.third.com.exceldemo.ui.adapter.BannerAdapter;
import demo.third.com.exceldemo.ui.adapter.BaseGridViewAdapter;
import demo.third.com.exceldemo.ui.adapter.ListViewAdapter;
import demo.third.com.exceldemo.ui.views.MyGridView;
import demo.third.com.exceldemo.ui.views.MyListView;
import demo.third.com.exceldemo.utils.JumpTools;
import demo.third.com.exceldemo.utils.Tools;

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
    @BindView(R.id.et_search)
    EditText etSearch;
    Unbinder unbinder2;
    @BindView(R.id.lv_main)
    MyListView lvMain;

    private BaseGridViewAdapter adapterGrid;
    private BannerAdapter adapterBanner;
    private List data = new ArrayList<>();
    private List<ImageView> bannerData = new ArrayList<>();
    private List<Integer> listData = new ArrayList<>();
    private ListViewAdapter listViewAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView imageView = new ImageView(getActivity());
        bannerData.add(imageView);
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
        etSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    //业务代码
                    Tools.toast("搜索" + etSearch.getText().toString());
                    JumpTools.jumpWithdFlag(getActivity(), SearchResultActivity.class, etSearch.getText().toString());
                }
                return false;
            }
        });
    }


    /**
     * @param position 可以绑定列表和网格的点击事件
     */
    @OnItemClick(R.id.grid_view)
    void onItemSelected(int position) {
        Tools.toast("位置" + position);
        switch (position) {
            case 0:
//                JumpTools.jumpOnly(getActivity(), InstitutionalPubActivity.class);
                JumpTools.jumpWithdFlag(getActivity(), FundProductsActivity.class, "employeeOrg");
                break;
            case 1:
                JumpTools.jumpWithdFlag(getActivity(), FundProductsActivity.class, "creditInfo");
                break;
            case 2:
                JumpTools.jumpWithdFlag(getActivity(), FundProductsActivity.class, "fundProducts");
                break;
            case 3:
                JumpTools.jumpWithdFlag(getActivity(), FundProductsActivity.class, "employee");
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
        }

        adapterGrid = new BaseGridViewAdapter(getActivity(), data);
        gridView.setAdapter(adapterGrid);

        adapterBanner = new BannerAdapter(bannerData);
        vpBanner.setAdapter(adapterBanner);

        if (listData != null) {
            listData.add(1);
            listData.add(1);
            listData.add(1);
            listData.add(1);
            listData.add(1);
            listData.add(1);
        }

        listViewAdapter = new ListViewAdapter(getActivity(), listData, "homepage");
        lvMain.setAdapter(listViewAdapter);
    }
//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//    }
}
