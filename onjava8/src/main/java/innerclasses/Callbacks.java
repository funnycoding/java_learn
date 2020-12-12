package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 5:49 下午
 */

interface Incrementable {
    void increment();
}

// 实现类1
class Callee1 implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        System.out.print("Callee1 increment(): ");
        i++;
        System.out.println(i);
    }
}

class MyIncrement {
    public void increment() {
        System.out.println("Other Operation");
    }

    static void f(MyIncrement mi) {
        System.out.println("My Increment f() 被调用");
        mi.increment();
    }
}

// If your class must implement increment() in
// some other way, you must use an inner class:

//如果你的类必须用其他方法实现 increment()函数，则你必须使用内部类


class Callee2 extends MyIncrement {
    // 覆写MyIncrement的函数
    private int i = 0;

    @Override
    public void increment() {
        System.out.print("Callee2 increment() 被调用");
        super.increment();
        i++;
        System.out.println("c2 :" + i);
    }

    private class Closure implements Incrementable {

        // Specify outer-class method, otherwise
        // you'll get an infinite recursion:
        // 使用外部类的 increment方法，否则会发生无限递归
        // 这个外部类.this.increment() 的语法
        @Override
        public void increment() {
            Callee2.this.increment();
            //System.out.println("试试无限递归");
        }

    }

    // 获取回调引用
    Incrementable getCallbackReference() {
        return new Closure();
    }
}

// 根据回调引用调用其对象方法的类
class Caller {
    private Incrementable callbackReference;

    public Caller(Incrementable cbh) {
        this.callbackReference = cbh;
    }

    void go() {
        callbackReference.increment();
    }
}

public class Callbacks {
    public static void main(String[] args) {
        // 实现类1的对象 直接实现了 Incrementable 接口
        Callee1 c1 = new Callee1();

        // 没有实现 incrementable 接口，其实现类定义了名称相同的 increment()函数
        Callee2 c2 = new Callee2();

        //todo  第一句输出语句来自这里
        MyIncrement.f(c2);

        // 生成Caller对象 ,其入参是 Incrementable 类型
        Caller caller1 = new Caller(c1);
        // 这里这个 c2.getCallbackReference 获取的是 Callee2的实现了 Incretable的内部类的实例对象
        Caller caller2 = new Caller(c2.getCallbackReference());

        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }

}
