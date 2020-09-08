package com.allen.springbootenterprisedevelopment.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @Auther: 20190598
 * @Date: 2020/9/8 13:50
 * @Description:
 */
@Component
public class MySchedule {

    /**
     * 固定延时执行，任务执行间隔 = 任务执行时间 + fixeddelay
     * @throws InterruptedException
     */
    //@Scheduled(fixedDelay = 1000)
    //public void fixedDelay() throws InterruptedException {
    //    Thread.sleep(2000);
    //    System.out.println(Thread.currentThread().getName() +  " | fixedDelay:" + LocalDateTime.now());
    //}

    //@Scheduled(fixedRate = 2000)
    //public void fixedRate() throws InterruptedException {
    //    long sleep = (long)(Math.random() * 1000 * 3);
    //    System.out.println(sleep);
    //    Thread.sleep( sleep);
    //    System.out.println(Thread.currentThread().getName() + " | fixedRate:" + LocalDateTime.now());
    //}

    @Scheduled(cron = "0/5 * * * * ?")
    public void cron(){
        System.out.println(Thread.currentThread().getName() + " | cron:" + LocalDateTime.now());
    }
}
