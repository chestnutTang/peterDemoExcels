package demo.third.com.exceldemo.ui.views;

import android.text.TextUtils;

import java.util.LinkedHashMap;

/**
 * Created by wangfengchen on 2016/11/29.
 */

public class OkRequestParams extends LinkedHashMap<String, String> {

    @Override
    public String put(String key, String value) {
        if(!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value))
            return super.put(key, value);
        return null;
    }
}
