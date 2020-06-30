package com.allen.springbootjpa.controller;

import com.allen.springbootjpa.entity.Book;
import com.allen.springbootjpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/6/30 16:30
 * @Description:
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/findall/{page}")
    public void  findAll(@PathVariable("page") int page){
        PageRequest pageable = PageRequest.of(page, 3);
        Page<Book> pages = bookService.getBookByPage(pageable);

        System.out.println("总页数：" + pages.getTotalPages());
        System.out.println("总记录数：" + pages.getTotalElements());
        System.out.println("查询结果：" + pages.getContent());
        System.out.println("当前页数：" + (pages.getNumber() + 1));
        System.out.println("当前页记录数：" + pages.getNumberOfElements());
        System.out.println("每页记录数：" + pages.getSize()) ;
    }

    @GetMapping("/search")
    public void search(){
        List<Book> b1 = bookService.getBooksByAuthorStartingWith("罗");
        List<Book> b2 = bookService.getBookByIdAndAuthor("鲁迅", 1);
        Book b = bookService.getMaxIdBook();

        System.out.println("b1:" + b1);
        System.out.println("b2:" + b2);
        System.out.println("b:" + b);

    }
}
