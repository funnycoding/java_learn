package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 9:52 下午
 */
// ExceptionSilencer.java
public class ExceptionSilencer {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        }finally {
            // 在 finally 中使用 return 会导致异常消失
            return;
        }
    }
}
