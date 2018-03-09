package demo.third.com.exceldemo.service;

import demo.third.com.exceldemo.service.entity.Book;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * peterDemoExcels
 * Created by peter
 * on 2017.12
 */

public interface RetrofitService {
    @GET("book/search")
    Observable<Book> getSearchBook(@Query("q") String name,
                                   @Query("tag") String tag,
                                   @Query("start") int start,
                                   @Query("count") int count);
}