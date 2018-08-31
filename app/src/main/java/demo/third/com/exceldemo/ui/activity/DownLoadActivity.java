package demo.third.com.exceldemo.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;

import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.adapter.DownloadAdapter;
import demo.third.com.exceldemo.utils.ACache;
import demo.third.com.exceldemo.utils.AddFileInfo;
import demo.third.com.exceldemo.utils.OpenFile;
import demo.third.com.exceldemo.utils.PreferenceHelper;
import demo.third.com.exceldemo.utils.ProgressDialog;

/**
 * @author songzhengpeng
 * 下载
 */
public class DownLoadActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.lv_download)
    ListView mListview;
    @BindView(R.id.pdfView)
    PDFView pdfView;
    private List<String> listResult = new ArrayList<>();


    public ProgressDialog dialog;
    private static Adapter adapter;
    private ACache aCache;
    private String fileDate = "";
    private Context context;
    private List<AddFileInfo> list = new ArrayList<AddFileInfo>();
    private String filePath = Environment.getExternalStorageDirectory().toString() + File.separator;

    private MyHandler handler = new MyHandler(DownLoadActivity.this);

    private DownloadAdapter downloadAdapter;


    public static class MyHandler extends Handler {
        WeakReference<DownLoadActivity> weakReference;
        Activity activity;

        MyHandler(DownLoadActivity activity) {
            weakReference = new WeakReference<>(activity);
            this.activity = activity;
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            DownLoadActivity downLoadActivity = weakReference.get();
            if (downLoadActivity != null) {
                switch (msg.what) {
                    case 1:
                        downLoadActivity.dismissProgress();
                        adapter.notifyDataSetChanged();
                        if (!TextUtils.isEmpty(downLoadActivity.fileDate)) {
                            downLoadActivity.aCache.put("file", downLoadActivity.fileDate
                                    .substring(0, (downLoadActivity.fileDate.length() - 1)), 6000);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        downloadAdapter = new DownloadAdapter(DownLoadActivity.this
                ,PreferenceHelper.getInstance().getFileUrl()
        ,PreferenceHelper.getInstance().getFileName());
        mListview.setAdapter(downloadAdapter);
//        context = this;
//        aCache = ACache.get(this);
//        onLoad();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_down_load;
    }

    public void onLoad() {
        tvTitle.setText(getResources().getString(R.string.action_download));
        adapter = new Adapter(DownLoadActivity.this);
        String string = aCache.getAsString("file");
        if (string == null) {
            showProgress();
            new MyThread().start();
        } else {
            String[] str = string.split(",");

            for (int i = 0; i < str.length; i++) {
                Log.i("file", str[i]);
                File f = new File(str[i]);
                if (f.exists()) {
                    FileInputStream fis = null;
                    try {
                        fis = new FileInputStream(f);
                        String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date(f
                                .lastModified()));
                        AddFileInfo info = new AddFileInfo(f.getName(), Long.valueOf(fis
                                .available()), time, false, f.getAbsolutePath());
                        fileDate += f.getAbsolutePath() + ",";
                        list.add(info);
                    } catch (Exception e) {
                        return;
                    }
                }
            }
        }
        mListview.setOnItemClickListener(onItemClickListener);
        mListview.setAdapter(adapter);
    }

    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.e("niubi", "大小" + list.size() + "");
            Log.e("niubi", "水电费" + list.get(position).getPath());
//            mListview.setVisibility(View.GONE);
//            tvTitle.setText(list.get(position).getName());
//            Uri uri = Uri.fromFile(new File(list.get(position).getPath()));
//            Log.e("niubi", "uri---->" + uri);
//            pdfView.fromUri(uri)
//                    .enableSwipe(true)
//                    //pdf文档翻页是否是垂直翻页，默认是左右滑动翻页
//                    .swipeHorizontal(true)
//                    .enableDoubletap(false)
//                    //设置默认显示第0页
//                    .defaultPage(0)
//                    //允许在当前页面上绘制一些内容，通常在屏幕中间可见。
////                .onDraw(onDrawListener)
////                // 允许在每一页上单独绘制一个页面。只调用可见页面
////                .onDrawAll(onDrawListener)
//                    //设置加载监听
//                    .onLoad(new OnLoadCompleteListener() {
//                        @Override
//                        public void loadComplete(int nbPages) {
//                        }
//                    })
//                    //设置翻页监听
//                    .onPageChange(new OnPageChangeListener() {
//
//                        @Override
//                        public void onPageChanged(int page, int pageCount) {
//                        }
//                    })
//                    .enableAnnotationRendering(false)
//                    .password(null)
//                    .scrollHandle(null)
//                    // 改善低分辨率屏幕上的渲染
//                    .enableAntialiasing(true)
//                    // 页面间的间距。定义间距颜色，设置背景视图
//                    .spacing(0)
//                    .load();
            startActivity(OpenFile.openFile(list.get(position).getPath()));
        }
    };

    public static Uri getMediaUriFromPath(Context context, String path) {
        Uri mediaUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = context.getContentResolver().query(mediaUri,
                null,
                MediaStore.Images.Media.DISPLAY_NAME + "= ?",
                new String[]{path.substring(path.lastIndexOf("/") + 1)},
                null);

        Uri uri = null;
        if (cursor.moveToFirst()) {
            uri = ContentUris.withAppendedId(mediaUri,
                    cursor.getLong(cursor.getColumnIndex(MediaStore.Images.Media._ID)));
        }
        cursor.close();
        return uri;
    }


    public class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                doSearch(filePath);
                Thread.sleep(2000);
                Message msg = new Message();
                msg.what = 1;
                msg.obj = 1;
                handler.sendMessage(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    /****
     *计算文件大小
     * @param length
     * @return
     */
    public static String ShowLongFileSzie(Long length) {
        if (length >= 1048576) {
            return (length / 1048576) + "MB";
        } else if (length >= 1024) {
            return (length / 1024) + "KB";
        } else if (length < 1024) {
            return length + "B";
        } else {
            return "0KB";
        }
    }

    File file;

    /****
     * 递归算法获取本地文件
     * @param path
     */
    private void doSearch(String path) {
        getPermission();
        file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] fileArray = file.listFiles();
                if (fileArray != null) {
                    for (File f : fileArray) {
                        if (f.isDirectory()) {
                            doSearch(f.getPath());
                        } else {
                            if (f.getName().endsWith(".ppt") || f.getName().endsWith(".pptx")
                                    || f.getName().endsWith(".docx") || f.getName().endsWith(".xls")
                                    || f.getName().endsWith(".doc") || f.getName().endsWith("" +
                                    ".pdf")) {
                                FileInputStream fis = null;
                                try {
                                    fis = new FileInputStream(f);
                                    String time = new SimpleDateFormat("yyyy-MM-dd").format(new
                                            Date(f.lastModified()));
                                    AddFileInfo info = new AddFileInfo(f.getName(), Long.valueOf
                                            (fis.available()), time, false, f.getAbsolutePath());
                                    list.add(info);
                                    fileDate += f.getAbsolutePath() + ",";
                                    Log.i("url", f.getAbsolutePath() + "--" + f.getName() + "---"
                                            + fis.available() + "--");
                                    System.out.println("文件名称：" + f.getName());
                                    System.out.println("文件是否存在：" + f.exists());
                                    System.out.println("文件的相对路径：" + f.getPath());
                                    System.out.println("文件的绝对路径：" + f.getAbsolutePath());
                                    System.out.println("文件可以读取：" + f.canRead());
                                    System.out.println("文件可以写入：" + f.canWrite());
                                    System.out.println("文件上级路径：" + f.getParent());
                                    System.out.println("文件大小：" + f.length() + "B");
                                    System.out.println("文件最后修改时间：" + new Date(f.lastModified()));
                                    System.out.println("是否是文件类型：" + f.isFile());
                                    System.out.println("是否是文件夹类型：" + f.isDirectory());

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    class Adapter extends BaseAdapter {
        private int[] img_word = new int[]{R.mipmap.word, R.mipmap.xls, R.mipmap.ppt};
        private LayoutInflater inflater;

        public Adapter(Context context) {
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (null == convertView) {
                convertView = inflater.inflate(R.layout.item_download_list, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            AddFileInfo info = (AddFileInfo) getItem(position);
//            if (info.getName().endsWith(".doc") || info.getName().endsWith(".docx")) {
//                holder.iv_img.setImageResource(img_word[0]);
//            } else if (info.getName().endsWith(".xls")) {
//                holder.iv_img.setImageResource(img_word[1]);
//            } else {
//                holder.iv_img.setImageResource(img_word[2]);
//            }
            holder.tv_name.setText(info.getName());
//            holder.size.setText(ShowLongFileSzie(info.getSize()));
//            holder.time.setText(info.getTime());
            return convertView;
        }


    }

    class ViewHolder {

        private TextView tv_name;
//        private TextView size;
//        private TextView time;

        public ViewHolder(View view) {
            tv_name = (TextView) view.findViewById(R.id.tv_black_title);
//            size = (TextView) view.findViewById(R.id.item_file_size);
//            time = (TextView) view.findViewById(R.id.item_file_time);
        }
    }


    /***
     * 启动
     */
    public void showProgress() {
        if (dialog == null) {
            dialog = new ProgressDialog(DownLoadActivity.this);
        }
        dialog.showMessage("正在加载");
        dialog.show();
    }

    /***
     * 关闭
     */
    public void dismissProgress() {
        if (dialog == null) {
            dialog = new ProgressDialog(this);
        }
        dialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    void getPermission() {
        int permissionCheck1 = ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE);
        int permissionCheck2 = ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck1 != PackageManager.PERMISSION_GRANTED || permissionCheck2 !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission
                            .READ_EXTERNAL_STORAGE},
                    124);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 124) {
            if ((grantResults.length > 0) && (grantResults[0] == PackageManager
                    .PERMISSION_GRANTED)) {
                Log.d("heihei", "获取到权限了！");
                file = new File(filePath);//初始化File对象
            } else {
                Log.d("heihei", "搞不定啊！");
            }
        }
    }

    @Override
    public void onBackPressed() {
        finish();
//        if (mListview.getVisibility() == View.VISIBLE && pdfView.getVisibility() == View.GONE) {
//            finish();
//        } else {
//            mListview.setVisibility(View.VISIBLE);
//            pdfView.setVisibility(View.GONE);
//        }
    }
}
