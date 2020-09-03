package com.allen.springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: 20190598
 * @Date: 2020/9/3 11:24
 * @Description:
 */
@Controller
public class LoginController {

    @GetMapping("/login_page")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login_page");

        return modelAndView;
    }
}
