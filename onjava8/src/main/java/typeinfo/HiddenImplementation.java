package typeinfo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import typeinfo.packageaccess.*;
/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/5 9:27 下午
 */
// typeinfo/HiddenImplementation.java
public class HiddenImplementation {
    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // 编译器抛出异常，因为无法找到变量类型C
        /* if(a instanceof C) {
            C c = (C)a;
            c.g();
        } */
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

     static void callHiddenMethod(Object a,String methodName)
             throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
         Method g = a.getClass().getDeclaredMethod(methodName);
         g.setAccessible(true);
         g.invoke(a);
     }
}
