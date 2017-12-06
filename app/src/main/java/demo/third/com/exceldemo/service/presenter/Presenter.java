package demo.third.com.exceldemo.service.presenter;

import android.content.Intent;

import demo.third.com.exceldemo.service.view.View;

/**
 * peterDemoExcels
 * Created by peter
 * on 2017.12
 */

public interface Presenter {
    void onCreate();

    void onStart();//暂时没用到

    void onStop();

    void pause();//暂时没用到

    void attachView(View view);

    void attachIncomingIntent(Intent intent);//暂时没用到

}
