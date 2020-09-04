package com.allen.springbootaurhority;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 20190598
 * @Date: 2020/9/3 16:13
 * @Description:
 */
@RestController
public class HelloController {

    @GetMapping("/user/hello")
    public String helloUser(){
        return "hello, allen";
    }

    @GetMapping("/db/hello")
    public String helloDba(){
        return "hello, dba";
    }

    @GetMapping("/admin/hello")
    public String helloAdmin(){
        return "hello, admin";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
