package com.allen.springbootshiro.config;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: 20190598
 * @Date: 2020/9/4 16:40
 * @Description:
 */
@ControllerAdvice
public class ExceptionController  {

    @ExceptionHandler(AuthorizationException.class)
    public ModelAndView error(AuthorizationException e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("error", e.getMessage());
        return mv;
    }
}
