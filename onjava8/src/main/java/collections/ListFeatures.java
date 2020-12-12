package collections;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import pets.Cymric;
import pets.Hamster;
import pets.Mouse;
import pets.Pet;
import pets.Pets;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/15 5:03 下午
 */

public class ListFeatures {
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Pet> pets = Pets.list(7);
        System.out.println("1: " +  pets) ;

        // List 尾部追加一个元素
        Hamster h = new Hamster();
        pets.add(h); // Automatically resizes
        System.out.println("2: " + pets);

        System.out.println("3: " + pets.contains(h));
        pets.remove(h); // Remove by object 删除该元素
        Pet p = pets.get(2);
        System.out.println("4: " +  p + " " + pets.indexOf(p)); // 获取第二个元素 打印 Pet 第二个元素的 index

        Pet cymric = new Cymric();
        System.out.println("5: " + pets.indexOf(cymric)); // 新创建的元素并不在 pets中
        System.out.println("6: " + pets.remove(cymric)); // 删除失败

        // Must be the exact object:
        System.out.println("7: " + pets.remove(p)); // 删除之前确认的元素
        System.out.println("8: " + pets); // 再次打印 第 2 位的元素已经被删除了


        pets.add(3, new Mouse()); // Insert at an index 在第三位 添加一个 元素 Mouse
        System.out.println("9: " + pets);

        List<Pet> sub = pets.subList(1, 4); // 截取子串 [1,4) 左开右闭
        System.out.println("subList: " + sub);

        System.out.println("10: " + pets.containsAll(sub)); // pets 包含 子串

        Collections.sort(sub); // In-place sort 对 sub 子串进行排序 按字母顺序排序
        System.out.println("sorted subList: " + sub);

        System.out.println("11: " + pets.containsAll(sub)); // 判断是否全包含

        Collections.shuffle(sub, rand); // Mix it up

        System.out.println("shuffled subList: " + sub);
        System.out.println("12: " + pets.containsAll(sub));

        ArrayList<Pet> copy = new ArrayList<>(pets);
        System.out.println("copy " + copy);

        sub = Arrays.asList(pets.get(1), pets.get(4));
        System.out.println("sub: " + sub);

        copy.retainAll(sub); // 只保存 copy 和 sub 的共集
        System.out.println("13: " + copy);

        copy = new ArrayList<>(pets); // Get a fresh copy
        copy.remove(2); // Remove by index
        System.out.println("14: " + copy);
        copy.removeAll(sub); // Only removes exact objects
        System.out.println("15: " + copy);

        copy.set(1, new Mouse()); // Replace an element 将第一个元素设置为 Mouse
        System.out.println("16: " + copy);
        System.out.println("sub " + sub);
        copy.addAll(2, sub); // Insert a list in the middle 从 2 开始 插入 sub 里的所有元素
        System.out.println("17: " + copy);
        System.out.println("18: " + pets.isEmpty());

        pets.clear(); // 删除所有元素
        System.out.println("19: " + pets);
        System.out.println("20: " + pets.isEmpty());

        pets.addAll(Pets.list(4)); // 随机添加4个元素
        System.out.println("21: " + pets);

        Object[] o = pets.toArray();
        System.out.println("22: " + o[3]);
        Pet[] pa = pets.toArray(new Pet[0]);
        System.out.println(Arrays.toString(pa));
        System.out.println("23: " + pa[3].id());
        System.out.println("23: " + pa[3]);

    }
}
