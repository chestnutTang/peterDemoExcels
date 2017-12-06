package demo.third.com.exceldemo.app;

import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import demo.third.com.exceldemo.BuildConfig;

/**
 * Created by peter on 2017/11/15.
 */

public class CustomApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), BuildConfig.BUGLYID, true);
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.e("song", "deviceToken--->" + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });
    }
}
