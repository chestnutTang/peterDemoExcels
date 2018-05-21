package demo.third.com.exceldemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.activity.ContactUsActivity;
import demo.third.com.exceldemo.ui.activity.LoginActivity;
import demo.third.com.exceldemo.ui.activity.MyInfoActivity;
import demo.third.com.exceldemo.utils.JumpTools;
import demo.third.com.exceldemo.utils.Logger;
import demo.third.com.exceldemo.utils.Tools;

/**
 * peterDemoExcels
 * Created by peter
 * on 2018.03
 * 设置页面，我的页面
 *
 * @author peter
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
    @BindView(R.id.head_iv)
    ImageView headIv;
    @BindView(R.id.iv_download_list)
    ImageView ivDownloadList;
    @BindView(R.id.iv_person_info)
    ImageView ivPersonInfo;
    @BindView(R.id.tv_person_info)
    TextView tvPersonInfo;
    @BindView(R.id.rl_person_info)
    RelativeLayout rlPersonInfo;
    //    Unbinder unbinder2;
    @BindView(R.id.iv_member)
    ImageView ivMember;
    @BindView(R.id.tv_member)
    TextView tvMember;
    @BindView(R.id.tv_btn_member)
    TextView tvBtnMember;
    @BindView(R.id.iv_dayu)
    ImageView ivDayu;
    @BindView(R.id.rl_member)
    RelativeLayout rlMember;
    @BindView(R.id.iv_help)
    ImageView ivHelp;
    @BindView(R.id.tv_help)
    TextView tvHelp;
    @BindView(R.id.rl_help)
    RelativeLayout rlHelp;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.rl_share)
    RelativeLayout rlShare;
    @BindView(R.id.iv_contract_us)
    ImageView ivContractUs;
    @BindView(R.id.tv_contract_us)
    TextView tvContractUs;
    @BindView(R.id.rl_contract_us)
    RelativeLayout rlContractUs;

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
//        unbinder2 = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void openShare() {
        UMWeb web = new UMWeb("https://www.baidu.com/");
        web.setTitle("牛逼不用解释");//标题
        web.setDescription("sldfjsdk");//描述
        new ShareAction(getActivity())
                .withMedia(web)
                .setDisplayList(SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN,
                        SHARE_MEDIA.QZONE)
                .setCallback(shareListener).open();
    }

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(getActivity(), "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(getActivity(), "失 败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(getActivity(), "取消了", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.e("song", "onDestroyView");
//        unbinder2.unbind();
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

    }

    @OnClick({R.id.rl_member, R.id.rl_help, R.id.rl_share, R.id.rl_contract_us, R.id.iv_backup, R.id.rel_update_password, R.id.rl_person_info})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_member:
                break;
            case R.id.rl_help:
                break;
                //帮助与反馈
            case R.id.rl_share:
                openShare();
                break;
                //联系我们
            case R.id.rl_contract_us:
                JumpTools.jumpOnly(getActivity(), ContactUsActivity.class);
                break;
            case R.id.iv_backup:
                Tools.toast("0909090");
                break;
            case R.id.rel_update_password:
                JumpTools.jumpOnly(getActivity(), LoginActivity.class);
                break;
            //个人信息
            case R.id.rl_person_info:
                JumpTools.jumpOnly(getActivity(), MyInfoActivity.class);
                break;
            default:
                break;
        }
    }
}
