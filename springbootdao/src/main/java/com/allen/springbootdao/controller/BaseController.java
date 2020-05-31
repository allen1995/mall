package com.allen.springbootdao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: allen
 * @Date: 2020-05-26 23:55
 * @Description:
 */
@Controller
public class  BaseController {

    @RequestMapping(value = "/stomp", method = RequestMethod.GET)
    public String home(){

        return "stomp";
    }
}
