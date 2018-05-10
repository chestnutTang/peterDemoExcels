package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;

/**
 * @author peter
 * 注册页面
 */
public class RegisterActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_jump)
    TextView tvJump;
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
    @BindView(R.id.iv_password)
    ImageView ivPassword;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.rl_password_clear)
    RelativeLayout rlPasswordClear;
    @BindView(R.id.rl_password)
    RelativeLayout rlPassword;
    @BindView(R.id.et_verification_code)
    EditText etVerificationCode;
    @BindView(R.id.tv_post_code)
    TextView tvPostCode;
    @BindView(R.id.rl_verification_code)
    RelativeLayout rlVerificationCode;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_protol)
    TextView tvProtol;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.lin_login_root)
    LinearLayout linLoginRoot;
    @BindView(R.id.iv_code)
    ImageView ivCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText(getResources().getText(R.string.register_btn));
        tvJump.setVisibility(View.GONE);
    }

    @OnClick({R.id.iv_backup, R.id.tv_post_code, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            case R.id.tv_post_code:
                break;
            case R.id.btn_login:
                break;
            default:
                break;
        }
    }
}
