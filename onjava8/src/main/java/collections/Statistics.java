package collections;

import java.util.HashMap;
import java.util.Random;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/16 4:35 下午
 */

public class Statistics {
    public static void main(String[] args) {
        Random rand = new Random(47);
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            // Produce a number between 0 and 20:
            int r = rand.nextInt(20);
            Integer freq = m.get(r); // 该数字出现的频率
            m.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(m);
    }
}
