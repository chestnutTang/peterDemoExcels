package demo.third.com.exceldemo.ui.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.ui.views.GlideCircleTransform;
import demo.third.com.exceldemo.ui.views.OkRequestParams;
import demo.third.com.exceldemo.utils.Constant;
import demo.third.com.exceldemo.utils.JumpTools;
import demo.third.com.exceldemo.utils.Link;
import demo.third.com.exceldemo.utils.PreferenceHelper;
import demo.third.com.exceldemo.utils.Tools;
import demo.third.com.exceldemo.utils.UploadImageHelper;
import okhttp3.Call;

import static demo.third.com.exceldemo.utils.Constant.INPUT_CONTENT;

/**
 * @author songzhengpeng
 * 个人信息页面
 */
public class MyInfoActivity extends BaseActivity {

    @BindView(R.id.iv_backup)
    ImageView ivBackup;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_jump)
    TextView tvJump;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.rel_head)
    RelativeLayout relHead;
    @BindView(R.id.et_nick_name)
    EditText etNickName;
    @BindView(R.id.rel_nick_name)
    RelativeLayout relNickName;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.rel_name)
    RelativeLayout relName;
    @BindView(R.id.tv_age)
    TextView tvAge;
    @BindView(R.id.rel_age)
    RelativeLayout relAge;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.rl_phone)
    RelativeLayout rlPhone;
    @BindView(R.id.et_city)
    EditText etCity;
    @BindView(R.id.rl_city)
    RelativeLayout rlCity;
    @BindView(R.id.et_profession)
    EditText etProfession;
    @BindView(R.id.rel_profession)
    RelativeLayout relProfession;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.rel_email)
    RelativeLayout relEmail;

    private Serializable imageUrl;
    private String myUpLoadUrl;
    private UploadImageHelper uploadImageHelper;
    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    private static final int MY_PERMISSIONS_REQUEST_STORAGE = 200;
    private Dialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUploadImageHelper();
        tvJump.setTextColor(Color.parseColor("#000000"));
    }

    /**
     * 更新个人信息
     */
    private void updateInfo() {
        OkRequestParams params = new OkRequestParams();
        params.put("id", PreferenceHelper.getInstance().getId() + "");
        params.put("nickName", etNickName.getText().toString());
        params.put("realName", etName.getText().toString());
        params.put("email", etEmail.getText().toString());
        params.put("age", tvAge.getText().toString());
        params.put("city", etCity.getText().toString());
        params.put("occupation", etProfession.getText().toString());
        OkHttpUtils.post().url(Link.UPDATE).params(params)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                finish();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine;
    }

    @OnClick({R.id.iv_backup, R.id.tv_jump, R.id.rel_head, R.id.rel_age})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backup:
                finish();
                break;
            case R.id.tv_jump:
                Tools.toast("保存数据");
                updateInfo();

                break;
            case R.id.rel_head:
                showPicChoseDialog("相机", "相册", "取消");
                break;
            case R.id.rel_age:
                Tools.showDateChoice(MyInfoActivity.this, tvAge);
                break;
//            case R.id.rel_nick_name:
//                JumpTools.jumpWithRequestCodeAndFlag(MyInfoActivity.this, InputInfoActivity
//                        .class, Constant.REQUEST_100, "nick");
//                break;
//            case R.id.rel_name:
//                JumpTools.jumpWithRequestCodeAndFlag(MyInfoActivity.this, InputInfoActivity
//                        .class, Constant.REQUEST_101, "name");
//                break;
//            case R.id.rel_age:
//                JumpTools.jumpWithRequestCodeAndFlag(MyInfoActivity.this, InputInfoActivity
//                        .class, Constant.REQUEST_102, "age");
//                break;
//            case R.id.rel_profession:
//                JumpTools.jumpWithRequestCodeAndFlag(MyInfoActivity.this, InputInfoActivity
//                        .class, Constant.REQUEST_103, "profession");
//                break;
//            case R.id.rel_email:
//                JumpTools.jumpWithRequestCodeAndFlag(MyInfoActivity.this, InputInfoActivity
//                        .class, Constant.REQUEST_104, "email");
//                break;
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
                        .apply(new RequestOptions().transform(new GlideCircleTransform
                                (getApplicationContext())))
                        .into(ivHead);
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

        dialog = new Dialog(MyInfoActivity.this, R.style.transparentFrameWindowStyle);
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
