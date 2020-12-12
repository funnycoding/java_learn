package generics;

import java.util.ArrayList;
import java.util.List;
import sun.text.normalizer.CharTrie.FriendAgent;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/14 10:51 下午
 */

public class NonCovariantGenerics {
    // 编译错误
    //List<Fruit> fList = new ArrayList<Apple>();
}
