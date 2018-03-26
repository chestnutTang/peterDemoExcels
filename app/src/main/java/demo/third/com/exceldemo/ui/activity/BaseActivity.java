package demo.third.com.exceldemo.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import demo.third.com.exceldemo.app.CustomApplication;

/**
 * Created by peter on 2017/11/23.
 * good choice
 */

public abstract class BaseActivity extends AppCompatActivity {

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

}
