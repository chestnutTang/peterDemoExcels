package demo.third.com.exceldemo.service.presenter;

import android.content.Context;
import android.content.Intent;

import demo.third.com.exceldemo.BuildConfig;
import demo.third.com.exceldemo.service.RetrofitHelper;
import demo.third.com.exceldemo.service.RetrofitService;
import demo.third.com.exceldemo.service.entity.LoginEntity;
import demo.third.com.exceldemo.service.manager.DataManager;
import demo.third.com.exceldemo.service.view.LoginView;
import demo.third.com.exceldemo.service.view.View;
import demo.third.com.exceldemo.utils.Tools;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.03.27
 *
 * @author songzhengpeng
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
        RetrofitHelper.getInstance(mContext).init(BuildConfig.HOST2)
                .loginSystem("青岛")
                .enqueue(new Callback<LoginEntity>() {
                    @Override
                    public void onResponse(Call<LoginEntity> call, Response<LoginEntity> response) {
                        LoginEntity loginEntity = response.body();
                        if (loginEntity != null) {
                            try {
                                Tools.toast(loginEntity.getData().getShidu());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginEntity> call, Throwable t) {

                    }
                });
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

    }
}
