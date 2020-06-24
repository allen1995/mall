package com.allen.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: allen
 * @Date: 2020-06-07 09:22
 * @Description:
 */
@Controller
public class BookController {

    @PostMapping("/book")
    @ResponseBody
    public String book(){
        //Book book = new Book();
        //book.setName("三国演义");
        //book.setAuthor("罗贯中");
        //book.setPrice(45f);
        //book.setDate(LocalDate.now());
        return "receive:三国演义";
    }

    @DeleteMapping("/book/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id){
        return String.valueOf(id);
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        //int i = 2/0;
        return "hello,world";
    }
}
