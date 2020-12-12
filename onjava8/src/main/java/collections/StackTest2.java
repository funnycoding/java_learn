package collections;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/16 2:59 下午
 */

public class StackTest2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
