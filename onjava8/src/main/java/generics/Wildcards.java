package generics;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/15 3:28 下午
 */
// generics/Wildcards.java
// Exploring the meaning of wildcards 展示  wildcards 的意义
// 这个例子比较长，有一些场景是重复的
public class Wildcards {
    // Raw Argument 使用 RawType Holder类
    static void rawArgs(Holder holder, Object arg) {
        //holder.set(arg); // 抛出警告，Unchecked 的方法调用

        // Can't do this; don't have any 'T':
        // holdger.get() 的返回值不能是泛型参数 T ,因为这里使用的是 RawType
        // T t = holder.get();
        // OK, but type information is lost:
        // 使用 holdger get 获取 holder 中存储的对象 运行正常，但是丢失了类的具体信息，需要手动进行强转
        Object obj = holder.get();
    }

    // Like rawArgs(), but errors instead of warnings:
    // 和原始类型有点像，但是 上面的警告编程了下面的 Error
    static void unboundedArg(Holder<?> holder, Object arg) {
        // 这里不能确定 Object 是 无界通配符类型的
        // error: method set in class Holder<T>
        // cannot be applied to given types;
        //     holder.set(arg);
        //           ^
        //   required: CAP#1
        //   found: Object
        //   reason: argument mismatch;
        //     Object cannot be converted to CAP#1
        //   where T is a type-variable:
        //     T extends Object declared in class Holder
        //   where CAP#1 is a fresh type-variable:
        //     CAP#1 extends Object from capture of ?
        // 1 error
        //holder.set(arg);

        // OK, but type information is lost: 与上面的一样，获取 Holder 中的对象正常，但是丢失对象类型
        Object obj = holder.get();
    }

    // 这里返回的是具体类型 T 而不是上面的 Object
    static <T> T exact1(Holder<T> holder) {
        return holder.get();
    }

    // 这里将对应 T 类型的元素放入 Holder<T> 很合理，没毛病
    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        return holder.get();
    }

    // 返回 Holder 中持有的对象
    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        // Error 这里需要的是 ? extends T 而不是具体的类型
        //holder.set(arg);
        return holder.get();
    }

    static <T> void wildSuperType(Holder<? super T> holder, T arge) {
        // set 工作正常，因为通配符限制了元素都是 T 类型的父类，所以 T 可以放入 Holder
        holder.set(arge);

        // 但是现在 Holder.get() 无法确定具体类型，只能获得 Object，于是无法返回 T 类型
        Object object = holder.get();

        //- T t = holder.get();
        // error: incompatible types:
        // CAP#1 cannot be converted to T
        //     T t = holder.get();
        //                     ^
        //   where T is a type-variable:
        //     T extends Object declared in method
        //       <T>wildSupertype(Holder<? super T>,T)
        //   where CAP#1 is a fresh type-variable:
        //     CAP#1 extends Object super:
        //       T from capture of ? super T
        // 1 error
    }

    public static void main(String[] args) {
        // Raw Type
        Holder raw = new Holder<>();
        //  或者直接这样
        raw = new Holder();

        // Long 包装器类型的 Holder
        Holder<Long> qualified = new Holder<>();
        // 无界通配符 Holder
        Holder<?> unbounded = new Holder<>();
        // 持有 Long 父类的 Holder
        Holder<? extends Long> bounded = new Holder<>();

        Long lng = 1L;
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        // 都ok
        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        Object o = exact1(raw); // Unchecked Assign 警告 ，因为 raw 是原始类型
        Long aLong = exact1(qualified); // 获得确定的 Long 对象
        Object r3 = exact1(unbounded); // Must return Object 只能返回 Object，不能返回确定类型
        Long r4 = exact1(bounded); // 可以确定其中保存的都是 Long 的子类，所以可以返回父类引用
        Long r5 = exact2(raw, lng); // 使用原始类型，编译器无法确定其中保存的对象类型，给出警告

        Long r6 = exact2(qualified, lng); // 确定类型的泛型，没问题

        //Long r7 = exact2(unbounded, lng); // 无界通配符，无法返回具体类型，只能返回 Object

        // 这里也无法返回具体的 Long 类型对象 这里需要的是 Holder<Long> 而不是 Hodler<? extends Long>
        // 这里传入的 T 是Long  而 bounded 类型是 <? extends Long> 于是无法确定
        //Long r8 = exact2(bounded, lng);

        Long r9 = wildSubtype(raw, lng); // 原始类型的Holder，同样抛出 Unchecked Assign 警告
        Long r10 = wildSubtype(qualified, lng); // 确切泛型 Holder 一直都 Ok
        Object r11 = wildSubtype(unbounded, lng);// 无界通配符只能返回 Object
        Long r12 = wildSubtype(bounded, lng); // 确定返回的都是 Long 类型的子类

        wildSuperType(raw, lng); // Unchecked
        wildSuperType(qualified, lng); // ok

        //wildSuperType(unbounded, lng); error
        // error: method wildSupertype in class Wildcards
        // cannot be applied to given types;
        //     wildSupertype(unbounded, lng);
        //     ^
        //   required: Holder<? super T>,T
        //   found: Holder<CAP#1>,Long
        //   reason: cannot infer type-variable(s) T
        //     (argument mismatch; Holder<CAP#1>
        //     cannot be converted to Holder<? super T>)
        //   where T is a type-variable:
        //     T extends Object declared in
        //     method <T>wildSupertype(Holder<? super T>,T)
        //   where CAP#1 is a fresh type-variable:
        //     CAP#1 extends Object from capture of ?
        // 1 error

        //wildSuperType(bounded, lng); // error
        // error: method wildSupertype in class Wildcards
        // cannot be applied to given types;
        //     wildSupertype(bounded, lng);
        //     ^
        //   required: Holder<? super T>,T
        //   found: Holder<CAP#1>,Long
        //   reason: cannot infer type-variable(s) T
        //     (argument mismatch; Holder<CAP#1>
        //     cannot be converted to Holder<? super T>)
        //   where T is a type-variable:
        //     T extends Object declared in
        //     method <T>wildSupertype(Holder<? super T>,T)
        //   where CAP#1 is a fresh type-variable:
        //     CAP#1 extends Long from capture of
        //     ? extends Long
        // 1 error

    }

}
