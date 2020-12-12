package streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/20 8:19 下午
 */
// streams/CollectionToStream.java
public class CollectionToStream {
    public static void main(String[] args) {

        // 构造一个 Bubbles List
        List<Bubble> bubbles = Arrays.asList(new Bubble(1), new Bubble(2), new Bubble(3));
        // 将 List 转为流，然后将 bubble 中的 i 求和 这里 i 分别是 1/2/3
        System.out.println(bubbles.stream()
                .mapToInt(bubble -> bubble.i)
                .sum());

        Set<String> w = new HashSet<>(Arrays.asList("It's a wonderful day for pie!".split(" ")));
        w.stream()
                .map(x -> x + " ")
                .forEach(System.out::print);
        System.out.println();

        HashMap<String, Double> m = new HashMap<>();
        m.put("pi", 3.1415926);
        m.put("e", 2.718);
        m.put("phi", 1.618);

        
        m.entrySet()
                .stream()
                .map( e -> e.getKey() + ": " + e.getValue())// 每个键值对中间插一个 ": "
                .forEach(System.out::println);
    }
}
