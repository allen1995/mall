package com.allen.springbootweb.controller;

import com.allen.springbootweb.dto.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

/**
 * @Auther: allen
 * @Date: 2020-06-07 09:22
 * @Description:
 */
@Controller
public class BookController {

    @RequestMapping("/book")
    @ResponseBody
    public Book book(){
        Book book = new Book();
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        book.setPrice(45f);
        book.setDate(LocalDate.now());
        return book;
    }
}
