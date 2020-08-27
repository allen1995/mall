package com.allen.springbootelasticjob.javaapi;

import org.apache.shardingsphere.elasticjob.api.JobConfiguration;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.ScheduleJobBootstrap;
import org.apache.shardingsphere.elasticjob.reg.base.CoordinatorRegistryCenter;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperConfiguration;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperRegistryCenter;

/**
 * @Auther: 20190598
 * @Date: 2020/8/26 09:36
 * @Description:
 */
public class MyJobDemo {

    public static void main(String[] args) {
        new ScheduleJobBootstrap(createRegisterCenter(), new MyElasticJob(), createJobConfiguration()).schedule();
    }

    private static JobConfiguration createJobConfiguration() {
        JobConfiguration jobConfiguration = JobConfiguration.newBuilder("MyJob", 3).cron("0/5 * * * * ?").build();
        return jobConfiguration;
    }

    private static CoordinatorRegistryCenter createRegisterCenter() {
        CoordinatorRegistryCenter registryCenter = new  ZookeeperRegistryCenter(new ZookeeperConfiguration("localhost:2181","My-Job"));
        registryCenter.init();
        return registryCenter;
    }
}
