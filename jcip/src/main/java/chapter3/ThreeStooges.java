package chapter3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import net.jcip.annotations.Immutable;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/3/26 2:18 下午
 */

// 使用可变的基础对象构建不可变的类
// ThreeStooges.java
@Immutable
public class ThreeStooges {
    // 用来保存名字
    private final Set<String> stooges = new HashSet<>();

    public ThreeStooges() {
        stooges.add("傀儡1");
        stooges.add("傀儡2");
        stooges.add("傀儡3");
    }

    public boolean isStooge(String name) {
        return stooges.contains(name);
    }

    // 这里相当于是要跟初始化类时放入的傀儡名称做一个对应
    public String getStoogeName() {
        List<String> stooges = new Vector<>();
        stooges.add("傀儡1");
        stooges.add("傀儡2");
        stooges.add("傀儡3");
        // 其实这个 Set 是可变的，只要你手动多添加一个，就破坏了不可变性
        this.stooges.add("傀儡4");

        return stooges.toString();
    }

    public static void main(String[] args) {
        ThreeStooges ts = new ThreeStooges();
        System.out.println("List: " + ts.getStoogeName());
        System.out.println("Set: " + ts.stooges);
    }
}
