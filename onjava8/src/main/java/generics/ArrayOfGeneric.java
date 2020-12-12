package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/13 8:44 下午
 */

// generics/ArrayOfGeneric.java

public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try {
            // 创建一个 Object 数组并将其强转为 Generic<Integer> 数组
            gia = (Generic<Integer>[]) new Object[SIZE];
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
        // Runtime type is the raw (erased) type:
        // 运行时类型是泛型擦除的
        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<>();
        //gia[1] = new Object(); // Compile-time error  编译器告诉你需要一个 Generic 类
        // Discovers type mismatch at compile time:
        //gia[2] = new Generic<Double>(); // 类型参数错误，之前顶一个 Generic[] 的类型参数是 Integer

    }
}
