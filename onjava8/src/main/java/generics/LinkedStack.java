package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/11 3:21 下午
 */

// LinkedStack.java
public class LinkedStack<T> {
    public static <T> void show(T t) {
        System.out.println(t);
    }

    public void show2(T t) {
        System.out.println(t);
    }

    // 再搞一个私有静态内部类 代表节点
    private static class Node<U> {
        U item;
        Node<U> next;

        public Node() {
            item = null;
            next = null;
        }

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }

    }

    private Node<T> top = new Node<>(); // 栈顶

    // 入栈操作
    public void push(T item) {
        top = new Node<>(item, top);
    }

    // 出栈，同时判断 是否存在下一个 Node 如果存在，则将 top 指向下一个 Node
    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        for (String s : "Phasers on stun!".split(" ")) {
            lss.push(s);
        }
        // 打印栈内元素
        String s;
        while ((s = lss.pop()) != null) {
            System.out.println(s);
        }
    }
}
