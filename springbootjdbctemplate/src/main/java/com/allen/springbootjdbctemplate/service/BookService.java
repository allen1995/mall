package com.allen.springbootjdbctemplate.service;

import com.allen.springbootjdbctemplate.dao.BookDao;
import com.allen.springbootjdbctemplate.module.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/6/30 14:08
 * @Description:
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> getAllBooks(){
        List<Book> books = bookDao.getAllBooks();
        return books;
    }

    public Book getBookById(int id){
        Book book = bookDao.getBookById(id);

        return book;
    }


    public int addBook(Book book){
       return bookDao.addBook(book);
    }

    public int updateBook(Book book){
       return bookDao.updateBook(book);
    }

    public int deleteBookById(int id){
       return bookDao.deleteBookById(id);
    }
}
