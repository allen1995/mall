package com.allen.springbootweb.aop;

import org.springframework.stereotype.Service;

/**
 * @Auther: 20190598
 * @Date: 2020/6/24 14:50
 * @Description:
 */
@Service
public class UserService {

    public String getUserById(String id){
        System.out.println("get...");
        return "user";
    }

    public void deleteUser(String id){
        System.out.println("delete...");
    }
}
