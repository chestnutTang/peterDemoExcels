package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;

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

    @OnClick(R.id.iv_backup)
    public void onViewClicked() {
        finish();
    }
}
