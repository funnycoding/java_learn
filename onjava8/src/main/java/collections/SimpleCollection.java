package collections;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/15 3:46 下午
 */

public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            c.add(i); // Autoboxing
        for(Integer i : c)
            System.out.print(i + ", ");
    }
}
