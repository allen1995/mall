package com.allen.springbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 20190598
 * @Date: 2020/9/2 19:14
 * @Description:
 */
@RestController
public class HelloController {

    @GetMapping("/admin/hello")
    public String admin(){
        return "hello,admin";
    }


    @GetMapping("/db/hello")
    public String dba(){
        return "hello,dba";
    }

    @GetMapping("/user/hello")
    public String user(){
        return "hello, allen";
    }


    @RequestMapping("/hello")
    public String hello(){

        return "hello, World!";
    }
}
