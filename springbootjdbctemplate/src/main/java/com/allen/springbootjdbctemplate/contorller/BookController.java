package com.allen.springbootjdbctemplate.contorller;

import com.allen.springbootjdbctemplate.module.dto.Book;
import com.allen.springbootjdbctemplate.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/6/30 14:15
 * @Description:
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    @Qualifier("oneJdbcTemplate")
    private JdbcTemplate oneJdbcTemplate;

    @Autowired
    @Qualifier("twoJdbcTemplate")
    private JdbcTemplate twoJdbcTemplate;

    @GetMapping("/bookOps")
    public void bookOps(){
        Book book = new Book("西厢记","王实甫");
        int i = bookService.addBook(book);
        System.out.println("addBook>>>>>>>>" + i);

        Book b2 = new Book(1, "朝花夕拾","鲁迅");
        int j = bookService.updateBook(b2);
        System.out.println("updateBook>>>>>>>>>" + j);

        int m = bookService.deleteBookById(2);
        System.out.println("deleteBook>>>>>>>>>" + m);

        Book b3 = bookService.getBookById(1);
        System.out.println("getBookById>>>>>>>>>>>" + b3);
    }


    @GetMapping("bookInDsone")
    public  List<Book>  bookByDataSourceOne(){
        List<Book> books = oneJdbcTemplate.query("select * from book",new BeanPropertyRowMapper<>(Book.class));

        return books;
    }

    @GetMapping("bookInDstwo")
    public  List<Book>  bookByDataSourceTwo(){
        List<Book> books = twoJdbcTemplate.query("select * from book",new BeanPropertyRowMapper<>(Book.class));

        return books;
    }
}
