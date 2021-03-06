package demo.third.com.exceldemo.service.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import demo.third.com.exceldemo.BuildConfig;
import demo.third.com.exceldemo.service.entity.Book;
import demo.third.com.exceldemo.service.manager.DataManager;
import demo.third.com.exceldemo.service.view.BookView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * peterDemoExcels
 * Created by peter
 * on 2017.12
 */

public class BookPresenter implements Presenter {

    private DataManager manager;
    private CompositeSubscription mCompositeSubscription;
    private Context mContext;
    private BookView mBookView;
    private Book mBook;

    public BookPresenter (Context mContext){
        this.mContext = mContext;
    }


    @Override
    public void onCreate() {
//        manager = new DataManager(mContext, BuildConfig.HOST);
//        manager = new DataManager(mContext, "http://weather.vivo.com.cn/v3/getweather?imei=860576034077154&model=vivoX6SA&elapsedtime=348696711&areaId=101120201/");
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(demo.third.com.exceldemo.service.view.View view) {
        mBookView = (BookView)view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void getSearchBooks(String name,String tag,int start,int count){
//        mCompositeSubscription.add(manager.getSearchBooks(name,tag,start,count)
//                .enqueue(new Callback<Book>() {
//                    @Override
//                    public void onResponse(Call<Book> call, Response<Book> response) {
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<Book> call, Throwable t) {
//
//                    }
//                }));
//        mCompositeSubscription.add(manager.getSearchBooks(name,tag,start,count)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Book>() {
//                    @Override
//                    public void onCompleted() {
//                        if (mBook != null){
//                            mBookView.onSuccess(mBook);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                        mBookView.onError("请求失败！！");
//                    }
//
//                    @Override
//                    public void onNext(Book book) {
//                        mBook = book;
//                    }
//                }
//                )
//        );
    }

}
