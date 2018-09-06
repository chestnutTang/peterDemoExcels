package demo.third.com.exceldemo.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.views.CustomActionWebView;
import demo.third.com.exceldemo.utils.DownloadTask;
import demo.third.com.exceldemo.utils.ProgressDialog;
import demo.third.com.exceldemo.utils.Tools;

/**
 * peterDemoExcels
 * Created by peter
 * on 2018.03
 * webView 类型的父类
 *
 * @author peter
 */

public abstract class BaseWebActivity extends AppCompatActivity {

    @BindView(R.id.web_view)
    CustomActionWebView webView;
//    SlowlyProgressBar slowlyProgressBar;

    protected String url;
    protected ProgressDialog dialog;

    /**
     * 需要隐藏的dom元素id或者class
     */
    private static final String[] HIDE_DOM_IDS = {"g-header clearfix", "m-top-bar"};
    private static final String[] HIDE_DOM_IDS3 = {"Noprint"};
    private static final String[] HIDE_DOM_IDS2 = {"m_sitebanner visible-xs ng-scope", "siteconnect ng-scope"
            , "m_sitefooter navbar-fixed-bottom visible-xs ng-scope"
            ,"line-horizontal-dash form-group"
            ,"form-group","sitespacing-180px ng-scope"
    };
//    @BindView(R.id.ProgressBar)
//    ProgressBar ProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        bindView();
    }

    protected void showProgress(String message) {
        if (dialog == null) {
            dialog = new ProgressDialog(BaseWebActivity.this);
        }
        dialog.show();
        dialog.showMessage(message);
    }

    protected void dismissProgress() {
        if (dialog == null) {
            dialog = new ProgressDialog(this);
        }
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if (slowlyProgressBar != null) {
//            slowlyProgressBar.destroy();
//            slowlyProgressBar = null;
//        }
    }

    protected int getLayoutId() {
        return R.layout.activity_base_web_view;
    }

    protected void bindView() {
//        slowlyProgressBar = new SlowlyProgressBar((ProgressBar) findViewById(R.id.ProgressBar));
    }

    /**
     * 初始化webView属性
     */
    @SuppressLint("SetJavaScriptEnabled")
    protected void initWebViewSetting(final WebView webView, final String url) {
        WebSettings setting = webView.getSettings();
        setting.setJavaScriptEnabled(true);
        setting.setCacheMode(WebSettings.LOAD_NO_CACHE);
        setting.setDomStorageEnabled(true);
        setting.setDefaultTextEncodingName("utf-8");
        setting.setAllowFileAccess(true);
        setting.setLoadWithOverviewMode(true);
        setting.setUseWideViewPort(true);
        setting.setTextSize(WebSettings.TextSize.LARGER); //
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
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dismissProgress();
                    }
                }, 1500);

//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        // UI操作，在主线程中
//                    }
//                });
            }


            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }


            @Override
            public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
                super.onReceivedTouchIconUrl(view, url, precomposed);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
