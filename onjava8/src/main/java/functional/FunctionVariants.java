package functional;

import java.util.StringJoiner;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.LongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 12:59 上午
 */

// 一个使用内置函数式接口进行各种基础操作的例子
// FunctionVariants.java
class Foo {
    @Override
    public String toString() {
        return new StringJoiner(", ", Foo.class.getSimpleName() + "[", "]")
                .toString();
    }
}

class Bar {
    // 持有一个Foo对象引用
    Foo f;

    public Bar(Foo f) {
        this.f = f;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Bar.class.getSimpleName() + "[", "]")
                .add("f=" + f)
                .toString();
    }
}

class IBaz {
    int i;
    public IBaz(int i) {
        this.i = i;
    }
}

class LBaz {
    long l;

    public LBaz(long l) {
        this.l = l;
    }
}

class DBaz {
    double d;

    public DBaz(double d) {
        this.d = d;
    }
}


public class FunctionVariants {
    // 使用内置接口，这里 Bar/ IBaz / LBaz / DBaz 与对应接口的函数方法签名和返回值一致
    static Function<Foo, Bar> f1 = f -> new Bar(f); // 传入一个 f 返回一个 Bar 符合 Function 的 apply() 函数
    static IntFunction<IBaz> f2 = i -> new IBaz(i); // 返回和入参相同类型的方法 apply()
    static LongFunction<LBaz> f3 = l -> new LBaz(l);
    static DoubleFunction<DBaz> f4 = d -> new DBaz(d);

    static ToIntFunction<IBaz> f5 = ib -> ib.i; // 返回 int
    static ToLongFunction<LBaz> f6 = lb -> lb.l; // 返回 long
    static ToDoubleFunction<DBaz> f7 = db -> db.d; // 返回 double

    static IntToLongFunction f8 = i -> i; // 入参 int 出参 long 入参类型比出参小，不用进行数据类型强转
    static IntToDoubleFunction f9 = i -> i;  // 入参 int 出参 double 入参类型比出参小，不用进行数据类型强转
    static LongToIntFunction f10 = l -> (int) l; // Long 转 int ，因为出参类型比入参小，需要在方法中进行强转
    static LongToDoubleFunction f11 = l -> l;  // Long 转 double ，不用进行数据类型强转
    static DoubleToIntFunction f12 = d -> (int) d; // double 转 int ，向下转换，需要强转
    static DoubleToLongFunction f13 = d -> (long) d; // double 转 long，强转

    public static void main(String[] args) {

        // Function 的 apply() 函数就是 根据入参生成出参两种类型变量。 这里就是根据 Foo对象构造 Bar对象
        Bar b = f1.apply(new Foo()); // 使用 Foo() 作为材料生成一个 Bar 对象
        System.out.println(b);
        // 对象的构建，根据对应的入参
        IBaz ib = f2.apply(11);
        LBaz lb = f3.apply(11);
        DBaz dBaz = f4.apply(11);

        // 获取 对象中的 int
        int i = f5.applyAsInt(ib);
        // 获取对象中的 long
        long l = f6.applyAsLong(lb);
        // 获取对象中的 double
        double d = f7.applyAsDouble(dBaz);

        // int 转 long
        l = f8.applyAsLong(12);
        // int 转 double
        d = f9.applyAsDouble(12);
        // long 转 int
        i = f10.applyAsInt(12);

        // long 转 double
        d = f11.applyAsDouble(12);
        // double 转 int
        i = f12.applyAsInt(13.0);
        // double 转 long
        l = f13.applyAsLong(13.0);
    }
}
