package chapter6;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description 显示的静态初始化 —— 使用静态代码块
 * @date 2020/9/8 3:09 下午
 */

public class Spoon {
    static int i;
    static {
        i = 47;
    }

    public static void main(String[] args) {
        System.out.println(i);
    }
}
