package arrays;


import java.util.Arrays;
import onjava.Rand;
import onjava.Rand.Pint;
import static onjava.ArrayShow.*;
/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/9 8:08 下午
 */
// ArraySearching.java
public class ArraySearching {
    public static void main(String[] args) {
        Rand.Pint rand = new Rand.Pint();

        int[] a = new Pint().array(25);
        Arrays.sort(a);
        show("排序后的数组",a);
        while (true) {
            int r = rand.getAsInt();
            int location = Arrays.binarySearch(a, r);
            if (location >= 0) {
                System.out.println("Location of  " + r + "所在的位置: " + location);
                break;
            }
        }

    }
}
