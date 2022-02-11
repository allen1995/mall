package com.allen.zookeeperdemo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

/**
 * @Auther: 20190598
 * @Date: 2022/2/11 14:42
 * @Description:
 */
public class CuratorDemo {

    public static void main(String[] args) {
        try {
            CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                    .connectString("192.168.181.140:2181")
                    .sessionTimeoutMs(4000)
                    .retryPolicy(new ExponentialBackoffRetry(1000,3))
                    .namespace("")
                    .build();

            curatorFramework.start();
            Stat stat = new Stat();
            //查询节点数据
            byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/");
            System.out.println("curator start ========>" + new String(bytes));

            curatorFramework.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
