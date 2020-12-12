package exceptions;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/25 4:02 下午
 */

class EBase1 extends Exception {}

class Except1 extends EBase1 {}

class EBase2 extends Exception {}

class Except2 extends EBase2 {}

class EBase3 extends Exception {}

class Except3 extends EBase3 {}

class EBase4 extends Exception {}

class Except4 extends EBase4 {}

public class SameHandler {
    void x() throws Except1, Except2, Except3, Except4 {}
    void process() {}
    void f() {
        try {
            x();
        } catch(Except1 e) {
            process();
        } catch(Except2 e) {
            process();
        } catch(Except3 e) {
            process();
        } catch(Except4 e) {
            process();
        }
    }
}