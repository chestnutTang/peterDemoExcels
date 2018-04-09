package demo.third.com.exceldemo.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.04.09
 */
public class SystemTools {
    /**
     * @param context 获取versionName
     * @return
     */
    public static String getVersionName(Context context)//获取·
    {
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(),
                    0);
            return pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "1.0.0";
        }
    }

}
