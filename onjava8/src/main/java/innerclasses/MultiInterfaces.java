package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 3:51 下午
 */

interface A{}

interface B{}

// 第一种选择， 外部类同时实现2个接口
class X implements A, B {}

// 第二种选择，外部类实现一个接口，使用匿名内部类获得第二种接口的引用，在匿名内部类中实现接口功能
class Y implements A {
    B makeB() {
        return new B() {

        };
    }
}

public class MultiInterfaces {
    static void takesA(A a) {}
    static void takesB(B a) {}

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        
        takesA(x);
        takesA(y);

        takesB(x);
        takesB(y.makeB());
    }
}
