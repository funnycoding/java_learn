package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/13 3:23 下午
 */

public class TestBed {
    public void f() {
        System.out.println("f()");
    }

    public static class Tester {
        public static void main(String[] args) {
            TestBed testBed = new TestBed();
            testBed.f();
        }
    }
}

