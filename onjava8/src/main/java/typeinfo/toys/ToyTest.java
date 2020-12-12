package typeinfo.toys;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/28 6:52 下午
 */
// typeinfo/toys/ToyTest.java
// 测试 Class 类
interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    Toy() {
    }

    Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    public FancyToy() {
        super(1);
    }
}


public class ToyTest {
    static void printInfo(Class clazz) {
        // 打印类名，以及是否是接口类型
        System.out.println("ClassName: " + clazz.getName() + "," + " is interface?[" + clazz.isInterface() + "]");
        // 打印简单类型
        System.out.println("Simple Nmae : " + clazz.getSimpleName());
        // 打印规范类名
        System.out.println("Canonical name: " + clazz.getCanonicalName());
    }

    public static void main(String[] args) {
        Class clazz = null;
        try {
            System.out.println("开始使用Class.forName 加载 FancyToy");
            clazz = Class.forName("typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        System.out.println("--- 开始打印 FancyToy 的Class 信息 ---");
        printInfo(clazz);
        System.out.println("--- FancyToy的Class 信息打印完毕 ---");
        System.out.println("---- 开始遍历 FancyTot的所有父类接口的类型信息 ----");
        for (Class face : clazz.getInterfaces()) { // 获取到一个类的所有接口信息
            printInfo(face);
        }
        System.out.println("---- FancyTot的所有父类接口的类型信息 遍历打印完毕 ----");

        System.out.println("开始获取FancyToy的父类信息");
        Class superclass = clazz.getSuperclass();
        Object obj = null;

        try {
            System.out.println("开始用父类的Class对象构造一个对象的实例");
            obj = superclass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("Can't Access");
            System.exit(1);
        }
        System.out.println("开始打印父类对象的Class信息");
        printInfo(obj.getClass());
    }
}
