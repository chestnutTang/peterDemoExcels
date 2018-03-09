package demo.third.com.exceldemo.app;

import android.support.multidex.MultiDexApplication;

import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import demo.third.com.exceldemo.BuildConfig;
import demo.third.com.exceldemo.utils.Logger;

/**
 * Created by peter on 2017/11/15.
 */

public class CustomApplication extends MultiDexApplication {

    private static CustomApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
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

    public static CustomApplication getInstance() {
        return instance;
    }
}
