package demo.third.com.exceldemo.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Method;

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

    /**
     * @param context 判断当前网络是否有代理
     * @return
     */
    public static boolean isWifiProxy(Context context) {

        final boolean IS_ICS_OR_LATER = Build.VERSION.SDK_INT >= Build.VERSION_CODES
                .ICE_CREAM_SANDWICH;
        String proxyAddress;
        int proxyPort;
        if (IS_ICS_OR_LATER) {
            proxyAddress = System.getProperty("http.proxyHost");
            String portStr = System.getProperty("http.proxyPort");
            proxyPort = Integer.parseInt((portStr != null ? portStr : "-1"));
        } else {
            proxyAddress = android.net.Proxy.getHost(context);
            proxyPort = android.net.Proxy.getPort(context);
        }
        return (!TextUtils.isEmpty(proxyAddress)) && (proxyPort != -1);
    }


    /**
     * 是否是华为
     */
    public static boolean isHUAWEI() {
        return android.os.Build.MANUFACTURER.equals("HUAWEI");
    }

    /**
     * @param context
     * @return 获取是否存在NavigationBar
     */
    public static boolean checkDeviceHasNavigationBar(Context context) {
        boolean hasNavigationBar = false;
        try {
            Resources rs = context.getResources();
            int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
            if (id > 0) {
                hasNavigationBar = rs.getBoolean(id);
            }
            Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
            Method m = systemPropertiesClass.getMethod("get", String.class);
            String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
            if ("1".equals(navBarOverride)) {
                hasNavigationBar = false;
            } else if ("0".equals(navBarOverride)) {
                hasNavigationBar = true;
            }
        } catch (Exception e) {

        }
        return hasNavigationBar;
    }

    public static String encryptToStringNew(int seed, String str) {
        int[] strInt = new int[str.getBytes().length];
        byte[] strBytes = str.getBytes();
        for (int i = 0; i < strBytes.length; i++) {
            strInt[i] = (int) strBytes[i];
        }

        int[] intArray = MakeValuedHashV1(seed, strInt);
        String result = "";
        for (int i = 0; i < intArray.length; i++) {
            result += "," + intArray[i];
        }
        String show = result.substring(1, result.length());

        return show;
    }

    private static int[] MakeValuedHashV1(int seed, int[] src) {
        int[] bytes = src;
        src = null;
        int len = bytes.length;
        int li = 0;
        int ri = len - 1;
        int mask = 0;
        while (true) {
            if (mask + bytes[li] > 2147483647) {
                mask = mask % 13;
            } else {
                mask += bytes[li];
            }
            bytes[li] &= 2147483647;
            bytes[li] ^= seed;
            if (ri > 0) {
                if (li < ri) {
                    bytes[li] ^= bytes[ri];
                } else if (li == ri) {
                    bytes[li] ^= (bytes[len - 1] | seed) ^ len;
                } else {
                    bytes[li] ^= bytes[li + 1];
                }
                ri--;
                li++;
            } else if (ri == 0) {
                bytes[li] ^= len;
                break;
            }
        }
        int mi = len / 2;
        len++;
        int[] fallback = new int[len];
        System.arraycopy(bytes, 0, fallback, 0, mi);
        fallback[mi] = mask;
        System.arraycopy(bytes, mi, fallback, mi + 1, len - mi - 1);
        return fallback;
    }

    public static int getSeedAll(int a) {
        return (2 * a + 1);
    }

    public static int getSeedAll1() {
        return (2 * EncryptPassUtils2.getPassWord() - EncryptPassUtils.getPassWord());
    }

    /*** @return 获取uuid并转成小写
     */

    public static String getUUID() {
        String uuid;
        uuid = java.util.UUID.randomUUID().toString().toLowerCase();
        Log.e("song", "UUID:-->" + uuid);
        return uuid;
    }
}
