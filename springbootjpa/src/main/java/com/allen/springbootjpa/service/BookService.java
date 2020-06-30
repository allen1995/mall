package com.allen.springbootjpa.service;

import com.allen.springbootjpa.dao.BookDao;
import com.allen.springbootjpa.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/6/30 16:22
 * @Description:
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void addBook(Book book){
        bookDao.save(book);
    }

    public Page<Book> getBookByPage(Pageable pageable){
        return bookDao.findAll(pageable);
    }

    public List<Book> getBooksByAuthorStartingWith(String author){
        return bookDao.getBooksByAuthorStartingWith(author);
    }

    public List<Book> getBooksByPriceCreaterThan(Float price){
        return bookDao.getBooksByPriceGreaterThan(price);
    }

    public Book getMaxIdBook(){
        return bookDao.getMaxIdBook();
    }

    public List<Book> getBookByIdAndAuthor(String author, Integer id){

        return bookDao.getBookByIdAndAuthor(author,id);
    }

    public List<Book> getBooksByIdAndName(String name,Integer id){
        return bookDao.getBooksByIdAndName(name, id);
    }
}
