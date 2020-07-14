package com.allen.springbootmybatis.controller;

import com.allen.springbootmybatis.entity.Book;
import com.allen.springbootmybatis.mapper1.BookMapper1;
import com.allen.springbootmybatis.mapper2.BookMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;

/**
 * (Book)表控制层
 *
 * @author makejava
 * @since 2020-06-30 14:50:38
 */
@RestController
public class BookController {
    /**
     * 服务对象
     */
    //@Resource
    //private BookService bookService;

    @Autowired
    private BookMapper1 bookMapper1;

    @Autowired
    private BookMapper2 bookMapper2;


    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 单条数据
     */
    //@GetMapping("/selectOne")
    //public Book selectOne(Integer id) {
    //    return this.bookService.queryById(id);
    //}

    //@GetMapping("/addBook")
    //public boolean addBook(){
    //    Book book = new Book();
    //    book.setName("放风筝的人");
    //    book.setAuthor("卡勒德.胡塞尼");
    //    bookService.insert(book);
    //
    //    return true;
    //}

    @GetMapping("/queryByIdInDsOne/{id}")
    public Book queryBookByDsone( @PathVariable("id") Integer id){
        Book book = bookMapper1.queryById(id);
        return book;
    }

    @GetMapping("/queryAll")
    public List<Book> queryAll(Book book){
        List<Book> books = bookMapper1.queryAll(book);
        return books;
    }

    @GetMapping("/queryAllByDstwo")
    public List<Book> queryBookByDstwo(){
        List<Book> books = bookMapper2.queryAll(new Book());
        return books;
    }

    @GetMapping("/batchInsert")
    public int batchInsert(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("传习录","王阳明"));
        books.add(new Book("千年金融史", "威廉-戈兹曼"));

        int result = bookMapper1.batchInsert(books);

        return result;
    }

    @GetMapping("/queryByIds")
    public List<Book> queryByIds(String ids){
        String[] idArr = ids.split(",");
        List<Book> books = bookMapper1.queryByIds(idArr);
        return books;
    }

    @GetMapping("/queryByMap")
    public List<Book> queryByMap(){
        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("3", "3");

        List<Book> books = bookMapper1.queryByMap(map);
        return books;
    }

}