package demo.third.com.exceldemo.utils;


/**
 *
 * @author apple
 * @date 2017/8/23
 */

public class EncryptPassUtils2 {

    public static int passWord(int x, int y) {
        int i = (8 * x - 2 * y) * (6 * x + 4 * y);
        return i;
    }

    public static int getPassWord() {
        return passWord(Constant.SEED00, Constant.SEED01);
    }

}
