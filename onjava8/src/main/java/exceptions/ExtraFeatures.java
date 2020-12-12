package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 3:28 下午
 */

// ExtraFeatures.java
class MyException2 extends Exception {
    private int x;

    public MyException2() {
    }

    public MyException2(String message) {
        super(message);
    }

    public MyException2(String message, int x) {
        super(message);
        this.x = x;
    }

    public int val() {
        return x;
    }

    @Override
    public String getMessage() {
        return "Detail Message: " + x + " " + super.getMessage();
    }
}

public class ExtraFeatures {
    public static void f() throws MyException2 {
        System.out.println("Throwing MyException2 from f()");
        throw new MyException2();
    }

    public static void g() throws MyException2 {
        System.out.println("Throwing MyException2 from h()");
        throw new MyException2("Originated in g()");
    }

    public static void h() throws MyException2 {
        System.out.println("Throwing MyException2 from h()");
        throw new MyException2("Originated in h()", 47);
    }


    public static void main(String[] args) {
        try {
            f();
        } catch (MyException2 myException2) {
            myException2.printStackTrace(System.out);
        }

        try {
            g();
        } catch (MyException2 myException2) {
            myException2.printStackTrace(System.out);
        }

        try {
            h();
        } catch (MyException2 myException2) {
            myException2.printStackTrace(System.out);
            System.out.println("e.val() = " + myException2.val());
        }
    }
}
