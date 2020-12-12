package exceptions;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/27 3:58 下午
 */
// AutoCloseableDetails.java
class Reporter implements AutoCloseable {
    String name = getClass().getSimpleName();

    public Reporter() {
        System.out.println("Createing: " + name);
    }

    @Override
    public void close() {
        System.out.println("Closing " + name);
    }
}

class First extends Reporter {
}

class Second extends Reporter {
}


public class AutoCloseableDetails {
    public static void main(String[] args) {
        try (
                First first = new First();
                Second second = new Second()
        ) {
        }
    }
}
