package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/14 10:58 下午
 */
// generics/GenericsAndCovariance.java
public class GnericAndCovariance {
    public static void main(String[] args) {
        // Wildcards allow covariance: 原始类型允许协变
        List<? extends Fruit> fList = new ArrayList<>();
        // 这里是我加的所以也就是可以将父类的 List 引用指向子类List
        List<Apple> aList = new ArrayList<>();
        fList = aList;
        // 下面的行为会产生一个编译时异常。无法添加任何对象到 fList 中
        // flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());

        fList.add(null);

        // 我们知道下面的操作返回第一个元素
        Fruit fruit = fList.get(0);
        System.out.println(fruit);
    }
}
