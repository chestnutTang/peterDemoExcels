package demo.third.com.exceldemo.utils;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextView;


/**
 * peterDemoExcels
 * Created by szp
 * on 2018.05.14
 * 计时器，一般用于验证码
 */
public class MyTimer extends CountDownTimer {


    private TextView textView;

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public MyTimer(long millisInFuture, long countDownInterval, final TextView textView) {
        super(millisInFuture, countDownInterval);
        this.textView = textView;
    }

    @Override
    public void onTick(long millisUntilFinished) {
//        textView.setTextColor(Color.parseColor("#c6c6c6"));
//        textView.setBackgroundResource(R.drawable.send_code_wait);
        textView.setClickable(false);
        //c6c6c6
        textView.setText(millisUntilFinished / 1000 + "秒后重试");
    }

    @Override
    public void onFinish() {
        textView.setText("再次发送");
//        textView.setTextColor(Color.parseColor("#FB6749"));
//        textView.setBackgroundResource(R.drawable.send_code);
        textView.setClickable(true);
    }
}
