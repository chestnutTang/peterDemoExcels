package demo.third.com.exceldemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.utils.Constant;
import demo.third.com.exceldemo.utils.JumpTools;

import static demo.third.com.exceldemo.utils.Constant.INPUT_CONTENT;

/**
 * @author songzhengpeng
 * 个人信息页面
 */
public class MyInfoActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_jump)
    TextView tvJump;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.rel_head)
    RelativeLayout relHead;
    @BindView(R.id.tv_nick_name)
    TextView tvNickName;
    @BindView(R.id.rel_nick_name)
    RelativeLayout relNickName;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.rel_name)
    RelativeLayout relName;
    @BindView(R.id.tv_age)
    TextView tvAge;
    @BindView(R.id.rel_age)
    RelativeLayout relAge;
    @BindView(R.id.tv_profession)
    TextView tvProfession;
    @BindView(R.id.rel_profession)
    RelativeLayout relProfession;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.rel_email)
    RelativeLayout relEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine;
    }

    @OnClick({R.id.iv_backup, R.id.tv_jump, R.id.rel_head, R.id.rel_nick_name, R.id.rel_name, R.id.rel_age, R.id.rel_profession, R.id.rel_email})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            case R.id.tv_jump:
                break;
            case R.id.rel_head:
                break;
            case R.id.rel_nick_name:
                JumpTools.jumpWithRequestCodeAndFlag(MyInfoActivity.this, InputInfoActivity.class, Constant.REQUEST_100, "nick");
                break;
            case R.id.rel_name:
                JumpTools.jumpWithRequestCodeAndFlag(MyInfoActivity.this, InputInfoActivity.class, Constant.REQUEST_101, "name");
                break;
            case R.id.rel_age:
                JumpTools.jumpWithRequestCodeAndFlag(MyInfoActivity.this, InputInfoActivity.class, Constant.REQUEST_102, "age");
                break;
            case R.id.rel_profession:
                JumpTools.jumpWithRequestCodeAndFlag(MyInfoActivity.this, InputInfoActivity.class, Constant.REQUEST_103, "profession");
                break;
            case R.id.rel_email:
                JumpTools.jumpWithRequestCodeAndFlag(MyInfoActivity.this, InputInfoActivity.class, Constant.REQUEST_104, "email");
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String content = data.getStringExtra(INPUT_CONTENT);
            if (!TextUtils.isEmpty(content)) {
                switch (requestCode) {
                    case Constant.REQUEST_100:
                        tvNickName.setText(content);
                        break;
                    case Constant.REQUEST_101:
                        tvName.setText(content);
                        break;
                    case Constant.REQUEST_102:
                        tvAge.setText(content);
                        break;
                    case Constant.REQUEST_103:
                        tvProfession.setText(content);
                        break;
                    case Constant.REQUEST_104:
                        tvEmail.setText(content);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
