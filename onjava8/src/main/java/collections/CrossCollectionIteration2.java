package collections;



import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import pets.Pet;
import pets.Pets;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/15 11:33 下午
 */

public class CrossCollectionIteration2 {
    public static void display(Iterable<Pet> iterable) {
        // 获取迭代器
        Iterator<Pet> iterator = iterable.iterator();
        // 其余操作与刚才一样
        while(iterator.hasNext()) {
            Pet p = iterator.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pet> pets = Pets.list(8);
        LinkedList<Pet> petsLL = new LinkedList<>(pets);
        HashSet<Pet> petsHS = new HashSet<>(pets);
        TreeSet<Pet> petsTS = new TreeSet<>(pets);
        // 这里调用不再需要在这一步获取迭代器，直接统一在方法中获取，简化了调用
        display(pets);
        display(petsLL);
        display(petsHS);
        display(petsTS);
    }


}
