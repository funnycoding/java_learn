package arrays;

import static arrays.ArrayShow.show;

import java.util.Arrays;
import onjava.Rand.StringGen;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/9 8:34 下午
 */
// arrays/AlphabeticSearch.java
public class AlphabeticSearch {
    public static void main(String[] args) {
        String[] sa = new StringGen().array(30);
        Arrays.sort(sa,String.CASE_INSENSITIVE_ORDER);
        show(sa);
        int index = Arrays.binarySearch(sa, sa[10], String.CASE_INSENSITIVE_ORDER);
        System.out.println("Index: " + index + "\n" + sa[index]);
    }
}
