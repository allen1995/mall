package com.allen.springbootweb.common;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Auther: allen
 * @Date: 2020-06-14 07:39
 * @Description:
 */
@Component
public class MyErrorViewResolver implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView("/error/errorPage");
        modelAndView.addObject("custommsg","出错啦");
        modelAndView.addAllObjects(model);

        return modelAndView;
    }
}
