package demo.third.com.exceldemo.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.socialize.PlatformConfig;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import demo.third.com.exceldemo.BuildConfig;
import demo.third.com.exceldemo.utils.Logger;

/**
 *
 * @author peter
 * @date 2017/11/15
 */

public class CustomApplication extends MultiDexApplication {

    private static CustomApplication instance;

    private List<Activity> activityList;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        activityList = new ArrayList<>();
//        handleSSLHandshake();
        UMConfigure.init(this, "5a12384aa40fa3551f0001d1", "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "https://sns.whalecloud.com/sina2/callback");
        CrashReport.initCrashReport(getApplicationContext(), BuildConfig.BUGLYID, true);
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Logger.e("song", "deviceToken--->" + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });
    }

    /**
     * @param base MultiDex，拆包必须重写的方法
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    /**
     * 获取application实例
     *
     * @return
     */
    public static CustomApplication getInstance() {
        return instance;
    }

    /**
     * @param activity 添加到activity栈里
     */
    public void addActivity(Activity activity) {
        if (activity != null) {
            if (!activityList.contains(activity)) {
                activityList.add(activity);
            }
        }
    }

    /**
     * 销毁所有activity
     */
    public void removeAllActivity() {
        if (activityList != null && activityList.size() > 0) {
            for (Activity activity : activityList) {
//                activityList.remove(activity);
                activity.finish();
            }
            activityList.clear();
        }
    }

    @SuppressLint("TrulyRandom")
    public static void handleSSLHandshake() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }};

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        } catch (Exception ignored) {
        }
    }
}
