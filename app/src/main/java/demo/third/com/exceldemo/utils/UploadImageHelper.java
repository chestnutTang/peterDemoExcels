package demo.third.com.exceldemo.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import demo.third.com.exceldemo.service.entity.LoginModel;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import top.zibin.luban.CompressionPredicate;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

public class UploadImageHelper {

    private static final int RESULT_CAMERA_ONLY = 100;
    private static final int RESULT_CAMERA_CROP_PATH_RESULT = 301;

    private Uri imageUri;
    private Uri imageCropUri;

    private static final String TAG = "UploadImageHelper";
    private Activity mAct;

    private Callback callback;

    String sd = getSDCardPath();
    private String myUpLoadUrl;

    private ProgressDialog progressDialog;
    private ArrayList<String> mStrings;

    private String flag = "";

    public UploadImageHelper(Activity act) {
        mAct = act;
        File file = new File(sd + "/myphoto.jpg");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            imageUri = FileProvider.getUriForFile(act, "demo.third.com.exceldemo.fileprovider", file);
            //通过FileProvider创建一个content类型的Uri
        } else {
            imageUri = Uri.fromFile(file);
        }
//        imageUri = FileProvider.getUriForFile(act, "demo.third.com.exceldemo.fileprovider", file);
// 通过FileProvider创建一个content类型的Uri
//        imageUri = Uri.fromFile(file);
//        genTemPhotoPath();
    }

    public UploadImageHelper(Activity act, String flag) {
        mAct = act;
        this.flag = flag;
        File file = new File(sd + "/myphoto.jpg");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            imageUri = FileProvider.getUriForFile(act, "demo.third.com.exceldemo.fileprovider", file);
            //通过FileProvider创建一个content类型的Uri
        } else {
            imageUri = Uri.fromFile(file);
        }
