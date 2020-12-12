package streams;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/22 7:29 下午
 */


// MapCollector.java
class Pair {
    public final Character c;
    public final Integer i;

    public Pair(Character c, Integer i) {
        this.c = c;
        this.i = i;
    }

    public Character getC() {
        return c;
    }

    public Integer getI() {
        return i;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pair.class.getSimpleName() + "[", "]")
                .add("c=" + c)
                .add("i=" + i)
                .toString();
    }
}

class RandomPair {
    Random rand = new Random(47);

    // 生成随机数然后转为 Char 类型
    Iterator<Character> capChars = rand.ints(65, 91)
            .mapToObj(i -> (char) i)
            .iterator();

    public Stream<Pair> stream() {
        return rand.ints(100, 1000)
                .distinct()
                .mapToObj(i -> new Pair(capChars.next(), i));
    }
}

public class MapCollector {
    public static void main(String[] args) {
        Map<Integer, Character> map = new RandomPair().stream()
                .limit(8)
                .collect(Collectors.toMap(Pair::getI, Pair::getC));
        System.out.println(map);
    }
}
