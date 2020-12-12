package exceptions;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/27 4:31 下午
 */

// Human.java
class Annoyance extends Exception {
}

class Sneeze extends Annoyance {

}

public class Human {
    // 捕获更具体的异常类型
    public static void main(String[] args) {
        try {
            throw new Sneeze();
        } catch (Annoyance a) {
            System.out.println("捕获 Anooyance");
        } /*catch (Sneeze s) {

        }*/

        // 捕获基本父类异常
        try {
            throw new Sneeze();
        } catch (Annoyance annoyance) {
            System.out.println("捕获父类异常Anooyance");
        }
    }
}
