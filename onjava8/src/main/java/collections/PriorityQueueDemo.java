package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/16 7:24 下午
 */

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            priorityQueue.offer(rand.nextInt(i + 10));
        }
        QueueDemo.printQ(priorityQueue);

        List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<>(ints);
        QueueDemo.printQ(priorityQueue);

        // 反转该队列
        priorityQueue = new PriorityQueue<>(ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        System.out.println("队列打印: " + priorityQueue);
        QueueDemo.printQ(priorityQueue);

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        // 将字符串拆分之后放入优先级队列并打印
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ =
                new PriorityQueue<>(strings);
        QueueDemo.printQ(stringPQ);
        // 倒序重新输出
        stringPQ = new PriorityQueue<>(strings.size(), Collections.reverseOrder());
        stringPQ.addAll(strings);
        QueueDemo.printQ(stringPQ);

        // 先将数据放入 HashSet中去掉重复字母 然后放入 PriorityQueue 按权重输出
        HashSet<Character> charSet = new HashSet<>();
        for (char c : fact.toCharArray()) {
            charSet.add(c);
        }
        PriorityQueue<Character> characterPQ = new PriorityQueue<>(charSet);
        QueueDemo.printQ(characterPQ);
    }
}
