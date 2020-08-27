package chapter3;

import com.google.common.annotations.VisibleForTesting;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/8/24 12:58 上午
 */

public class LogMsg {
    public static void main(String[] args) {
        String s2 = "1";
        String s = new String("1");
        s.intern();

        System.out.println(s == s2);
    }
}
