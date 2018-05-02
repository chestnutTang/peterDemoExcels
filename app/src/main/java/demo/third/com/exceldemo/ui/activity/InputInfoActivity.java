package demo.third.com.exceldemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;

import static demo.third.com.exceldemo.utils.Constant.INPUT_CONTENT;
import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;

/**
 * @author songzhengpeng
 * 输入个人信息相关的类
 */
public class InputInfoActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_jump)
    TextView tvJump;
    @BindView(R.id.et_info)
    EditText etInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_input_info;
    }

    @Override
    protected void initView() {
        super.initView();
        tvJump.setText("完成");
        String flag = getIntent().getStringExtra(INTENT_FLAG);
        if (!TextUtils.isEmpty(flag)) {
            switch (flag) {
                case "nick":
                    tvTitle.setText(getString(R.string.txt_nick_name));
                    etInfo.setHint(getString(R.string.tip_nick_name));
                    break;
                case "name":
                    tvTitle.setText(getString(R.string.txt_name));
                    etInfo.setHint(getString(R.string.tip_name));
                    break;
                case "age":
                    tvTitle.setText(getString(R.string.txt_age));
                    etInfo.setHint(getString(R.string.tip_age));
                    break;
                case "profession":
                    tvTitle.setText(getString(R.string.txt_profession));
                    etInfo.setHint(getString(R.string.tip_profession));
                    break;
                case "email":
                    tvTitle.setText(getString(R.string.txt_email));
                    etInfo.setHint(getString(R.string.tip_email));
                    break;
                default:
                    break;
            }
        }
    }

    @OnClick({R.id.iv_backup, R.id.tv_jump})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            case R.id.tv_jump:
                intent.putExtra(INPUT_CONTENT, etInfo.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
                break;
            default:
                break;
        }
    }
}
