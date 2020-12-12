package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/13 2:38 下午
 */

// 关于擦除和继承类的Demo
// generics/ErasureAndInheritance.java
class GenericBase<T> {
    private T element;

    public void set(T t) {
        element = t;
    }

    public T get() {
        return element;
    }
}


class Derved1<T> extends GenericBase<T> {

}

class Dervied2 extends GenericBase { // 这里编译器会提示你在使用Raw-Type 类型的 GenericBase
}

// 语法错误
// 这里编译器无法确定 GenericBase 的类型参数
// 必须提供类或接口
/*
class Derived3 extends GenericBase<?> {
}
*/


public class ErasureAndInheritance<T> {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Dervied2 dervied2 = new Dervied2();
        Object o = dervied2.get();
        dervied2.set(o); // 如果不使用注解忽视 unchecked warring的话，这里编译器会告诉你 编译器无法根据泛型来进行类型检测
    }

}
