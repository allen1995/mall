package com.allen.springbootelasticjob.javaapi;

import org.apache.shardingsphere.elasticjob.api.listener.ElasticJobListener;
import org.apache.shardingsphere.elasticjob.api.listener.ShardingContexts;

/**
 * @Auther: 20190598
 * @Date: 2020/8/27 16:02
 * @Description:
 */
//@Component
public class MyElasticJobListener  implements ElasticJobListener {

    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        System.out.println("before job execute.");
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        System.out.println("after job execute.");
    }
}
