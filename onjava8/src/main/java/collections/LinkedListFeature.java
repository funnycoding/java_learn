package collections;



import java.util.LinkedList;
import pets.Hamster;
import pets.Pet;
import pets.Pets;
import pets.Rat;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/16 12:48 上午
 */

public class LinkedListFeature {
    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<>(Pets.list(5));
        System.out.println(pets);

        // Identical 等同的调用
        System.out.println("pets.getFirst(): " + pets.getFirst());
        System.out.println("pets.element(): " + pets.element());

        // Only differs in empty-list behavior: 只在集合为空时不同行为的方法
        System.out.println("pets.peek(): " + pets.peek());
        // Identical; remove and return the first element: 相同的调用 移除第一个元素
        System.out.println("pets.remove(): " + pets.remove());
        System.out.println("pets.removeFirst(): " + pets.removeFirst());
        System.out.println(pets);

        // Only differs in empty-list behavior: poll 删除第一个元素
        System.out.println("pets.poll(): " + pets.poll());
        System.out.println(pets);

        pets.addFirst(new Rat());
        System.out.println("After addFirst(): " + pets);

        pets.add(Pets.get());
        System.out.println("After add(): " + pets);
        pets.addLast(new Hamster());
        System.out.println("After addLast(): " + pets);
        System.out.println(
                "pets.removeLast(): " + pets.removeLast());
    }
}
