package com.allen.springbootweb.common;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @Auther: 20190598
 * @Date: 2020/6/24 13:55
 * @Description:
 */
@Component
@Order(1)
public class MyApplicationRunner1 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyApplicationRunner1>>>>>>>>>" + args.getNonOptionArgs());
        Set<String> params = args.getOptionNames();
        params.stream().forEach( s -> {
            System.out.printf("key: %s, value: %s \n", s , args.getOptionValues(s));
        });

    }
}
