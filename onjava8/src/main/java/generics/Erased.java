package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/13 6:05 下午
 */

// Erased.java
public class Erased <T> {
    private final int SIZE = 100;
    public void f(Object arg) {
        // error: illegal generic type for instanceof
        // 无法对泛型参数 T 使用 instanceof 操作符
     /*   if (arg instanceof T) {

        }*/

        // error: unexpected type
        // 不能实例化 T 类型的对象 因为 T 不是一个确切的类
        //T t = new T();

        // error: generic array creation
        // 同理，不能创建 T类型的数组 但是可以进行类型强转创建数组
        //T[] array = new T[SIZE];
        // warning: [unchecked] unchecked cast
        T[] array = (T[]) new Object[SIZE];
    }
}
