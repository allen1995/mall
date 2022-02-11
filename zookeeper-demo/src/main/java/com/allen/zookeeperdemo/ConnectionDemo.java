package com.allen.zookeeperdemo;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: 20190598
 * @Date: 2022/2/11 14:34
 * @Description:
 */
public class ConnectionDemo {

    public static void main(String[] args) {
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);

            ZooKeeper zookeeper = new ZooKeeper("192.168.181.140:2181", 4000,
                    new Watcher() {
                        @Override
                        public void process(WatchedEvent watchedEvent) {
                            if( Event.KeeperState.SyncConnected == watchedEvent.getState() ) {
                                //如果已经连接上，释放countdown锁
                                countDownLatch.countDown();
                            }
                        }
                    });

            countDownLatch.await();

            System.out.println(zookeeper.getState());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
