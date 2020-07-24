import java.util.Arrays;

/**
 * @author XuYanXin
 * @program javaconcurrency_learn
 * @description
 * @date 2020/7/24 3:42 下午
 */

public class ObjectTest {
    private void testM() {

    }
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(obj.getClass());
        ObjectTest objT = new ObjectTest();
        Class<? extends ObjectTest> aClass = objT.getClass();
        System.out.println(Arrays.toString(aClass.getMethods()));
        System.out.println(aClass);
        System.out.println(ObjectTest.class);
    }
}
