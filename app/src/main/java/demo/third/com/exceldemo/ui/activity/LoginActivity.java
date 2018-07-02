package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.OkHttpRequest;
import com.zhy.http.okhttp.request.OtherRequest;

import org.json.JSONObject;

import butterknife.BindView;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.service.entity.LoginEntity;
import demo.third.com.exceldemo.service.entity.LoginModel;
import demo.third.com.exceldemo.service.presenter.LoginPresenter;
import demo.third.com.exceldemo.service.view.LoginView;
import demo.third.com.exceldemo.ui.views.OkRequestParams;
import demo.third.com.exceldemo.utils.CustomGson;
import demo.third.com.exceldemo.utils.JumpTools;
import demo.third.com.exceldemo.utils.Link;
import demo.third.com.exceldemo.utils.Logger;
import demo.third.com.exceldemo.utils.MyTimer;
import demo.third.com.exceldemo.utils.PreferenceHelper;
import demo.third.com.exceldemo.utils.Tools;
import okhttp3.Call;

/**
 * 登陆页面
 *
 * @author peter
 */
public class LoginActivity extends BaseActivity {


    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    //    @BindView(R.id.login_progress)
//    ProgressBar loginProgress;
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
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_protol)
    TextView tvProtol;
    @BindView(R.id.tv_register)
    TextView tvRegister;

    public static LinearLayout lin_login_root;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_verification_code)
    RelativeLayout rlVerificationCode;
    @BindView(R.id.tv_login_pass)
    TextView tvLoginPass;
    @BindView(R.id.lin_login_root)
    LinearLayout linLoginRoot;

    private LoginModel loginModel;

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
            Logger.e("song", "错误的信息" + result);
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
        lin_login_root = (LinearLayout) findViewById(R.id.lin_login_root);
    }

    @Override
    protected void bindListener() {
        super.bindListener();
        btnLogin.setOnClickListener(this);
        tvPostCode.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        tvLoginPass.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    private void getVerifiedCode() {
        OkHttpUtils.post().url(Link.SEND).addParams("phoneNumber", etPhone.getText().toString())
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Logger.e("song", response);
            }
        });
    }

    /**
     * 登录
     */
    private void signIn() {
        OkRequestParams params = new OkRequestParams();
        String phoneNumber = etPhone.getText().toString();
        String verifyCode = etVerificationCode.getText().toString();
        if (!TextUtils.isEmpty(phoneNumber)) {
            params.put("phoneNumber", phoneNumber);
        } else {
            Tools.toast("请输入手机号");
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
                    PreferenceHelper.getInstance().setId(loginModel.getResult().getAccountInfo().getId());
                    switch (loginModel.getCode()) {
                        //成功
                        case 0:
                            JumpTools.jumpOnly(LoginActivity.this, MainActivity.class);
                            break;
                        //失败
                        case 101:
                            if (!TextUtils.isEmpty(loginModel.getMessage())) {
                                Tools.toast(loginModel.getMessage());
                            } else {
                                Tools.toast("登录失败");
                            }
                            break;
                        default:
                            Tools.toast("登录失败");
                            break;
                    }
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            //登录
            case R.id.btn_login:
//                if (!TextUtils.isEmpty(etPhone.getText().toString()) && !TextUtils.isEmpty
//                        (etVerificationCode.getText().toString())) {
//                    loginPresenter.loginSystem(etPhone.getText().toString(), etVerificationCode.getText().toString());
//                } else {
//                    loginPresenter.postFeedback("不太好用");
//                    Tools.toast("补充信息");
//                }
                signIn();
                break;
            //发送验证码
            case R.id.tv_post_code:
//                JumpTools.JumpToOtherApp(this);
                getVerifiedCode();
                new MyTimer(60000, 1000, tvPostCode, "login").start();
//                JumpTools.jumpWithUrl(this, MyWebActivity.class, "http://gs.amac.org.cn/amac-infodisc/res/pof/fund/351000133588.html");
                break;
            //注册
            case R.id.tv_register:
                JumpTools.jumpOnly(this, RegisterActivity.class);
                break;
            //密码登录
            case R.id.tv_login_pass:
                Tools.toast("密码登录");
                break;
            default:
                break;
        }
    }

}

