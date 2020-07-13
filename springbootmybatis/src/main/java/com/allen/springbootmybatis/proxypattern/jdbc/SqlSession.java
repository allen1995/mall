package com.allen.springbootmybatis.proxypattern.jdbc;

import com.allen.springbootmybatis.entity.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/7/13 09:45
 * @Description:
 */
public interface SqlSession {
    List<Book> selectList(String statement) throws SQLException;
}
