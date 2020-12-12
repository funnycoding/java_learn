package polymorphism;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/28 1:50 下午
 */

class Father {
    void fatherMethod() {
        System.out.println("Father Method Invoked");
    }
}

class Son extends Father {
/*    void sonMethod() {
        System.out.println("Just Son Have this Method");
    }*/

    @Override
    void fatherMethod() {
        System.out.println("Son's Father Method");
        super.fatherMethod();
    }
}

public class FatherTest {
    public static void main(String[] args) {
        // 向下转型
        //Son s = (Son) new Father();
        //s.fatherMethod();

        Father s = (Son)new Father();
        s.fatherMethod();

        // 向上转型
        Father f = new Son();
        f.fatherMethod();
    }



}
