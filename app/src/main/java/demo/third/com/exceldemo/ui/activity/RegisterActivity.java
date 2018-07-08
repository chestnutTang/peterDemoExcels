package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.LoginModel;
import demo.third.com.exceldemo.ui.views.OkRequestParams;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.EncryptPassUtils;
import demo.third.com.exceldemo.utils.JumpTools;
import demo.third.com.exceldemo.utils.Link;
import demo.third.com.exceldemo.utils.Logger;
import demo.third.com.exceldemo.utils.MyTimer;
import demo.third.com.exceldemo.utils.Tools;
import okhttp3.Call;

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
    @BindView(R.id.lin_phonenumber_layout)
    RelativeLayout linPhonenumberLayout;
    @BindView(R.id.iv_password)
    ImageView ivPassword;
    @BindView(R.id.et_password)
    EditText etPassword;
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

    private LoginModel loginModel;

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

    /**
     * 注册
     */
    private void signUp() {
        OkRequestParams params = new OkRequestParams();
        String phoneNumber = etPhone.getText().toString();
        String password = etPassword.getText().toString();
        String verifyCode = etVerificationCode.getText().toString();
        if (!TextUtils.isEmpty(phoneNumber)) {
            params.put("phoneNumber", phoneNumber);
        } else {
            Tools.toast("请输入手机号");
            return;
        }
        if (!TextUtils.isEmpty(password)) {
            params.put("password", EncryptPassUtils.MD5(password));
        } else {
            Tools.toast("请输入密码");
            return;
        }
        if (!TextUtils.isEmpty(verifyCode)) {
            params.put("verifyCode", verifyCode);
        } else {
            Tools.toast("请输入验证码");
            return;
        }
        OkHttpUtils.post().url(Link.SIGN).params(params)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Logger.e("song", response);
                loginModel = CustomGson.fromJson(response, LoginModel.class);
                if (loginModel != null) {
                    switch (loginModel.getCode()) {
                        //成功
                        case 0:
                            JumpTools.jumpOnly(RegisterActivity.this, MainActivity.class);
                            break;
                        //失败
                        case 101:
                            if (!TextUtils.isEmpty(loginModel.getMessage())) {
                                Tools.toast(loginModel.getMessage());
                            } else {
                                Tools.toast("注册失败");
                            }
                            break;
                        default:
                            Tools.toast("注册失败");
                            break;
                    }
                }
            }
        });
    }

    @OnClick({R.id.iv_backup, R.id.tv_post_code, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            //获取验证码
            case R.id.tv_post_code:
                Tools.getVerifiedCode(etPhone.getText().toString());
                new MyTimer(60000, 1000, tvPostCode, "login").start();
                break;
            case R.id.btn_login:
                signUp();
                break;
            default:
                break;
        }
    }
}
