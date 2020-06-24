package com.allen.springbootweb.common;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Auther: 20190598
 * @Date: 2020/6/24 13:52
 * @Description:
 */
@Component
@Order(2)
public class MyCommandLineRunner2 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner2>>>>>>>>" + Arrays.toString(args));
    }
}
