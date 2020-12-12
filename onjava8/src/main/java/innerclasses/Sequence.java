package innerclasses;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/12 8:55 下午
 */

interface Selector {
    boolean end();

    Object current();

    void next();
}


public class Sequence {
    private Object[] items;
    private int next = 0;

    // 初始化一个传入数值长度的数组
    public Sequence(int sz) {
        items = new Object[sz];
    }

    // 将对象放入数组
    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }


    // 私有内部类来了 这个类实现了 Selector 接口，操作了外部类中的数组字段
    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);

        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }

        // 获取Select的实例，这里是继承了Selector 的接口实例 SequenceSelector 对象
        Selector selector = sequence.selector();

        // 遍历 item
        while (!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }
    }

}
