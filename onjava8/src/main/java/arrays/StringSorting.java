package arrays;

import static arrays.ArrayShow.show;

import java.util.Arrays;
import java.util.Collections;
import onjava.Rand.StringGen;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/9 7:17 下午
 */
// arrays/StringSorting.java
public class StringSorting {
    public static void main(String[] args) {
        String[] sa = new StringGen().array(20);
        show("排序之前", sa);

        Arrays.sort(sa);
        show("排序之后", sa);

        Arrays.sort(sa, Collections.reverseOrder());
        show("Reverse Sort 之后",sa);

        Arrays.sort(sa,String.CASE_INSENSITIVE_ORDER); // 无论大小写，将单词组合在一起的排序
        show("Case-insensitive排序",sa);

    }
}
