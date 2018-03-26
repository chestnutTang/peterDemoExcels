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

/**
 * 登陆页面
 *
 * @author peter
 */
public class LoginActivity extends BaseActivity {


    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.login_progress)
    ProgressBar loginProgress;
    @BindView(R.id.image_phone)
    ImageView imagePhone;
    @BindView(R.id.edit_login_number)
    EditText editLoginNumber;
    @BindView(R.id.iv_phone_clear)
    RelativeLayout ivPhoneClear;
    @BindView(R.id.lin_phonenumber_layout)
    RelativeLayout linPhonenumberLayout;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.btn_post_code1)
    TextView btnPostCode1;
    @BindView(R.id.lin_password_layout)
    RelativeLayout linPasswordLayout;
    @BindView(R.id.btn_login_in)
    Button btnLoginIn;
    @BindView(R.id.txt_protol)
    TextView txtProtol;
    @BindView(R.id.txt_connect_us)
    TextView txtConnectUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView();
    }

    @Override
    protected void bindView() {
        super.bindView();
        ivBackup.setVisibility(View.GONE);
        ivShare.setVisibility(View.GONE);
        tvTitle.setText(getResources().getText(R.string.login_btn));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

}

