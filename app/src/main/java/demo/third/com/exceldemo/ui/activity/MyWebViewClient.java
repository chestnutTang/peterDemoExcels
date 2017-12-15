package demo.third.com.exceldemo.ui.activity;

import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * peterDemoExcels
 * Created by peter
 * on 2017.12
 */

public class MyWebViewClient extends WebViewClient {
    @Override
    public void onSafeBrowsingHit(WebView view, WebResourceRequest request, int threatType,
                                  SafeBrowsingResponse callback) {
        super.onSafeBrowsingHit(view, request, threatType, callback);
        callback.backToSafety(true);
//        BaseActivity.showCustomSnackbar(view, "Unsafe web page blocked.", "OK");
        Toast.makeText(view.getContext(),"Unsafe web page blocked.",Toast.LENGTH_SHORT).show();
    }
}
