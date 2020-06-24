package com.allen.springbootweb.common;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Auther: 20190598
 * @Date: 2020/6/24 13:49
 * @Description:
 */
@Component
@Order(1)
public class MyCommandLineRunnber1 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunnber1>>>>>>" + Arrays.toString(args));
    }
}
