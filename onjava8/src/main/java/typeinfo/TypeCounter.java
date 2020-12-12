package typeinfo;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/4 1:49 下午
 */
// TypeCounter.java
public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object obj) {
        Class<?> type = obj.getClass();
        if (!baseType.isAssignableFrom(type)) {
            throw new RuntimeException(obj + "incorrect type" + type + ", should be type or subtype of " + baseType);
        }
        countClass(type);
    }

    // 递归计数，直到继承根对象。
    private void countClass(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superclass = type.getSuperclass();
        // 确定传入 CLass 表示的类或者接口是否与指定 Class的类或接口相同 如果不为空且相同，则在基类上调用 countClass 方法
        if (superclass != null && baseType.isAssignableFrom(superclass)) {
            countClass(superclass);
        }
    }

    @Override
    public String toString() {
        String result = entrySet().stream().map(
                pair -> String.format("%s=%s",
                        pair.getKey().getSimpleName(),
                        pair.getValue()))
                .collect(Collectors.joining(", "));

        return "{" + result + "}";
    }
}
