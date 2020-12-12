package functional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/17 8:24 下午
 */

// FunctionalAnnotation.java
// 加了这个注解接口就只能存在1个抽象方法
@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

// 不加注解也没事，注解只是一个强制校验 当抽象方法的数量超过一个的时候会报错，而不加注解则该接口就成为非函数式接口
interface FunctionalNoAnn {
    String goodbye(String arg);
}

/*
以下是一个使用 @FunctionalInterface注解标示为函数式接口但是存在多个抽象方法的例子，编译器会报错。

@FunctionalInterface
interface NotFunctional {
  String goodbye(String arg);
  String hello(String arg);
}
产生错误信息:
NotFunctional is not a functional interface
multiple non-overriding abstract methods
found in interface NotFunctional
 因为如果使用了 @FunctionalInterface 注解，那么接口中只能存在一个抽象函数
*/


public class FunctionalAnnotation {
    // 与接口中返回值与签名一样的未绑定方法
    public String classGoodBye(String arg) {
        return "Good bye" + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        // 方法引用赋值
        Functional f = fa::classGoodBye;
        FunctionalNoAnn fna = fa::classGoodBye;
        // 对象的实例赋值给接口的引用，因为没有实现
        //Functional fac = fa; // 编译器报错

        // 使用 Lambda形式实现 Function接口的函数 这里编译器会自动推导出返回值为 String类型
        Functional fl = a -> "GoodBye Lambda," + a;
        Functional fnal = a -> "GoodBye Lambda With No Annotation," + a;
        System.out.println(fl.goodbye("fl方法被调用"));
        System.out.println(fnal.goodbye("fnal方法被调用"));
    }
}
