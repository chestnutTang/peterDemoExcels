package demo.third.com.exceldemo.service;

import android.content.Context;

import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

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
//        SSLSocketFactory sslSocketFactory = new SslContextFactory().getSslSocket(context).getSocketFactory();
//        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder().sslSocketFactory(sslSocketFactory);


        mRetrofit = new Retrofit.Builder().baseUrl(url)
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
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
            builder.sslSocketFactory(getSSLSocketFactory()).hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
