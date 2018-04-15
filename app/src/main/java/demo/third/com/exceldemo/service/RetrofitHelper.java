package demo.third.com.exceldemo.service;

import android.content.Context;
import android.util.Log;

import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import demo.third.com.exceldemo.BuildConfig;
import demo.third.com.exceldemo.service.entity.LoginEntity;
import demo.third.com.exceldemo.utils.Tools;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        RetrofitService retrofitService = mRetrofit.create(RetrofitService.class);
        Call<LoginEntity> call = retrofitService.loginSystem("北京");
        call.enqueue(new Callback<LoginEntity>() {
            @Override
            public void onResponse(Call<LoginEntity> call, Response<LoginEntity> response) {
                LoginEntity loginEntity = response.body();
                if (loginEntity!=null) {
                    Tools.toast(loginEntity.getData().getQuality());
                }
            }

            @Override
            public void onFailure(Call<LoginEntity> call, Throwable t) {
                Tools.toast("失败了" + t.toString());
                Log.e("song","失败"+t.toString());
            }
        });
    }

    public RetrofitService getServer() {
        return mRetrofit.create(RetrofitService.class);
    }

    public static SSLSocketFactory getSSLSocketFactory() throws Exception {
        //创建一个不验证证书链的证书信任管理器。
        final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] chain,
                    String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] chain,
                    String authType) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[0];
            }
        }};

        // Install the all-trusting trust manager
        final SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustAllCerts,
                new java.security.SecureRandom());
        // Create an ssl socket factory with our all-trusting manager
        return sslContext
                .getSocketFactory();
    }


    //使用自定义SSLSocketFactory
    private void onHttps(OkHttpClient.Builder builder) {
        try {
            builder.sslSocketFactory(getSSLSocketFactory()).hostnameVerifier(org.apache.http.conn
                    .ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
