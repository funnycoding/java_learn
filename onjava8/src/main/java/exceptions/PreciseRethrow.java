package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 5:51 下午
 */

// PreciseRethrow.java
class BaseException extends Exception {}

class DerivedException extends BaseException {}

public class PreciseRethrow {
    void catcher() throws DerivedException {
        try {
            throw new DerivedException();
        } catch (BaseException e) {
            throw e;
        }
    }
}
