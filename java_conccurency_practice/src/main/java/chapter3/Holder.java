package chapter3;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/3/26 9:03 下午
 */
// Class at risk of failure if not properly published
// 不安全的发布，在多线程环境下可能会出现异常与状态不一致
// Holder.java
public class Holder {
    private int n;

    public Holder(int n) {
        this.n = n;
    }

    public void assertSanity() {
        if (n != n) {
            throw new AssertionError("This statement is false");
        }
    }
}
