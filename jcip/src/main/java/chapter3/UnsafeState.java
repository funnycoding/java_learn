package chapter3;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/3/24 9:25 下午
 */

// UnsafeState.java
public class UnsafeState {
    private String[] states = new String[]{
            "AK", "AL" /* ... */
    };
    // 私有变量的访问器，破坏了私有变量的封装性
    public String[] getStatus() {
        return states;
    }
}
