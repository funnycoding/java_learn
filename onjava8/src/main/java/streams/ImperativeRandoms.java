package streams;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/20 5:26 下午
 */

public class ImperativeRandoms {
    public static void main(String[] args) {
        Random rand = new Random(47);
        SortedSet<Object> rints = new TreeSet<>();
        while (rints.size() < 7) {
            int r = rand.nextInt(20);
            if (r < 5) {
                continue;
            }
            rints.add(r);
        }
        System.out.println(rints);
    }
}
