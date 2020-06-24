package com.allen.springbootweb.controller;

import com.allen.springbootweb.aop.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 20190598
 * @Date: 2020/6/24 15:03
 * @Description:
 */
@RestController
public class UserContrller {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserById/{id}")
    public void getUserById( @PathVariable String id){
        userService.getUserById(id);
    }

    @GetMapping("/deleteUserById/{id}")
    public void deleteUserById(@PathVariable String id){
        userService.deleteUser(id);
    }
}
