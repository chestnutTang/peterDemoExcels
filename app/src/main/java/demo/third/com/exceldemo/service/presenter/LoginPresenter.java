package demo.third.com.exceldemo.service.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import demo.third.com.exceldemo.BuildConfig;
import demo.third.com.exceldemo.app.CustomApplication;
import demo.third.com.exceldemo.service.RetrofitHelper;
import demo.third.com.exceldemo.service.RetrofitService;
import demo.third.com.exceldemo.service.entity.LoginEntity;
import demo.third.com.exceldemo.service.manager.DataManager;
import demo.third.com.exceldemo.service.view.LoginView;
import demo.third.com.exceldemo.service.view.View;
import demo.third.com.exceldemo.utils.Logger;
import demo.third.com.exceldemo.utils.SystemTools;
import demo.third.com.exceldemo.utils.Tools;
import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

import static demo.third.com.exceldemo.utils.Link.HOST3;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.03.27
 *
 * @author peter
 */

public class LoginPresenter implements Presenter {

    private Context mContext;
    private CompositeSubscription mCompositeSubscription;
    private DataManager manager;
    private LoginEntity loginEntity;
    private LoginView loginView;

    public LoginPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate() {
//        manager = new DataManager(mContext, BuildConfig.HOST2);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(View view) {
        loginView = (LoginView) view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void loginSystem(String phone, String code) {
        RetrofitHelper.getInstance(mContext).baseUrl(BuildConfig.HOST2)
                .loginSystem("青岛")
                .enqueue(new Callback<LoginEntity>() {
                    @Override
                    public void onResponse(Call<LoginEntity> call, Response<LoginEntity> response) {
                        LoginEntity loginEntity = response.body();
                        Headers headers = response.headers();
                        Logger.e("song2", headers.toString());
                        Tools.toast(headers.toString());
                        Tools.toast(loginEntity.getData().getShidu());
                    }

                    @Override
                    public void onFailure(Call<LoginEntity> call, Throwable t) {

                    }
                });
    }

    public void postFeedback(String content) {
        Map<String, String> map = new HashMap<>();
        map.put("uid", "125822");
        map.put("content", content);
        map.put("clientType", "2");
        map.put("appVersion", SystemTools.getVersionName(CustomApplication.getInstance()
                .getApplicationContext()));
        // 手机厂商
        String phoneManufacturer = android.os.Build.MANUFACTURER;
        // 手机型号
        String phoneModel = android.os.Build.MODEL;
        // 系统版本
        String systemVersion = android.os.Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(phoneManufacturer)) {
            map.put("phoneFirm", phoneManufacturer);
        }
        if (!TextUtils.isEmpty(phoneModel)) {
            map.put("phoneVersion", phoneModel);
        }
        if (!TextUtils.isEmpty(systemVersion)) {
            map.put("phoneSystemVersion", systemVersion);
        }


        RetrofitHelper.getInstance(mContext).baseUrl(HOST3)
//        RetrofitHelper.getInstance(mContext).baseUrl(BuildConfig.HOST3)
                .postFeedback(map).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Logger.e("song", "意见反馈-->" + response.body().string());
                    Logger.e("song", "意见反馈-->" + response.headers());
//                    Tools.toast(response.headers().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
