package exceptions;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/27 4:12 下午
 */

// exceptions/BodyException.java
class Third extends Reporter {
}

public class BodyException {
    public static void main(String[] args) {
        try (
                final First first = new First();
                final Second second = new Second()
        ) {
            System.out.println("In boyd");
            final Third t = new Third();
            final SecondExcept secondExcept = new SecondExcept();
            System.out.println("End of body");
        } catch (CE ce) {
            System.out.println("Caught " + ce);
        }
    }
}
