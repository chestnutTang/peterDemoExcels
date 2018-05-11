package demo.third.com.exceldemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.adapter.BannerAdapter;
import demo.third.com.exceldemo.ui.adapter.BaseGridViewAdapter;
import demo.third.com.exceldemo.ui.views.MyGridView;

/**
 * @author peter
 * @date 2017/11/25
 */

public class MainFragment extends BaseFragment implements AdapterView.OnItemClickListener {
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

    private BaseGridViewAdapter adapterGrid;
    private BannerAdapter adapterBanner;
    private List data = new ArrayList();
    private List<ImageView> listData = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView imageView = new ImageView(getActivity());
        listData.add(imageView);
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridView.setOnItemClickListener(this);
        if (data != null) {
            data.add(1);
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

        adapterBanner = new BannerAdapter(listData);
        vpBanner.setAdapter(adapterBanner);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
