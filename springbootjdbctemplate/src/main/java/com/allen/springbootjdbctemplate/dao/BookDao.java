package com.allen.springbootjdbctemplate.dao;

import com.allen.springbootjdbctemplate.module.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/6/30 11:55
 * @Description:
 */
@Repository
public class BookDao {

    @Autowired
    @Qualifier("oneJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<Book> getAllBooks(){
        String sql = "select * from book";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        return  books;
    }

    public Book getBookById(int id){
        String sql = " select id,name,author from book where id=?";
        List<Book> books = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));

        return books != null && books.size()>0 ? books.get(0) : null;
    }

    public int addBook(Book book){
        String sql = "insert into book(name,author) values(?,?)";
        return jdbcTemplate.update(sql,new Object[]{
           book.getName(),book.getAuthor()
        });
    }

    public int updateBook(Book book){
        String sql = "update book set name=?,author=? where id=?";
        return jdbcTemplate.update(sql, new Object[]{
                book.getName(),
                book.getAuthor(),
                book.getId()
        });
    }

    public int deleteBookById(int id){
        String sql = "delete from book where id=?";
        return jdbcTemplate.update(sql, id);
    }
}
