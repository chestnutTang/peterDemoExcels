package demo.third.com.exceldemo.service.manager;

import android.content.Context;

import java.io.IOException;

import demo.third.com.exceldemo.service.RetrofitHelper;
import demo.third.com.exceldemo.service.RetrofitService;
import demo.third.com.exceldemo.service.entity.Book;
import demo.third.com.exceldemo.service.entity.LoginEntity;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import rx.Observable;

/**
 * peterDemoExcels
 * Created by peter
 * on 2017.12
 */

public class DataManager {
    private RetrofitService mRetrofitService;

    public DataManager(Context context, String url) {
        this.mRetrofitService = RetrofitHelper.getInstance(context, url).getServer();
    }

    public Observable<Book> getSearchBooks(String name, String tag, int start, int count) {
        return mRetrofitService.getSearchBook(name, tag, start, count);
    }

    public Call<LoginEntity> loginSystem(String phone) {
        return mRetrofitService.loginSystem("北京");
    }

    public static OkHttpClient genericClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/x-www-form-urlencoded; " +
                                        "charset=UTF-8")
                                .addHeader("Accept-Encoding", "gzip, deflate")
                                .addHeader("User-Agent", "keep-alive")
                                .addHeader("Accept", "*/*")
                                .addHeader("Cookie", "add cookies here")
                                .build();
                        return chain.proceed(request);
                    }

                })
                .build();

        return httpClient;
    }

}
