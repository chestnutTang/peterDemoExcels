package demo.third.com.exceldemo.service.manager;

import android.content.Context;

import demo.third.com.exceldemo.service.RetrofitHelper;
import demo.third.com.exceldemo.service.RetrofitService;
import demo.third.com.exceldemo.service.entity.Book;
import rx.Observable;

/**
 * peterDemoExcels
 * Created by peter
 * on 2017.12
 */

public class DataManager {
    private RetrofitService mRetrofitService;

    public DataManager(Context context,String url) {
        this.mRetrofitService = RetrofitHelper.getInstance(context,url).getServer();
    }

    public Observable<Book> getSearchBooks(String name, String tag, int start, int count) {
        return mRetrofitService.getSearchBook(name, tag, start, count);
    }

}
