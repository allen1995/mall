package com.allen.springbootelasticjob.config;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.dataflow.job.DataflowJob;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpringBootDataflowJob implements DataflowJob<Foo> {
    
    @Override
    public List<Foo> fetchData(final ShardingContext shardingContext) {
        // fetch data
        List<Foo> foos = new ArrayList<>();
        Foo foo = new Foo(1, "allen");
        foos.add(foo);

        return foos;
    }
    
    @Override
    public void processData(final ShardingContext shardingContext, final List<Foo> data) {
        // process data
        data.forEach( foo -> {
            System.out.println("sharding:" + shardingContext.getShardingItem() + "," + foo);
        });

    }
}