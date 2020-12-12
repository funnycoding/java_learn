package collections;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/16 11:28 下午
 */

public class ForInCollections {
    public static void main(String[] args) {
        LinkedList<String> cs = new LinkedList<>();
        Collections.addAll(cs, "Take the long way home".split(" "));
        for (String s : cs) {
            System.out.print(" " + s + " ");
        }
    }
}
