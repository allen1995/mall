package com.allen.springbootredis.jmh;

import com.allen.springbootredis.SpringbootredisApplication;
import com.allen.springbootredis.distributedlock.DistributedLock;
import com.allen.springbootredis.distributedlock.LockTest;
import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Auther: allen
 * @Date: 2020-06-21 08:50
 * @Description:
 */
@State(Scope.Benchmark)
public class RedisDistributedBenchmark {

    private ConfigurableApplicationContext context;

    private DistributedLock distributedLock;

    private LockTest lockTest;


    @Setup(Level.Trial)
    public void init(){
        context = SpringApplication.run(SpringbootredisApplication.class);
        lockTest = (LockTest)context.getBean("lockTest");
    }


    @Benchmark
    public void testLock(){
        lockTest.beachmarkTest();
    }

    @TearDown
    public void destory(){
        context.close();
    }
}
