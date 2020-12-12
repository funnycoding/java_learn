package generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author XuYanXin
 * @program My_Onjava8_Exaples
 * @description
 * @date 2020/3/15 9:57 下午
 */
// generics/NeedCasting.java
public class NeedCasting {
    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));

        List<Widget> shapens = (List<Widget>) in.readObject(); // 这里虽然使用泛型但是仍然会警告 未检查的类型转换
    }
}
