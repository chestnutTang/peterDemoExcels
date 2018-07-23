package demo.third.com.exceldemo.service;

import android.content.Context;

import com.google.gson.GsonBuilder;

import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static demo.third.com.exceldemo.service.manager.DataManager.genericClient;

/**
 * peterDemoExcels
 * Created by peter
 * on 2017.12
 *
 * @author peter
 */

public class RetrofitHelper {
    private Context mCntext;

    OkHttpClient client = genericClient().build();
    GsonConverterFactory factory = GsonConverterFactory.create();

    private static RetrofitHelper instance = null;
    private Retrofit mRetrofit = null;

    public static RetrofitHelper getInstance(Context context) {
        if (instance == null) {
            instance = new RetrofitHelper(context);
        }
        return instance;
    }

    public RetrofitHelper(Context context) {
        mCntext = context;
    }

    public RetrofitService baseUrl(String url) {
        mRetrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .client(client)
                .build();
        return mRetrofit.create(RetrofitService.class);
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
