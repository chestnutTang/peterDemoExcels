package demo.third.com.exceldemo.utils;


/**
 * Created by apple on 2017/8/23.
 */

public class EncryptPassUtils {

    public static int passWord(int x, int y) {
        int i = (x - y) * (x + y);
        return i;
    }

    public static int getPassWord() {
        return passWord(Constant.SEED11, Constant.SEED10);
    }
}
