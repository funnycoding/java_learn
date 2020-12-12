package collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description 一个队列的 Demo
 * @date 2020/2/16 5:39 下午
 */

public class QueueDemo {
    // 打印并删除队列中的元素
    public static void printQ(Queue q) {
        while (q.peek() != null) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            queue.offer(rand.nextInt(i + 10));
        }
        printQ(queue);
        System.out.println(queue);
        LinkedList<Character> qc = new LinkedList<>();
        for (char c : "Brontosaurus".toCharArray()) {
            qc.offer(c);
        }
        printQ(qc);
        System.out.println(qc);
    }
}
