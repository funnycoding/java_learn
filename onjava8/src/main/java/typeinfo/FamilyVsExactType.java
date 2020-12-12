package typeinfo;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/4 4:35 下午
 */

//  typeinfo/FamilyVsExactType.java
// instanceof 与 class 的差别
class Base {
}

class Derived extends Base {
}


public class FamilyVsExactType {
    static void test(Object x) {
        System.out.println("Testing x of type " + x.getClass());
        System.out.println("x instance of Base: " + (x instanceof Base));
        System.out.println("x instanceof Derived: " + (x instanceof  Derived));
        System.out.println("Base.isInstance(x): " + Base.class.isInstance(x));
        System.out.println("Derived.isInstance(x): " + Derived.class.isInstance(x));
        System.out.println("x.getClass() == Base.class: " + (x.getClass() == Base.class));
        System.out.println("x.getClass() == Derived.class: " + (x.getClass() == Derived.class));
        System.out.println("x.getClass.equals(Base.class): " + x.getClass().equals(Base.class));
        System.out.println("x.getClass.equals(Derived.class): " + x.getClass().equals(Derived.class));
    }

    public static void main(String[] args) {
        System.out.println("test Base");

        test(new Base());
        System.out.println("--------------");

        System.out.println("test Derived");
        test(new Derived());
    }
}
