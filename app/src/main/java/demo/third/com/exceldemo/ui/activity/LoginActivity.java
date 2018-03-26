package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.utils.JumpTools;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView();
        bindListener();
    }

    @Override
    protected void bindView() {
        super.bindView();
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
                JumpTools.jumpOnly(this, MainActivity.class);
                break;
            //发送验证码
            case R.id.tv_post_code:
                break;
            default:
                break;
        }
    }
}

