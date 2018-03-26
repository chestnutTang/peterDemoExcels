package demo.third.com.exceldemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

/**
 * peterDemoExcels
 * Created by peter
 * on 2018.03
 * Intent 显示跳转工具里
 */

public class JumpTools {

    /**
     * @param context
     * @param activity 不带参数的跳转
     */
    public static void jumpOnly(Context context, Class<?> activity) {
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }

    public static void JumpToOtherApp(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent = packageManager.getLaunchIntentForPackage("com.android.icredit");
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.qichacha.com/"));
            context.startActivity(viewIntent);
        }
    }
}
