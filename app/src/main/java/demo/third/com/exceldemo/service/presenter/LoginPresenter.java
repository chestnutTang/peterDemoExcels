package demo.third.com.exceldemo.service.presenter;

import android.content.Context;
import android.content.Intent;

import demo.third.com.exceldemo.BuildConfig;
import demo.third.com.exceldemo.service.entity.LoginEntity;
import demo.third.com.exceldemo.service.manager.DataManager;
import demo.third.com.exceldemo.service.view.LoginView;
import demo.third.com.exceldemo.service.view.View;
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
        manager = new DataManager(mContext, BuildConfig.HOST2);
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
        mCompositeSubscription.add(manager.loginSystem(phone, code)
                .subscribeOn(rx.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginEntity>() {
                    @Override
                    public void onCompleted() {
                        if (loginEntity != null) {
                            loginView.onSuccess(loginEntity);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        loginView.onError("请求失败!!!!!!");
                    }

                    @Override
                    public void onNext(LoginEntity mloginEntity) {
                        loginEntity = mloginEntity;
                    }
                }));
    }
}
