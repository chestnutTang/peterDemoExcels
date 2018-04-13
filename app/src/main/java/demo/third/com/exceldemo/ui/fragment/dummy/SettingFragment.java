package demo.third.com.exceldemo.ui.fragment.dummy;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.activity.LoginActivity;
import demo.third.com.exceldemo.ui.fragment.BaseFragment;
import demo.third.com.exceldemo.utils.JumpTools;
import demo.third.com.exceldemo.utils.Logger;
import demo.third.com.exceldemo.utils.Tools;

/**
 * peterDemoExcels
 * Created by peter
 * on 2018.03
 * 设置页面，我的页面
 */

public class SettingFragment extends BaseFragment implements View.OnClickListener {


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
    @BindView(R.id.head_iv)
    ImageView headIv;
    Unbinder unbinder1;

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
        bindListener();
        unbinder1 = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.e("song", "onDestroyView");
        unbinder1.unbind();
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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void bindListener() {
        ivBackup.setOnClickListener(this);
        relUpdatePassword.setOnClickListener(this);
        Bitmap bitmap = Tools.createTextImage(200, 200, 30, "索拉卡的积分可视对讲佛我未及时打开了飞机快乐圣诞节疯狂了的设计费考虑到设计费施蒂利克");
        Glide.with(view).load(bitmap).into(headIv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_backup:
                Tools.toast("0909090");
                break;
            case R.id.rel_update_password:
                JumpTools.jumpOnly(getActivity(), LoginActivity.class);
                break;
            default:
                break;
        }
    }
}
