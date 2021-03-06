package demo.third.com.exceldemo.service;

import org.w3c.dom.Comment;

import java.util.Map;

import demo.third.com.exceldemo.service.entity.Book;
import demo.third.com.exceldemo.service.entity.LoginEntity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * peterDemoExcels
 * Created by peter
 * on 2017.12
 */

public interface RetrofitService {
    @GET("book/search")
    Call<Book> getSearchBook(@Query("q") String name,
                             @Query("tag") String tag,
                             @Query("start") int start,
                             @Query("count") int count);

    @FormUrlEncoded
    @POST("Comments/{newsId}")
    Call<Comment> reportComment(
            @Path("newsId") String commentId,
            @Field("reason") String reason);


    @GET("open/api/weather/json.shtml")
    Call<LoginEntity> loginSystem(@Query("city") String phone);

    @POST("api/user/insertFeedback.do")
    Call<ResponseBody> postFeedback(@QueryMap Map<String, String> options);


}