//                if (slowlyProgressBar != null) {
//                    slowlyProgressBar.onProgressChange(newProgress);
//                }
            }
        });
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                if (!request.isForMainFrame() && request.getUrl().getPath().endsWith("/favicon.ico")) {
                    try {
                        return new WebResourceResponse("image/png", null,
                                new BufferedInputStream(view.getContext().getAssets().open("empty_favicon.ico")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return null;

            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                if (url.toLowerCase().contains("/favicon.ico")) {
                    try {
                        return new WebResourceResponse("image/png", null,
                                new BufferedInputStream(view.getContext().getAssets().open("empty_favicon.ico")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

            @Override
            public void onPageFinished(WebView view,final String url) {
                super.onPageFinished(view, url);
//                webView.loadUrl(url);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (url.contains("fo.amac.org.cn/amac/allNotice")) {
//                    webView.loadUrl("javascript:window.onload=function(){   alert($) }");
                            webView.loadUrl(deleteOthers());
//                            webView.loadUrl(getDomOperationStatements(HIDE_DOM_IDS3));
                        } else if (url.contains("baoming.amac.org.cn:10080/")) {
//                            webView.loadUrl(deleteHH());
                            webView.loadUrl(getDomOperationStatements(HIDE_DOM_IDS2));
                        } else {
                            webView.loadUrl(getDomOperationStatements(HIDE_DOM_IDS));
                        }
                    }
                },1500);

//                webView.loadUrl("javascript:document.body.style.paddingLeft=\"8%\"; void 0");
//                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
//                if (slowlyProgressBar != null) {
//                    slowlyProgressBar.onProgressStart();
//                }
//                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager
//                        .LayoutParams.FLAG_NOT_TOUCHABLE);
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
//        webView.setDownloadListener(new MyWebViewDownLoadListener());
        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                String fileName = Tools.getDownFileName(url, contentDisposition, mimetype);
//                String fileName = URLUtil.guessFileName(url, contentDisposition, mimetype);
                String destPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                        .getAbsolutePath() + File.separator + fileName;
                DownloadTask task = new DownloadTask(BaseWebActivity.this, dialog);
                task.execute(url, destPath, fileName);

            }
        });
        //  API 17以下的，禁止使用该功能，数据安全考虑
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            webView.addJavascriptInterface(new JsObject(getApplicationContext()), "JsTest");
        }
        if (url.startsWith("http") || url.startsWith("https") || url.startsWith("www")) {
            webView.loadUrl(url);
        } else {
            String css = "<style type=\"text/css\"> </style>";
            String html = "<html><header><meta name=\"viewport\" content=\"width=device-width, " +
                    "initial-scale=1.0, maximum-scale=1.0, user-scalable=no>" + css + "</header>" +
                    "<body>" + url + "</body>" + "</html>";
            webView.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);
        }
    }

    protected boolean openWithWevView(String url) {//处理判断url的合法性
        if (url.startsWith("http:") || url.startsWith("https:")) {
            return true;
        }
        return false;
    }

    private class MyWebViewDownLoadListener implements DownloadListener {

        @Override
        public void onDownloadStart(String url, String userAgent, String contentDisposition,
                                    String mimetype, long contentLength) {
            Uri uri = Uri.parse(url); // url为你要链接的地址
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }

    /**
     * 自定义JS交互类
     */
    class JsObject {
        private Context context;

        public String TranslateToString() {
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

    private void imgReset() {
        webView.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName('img'); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{"
                + "var img = objs[i];   " +
                " img.style.maxWidth = '100%';img.style.height='auto';" +
                "}" +
                "})()");
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
            builder.append("var item = document.getElementsByClassName('").append(domId).append
                    ("')[0];");
            builder.append("item.parentNode.removeChild(item);");
        }
        // add javascript suffix
        builder.append("})()");
        return builder.toString();
    }

    public String deleteHH(){
        return "javascript: window.onload = function () { \n" +
                "    var rmFm = document.querySelectorAll(\".form-group\");\n" +
                "    rmFm.forEach(function (item,index) { \n" +
                "        if(index >5){\n" +
                "            item.parentNode.removeChild(item); \n" +
                "        }\n" +
                "    });\n" +
                "    var rmFt = document.querySelectorAll(\"footer\");\n" +
                "    rmFt.forEach(function (item) { item.parentNode.removeChild(item); });\n" +
                "    var rmBn = document.querySelector(\".m_sitebanner\");\n" +
                "    rmBn.parentNode.removeChild(rmBn);\n" +
                "    var rmSC = document.querySelector(\".siteconnect\");\n" +
                "    rmSC.parentNode.removeChild(rmSC);\n" +
                "    var rmPB = document.querySelector(\".sitespacing-180px\")\n" +
                "    rmPB.parentNode.removeChild(rmPB);\n" +
                "}()";
    }

    public String deleteOthers2(){
        return "javascript:window.onload=function(){  \n" +
                "\n" +
                "var f = document.getElementsByTagName(\"form\")[0];\n" +
                "var childs = f.childNodes;\n" +
                "for(var i = 0; i < childs.length; i++) { \n" +
                "  if(childs[i].tagName == 'BR' || childs[i].tagName == 'DIV' || childs[i].tagName == 'FONT'){\n" +
                "   f.removeChild(childs[i]);   \n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "var node = document.getElementById('footer');\n" +
                "node.parentNode.removeChild(node);\n" +
                "\n" +
                "node = document.getElementById('header');\n" +
                "node.parentNode.removeChild(node);\n" +
                "\n" +
                "document.body.style.width = '100%'; \n" +
                "}()";
    }

    public String deleteOthers() {
        return "javascript: window.onload = function () {\n" +
                "    var bd = document.getElementById(\"body\");\n" +
                "    var BD = document.body;\n" +
                "    var fm = bd.childNodes[1];\n" +
                "    var rmItems = fm.querySelectorAll(\"div,font,br\");\n" +
                "    rmItems.forEach(function(item){item.parentNode.removeChild(item);});\n" +
                "    document.getElementById(\"header\");\n" +
                "    BD.style.width = \"100%\";\n" +
                "    BD.removeChild(document.getElementById(\"header\"));\n" +
                "    BD.removeChild(document.getElementById(\"footer\"));\n" +
                "}()";
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack(); // goBack()表示返回WebView的上一页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

