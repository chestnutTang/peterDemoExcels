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

    /**
     * @param context
     * @param dpValue
     * @return 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dipTopx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static float dipTopx2(Context context, int dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int pxTodip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

}
