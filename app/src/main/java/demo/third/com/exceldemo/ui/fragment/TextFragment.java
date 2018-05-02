package demo.third.com.exceldemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.adapter.BaseGridViewAdapter;

/**
 * @author peter
 * @date 2017/11/25
 */

public class TextFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    Unbinder unbinder;
    @BindView(R.id.grid_view)
    GridView gridView;

    private BaseGridViewAdapter adapter;
    private List data = new ArrayList();

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
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
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
        }

        adapter = new BaseGridViewAdapter(getActivity(), data);
        gridView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
