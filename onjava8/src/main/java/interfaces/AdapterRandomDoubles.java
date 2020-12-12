package interfaces;

import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/11 10:07 下午
 */


public class AdapterRandomDoubles implements RandomDoubles, Readable {
    private int count;

    public AdapterRandomDoubles(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) {
        if (count-- == 0) {
            return -1;
        }

        String result = next() + " ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new AdapterRandomDoubles(7));

        while (s.hasNext()) {
            System.out.println(s.nextDouble() + " ");
        }
    }
}
