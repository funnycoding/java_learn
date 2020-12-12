package yunaispring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/11/7 6:10 下午
 */

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> source = new ArrayList<>(101);
        HashMap<Integer, Integer> map = new HashMap<>(100);
        for (int i = 1; i <= 101; i++) {
            source.add(i);
            if (i <= 101 - 5) {
                map.put(i, i + 5);
            }
        }
        System.out.println(map);
    }
}
