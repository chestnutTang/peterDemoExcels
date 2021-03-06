package demo.third.com.exceldemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import demo.third.com.exceldemo.app.CustomApplication;

/**
 *
 * @author peter
 * @date 2017/11/23
 * good choice
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        CustomApplication.getInstance().addActivity(this);
    }

    /**
     * @return 获取布局文件的resID
     */
    protected abstract int getLayoutId();

    /**
     * 绑定控件
     */
    protected void bindView() {
    }

    protected void bindListener() {
    }

    @Override
    public void onClick(View v) {

    }
}