//        imageUri = FileProvider.getUriForFile(act, "demo.third.com.exceldemo.fileprovider", file);
// 通过FileProvider创建一个content类型的Uri
//        imageUri = Uri.fromFile(file);
//        genTemPhotoPath();
    }

    /**
     * 生成照片临时文件
     */
    public void genTemPhotoPath() {
        String imgSaveUrl = sd + "/myphoto_crop" + System.currentTimeMillis() + ".jpg";
        File faceFile = new File(imgSaveUrl);
//        if (Build.VERSION.SDK_INT >= 25){
//            imageCropUri = FileProvider.getUriForFile(mAct, "demo.third.com.exceldemo.fileprovider",
// faceFile);
//        } else {
        imageCropUri = Uri.fromFile(faceFile);
//        }
    }

    public void openCameraCut() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// action is
        // capture
        intent.putExtra("return-data", false);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        mAct.startActivityForResult(intent, RESULT_CAMERA_ONLY);
    }

    public void openPhotoAlbum() {
//        File outputImage = new File(Environment.getExternalStorageDirectory(),
//                "output_image.jpg");
//        imageUri = Uri.fromFile(outputImage);

//        try {
//            if (outputImage.exists()) {
//                outputImage.delete();
//            }
//            outputImage.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        //此处调用了图片选择器
        //如果直接写intent.setDataAndType("image/*");
        //调用的是系统图库
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        mAct.startActivityForResult(intent, 1);
    }

    public void cropImg(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true"); // 开启剪裁
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//        if (!TextUtils.isEmpty(flag)) {
//            if ("head".equals(flag)) {
//                intent.putExtra("aspectX", 9998);// 宽高比例
//                intent.putExtra("aspectY", 9999);// 宽高比例
//                intent.putExtra("outputX", 700);// 宽高
//                intent.putExtra("outputY", 700);// 宽高
//            }
//        } else {
////            intent.putExtra("aspectX", 9998);// 宽高比例
////            intent.putExtra("aspectY", 9999);// 宽高比例
////            intent.putExtra("outputX", 700);// 宽高
////            intent.putExtra("outputY", 700);// 宽高
//        }

        intent.putExtra("return-data", false);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageCropUri);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        mAct.startActivityForResult(intent, RESULT_CAMERA_CROP_PATH_RESULT);
    }

    // 检测是否有sd卡
    private boolean hasSdcard() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            System.out.println("存在sd卡");
            return true;
        } else {
            System.out.println("不存在sd卡");
            return false;
        }
    }

    public static String getSDCardPath() {
        String cmd = "cat /proc/mounts";
        Runtime run = Runtime.getRuntime();// 返回与当前 Java 应用程序相关的运行时对象
        try {
            Process p = run.exec(cmd);// 启动另一个进程来执行命令
            BufferedInputStream in = new BufferedInputStream(p.getInputStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));

            String lineStr;
            while ((lineStr = inBr.readLine()) != null) {
                // 获得命令执行后在控制台的输出信息
                if (lineStr.contains("sdcard")
                        && lineStr.contains(".android_secure")) {
                    String[] strArray = lineStr.split(" ");
                    if (strArray.length >= 5) {
                        return strArray[1].replace("/.android_secure",
                                "");
                    }
                }
                // 检查命令是否执行失败。
//                if (p.waitFor() != 0 && p.exitValue() == 1) {
                // p.exitValue()==0表示正常结束，1：非正常结束
//                }
            }
            inBr.close();
            in.close();
        } catch (Exception e) {

            return Environment.getExternalStorageDirectory().getPath();
        }

        return Environment.getExternalStorageDirectory().getPath();
    }

    /**
     * 上传多张图片到oss
     *
     * @param files 图片path
     */
    @SuppressWarnings("rawtypes")
    public void doOSSSetting2(final List<String> files) {

        if (files == null) {
            return;
        }

        if (progressDialog == null) {
            progressDialog = new ProgressDialog(mAct);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("上传中...");
            progressDialog.setCancelable(true);
            progressDialog.show();
        }

        if (mStrings == null) {
            mStrings = new ArrayList<>();
        }
        Log.e(TAG, "doOSSSetting2: 999999999" + files.size());
        if (files.size() <= 0) {
            progressDialog.dismiss();
            progressDialog = null;
            Log.e(TAG, "doOSSSetting2: 988888888888");
            callback.onUploadSuccess(mStrings);
            mStrings.clear();
            Log.e(TAG, "doOSSSetting2: " + mStrings.toString());
            return;
        }


        final String endpoint = Link.UPLOADIMAGE;
        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(
                PreferenceHelper.getInstance().getOSSKeyId(),
                PreferenceHelper.getInstance().getOSSKeySecret());
        ClientConfiguration conf = new ClientConfiguration();
        conf.setConnectionTimeout(15 * 1000); // 连接超时，默认15秒
        conf.setSocketTimeout(15 * 1000); // socket超时，默认15秒
        conf.setMaxConcurrentRequest(5); // 最大并发请求书，默认5个
        conf.setMaxErrorRetry(2); // 失败后最大重试次数，默认2次
        OSS oss = new OSSClient(mAct, endpoint,
                credentialProvider, conf);

        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat
                ("yyyyMMddHHmmss");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String timeStr = formatter.format(curDate);

        final String upLoadUrl = timeStr + ".png";
        Log.e("mygood", upLoadUrl);
        PutObjectRequest put = new PutObjectRequest(Link.UPLOAD_IMAGE_CONSTANT, upLoadUrl, files.get(0));
        //
        myUpLoadUrl = Link.UPLOADIMAGE + upLoadUrl;
        // myUpLoadUrl = endpoint + "ssb-img/" + upLoadUrl;
        put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {

            @Override
            public void onProgress(PutObjectRequest request, long currentSize,
                                   long totalSize) {
                Log.e("PutObject", "currentSize: " + currentSize
                        + " totalSize: " + totalSize);
            }
        });
        oss.asyncPutObject(put,
                new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {

                    @Override
                    public void onSuccess(PutObjectRequest request,
                                          PutObjectResult result) {
//                        progressDialog.dismiss();
                        Log.e("doOSSSetting2", myUpLoadUrl);

//                        deleteFile(files.get());
                        mStrings.add(myUpLoadUrl);
                        files.remove(0);
                        doOSSSetting2(files);
//                        callback.onUploadSuccess(myUpLoadUrl);
                        // postMessageToOSS(myUpLoadUrl);
                    }

                    @Override
                    public void onFailure(PutObjectRequest arg0,
                                          ClientException clientExcepion,
                                          ServiceException serviceException) {
                        // 请求异常
                        if (clientExcepion != null) {
                            // 本地异常如网络异常等
                            clientExcepion.printStackTrace();
                        }
                        if (serviceException != null) {
                            // 服务异常
                            Log.e("PutObject", serviceException.getErrorCode());
                            Log.e("PutObject", serviceException.getRequestId());
                            Log.e("PutObject", serviceException.getHostId());
                            Log.e("PutObject", serviceException.getRawMessage());
                        }
                        callback.onUploadError(serviceException);
                    }
                });
        // task.waitUntilFinished();

    }

    /**
     * 上传到oss
     *
     * @param imgUrl 图片path
     */
    @SuppressWarnings("rawtypes")
    public void doOSSSetting(final Activity context,final String imgUrl, final String suggestion,final boolean isPush) {
        if(TextUtils.isEmpty(suggestion)){
            Tools.toast("请输入您的宝贵意见");
            return;
        }
        if (!isPush)
            return;
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(mAct);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("上传中...");
            progressDialog.setCancelable(true);
            progressDialog.show();
        }
        OkHttpClient mOkHttpClent = new OkHttpClient();
