package demo.third.com.exceldemo.utils;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.widget.TextView;


/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.14
 * 计时器，一般用于验证码
 */
public class MyTimer extends CountDownTimer {


    private TextView textView;

    private String fromFlag;
    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public MyTimer(long millisInFuture, long countDownInterval, final TextView textView,String fromFlag) {
        super(millisInFuture, countDownInterval);
        this.textView = textView;
        this.fromFlag = fromFlag;
    }

    @Override
    public void onTick(long millisUntilFinished) {
//        textView.setTextColor(Color.parseColor("#c6c6c6"));
//        textView.setBackgroundResource(R.drawable.send_code_wait);

        //c6c6c6
        if (!TextUtils.isEmpty(fromFlag)){
            if (TextUtils.equals("Welcome",fromFlag)){
                textView.setText("跳过("+(millisUntilFinished / 1000) + "s)");
                textView.setClickable(true);
            }else if (TextUtils.equals("login",fromFlag)){
                textView.setText(millisUntilFinished / 1000 + "秒后重试");
                textView.setClickable(false);
            }
        }

    }

    @Override
    public void onFinish() {
        if (!TextUtils.isEmpty(fromFlag)){
            if (TextUtils.equals("Welcome",fromFlag)){
                textView.setText("0");
            }else if (TextUtils.equals("login",fromFlag)){
                textView.setText("再次发送");
            }
        }
        textView.setClickable(true);
//        textView.setTextColor(Color.parseColor("#FB6749"));
//        textView.setBackgroundResource(R.drawable.send_code);
    }
}
