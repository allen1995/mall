package com.allen.springbootmybatis.controller;

import com.allen.springbootmybatis.entity.Book;
import com.allen.springbootmybatis.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Book)表控制层
 *
 * @author makejava
 * @since 2020-06-30 14:50:38
 */
@RestController
@RequestMapping("/book")
public class BookController {
    /**
     * 服务对象
     */
    @Resource
    private BookService bookService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Book selectOne(Integer id) {
        return this.bookService.queryById(id);
    }

    @GetMapping("/addBook")
    public boolean addBook(){
        Book book = new Book();
        book.setName("放风筝的人");
        book.setAuthor("卡勒德.胡塞尼");
        bookService.insert(book);

        return true;
    }

}