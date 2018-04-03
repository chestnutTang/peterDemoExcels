package demo.third.com.exceldemo.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * peterDemoExcels
 * Created by peter
 * on 2018.03
 * webView 类型的父类
 *
 * @author peter
 */

public abstract class WebViewBaseActivity extends AppCompatActivity {
    protected String url;

    /**
     * 需要隐藏的dom元素id或者class
     */
    private static final String[] HIDE_DOM_IDS = {"g-header clearfix", "mb15"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    /**
     * @return 获取布局文件的resID
     */
    protected abstract int getLayoutId();

    protected void initView() {
    }

    /**
     * 初始化webView属性
     */
    @SuppressLint("SetJavaScriptEnabled")
    protected void initWebViewSetting(final WebView webView, final String url) {
        WebSettings setting = webView.getSettings();
        setting.setJavaScriptEnabled(true);
        setting.setDomStorageEnabled(true);
        setting.setDefaultTextEncodingName("utf-8");
        setting.setAllowFileAccess(true);
        setting.setLoadWithOverviewMode(true);
        setting.setUseWideViewPort(true);
        //重写userAgent，用于前端判断是否是在APP内，也可以用来区分iOS和Android
        String userAgent = setting.getUserAgentString();
        String userAgentCustom = userAgent.replace("(KHTML", "(skhtmlsb");
        Log.e("song", "老的userAgent-->" + userAgent);
        Log.e("song", "新的userAgent-->" + userAgentCustom);
        setting.setUserAgentString(userAgentCustom);

        //支持flash播放
        setting.setPluginState(WebSettings.PluginState.ON);
        //同时支持https和http
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setting.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        //清除缓存
        webView.clearCache(true);
        webView.clearHistory();
        //开启硬件加速
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, final String title) {
                super.onReceivedTitle(view, title);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        // UI操作，在主线程中
//                    }
//                });
            }


            @Override
            public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
                super.onReceivedTouchIconUrl(view, url, precomposed);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webView.loadUrl(getDomOperationStatements(HIDE_DOM_IDS));
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.cancel();
//                handler.proceed();//接受所有证书
            }

            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request,
                                            WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request,
                                        WebResourceError error) {
                super.onReceivedError(view, request, error);

            }
        });
        //  API 17以下的，禁止使用该功能，数据安全考虑
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            webView.addJavascriptInterface(new JsObject(getApplicationContext()), "JsTest");
        }
        webView.loadUrl(url);
//        webView.loadDataWithBaseURL(url,null, "text/html",  "utf-8", null);
    }

    /**
     * 自定义JS交互类
     */
    class JsObject {
        private Context context;

        public String toString() {
            return "injectedObject";
        }

        public JsObject(Context context) {
            this.context = context;
        }


        /**
         * 安卓调用JS方法，返回json格式的字符串
         *
         * @return
         */
        @JavascriptInterface
        public String androidCallJs() {
            JSONObject object = new JSONObject();
            try {
                object.put("uid", "123");
                object.put("phone", "186");
                object.put("username", "peter");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return object.toString();
        }

        /**
         * @param json JS调用安卓的方法，用json格式返回数据
         */
        @JavascriptInterface
        public void getShareData(String json) {
            try {
                JSONObject jsonObject = new JSONObject(json);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param hideDomIds 需要删除的DOM节点的ID或者Class
     * @return 删除DOM树的某几个节点
     */
    public static String getDomOperationStatements(String[] hideDomIds) {
        StringBuilder builder = new StringBuilder();
        // add javascript prefix
        builder.append("javascript:(function() { ");
        for (String domId : hideDomIds) {
            builder.append("var item = document.getElementsByClassName('").append(domId).append("')[0];");
            builder.append("item.parentNode.removeChild(item);");
        }
        // add javascript suffix
        builder.append("})()");
        return builder.toString();
    }

}

