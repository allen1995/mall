package com.allen.springbootredis.jmh;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @Auther: allen
 * @Date: 2020-06-21 09:07
 * @Description:
 */
public class RedisDistributedRunner {

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(RedisDistributedBenchmark.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(10)
                .mode(Mode.Throughput)
                .forks(3)
                .build();
        new Runner(options).run();


    }
}
