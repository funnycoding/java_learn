package generics.watercolors;

import static generics.watercolors.Watercolors.黄;
import static onjava.Sets.complement;
import static onjava.Sets.difference;
import static onjava.Sets.intersection;
import static onjava.Sets.union;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/12 7:28 下午
 */
// WatercolorSets.java
public class WatercolorSets {
    public static void main(String[] args) {
        // 截取传入枚举之间的枚举
        Set<Watercolors> set1 = EnumSet.range(Watercolors.红, Watercolors.紫);
        Set<Watercolors> set2 =
                EnumSet.range(Watercolors.白, 黄);
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println(
                "union(set1, set2): " + union(set1, set2));

        Set<Watercolors> subset = intersection(set1, set2);
        System.out.println("subset: " + subset);
        System.out.println("difference(set1, subset): " + difference(set1, subset));
        System.out.println("complement(set1, set2): " + complement(set1, set2));
    }
}
