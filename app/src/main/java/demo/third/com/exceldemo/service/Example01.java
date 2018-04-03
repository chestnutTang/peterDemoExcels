package demo.third.com.exceldemo.service;

import org.json.JSONObject;

import java.io.IOException;

import demo.third.com.exceldemo.service.entity.LoginEntity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.Result;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.03.31
 */
public class Example01 {
    public interface BlogService {
        @GET("open/api/weather/json.shtml")
            //这里的{id} 表示是一个变量
        Call<Result<LoginEntity>> getBlog(@Query("city") String id);
    }

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.sojson.com/")
                .build();

        BlogService service = retrofit.create(BlogService.class);
        Call<Result<LoginEntity>> call = service.getBlog("北京");
        // 用法和OkHttp的call如出一辙
        // 不同的是如果是Android系统回调方法执行在主线程
        call.enqueue(new Callback<Result<LoginEntity>>() {
            @Override
            public void onResponse(
                    Call<Result<LoginEntity>> call, Response<Result<LoginEntity>> response) {
                try {
                    Result<LoginEntity> result = response.body();
                    System.out.println(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Result<LoginEntity>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
