package demo.third.com.exceldemo.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.app.CustomApplication;
import demo.third.com.exceldemo.service.entity.LoginModel;
import demo.third.com.exceldemo.ui.activity.LoginActivity;
import demo.third.com.exceldemo.ui.views.DateChooseBirthdayView;
import okhttp3.Call;

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

    /**
     * 创建指定大小的包含文字的图片，背景为透明
     *
     * @param width    图片宽度
     * @param height   图片高度
     * @param txtSize  文字字号
     * @param innerTxt 内容文字
     * @return
     */
    public static Bitmap createTextImage(int width, int height, int txtSize, String innerTxt) {
        //若使背景为透明，必须设置为Bitmap.Config.ARGB_4444
        Bitmap bm = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(bm);

        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setTextSize(txtSize);

        //计算得出文字的绘制起始x、y坐标
        int posX = width / 2 - txtSize * innerTxt.length() / 2;
        int posY = height / 2 - txtSize / 2;

        canvas.drawText(innerTxt, posX, posY, paint);

        return bm;
    }

    public static Bitmap getScreenShotBitmap(ViewGroup view) {
        Bitmap bitmap = Bitmap.createBitmap(
                view.getChildAt(0).getWidth(),
                view.getChildAt(0).getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bitmap);
        view.getChildAt(0).draw(c);
        return bitmap;
    }


    public static void showDateChoice(Context context, final TextView textView) {
        DateChooseBirthdayView dateChooseView = DateChooseBirthdayView.create(context, 80, 0, 60);
        if (dateChooseView != null && dateChooseView.getParent() != null) {
            ((ViewGroup) dateChooseView.getParent()).removeView(dateChooseView);
        }
        final Dialog dialog = new Dialog(context, R.style.transparentFrameWindowStyle);
        dialog.setContentView(dateChooseView, new WindowManager.LayoutParams(WindowManager
                .LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT));
        Window window = dialog.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        // 设置显示动画
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.x = 0;
        wl.y = ((Activity) context).getWindowManager().getDefaultDisplay().getHeight();
        // 以下这两句是为了保证按钮可以水平满屏
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = DensityUtil.dipTopx(context, 300);
        // 设置显示样式
        window.setAttributes(wl);
        dateChooseView.setTimeChooseCallback(new DateChooseBirthdayView.TimeChooseCallback() {
            @Override
            public void onDismiss() {
                dialog.cancel();
            }

            @Override
            public void onDetermine(String y, String m, String d) {
                String date = y + "-" + m + "-" + d;
                Log.d("wfc", "date " + date);
                Calendar c = Calendar.getInstance();
                int nowYear = c.get(Calendar.YEAR);
                Log.e("song", "yearNow" + nowYear);
                textView.setText(date);
//                if (nowYear - (Integer.parseInt(y)) > 15) {
//
//                    textView.setText(date);
////                    birth = date;
//                } else {
//                    toast("请选择正确的出生年月");
//                    textView.setText("请选择正确的出生年月");
//                }
                dialog.cancel();
            }
        });
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    public static String getVerifiedCode(String phoneNumber) {
        OkHttpUtils.post().url(Link.SEND).addParams("phoneNumber", phoneNumber)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Logger.e("song", response);
            }
        });
        return "000000";
    }

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     * @param format  日期格式
     * @return
     */
    public static String timeStamp2Date(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds)));
    }

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param date_str 字符串日期
     * @return
     */
    public static String date2TimeStamp(String date_str) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return String.valueOf(sdf.parse(date_str).getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 取得当前时间戳（精确到秒）
     *
     * @return
     */
    public static String timeStamp() {
        long time = System.currentTimeMillis();
        String t = String.valueOf(time / 1000);
        return t;
    }

    public static void showOrHideSoftWare(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context
                .INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public static void forceHideSoftWare(Context context, EditText view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context
                .INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //强制隐藏键盘
    }

    /**
     * 判断是否已经登录
     *
     * @return
     */
    public static boolean isOnline() {
        String token = PreferenceHelper.getInstance().getToken();
        if (!TextUtils.isEmpty(token)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param loginModel 保存用户个人信息
     */
    public static void saveUserInfo(LoginModel loginModel) {
        if (loginModel != null) {
            if (loginModel.getResult() != null) {
                PreferenceHelper.getInstance().setToken(loginModel.getResult().getToken());
                if (loginModel.getResult().getAccountInfo() != null) {
                    PreferenceHelper.getInstance().setId(loginModel.getResult().getAccountInfo()
                            .getId());
                    PreferenceHelper.getInstance().setnickName(loginModel.getResult()
                            .getAccountInfo().getNickName());
                    PreferenceHelper.getInstance().setage(loginModel.getResult().getAccountInfo()
                            .getAge());
                    PreferenceHelper.getInstance().setrealName(loginModel.getResult()
                            .getAccountInfo().getRealName());
                    PreferenceHelper.getInstance().setemail(loginModel.getResult().getAccountInfo
                            ().getEmail());
                    PreferenceHelper.getInstance().setoccupation(loginModel.getResult()
                            .getAccountInfo().getOccupation());
                    PreferenceHelper.getInstance().setcity(loginModel.getResult().getAccountInfo
                            ().getCity());
                    PreferenceHelper.getInstance().setprofileImg(loginModel.getResult()
                            .getAccountInfo().getProfileImg());
                    PreferenceHelper.getInstance().setprofileUrl(loginModel.getResult()
                            .getAccountInfo().getProfileImgUrl());
                    PreferenceHelper.getInstance().setphoneNumber(loginModel.getResult()
                            .getAccountInfo().getPhoneNumber());
                    PreferenceHelper.getInstance().setpassword(loginModel.getResult()
                            .getAccountInfo().getPassword());
                }

            }
        }
    }

    /**
     * @param output
     * @return 把二级制图片转成bitmap
     */
    public static Bitmap convertStringToIcon(String output) {
        Bitmap bitmap;
        try {
            byte[] bitmapArray;
            bitmapArray = Base64.decode(output, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0,
                    bitmapArray.length);
            return bitmap;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param str
     * @return 判断字符串是否为纯数字
     */
    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取一个月前的日期
     *
     * @param date 传入的日期
     * @return
     */
    public static String getMonthAgo(Date date, int count) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -count);
        String monthAgo = simpleDateFormat.format(calendar.getTime());
        return monthAgo;
    }

    /**
     * @param listView
     * @return 获取listview的高度，但是要求item的跟布局是LinearLayout
     */
    public static int getTotalHeightofListView(ListView listView) {
        ListAdapter mAdapter = listView.getAdapter();
        if (mAdapter == null) {
            return 0;
        }
        int totalHeight = 0;
        for (int i = 0; i < mAdapter.getCount(); i++) {
            View mView = mAdapter.getView(i, null, listView);
            mView.measure(
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            totalHeight += mView.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (mAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
        return totalHeight;
    }

    /**
     * @param url                下载路径
     * @param contentDisposition header
     * @param mimetype           文件后缀
     * @return 获取当前下载文件的名字
     */
    public static String getDownFileName(String url, String contentDisposition, String mimetype) {
        String fileName;
        if (!TextUtils.isEmpty(contentDisposition) && contentDisposition.length() > 0) {
            if (contentDisposition.contains(";")) {
                String[] content = contentDisposition.split(";");
                if (content.length > 0) {
                    String ready = content[content.length - 1];
                    if (!TextUtils.isEmpty(ready) && ready.contains(" filename=")) {
                        fileName = ready.replace(" filename=", "");
                        if (!TextUtils.isEmpty(fileName) && fileName.length() > 0) {
                            fileName = fileName.substring(1, fileName.length() - 1);
                        } else {
                            fileName = URLUtil.guessFileName(url, contentDisposition, mimetype);
                        }
                    } else {
                        fileName = URLUtil.guessFileName(url, contentDisposition, mimetype);
                    }
                } else {
                    fileName = URLUtil.guessFileName(url, contentDisposition, mimetype);
                }
            } else {
                fileName = URLUtil.guessFileName(url, contentDisposition, mimetype);
            }
        } else {
            fileName = URLUtil.guessFileName(url, contentDisposition, mimetype);
        }
        return fileName;
    }
}
