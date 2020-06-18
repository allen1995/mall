package com.allen.springbootweb.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @Auther: allen
 * @Date: 2020-06-10 22:09
 * @Description:
 */
@ControllerAdvice
public class CustomExceptionHandler {

    private Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView uploadExcepiton(MaxUploadSizeExceededException e, HttpServletResponse resp) throws IOException {
        LOGGER.info("文件上传异常", e);

        //resp.setContentType("text/html;charset=utf-8");
        //Writer out = resp.getWriter();
        //out.write("上传文件超出异常!");
        //out.flush();
        //out.close();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","文件大小超出异常");
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
