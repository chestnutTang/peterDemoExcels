package demo.third.com.exceldemo.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Void, Context> {

    private Context context;
    private ProgressDialog dialog;

    public DownloadTask(Context context, ProgressDialog dialog) {
        this.context = context;
        this.dialog = dialog;
    }

    // 传递两个参数：URL 和 目标路径
    private String url;
    private String destPath;
    private String fileName;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Logger.e("excel", "开始下载");
    }

    public void dismissProgress() {
        if (dialog == null) {
            dialog = new ProgressDialog(context);
        }
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    protected void onPostExecute(Context context) {
        super.onPostExecute(context);
        dismissProgress();
        if (!TextUtils.isEmpty(destPath)) {
            PreferenceHelper.getInstance().setFileUrl(destPath);
        }
        if (!TextUtils.isEmpty(fileName)) {
            PreferenceHelper.getInstance().setFileName(fileName);
        }
        Intent handlerIntent = new Intent(Intent.ACTION_VIEW);
        String mimeType = getMIMEType(destPath);
//        Uri uri = Uri.fromFile(new File(destPath));
        Uri uri2 = FileProvider.getUriForFile(this.context, "demo.third.com.exceldemo.fileprovider", new File(destPath));
        handlerIntent.setDataAndType(uri2, mimeType);
        this.context.startActivity(handlerIntent);

    }

    @Override
    protected Context doInBackground(String... params) {
        url = params[0];
        destPath = params[1];
        fileName = params[2];
        OutputStream out = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(params[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(15000);
            urlConnection.setReadTimeout(15000);
            InputStream in = urlConnection.getInputStream();
            out = new FileOutputStream(params[1]);
            byte[] buffer = new byte[10 * 1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            in.close();
        } catch (IOException e) {
            Logger.e("excel", "IO异常");
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    Logger.e("excel", "IOyichang");
                }
            }
        }
        return null;
    }

    private String getMIMEType(String url) {
        String type = null;
        String extension = MimeTypeMap.getFileExtensionFromUrl(url);
        Logger.e("excel", extension);
        if (extension != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        }
        return type;
    }

}
