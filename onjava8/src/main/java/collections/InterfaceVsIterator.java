package collections;


import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import pets.Pet;
import pets.Pets;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/16 10:47 下午
 */

public class InterfaceVsIterator {
    // 使用迭代器遍历
    public static void display(Iterator<Pet> it) {
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ": " + p + " ");
        }
        System.out.println();
    }

    // for-in 遍历
    public static void display(Collection<Pet> pets) {
        for (Pet p : pets) {
            System.out.print(p.id() + ": " + p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pet> petList = Pets.list(8);
        HashSet<Pet> petSet = new HashSet<>(petList);
        Map<String, Pet> petMap = new LinkedHashMap<>();
        String[] names = ("Ralph, Eric, Robin, Lacey, " +
                "Britney, Sam, Spot, Fluffy").split(", ");
        for (int i = 0; i < names.length; i++) {
            petMap.put(names[i], petList.get(i));
        }
        System.out.println("Collection Display");
        display(petList);
        display(petSet);
        System.out.println("Iterator Display");
        display(petList.iterator());
        display(petSet.iterator());

        System.out.println(petMap);
        System.out.println(petMap.keySet());
        display(petMap.values());
        display(petMap.values().iterator());
    }

}
