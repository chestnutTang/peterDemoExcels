package demo.third.com.exceldemo.ui.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.utils.Tools;
import demo.third.com.exceldemo.utils.UploadImageHelper;

import static demo.third.com.exceldemo.utils.Constant.INPUT_CONTENT;

/**
 * @author peter
 * 帮助与反馈
 */
public class FeedBackActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_jump)
    TextView tvJump;
    @BindView(R.id.edit_feedback)
    EditText editFeedback;
    @BindView(R.id.iv_feedback)
    ImageView ivFeedback;

    private Dialog dialog;
    private UploadImageHelper uploadImageHelper;
    private Serializable imageUrl;
    private String myUpLoadUrl;
    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    private static final int MY_PERMISSIONS_REQUEST_STORAGE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initUploadImageHelper();
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText(getResources().getString(R.string.txt_title_feedback));
        tvJump.setText(getResources().getString(R.string.btn_finish));
        tvJump.setTextColor(Color.parseColor("#000000"));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feed_back;
    }

    @OnClick({R.id.iv_backup, R.id.tv_jump, R.id.iv_feedback})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            //完成
            case R.id.tv_jump:
                Tools.toast("网络请求");
                finish();
                break;
            case R.id.iv_feedback:
                showPicChoseDialog("相机", "相册", "取消");
                break;
            default:
                break;
        }
    }


    private void initUploadImageHelper() {
        uploadImageHelper = new UploadImageHelper(this, "head");
        uploadImageHelper.setCallback(new UploadImageHelper.Callback() {
            @Override
            public void onCropResult(Uri s) {
                Glide.with(getApplicationContext())
                        .load(s)
//                        .apply(new RequestOptions().transform(new GlideCircleTransform(getApplicationContext())))
                        .into(ivFeedback);
                uploadImageHelper.doOSSSetting(s.getPath());
                imageUrl = s.getPath();
            }

            @Override
            public void onResults(List<String> files) {

            }

            @Override
            public void onUploadSuccess(String url) {
                myUpLoadUrl = url;
            }

            @Override
            public void onUploadSuccess(List<String> files) {

            }

            @Override
            public void onUploadError(Throwable e) {
            }
        });
    }

    /**
     * @param title
     * @param firstStr
     * @param secondStr 调出选择相册和相机的弹窗
     */
    private void showPicChoseDialog(String title, String firstStr, String secondStr) {

        View view = getLayoutInflater().inflate(R.layout.dialog_open_camera, null);

        dialog = new Dialog(FeedBackActivity.this, R.style.transparentFrameWindowStyle);
        dialog.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        Window window = dialog.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        // 设置显示动画
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.x = 0;
        wl.y = getWindowManager().getDefaultDisplay().getHeight();
        // 以下这两句是为了保证按钮可以水平满屏
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        // 设置显示样式
        window.setAttributes(wl);

        // 相机
        TextView tvOpenCamera = view.findViewById(R.id.txt_open_camera);
        // 相册
        TextView tvOpenAlbum = view.findViewById(R.id.txt_open_album);
        // 取消
        TextView txtCancel = view.findViewById(R.id.txt_cancel);

        tvOpenCamera.setText(title);
        tvOpenAlbum.setText(firstStr);
        txtCancel.setText(secondStr);

        tvOpenCamera.setOnClickListener(this);
        tvOpenAlbum.setOnClickListener(this);
        txtCancel.setOnClickListener(this);
        dialog.show();
        if (uploadImageHelper != null) {
            uploadImageHelper.genTemPhotoPath();
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            //打开摄像机
            case R.id.txt_open_camera:
                try {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !=
                            PackageManager.PERMISSION_GRANTED || ContextCompat
                            .checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                            != PackageManager.PERMISSION_GRANTED || ContextCompat
                            .checkSelfPermission(this, Manifest.permission
                                    .WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission
                                .CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest
                                .permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_CAMERA);
                    } else {
                        uploadImageHelper.openCameraCut();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dialog.dismiss();
                break;
            //打开相册
            case R.id.txt_open_album:
                try {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission
                            .READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                            ContextCompat.checkSelfPermission(this, Manifest.permission
                                    .WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission
                                .READ_EXTERNAL_STORAGE, Manifest.permission
                                .WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_STORAGE);
                    } else {
                        uploadImageHelper.openPhotoAlbum();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dialog.dismiss();
                break;
            //取消
            case R.id.txt_cancel:
                dialog.dismiss();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uploadImageHelper.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String content = data.getStringExtra(INPUT_CONTENT);
            if (!TextUtils.isEmpty(content)) {
//                switch (requestCode) {
//                    case Constant.REQUEST_100:
//                        tvNickName.setText(content);
//                        break;
//                    case Constant.REQUEST_101:
//                        tvName.setText(content);
//                        break;
//                    case Constant.REQUEST_102:
//                        tvAge.setText(content);
//                        break;
//                    case Constant.REQUEST_103:
//                        tvProfession.setText(content);
//                        break;
//                    case Constant.REQUEST_104:
//                        tvEmail.setText(content);
//                        break;
//                    default:
//                        break;
//                }
            }
        }
    }
}
