package collections;

import java.util.AbstractCollection;
import java.util.Iterator;
import pets.Pet;
import pets.Pets;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/16 11:07 下午
 */

public class CollectionSequence extends AbstractCollection<Pet> {

    private Pet[] pets = Pets.array(8);



    // 这里使用匿名内部类定义了这个类的迭代器的行为
    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            @Override
            public void remove() { // 不实现 ，抛出异常
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public int size() {
        return pets.length;
    }

    public static void main(String[] args) {
        CollectionSequence cs = new CollectionSequence();
        InterfaceVsIterator.display(cs);
        System.out.println("-----------");
        InterfaceVsIterator.display(cs.iterator());

    }
}
