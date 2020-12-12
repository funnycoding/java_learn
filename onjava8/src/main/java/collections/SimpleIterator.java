package collections;



import java.util.Iterator;
import java.util.List;
import pets.Pet;
import pets.Pets;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/15 11:03 下午
 */

public class SimpleIterator {
    public static void main(String[] args) {
        List<Pet> pets = Pets.list(12);
        // 获取其迭代器
        Iterator<Pet> petIterator = pets.iterator();
        while (petIterator.hasNext()) {
            Pet p = petIterator.next();
            System.out.print("p.id: " + p.id() + ": " + p + " ");
        }
        System.out.println();

        // 另一种更简单的方法

        for (Pet p : pets) {
            System.out.print("p.id: " + p.id() + ": " + p + " ");
        }

        System.out.println();

        // 迭代器同样可以 remove 元素

        petIterator = pets.iterator();

        for (int i = 0; i < 6; i++) {
            //petIterator.next();
            petIterator.remove();
        }

        System.out.println(pets);
    }
}
