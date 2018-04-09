package demo.third.com.exceldemo.service.manager;

import android.content.Context;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import demo.third.com.exceldemo.app.CustomApplication;
import demo.third.com.exceldemo.service.RetrofitHelper;
import demo.third.com.exceldemo.service.RetrofitService;
import demo.third.com.exceldemo.service.entity.Book;
import demo.third.com.exceldemo.service.entity.LoginEntity;
import demo.third.com.exceldemo.utils.Constant;
import demo.third.com.exceldemo.utils.SystemTools;
import demo.third.com.exceldemo.utils.Tools;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import rx.Observable;

import static demo.third.com.exceldemo.utils.Tools.getSeedAll1;

/**
 * peterDemoExcels
 * Created by peter
 * on 2017.12
 */

public class DataManager {
    private RetrofitService mRetrofitService;
    private static Context mContext;

    public DataManager(Context context, String url) {
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
        mContext = context;
    }

    public Call<Book> getSearchBooks(String name, String tag, int start, int count) {
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
                        Random random = new Random();
                        String timestamp, r;
                        timestamp = "" + System.currentTimeMillis();
                        int seedAll = Tools.getSeedAll(getSeedAll1());
                        int seedAll1 = Tools.getSeedAll(seedAll);
                        //uuid
                        String uuid = Tools.getUUID();
                        //did
                        String timeSmat = String.valueOf(System.currentTimeMillis());
                        String uuidSec = Tools.encryptToStringNew(seedAll1, uuid);
                        String didSec = Tools.encryptToStringNew(seedAll1, timeSmat);

                        //sign
                        String sign = uuidSec + didSec;
                        String signSec = Tools.encryptToStringNew(seedAll1, sign);


                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/x-www-form-urlencoded; " +
                                        "charset=UTF-8")
                                .addHeader("Accept-Encoding", "gzip, deflate")
                                .addHeader("User-Agent", "keep-al222ive")
                                .addHeader("Accept", "*/*")
                                .addHeader("Cookie", "add cookies here")

                                .addHeader("ts", timestamp)
                                .addHeader("ck", didSec)
                                .addHeader("dk", uuidSec)
                                .addHeader("sg", signSec)
                                .addHeader("AGID", "1")
//                                .addHeader("r", r)
//                                .addHeader("token", "" + token)
                                //验证登录
                                .addHeader("apiVersion", 2 + "")
//                                .addHeader("user", ShangshabanUtil.getEid(getApplicationContext
// ()))
//                                .addHeader("authorization", ShangshabanUtil.getToken
//                                        (getApplicationContext()))
//                                .addHeader("authorization","1111")
                                .addHeader("appVersion", SystemTools.getVersionName(CustomApplication.getInstance().getApplicationContext()))


                                .build();
                        return chain.proceed(request);
                    }

                })
                .build();

        return httpClient;
    }

}
