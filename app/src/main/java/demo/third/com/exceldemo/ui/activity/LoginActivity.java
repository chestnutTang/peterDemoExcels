package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.LoginEntity;
import demo.third.com.exceldemo.service.presenter.LoginPresenter;
import demo.third.com.exceldemo.service.view.LoginView;
import demo.third.com.exceldemo.utils.JumpTools;
import demo.third.com.exceldemo.utils.Tools;

/**
 * 登陆页面
 *
 * @author peter
 */
public class LoginActivity extends BaseActivity {


    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.login_progress)
    ProgressBar loginProgress;
    @BindView(R.id.image_phone)
    ImageView imagePhone;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.iv_phone_clear)
    RelativeLayout ivPhoneClear;
    @BindView(R.id.lin_phonenumber_layout)
    RelativeLayout linPhonenumberLayout;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.et_verification_code)
    EditText etVerificationCode;
    @BindView(R.id.tv_post_code)
    TextView tvPostCode;
    @BindView(R.id.lin_password_layout)
    RelativeLayout linPasswordLayout;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_protol)
    TextView tvProtol;
    @BindView(R.id.tv_register)
    TextView tvRegister;

    private LoginPresenter loginPresenter = new LoginPresenter(this);

    private LoginView loginView = new LoginView() {
        @Override
        public void onSuccess(LoginEntity mloginEntity) {
            if (mloginEntity != null) {
                Tools.toast(mloginEntity.getData().getQuality());
            }
        }

        @Override
        public void onError(String result) {
            Tools.toast("错误" + result);
            Log.e("song", "错误的信息" + result);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView();
        bindListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onStop();
    }

    @Override
    protected void bindView() {
        super.bindView();
        loginPresenter.onCreate();
        loginPresenter.attachView(loginView);
    }

    @Override
    protected void bindListener() {
        super.bindListener();
        btnLogin.setOnClickListener(this);
        tvPostCode.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            //登录
            case R.id.btn_login:
                if (!TextUtils.isEmpty(etPhone.getText().toString()) && !TextUtils.isEmpty
                        (etVerificationCode.getText().toString())) {
                    loginPresenter.loginSystem(etPhone.getText().toString(), etVerificationCode
                            .getText().toString());
                } else {
                    Tools.toast("补充信息");
                }
                JumpTools.jumpOnly(this, MainActivity.class);
                break;
            //发送验证码
            case R.id.tv_post_code:
                JumpTools.JumpToOtherApp(this);
                break;
            default:
                break;
        }
    }

}

