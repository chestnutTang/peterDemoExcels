package demo.third.com.exceldemo.app;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;

import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import java.util.ArrayList;
import java.util.List;

import demo.third.com.exceldemo.BuildConfig;
import demo.third.com.exceldemo.utils.Logger;

/**
 * Created by peter on 2017/11/15.
 */

public class CustomApplication extends MultiDexApplication {

    private static CustomApplication instance;

    private List<Activity> activityList;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        activityList = new ArrayList<>();
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

    public void addActivity(Activity activity) {
        if (activity != null) {
            if (!activityList.contains(activity)) {
                activityList.add(activity);
            }
        }
    }

    public void removeAllActivity() {
        if (activityList != null && activityList.size() > 0) {
            for (Activity activity : activityList) {
//                activityList.remove(activity);
                activity.finish();
            }
            activityList.clear();
        }
    }
}
