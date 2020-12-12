package collections;

import java.util.ArrayDeque;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/16 2:45 下午
 */

public class StackTest {
    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ,");
        }
    }

}
