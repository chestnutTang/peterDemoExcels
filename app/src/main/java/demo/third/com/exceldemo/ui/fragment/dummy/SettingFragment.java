package demo.third.com.exceldemo.ui.fragment.dummy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.fragment.BaseFragment;

/**
 * peterDemoExcels
 * Created by peter
 * on 2018.03
 * 设置页面，我的页面
 */

public class SettingFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(getLayoutId(), container, false);
        }

        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        return view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }
}
