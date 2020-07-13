package com.allen.springbootmybatis.proxypattern.jdbc;

import com.allen.springbootmybatis.entity.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/7/13 10:39
 * @Description:
 */
public class TestMain {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, SQLException {
        SqlSession sqlSession = SqlSesseionFactory.build(DefaultSqlSession.class);
        List<Book> bookList = sqlSession.selectList("select * from book");
        System.out.println(bookList);
    }
}
