package collections;



import java.util.List;
import pets.Pet;
import pets.Pets;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/15 11:52 下午
 */

public class ListIterator {
    public static void main(String[] args) {
        List<Pet> pets = Pets.list(8);
        java.util.ListIterator<Pet> it = pets.listIterator();

        // 打印所有元素和 以及下一个元素和上一个元素的索引值
        while (it.hasNext()) {
            System.out.print(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; ");
        }
        System.out.println();

        // 打印前一个元素:
        while (it.hasPrevious()) {
            System.out.print(it.previous().id() + " ");
        }
        System.out.println();

        // 打印整个集合
        System.out.println(pets);

        // 获取从第三个元素开始的迭代器
        it = pets.listIterator(3);
        while (it.hasNext()) {
            it.next();
            // 替换元素
            it.set(Pets.get());
        }

        System.out.println("last" + pets);
    }
}
