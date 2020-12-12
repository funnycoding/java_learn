package collections;

import java.util.HashSet;
import java.util.Random;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/16 3:18 下午
 */

public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        HashSet<Integer> intset = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            intset.add(rand.nextInt(30));
        }
        System.out.println(intset);
    }
}
