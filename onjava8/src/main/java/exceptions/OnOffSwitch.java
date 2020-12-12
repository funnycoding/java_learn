package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 7:35 下午
 */

public class OnOffSwitch {
    private static Switch sw = new Switch();

    public static void f()
            throws OnOffException1, OnOffException2 {
    }

    public static void main(String[] args) {
        try {
            sw.on();
            f();
            sw.off();
        } catch (OnOffException1 onOffException1) {
            onOffException1.printStackTrace();
            sw.off();
        } catch (OnOffException2 onOffException2) {
            onOffException2.printStackTrace();
            sw.off();
        }
    }
}
