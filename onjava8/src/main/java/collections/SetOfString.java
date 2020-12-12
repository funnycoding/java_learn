package collections;

import java.util.HashSet;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description 用Set保存String的例子
 * @date 2020/2/16 3:43 下午
 */

public class SetOfString {
    public static void main(String[] args) {
        HashSet<String> colors = new HashSet<>();
        for(int i = 0; i < 100; i++) {
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Red");
            colors.add("Red");
            colors.add("Orange");
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Purple");
        }
        System.out.println(colors);
    }

}
