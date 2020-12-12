package interfaces;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/11 4:12 下午
 */


/**
 * 创建一个继承接口的适配器类
 */
class FilterAdapter implements Processor {

    // 定义一个要适配的类的引用
    Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    // 这里相当于在这个类中调用 Filter的方法,这里可以修改为自己的实现

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Object process(Object input) {
        return filter.process((Waveform) input);
    }
}

public class FilterProcessor {
    public static void main(String[] args) {
        Waveform waveform = new Waveform();
        Applicator.apply(new FilterAdapter(new LowPass(1.0)), waveform);
        Applicator.apply(new FilterAdapter(new HighPass(2.0)), waveform);
        Applicator.apply(new FilterAdapter(new BandPass(3.0,4.0)), waveform);
    }
}
