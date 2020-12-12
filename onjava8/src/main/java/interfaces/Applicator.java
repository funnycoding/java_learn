package interfaces;

import java.util.Arrays;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/11 3:35 下午
 */


class Upcase implements Processor {
    // 协变返回类型 , 将父类方法的返回类型从 Object 改为了 String，并转为大写
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}


class Downcase implements Processor {
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter implements Processor {
    @Override
    public String process(Object input) {
        // split() divides a String into pieces:
        return Arrays.toString(((String) input).split(" "));
    }
}


public class Applicator {
    public static void apply(Processor p, Object s) {
        System.out.println("Using Processor :" + p.name());
        System.out.println(p.process(s));
    }

    public static void main(String[] args) {
        String s = "We are such stuff as dreams are made on";

        apply(new Upcase(),s);
        apply(new Downcase(),s);
        apply(new Splitter(),s);
    }
}

