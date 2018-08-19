package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.utils.JumpTools;

/**
 * @author peter
 * 联系我们
 */
public class ContactUsActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_telephone)
    TextView tvTelephone;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.tv_address)
    TextView tvAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvTitle.setText(getResources().getString(R.string.tip_contract_us));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_contact_us;
    }

    @OnClick({R.id.iv_backup, R.id.tv_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            case R.id.tv_address:
//                JumpTools.jumpOnly(this, MapActivity.class);
                break;
            default:
                break;
        }
    }
}
