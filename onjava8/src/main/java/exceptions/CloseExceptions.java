package exceptions;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/27 4:18 下午
 */

// CloseExceptions.java
class CloseException extends Exception {

}

class Report2 implements AutoCloseable {
    String name = getClass().getSimpleName();

    public Report2() {
        System.out.println("Creating: " + name);
    }


    @Override
    public void close() throws CloseException { // 声明抛出异常，但是实际没有抛出
        System.out.println("Closing " + name);

    }
}

class Closer extends Report2 {
    @Override
    public void close() throws CloseException { // 覆写父类方法 抛出异常
        super.close();
        throw new CloseException();
    }
}

public class CloseExceptions {
    public static void main(String[] args) throws CloseException {
        try (
                final First first = new First();
                final Closer closer = new Closer();
                final Second second = new Second()

        ){
            System.out.println("In body");
        }
    }
}
