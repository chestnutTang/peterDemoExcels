package demo.third.com.exceldemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * peterDemoExcels
 * Created by peter
 * on 2018.03
 * Intent 显示跳转工具里
 */

public class JumpTools {

    /**
     * @param context
     * @param activity
     * 不带参数的跳转
     */
    public static void jumpOnly(Context context, Class<?> activity) {
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }
}
