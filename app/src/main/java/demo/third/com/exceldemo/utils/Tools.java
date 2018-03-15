package demo.third.com.exceldemo.utils;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.app.CustomApplication;
import demo.third.com.exceldemo.ui.activity.LoginActivity;

/**
 * peterDemoExcels
 * Created by peter
 * on 2018.03
 * 工具类
 */

public class Tools {

    //上一次点击的时间
    private static long lastClickTime;

    /**
     * 判断是否是点击过快，或者双击行为
     *
     * @return
     */
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 400) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    public static void logoutSystem(Context context) {
        if ((System.currentTimeMillis() - lastClickTime) > 2000) {
            toast("再按一次退出" + context.getResources().getString(R.string.app_name));
            // 记录用户首次点击的时间
            lastClickTime = System.currentTimeMillis();
        } else {
            //相当于点击home键
//            Intent home = new Intent(Intent.ACTION_MAIN);
//            home.addCategory(Intent.CATEGORY_HOME);
//            context.startActivity(home);
            //关闭所有Activity，退出系统
            CustomApplication.getInstance().removeAllActivity();

        }
    }

    /**
     * 系统自带吐司
     *
     * @param toastStr
     */
    public static void toast(String toastStr) {
        Toast.makeText(CustomApplication.getInstance(), toastStr, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param view
     * @param tipStr
     * @param rightStr 类似微信用的从底部弹出的提示框
     */
    public static void snackBar(final View view, String tipStr, final String rightStr) {
        Snackbar.make(view, tipStr, Snackbar.LENGTH_SHORT).setAction(rightStr, new View
                .OnClickListener() {
            @Override
            public void onClick(View v) {
                toast(rightStr);
                startIntent(view.getContext(), LoginActivity.class);
            }
        }).show();
    }

    /**
     * @param context
     * @param targetActivity 跳转目标类
     */
    public static void startIntent(Context context, Class<?> targetActivity) {
        Intent intent = new Intent(context, targetActivity);
        context.startActivity(intent);
    }
}
