package demo.third.com.exceldemo.service.view;

import demo.third.com.exceldemo.service.entity.Book;
import demo.third.com.exceldemo.service.entity.LoginEntity;

/**
 * peterDemoExcels
 * Created by peter
 * on 2017.12
 */

public interface LoginView extends View {
    void onSuccess(LoginEntity mloginEntity);

    void onError(String result);
}
