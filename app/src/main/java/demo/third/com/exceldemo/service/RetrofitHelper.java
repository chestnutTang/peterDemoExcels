package demo.third.com.exceldemo.service;

import android.content.Context;

import demo.third.com.exceldemo.BuildConfig;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static demo.third.com.exceldemo.service.manager.DataManager.genericClient;

/**
 * peterDemoExcels
 * Created by peter
 * on 2017.12
 */

public class RetrofitHelper {
    private Context mCntext;

    OkHttpClient client = genericClient();
    GsonConverterFactory factory = GsonConverterFactory.create();

    private static RetrofitHelper instance = null;
    private Retrofit mRetrofit = null;

    public static RetrofitHelper getInstance(Context context, String url) {
        if (instance == null) {
            instance = new RetrofitHelper(context, url);
        }
        return instance;
    }

    public RetrofitHelper(Context context, String url) {
        mCntext = context;
        init(url);
    }

    private void init(String url) {
        resetApp(url);
    }

    private void resetApp(String url) {
        mRetrofit = new Retrofit.Builder().baseUrl(url)
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public RetrofitService getServer() {
        return mRetrofit.create(RetrofitService.class);
    }
}
