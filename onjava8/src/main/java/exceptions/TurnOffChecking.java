package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/27 7:08 下午
 */

// TurnOffChecking.java
class WrapCheckedException {
    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0:
                    throw new FileNotFoundException();
                case 1:
                    throw new IOException();
                case 2:
                    throw new
                            RuntimeException("Where am I?");
                default:
                    return;
            }
        } catch (IOException | RuntimeException e) {
            // Adapt to unchecked:
            throw new RuntimeException(e);
        }
    }
}


class SomeOtherException extends Exception {
}

public class TurnOffChecking {
    public static void main(String[] args) {
        WrapCheckedException wce = new WrapCheckedException();
        wce.throwRuntimeException(3);

        for (int i = 0; i < 4; i++) {
            System.out.println("Now i :" + i);
            try {
                if (i < 3) {
                    wce.throwRuntimeException(i);
                } else {
                    throw new SomeOtherException();
                }
            } catch (SomeOtherException e) {
                System.out.println("SomeOtherException " + e);
            } catch (RuntimeException re) {
                try {
                    throw re.getCause();
                } catch (FileNotFoundException e) {
                    System.out.println("FileNotFound Exception: " + e );
                } catch (IOException e) {
                    System.out.println("IOException: " + e);
                } catch (Throwable throwable) {
                    System.out.println("Throwable: " + throwable);
                }
            }
        }
    }
}
