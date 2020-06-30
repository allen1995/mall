package com.allen.springbootjdbctemplate.contorller;

import com.allen.springbootjdbctemplate.module.dto.Book;
import com.allen.springbootjdbctemplate.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 20190598
 * @Date: 2020/6/30 14:15
 * @Description:
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

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
}
