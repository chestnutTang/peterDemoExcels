package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;

/**
 * 从业资格考试报名
 */
public class QaRegisterActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ll_yyksrk)
    LinearLayout llYyksrk;
    @BindView(R.id.ll_qgtkrk)
    LinearLayout llQgtkrk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText(getResources().getString(R.string.txt_qualification_enroll));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_qa_register;
    }

    @OnClick({R.id.iv_backup, R.id.ll_yyksrk, R.id.ll_qgtkrk})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            case R.id.ll_yyksrk:
                break;
            case R.id.ll_qgtkrk:
                break;
        }
    }
}
