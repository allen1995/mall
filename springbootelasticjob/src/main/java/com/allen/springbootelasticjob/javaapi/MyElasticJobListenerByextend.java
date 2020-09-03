package com.allen.springbootelasticjob.javaapi;

import org.apache.shardingsphere.elasticjob.api.listener.ShardingContexts;
import org.apache.shardingsphere.elasticjob.lite.api.listener.AbstractDistributeOnceElasticJobListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: 20190598
 * @Date: 2020/8/27 16:41
 * @Description:
 */
@Component
public class MyElasticJobListenerByextend extends AbstractDistributeOnceElasticJobListener {

    public MyElasticJobListenerByextend() {
        this(0L,10L);
    }

    public MyElasticJobListenerByextend(long startedTimeoutMilliseconds, long completedTimeoutMilliseconds) {
        super(startedTimeoutMilliseconds, completedTimeoutMilliseconds);
    }

    @Override
    public void doBeforeJobExecutedAtLastStarted(ShardingContexts shardingContexts) {
        System.out.println("doBeforeJobExecutedAtLastStarted");
    }

    @Override
    public void doAfterJobExecutedAtLastCompleted(ShardingContexts shardingContexts) {
        System.out.println("doAfterJobExecutedAtLastCompleted");
    }
}