//        MediaType fileType = MediaType.parse("File/*");
        MultipartBody.Builder builder;
        if(!TextUtils.isEmpty(imgUrl)){
            File file = new File(imgUrl);
             builder = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("suggestion",suggestion)
                    .addFormDataPart("printscreen", "printscreen.jpg", RequestBody.create(MediaType.parse("image/png"), file));

        }else {
            builder = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("suggestion",suggestion);
        }

        RequestBody requestBody = builder.build();
        Request request = new Request.Builder()
                .addHeader("ts", System.currentTimeMillis() + "")
                .addHeader("Content-Type", "multipart/form-data")
                .addHeader("apiVersion", SystemTools.getVersionName(mAct))
                .addHeader("user-token", PreferenceHelper.getInstance().getToken())
                .url(Link.SUGGESTION)
                .post(requestBody)
                .build();
        Call call = mOkHttpClent.newCall(request);
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mAct.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        Toast.makeText(mAct, "头像上传失败", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        progressDialog = null;
                        callback.onUploadError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                mAct.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        Toast.makeText(mAct, "头像上传成功", Toast.LENGTH_SHORT).show();
//                        try {
//                            String str = response.body().string();
//                            JSONObject object = new JSONObject(str);
//                            if (object.optInt("code") == 0){
//                                Tools.toast("反馈成功");
//                                context.finish();
//                            }else {
//                                Tools.toast("反馈失败");
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
                        progressDialog.dismiss();
                        progressDialog = null;
                        if(!TextUtils.isEmpty(imgUrl)){
                            Log.d(TAG, imgUrl);
                            deleteFile(imgUrl);
                        }

                        callback.onUploadSuccess(myUpLoadUrl);
                    }
                });
            }
        });
    }

    public void getFile(final Uri path,final String url) {
        //创建文件
        File file = new File(path.getPath());
        Luban.with(mAct).
                load(file)
                .ignoreBy(50)
                .filter(new CompressionPredicate() {
                    @Override
                    public boolean apply(String path) {
                        return !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"));
                    }
                })
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {
                        // TODO 压缩开始前调用，可以在方法内启动 loading UI
                        if (progressDialog == null) {
                            progressDialog = new ProgressDialog(mAct);
                            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                            progressDialog.setMessage("上传中...");
                            progressDialog.setCancelable(true);
                            progressDialog.show();
                        }
                    }

                    @Override
                    public void onSuccess(File file) {
                        // TODO 压缩成功后调用，返回压缩后的图片文件
                        OkHttpClient mOkHttpClent = new OkHttpClient();
                        MultipartBody.Builder builder = new MultipartBody.Builder()
                                .setType(MultipartBody.FORM)
                                .addFormDataPart("profileImg", "HeadPortrait.jpg", RequestBody.create(MediaType.parse("image/png"), file));

                        RequestBody requestBody = builder.build();
                        Request request = new Request.Builder()
                                .addHeader("ts", System.currentTimeMillis() + "")
                                .addHeader("Content-Type", "multipart/form-data")
                                .addHeader("apiVersion", SystemTools.getVersionName(mAct))
                                .addHeader("user-token", PreferenceHelper.getInstance().getToken())
                                .url(url)
                                .post(requestBody)
                                .build();
                        Call call = mOkHttpClent.newCall(request);
                        call.enqueue(new okhttp3.Callback() {
                            @Override
                            public void onFailure(Call call, final IOException e) {
                                mAct.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(mAct, "头像上传失败", Toast.LENGTH_SHORT).show();
                                        progressDialog.dismiss();
                                        progressDialog = null;
                                        callback.onUploadError(e);
                                    }
                                });
                            }

                            @Override
                            public void onResponse(Call call, final Response response) throws IOException {
                                ResponseBody body = response.body();
                                try {
                                    if (body != null) {
                                        String str = body.string();
                                        LoginModel loginModel = CustomGson.fromJson(str, LoginModel.class);
                                        if (loginModel != null && loginModel.getResult() != null) {
                                            PreferenceHelper.getInstance().setprofileImg(loginModel.getResult().getAccountInfo().getProfileImg());
                                        }
                                        progressDialog.dismiss();
                                        progressDialog = null;
                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
//                                mAct.runOnUiThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        String str = null;
//
//                                        Toast.makeText(mAct, "头像上传成功", Toast.LENGTH_SHORT).show();
//
//                                        progressDialog.dismiss();
//                                        progressDialog = null;
//                                        deleteFile(path.getPath());
//                                        callback.onUploadSuccess(myUpLoadUrl);
//                                    }
//                                });
                            }
                        });
                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO 当压缩过程出现问题时调用
                    }
                }).launch();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            // 拍照
            case 0:
                break;
            // 打开相册
            case 1:
                Uri uri = null;
                if (data != null) {
                    uri = data.getData();
                }
                if (uri != null) {
                    cropImg(uri);
                }
                break;
            case RESULT_CAMERA_ONLY:
                cropImg(imageUri);
                break;
            case RESULT_CAMERA_CROP_PATH_RESULT:
                if (data != null) {
                    deleteFile(imageUri.getPath());
                    Log.d(TAG, "imageCropUri " + imageCropUri);
                    if (imageCropUri != null && callback != null) {
                        callback.onCropResult(imageCropUri);
                    }
                }

                break;
            case 200:
                if (data != null) {
                    if (callback != null) {
                        callback.onResults(data.getStringArrayListExtra("imageFiles"));
                    }
                }
                break;
            default:
                break;
        }
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public interface Callback {

        void onCropResult(Uri s);

        void onResults(List<String> files);

        void onUploadSuccess(String url);

        void onUploadSuccess(List<String> files);

        void onUploadError(Throwable e);
    }

    /**
     * 删除临时文件
     *
     * @param filePath 文件path
     */
    public static void deleteFile(String filePath) {
        File imageCropFile = new File(filePath);
        Log.d(TAG, "exists? " + imageCropFile.exists());
        if (imageCropFile.exists()) {
            imageCropFile.delete();
        }
    }
}
