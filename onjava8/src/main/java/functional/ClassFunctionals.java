package functional;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 1:41 上午
 */

class AA {
}

class BB {
}

class CC {
}


public class ClassFunctionals {
    static AA f1() {
        return new AA();
    }

    static int f2(AA a1, AA a2) {
        return 1;
    }

    static void f3(AA aa) {
        System.out.println("f3被调用了");
    }

    static void f4(AA aa, BB bb) {

    }

    static CC f5(AA aa) {
        System.out.println("f5被调用了，入参AA，返回值CC");
        return new CC();
    }

    static CC f6(AA aa, BB bb) {
        return new CC();
    }

    static boolean f7(AA aa) {
        return true;
    }

    static boolean f8(AA aa, BB bb) {
        return true;
    }

    static AA f9(AA aa) {
        return new AA();
    }

    static AA f10(AA aa1, AA aa2) {
        return new AA();
    }
    // 这10个方法基本是这几个类作为参数来回换
    public static void main(String[] args) {
        // 返回对应AA类型 Supplier
        Supplier<AA> s = ClassFunctionals::f1;
        s.get(); // x相当于调用 AA的 f1函数，创建一个 AA 对象
        Comparator<AA> comparator = ClassFunctionals::f2;
        comparator.compare(new AA(), new AA());

        // 将f3赋值给参数类型为AA的Consumer接口
        Consumer<AA> cons = ClassFunctionals::f3;
        // 调用对应的 accept方法
        cons.accept(new AA());

        BiConsumer<AA, BB> bicons = ClassFunctionals::f4;
        bicons.accept(new AA(), new BB());

        Function<AA, CC> f = ClassFunctionals::f5;
        CC apply = f.apply(new AA());

        BiFunction<AA, BB, CC> bif = ClassFunctionals::f6;
        bif.apply(new AA(), new BB());

        Predicate<AA> p = ClassFunctionals::f7;
        boolean result = p.test(new AA());

        BiPredicate<AA, BB> bip = ClassFunctionals::f8;
        result = bip.test(new AA(), new BB());

        UnaryOperator<AA> uo = ClassFunctionals::f9;
        AA aa = uo.apply(new AA());
        BinaryOperator<AA> bo = ClassFunctionals::f10;
        aa = bo.apply(new AA(), new AA());

    }
}
