package generics;

import java.util.StringJoiner;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/14 10:07 下午
 */
// generics/CovariantArrays.java

class Fruit {

}

class Apple extends Fruit {
    @Override
    public String toString() {
        return new StringJoiner(", ", Apple.class.getSimpleName() + "[", "]")
                .toString();
    }
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
    @Override
    public String toString() {
        return new StringJoiner(", ", Orange.class.getSimpleName() + "[", "]")
                .toString();
    }
}


public class CovariantArrays {
    public static void main(String[] args) {
        // 父类引用指向子类数组
        Fruit[] fruits = new Apple[10];

        fruits[0] = new Apple(); // ok 将子类对象存入数组
        fruits[1] = new Jonathan(); // ok 子类的子类存入数组

        try {
            // 编译器允许将父类对象存入指向子类的数组中
            fruits[0] = new Fruit(); // ArrayStoreException  但是实际运行会引发异常

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
