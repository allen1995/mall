package com.allen.springbootredis.distributedlock;

import java.util.UUID;
import java.util.concurrent.CyclicBarrier;

public class LockTask implements Runnable{

    private DistributedLock lock;

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(9);

    public LockTask(DistributedLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {


        String value = UUID.randomUUID().toString();
        String requestId = UUID.randomUUID().toString();
        try {

            lock.lock("testlock",value,requestId);
            System.out.println( Thread.currentThread().getName() + "加锁成功");
        }  finally {
            lock.unlock("testlock",value, requestId);
            System.out.println( Thread.currentThread().getName() + "解锁成功");
            System.out.println("----------------------------------------------");

        }
    }
}