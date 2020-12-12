package arrays;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/7 7:46 下午
 */
// arrays/ArrayOfGenericType.java

public class ArrayOfGenericType<T> {
    T[] array; // OK

    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size) {
        //array = new T[size]; // 这里编译器报错，告诉你需要将 T 更换为更具体的类型，因为泛型擦除时类型参数的本质都是 Object。
        array = (T[]) new Object[size]; // Ok
    }

    @SuppressWarnings("unchecked")
    public <U> U[] makeArry() {
        //return new U[10]; // 提示跟上面一样，需要更换为更具体的类型，而不能使用泛型类型来创建数组；
        return  (U[]) new Object[10]; // 这样就可以了
    }
}
