package typeinfo.toys;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/28 8:19 下午
 */
// typeinfo/toys/GenericToyTest.java
// 测试 Class 类
// {java typeinfo.toys.GenericToyTest}
public class GenericToyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        // 通过类字面量获取 Class 对象
        Class<FancyToy> ftClass = FancyToy.class;

        // 通过泛型的 Class 对象生成具体的类
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> superclass = ftClass.getSuperclass();
        // This won't compile: 下面的语句不能编译 无法通过 Class<FancyToy> 生成 Class<Toy>
        // 因为 Class<Toy> 不是 Class<FancyToy> 的父类
        // 具体还是跟泛型的擦除有关
        // Class<Toy> up2 = ftClass.getSuperclass();

        // 只能构造 Object对象 而不是 Toy 对象 然后对Object进行类型转换
        Toy object = (Toy) superclass.newInstance();
    }
}
