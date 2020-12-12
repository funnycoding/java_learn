package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 9:41 下午
 */

// 演示异常怎样被丢失的
// VeryImportantException.java
class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "重要的异常";
    }
}

// 不重要的异常
class HoHumException extends Exception {
    @Override
    public String toString() {
        return "不重要的异常";
    }
}

public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } catch (VeryImportantException e) {
                e.printStackTrace();
            } finally {
                try {
                    lm.dispose();
                } catch (HoHumException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println();
        }
    }
}
