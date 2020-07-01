package com.allen.springbootredis.distributedlock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Auther: allen
 * @Date: 2020-06-20 10:47
 * @Description:
 */
@Component
public class LockTest implements ApplicationRunner {

    @Autowired
    private DistributedLock lock;

    public static void main(String[] args) {
        //for (int i = 0; i < 10; i++) {
        //    Thread thread = new Thread(new LockTask());
        //    thread.start();
        //}

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //try {
        //    lock.lock("testlock","1234","123");
        //    System.out.println("加锁成功");
        //} finally {
        //    lock.unlock("testlock","1234", "123");
        //    System.out.println("解锁成功");
        //}

        //for (int i = 0; i < 10; i++) {
        //    Thread thread = new Thread(new LockTask(lock));
        //    thread.start();
        //}
    }


    public void beachmarkTest(){
        String value = UUID.randomUUID().toString();
        String requestId = UUID.randomUUID().toString();
        try {

            lock.lock("testlock",value,requestId);
        }  finally {
            lock.unlock("testlock",value, requestId);


        }
    }
}


