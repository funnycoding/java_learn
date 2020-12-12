package interfaces;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/11 2:00 下午
 */


interface Concept {
    void idea1();

    void idea2();

    default void idea3() {
        System.out.println("default method idea3");
    }
}


public class ImplementingAnInterface implements Concept {
    @Override
    public void idea1() {
        System.out.println("idea1");
    }

    @Override
    public void idea2() {
        System.out.println("idea2");
    }

    public static void main(String[] args) {
        ImplementingAnInterface implementingAnInterface = new ImplementingAnInterface();
        implementingAnInterface.idea3();
    }
}
