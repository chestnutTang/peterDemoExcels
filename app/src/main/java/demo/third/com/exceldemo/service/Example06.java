package demo.third.com.exceldemo.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import demo.third.com.exceldemo.service.entity.LoginEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.Result;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * peterDemoExcels
 * Created by szp
 * on 2018.03.31
 */
public class Example06 {
    public interface BlogService {
        @GET("open/api/weather/json.shtml")
        Call<Result<LoginEntity>> getBlog(@Query("city") String id);
    }

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                //配置你的Gson
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.sojson.com/")
                //可以接收自定义的Gson，当然也可以不传
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        BlogService service = retrofit.create(BlogService.class);
        Call<Result<LoginEntity>> call = service.getBlog("青岛");
        call.enqueue(new Callback<Result<LoginEntity>>() {
            @Override
            public void onResponse(Call<Result<LoginEntity>> call, Response<Result<LoginEntity>> response) {
                // 已经转换为想要的类型了
                Result<LoginEntity> result = response.body();
                System.out.println(result);
            }

            @Override
            public void onFailure(Call<Result<LoginEntity>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
