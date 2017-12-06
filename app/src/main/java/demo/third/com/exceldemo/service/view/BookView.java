package demo.third.com.exceldemo.service.view;

import demo.third.com.exceldemo.service.entity.Book;

/**
 * peterDemoExcels
 * Created by peter
 * on 2017.12
 */

public interface BookView extends View {
    void onSuccess(Book mbook);

    void onError(String result);
}
