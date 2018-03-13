package demo.third.com.exceldemo.ui.fragment.dummy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.fragment.BaseFragment;
import demo.third.com.exceldemo.utils.Logger;
import demo.third.com.exceldemo.utils.Tools;

/**
 * peterDemoExcels
 * Created by peter
 * on 2018.03
 * 设置页面，我的页面
 */

public class SettingFragment extends BaseFragment {


    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.txt_update_password)
    TextView txtUpdatePassword;
    @BindView(R.id.rel_update_password)
    RelativeLayout relUpdatePassword;
    Unbinder unbinder;

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
        ivBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tools.toast("0909090");
            }
        });
        return view;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.e("song", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.e("song", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.e("song", "onDetach");
    }
}
