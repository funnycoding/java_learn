package interfaces;


/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/11 4:07 下午
 */

 interface StringProcessor extends Processor {
    @Override
    Object process(Object input);

    String S = "If she weights the same as a duck, she's made of wood";

    static void main(String[] args) {
        Applicator.apply(new Upcase(),S);
        Applicator.apply(new Downcase(),S);
        Applicator.apply(new Splitter(),S);
    }
}

