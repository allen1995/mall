package com.allen.springbootmybatis.proxypattern.jdbc;

import com.allen.springbootmybatis.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/7/13 10:11
 * @Description:
 */
public class DefaultSqlSession implements SqlSession{

    private Connection connection;

    @Override
    public  List<Book> selectList(String statement) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(statement);

        ResultSet resultSet = ps.executeQuery();
        List<Book> books = new ArrayList<>();
        while ( resultSet.next()){
            Book book =new Book();
            book.setId(resultSet.getInt("id"));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString("author"));
            books.add(book);
        }
        return books;
    }
}
