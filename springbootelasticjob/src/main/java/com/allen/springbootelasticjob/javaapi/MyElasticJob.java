package com.allen.springbootelasticjob.javaapi;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: 20190598
 * @Date: 2020/8/24 10:57
 * @Description:
 */
@Component
public class MyElasticJob implements SimpleJob {

    private static final Logger logger = LoggerFactory.getLogger(MyElasticJob.class);

    @Override
    public void execute(ShardingContext shardingContext) {
        //switch ( shardingContext.getShardingItem() ){
        //    case 0:
        //        System.out.printf("sharding %d execute %s job.", shardingContext.getShardingItem(), shardingContext.getJobName());
        //        System.out.println();
        //        break;
        //    case 1:
        //        System.out.printf("sharding %d execute %s job.", shardingContext.getShardingItem(), shardingContext.getJobName());
        //        System.out.println();
        //        break;
        //    case 2:
        //        System.out.printf("sharding %d execute %s job.", shardingContext.getShardingItem(), shardingContext.getJobName());
        //        System.out.println();
        //        break;
        //    default:
        //        System.out.printf("sharding %d execute %s job.", shardingContext.getShardingItem(), shardingContext.getJobName());
        //}
        System.out.println("allen");

    }
}
