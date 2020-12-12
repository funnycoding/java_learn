package interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/11 9:39 下午
 */

public class RandomStrings implements Readable {

    private static Random random = new Random(47);
    // 开始构造随机字符串
    private static final char[] CAPITALS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] LOWERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] VOWELS = "aeiou".toCharArray();

    private int count;

    public RandomStrings(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) {
            return -1; // 输出结束
        }

        cb.append(CAPITALS[random.nextInt(CAPITALS.length)]);
        for (int i = 0; i < 4; i++) {
            cb.append(VOWELS[random.nextInt(VOWELS.length)]);
            cb.append(LOWERS[random.nextInt(LOWERS.length)]);
        }
        cb.append(" ");
        return 10; // 已经拼接的字符的长度 Number of characters appended
    }

    public static void main(String[] args) {
        // 随机输出10次
        Scanner s = new Scanner(new RandomStrings(10));
        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }

}
