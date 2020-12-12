package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pets.Cat;
import pets.Dog;
import pets.Pet;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/16 3:07 下午
 */
// generics/CheckedList.java
// Using Collection.checkedList()
// 使用集合工具检查 List 类型
public class CheckedList {
    // 这里是一个没有使用泛型的 List 集合，所以什么对象都可以放进去
    // 这里看名字应该是一个只存储 Dog 对象的集合，然而这里我们放了一个 Cat() 进去
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        ArrayList<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1); // 在这个泛型参数类型为 Dog 的 ArrayList 中，放入了一个 Cat() 对象
        // 一个带类型检查的List
        List<Dog> dogs2 = Collections.checkedList(new ArrayList<>(), Dog.class);

        try {
            oldStyleMethod(dogs2); // 往带类型检查的 List 中 放入与类型不符的对象就会抛出运行时异常
        } catch (Exception e) {
            System.out.println("Excepted :" + e);
        }
        System.out.println("父类类型检查例子：");
        // Derived types work fine: 当类型检查为父类时，向集合中添加子类的对象不会引起异常
        List<Pet> pets = Collections.checkedList(
                new ArrayList<>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());

    }
}
