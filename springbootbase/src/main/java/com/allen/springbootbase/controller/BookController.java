package com.allen.springbootbase.controller;

import com.allen.springbootbase.module.dto.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allen
 * @Date: 2020-05-31 16:29
 * @Description:
 */
@Controller
public class BookController {

    @GetMapping("/books")
    public ModelAndView getBooks(){
        ModelAndView modelAndView = new ModelAndView();
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"罗贯中","三国演义"));
        books.add(new Book(2,"施耐庵", " 水浒传"));
        books.add(new Book(3,"曹雪芹","红楼梦"));

        modelAndView.addObject("books", books);
        modelAndView.setViewName("books");

        return modelAndView;
    }

    @GetMapping("/booksbyfreemarker")
    public ModelAndView getBooksByFreeMarker(){
        ModelAndView modelAndView = new ModelAndView();
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"罗贯中","三国演义"));
        books.add(new Book(2,"施耐庵", " 水浒传"));
        books.add(new Book(3,"曹雪芹","红楼梦"));

        modelAndView.addObject("books", books);
        modelAndView.setViewName("booksbyfreemarker");

        return modelAndView;
    }

}
