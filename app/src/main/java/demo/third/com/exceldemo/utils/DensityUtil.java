package demo.third.com.exceldemo.utils;

import android.content.Context;
import android.view.WindowManager;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.04.13
 */
public class DensityUtil {
    /**
     * @param context
     * @return 获取手机屏幕宽度
     */
    @SuppressWarnings("deprecation")
    public static int getScreenWidthSize(Context context) {
        WindowManager window = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        int width = window.getDefaultDisplay().getWidth();
        return width;
    }

    /**
     * @param context
     * @return 获取手机屏幕高度
     */
    @SuppressWarnings("deprecation")
    public static int getScreenHeightSize(Context context) {
        WindowManager window = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        int height = window.getDefaultDisplay().getHeight();
        return height;
    }
}
