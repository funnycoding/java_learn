package typeinfo;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/28 8:05 下午
 */
// typeinfo/BoundedClassReferences.java
public class BoundedClassReferences {
    public static void main(String[] args) {
        // 可以指向任何任何 Number 的子类的Class对象
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;

    }
}
