package demo.third.com.exceldemo.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import demo.third.com.exceldemo.R;
import demo.third.com.exceldemo.utils.BitmapUtil;
import demo.third.com.exceldemo.utils.Logger;
import demo.third.com.exceldemo.utils.StringBitmapParameter;

import static demo.third.com.exceldemo.ui.activity.LoginActivity.lin_login_root;
import static demo.third.com.exceldemo.utils.Tools.getScreenShotBitmap;

/**
 * @author peter
 */
public class TextToImageActivity extends BaseActivity {

    private Button imageBtn;
    private ImageView mView;
    private ScrollView scroll_view;
    private LinearLayout activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageBtn = (Button) findViewById(R.id.p_image);
        mView = (ImageView) findViewById(R.id.s_image);
        scroll_view = (ScrollView) findViewById(R.id.scroll_view);
        activity_main = (LinearLayout) findViewById(R.id.activity_main);


        imageBtn.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_text_to_image;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.p_image:
//                ImageTask mImageTask = new ImageTask();
//                mImageTask.execute("");
                Glide.with(getApplicationContext()).load(getScreenShotBitmap(lin_login_root)).into(mView);
                break;
            default:
                break;
        }
    }



    public static Bitmap loadBitmapFromView(View v, int width, int height) {
        Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(0, 0, v.getLayoutParams().width, v.getLayoutParams().height);
        v.draw(c);
        return b;
    }

    private class ImageTask extends AsyncTask<String, Integer, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... params) {
            return null;
//            return creatImage();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            imageBtn.setText("正在生成 - 请等待 不要着急");
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageBtn.setText("生成");
//            mView.setImageBitmap(bitmap);
            Glide.with(getApplicationContext()).load(bitmap).into(mView);
        }
    }

    private Bitmap creatImage() {
        try {
            InputStream ins = getAssets().open("res" + File.separator + "print.bmp");
            Bitmap imageBitmap = BitmapFactory.decodeStream(ins);
            ArrayList<StringBitmapParameter> mParameters = new ArrayList<>();

            mParameters.add(new StringBitmapParameter("\n"));
            mParameters.add(new StringBitmapParameter("\n"));
            mParameters.add(new StringBitmapParameter("商户存根联"));
            mParameters.add(new StringBitmapParameter("用户名称(MERCHANT NAME):江苏东大集成电路系统工程技术有限公司"));
            mParameters.add(new StringBitmapParameter("\n"));
            mParameters.add(new StringBitmapParameter("商户编号(MERCHANT NO): 304301057328106"));
            mParameters.add(new StringBitmapParameter("终端编号(TEBMINAL NO): 00706937"));
            mParameters.add(new StringBitmapParameter("操作员号: 01"));
            mParameters.add(new StringBitmapParameter("卡号(CARD NO)"));
            mParameters.add(new StringBitmapParameter("12345678901212(C)", BitmapUtil.IS_RIGHT));
            mParameters.add(new StringBitmapParameter("\n"));
            mParameters.add(new StringBitmapParameter("发卡行(ISSUER):工商银行"));
            mParameters.add(new StringBitmapParameter("收单行(ACQUIRER):华夏银行"));
            mParameters.add(new StringBitmapParameter("交易类别(TXN TYPE):"));
            mParameters.add(new StringBitmapParameter(" 消费撤销(VOID)"));
            mParameters.add(new StringBitmapParameter("-------------------------"));
            mParameters.add(new StringBitmapParameter("持卡人签名CARD HOLDER SIGNATURE:"));
            mParameters.add(new StringBitmapParameter("\n"));
            mParameters.add(new StringBitmapParameter("\n"));
            mParameters.add(new StringBitmapParameter("\n"));

            mParameters.add(new StringBitmapParameter("模拟农行打印凭条", BitmapUtil.IS_CENTER, BitmapUtil.IS_LARGE));
            mParameters.add(new StringBitmapParameter("\n"));
            mParameters.add(new StringBitmapParameter("\n"));
            mParameters.add(new StringBitmapParameter("商户存根联           请妥善保管"));
            mParameters.add(new StringBitmapParameter("-------------------------"));
            mParameters.add(new StringBitmapParameter("用户名称(MERCHANT NAME):"));
            mParameters.add(new StringBitmapParameter("苏州农行直连测试商户", BitmapUtil.IS_RIGHT));
            mParameters.add(new StringBitmapParameter("商户编号(MERCHANT NO):"));
            mParameters.add(new StringBitmapParameter("113320583980037", BitmapUtil.IS_RIGHT));
            mParameters.add(new StringBitmapParameter("终端编号(TEBMINAL NO): 10300751"));
            mParameters.add(new StringBitmapParameter("操作员号(OPERATOR NO):     01"));
            mParameters.add(new StringBitmapParameter("-------------------------"));
            mParameters.add(new StringBitmapParameter("发卡行(ISSUER)"));
            mParameters.add(new StringBitmapParameter("农业银行", BitmapUtil.IS_RIGHT));
            mParameters.add(new StringBitmapParameter("收单行(ACQUIRER)"));
            mParameters.add(new StringBitmapParameter("农业银行", BitmapUtil.IS_RIGHT));
            mParameters.add(new StringBitmapParameter("卡号(CARD NO)"));
            mParameters.add(new StringBitmapParameter("12345678901212(C)", BitmapUtil.IS_RIGHT, BitmapUtil.IS_LARGE));
            mParameters.add(new StringBitmapParameter("卡有效期(EXP DATE)     2023/10"));
            mParameters.add(new StringBitmapParameter("交易类型(TXN TYPE)"));
            mParameters.add(new StringBitmapParameter("消费", BitmapUtil.IS_RIGHT, BitmapUtil.IS_LARGE));
            mParameters.add(new StringBitmapParameter("-------------------------"));
            mParameters.add(new StringBitmapParameter("交易金额未超过300.00元，无需签名"));

            ArrayList<StringBitmapParameter> mParametersEx = new ArrayList<>();/**如果是空的列表，也可以传入，会打印空行*/
            mParametersEx.add(new StringBitmapParameter("\n"));
            mParametersEx.add(new StringBitmapParameter("\n"));
            mParametersEx.add(new StringBitmapParameter("\n"));

            Bitmap textBitmap = BitmapUtil.StringListtoBitmap(TextToImageActivity.this, mParameters);
            Bitmap textBitmap2 = BitmapUtil.StringListtoBitmap(TextToImageActivity.this, mParametersEx);

            Bitmap mergeBitmap = BitmapUtil.addBitmapInHead(imageBitmap, textBitmap);

            Bitmap mergeBitmap2 = BitmapUtil.addBitmapInFoot(mergeBitmap, imageBitmap);
            Bitmap mergeBitmap3 = BitmapUtil.addBitmapInFoot(mergeBitmap2, textBitmap2);

            Logger.e("fmx", "argb_8888 =  " + mergeBitmap3.getHeight() * mergeBitmap3.getWidth() * 32);
            Logger.e("fmx", "rgb_565 =  " + mergeBitmap3.getHeight() * mergeBitmap3.getWidth() * 16);
            return mergeBitmap3;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
