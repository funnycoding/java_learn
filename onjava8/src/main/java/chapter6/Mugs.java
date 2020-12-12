package chapter6;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/9/8 3:15 下午
 */

class Mug {
    public Mug(int marker) {
        System.out.println("Mug(" + marker + ")");
    }
}

public class Mugs {
    Mug mug1;
    Mug mug2;

    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        System.out.println("代码块初始化 mug1 mug2");
    }

    Mugs() {
        System.out.println("Mugs 构造函数");
    }

    Mugs(int marker) {
        System.out.println("Mugs(int) 构造函数");
    }

    public static void main(String[] args) {
        System.out.println("Main函数");
        new Mugs();
        System.out.println("无参 Mugs 构造完成");
        new Mug(1);
        System.out.println("有参 Mugs 否早完成");
    }
}
