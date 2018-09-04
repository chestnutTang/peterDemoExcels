package demo.third.com.exceldemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import static demo.third.com.exceldemo.utils.Constant.INTENT_FLAG;

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

    /**
     * @param context
     * @param activity
     * @param requestCode 请求参数
     */
    public static void jumpWithRequestCode(Context context, Class<?> activity, int requestCode) {
        Intent intent = new Intent(context, activity);
        ((Activity) context).startActivityForResult(intent, requestCode);
    }

    public static void jumpWithdFlag(Context context, Class<?> activity, String flag) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(INTENT_FLAG, flag);
        ((Activity) context).startActivity(intent);
    }

    public static void jumpWithdFlag(Context context, Class<?> activity, String flag,String title) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(INTENT_FLAG, flag);
        intent.putExtra("title", title);
        ((Activity) context).startActivity(intent);
    }

    public static void jumpWithRequestCodeAndFlag(Context context, Class<?> activity, int requestCode, String flag) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(INTENT_FLAG, flag);
        ((Activity) context).startActivityForResult(intent, requestCode);
    }

    public static void JumpToOtherApp(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = packageManager.getLaunchIntentForPackage("com.android.icredit");
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://www" +
                    ".qichacha.com/"));
            context.startActivity(viewIntent);
        }
    }

    /**
     * @param context  上线文
     * @param activity 目标
     * @param url      路径
     */
    public static void jumpWithUrl(Context context, Class<?> activity, String url) {
        Intent intent = new Intent(context, activity);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    public static void jumpWithUrl(Context context, Class<?> activity, String url, String title) {
        Intent intent = new Intent(context, activity);
        intent.putExtra("url", url);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }
}
