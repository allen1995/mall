package com.allen.springbootbase.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Auther: 20190598
 * @Date: 2020/8/19 15:16
 * @Description:
 */
@Component("helloTask")
public class HelloTask {

    @Scheduled(cron = "*/1 * * * * ?")
    public void doTask(){
        System.out.println("定时任务执行。。。");
    }
}
