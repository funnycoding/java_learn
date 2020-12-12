package arrays.jmh;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import onjava.Rand;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/9 7:30 下午
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class ParallelSort {
    private long[] la;

    @Setup
    public void setup(){
        la = new Rand.Plong().array(100_00000);
    }

    @Benchmark
    public void sort() {
        Arrays.sort(la);
    }

    @Benchmark
    public void parallelSort() {
        Arrays.parallelSort(la);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ParallelSort.class.getSimpleName())
                .forks(1)
                .warmupIterations(1)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }

}
