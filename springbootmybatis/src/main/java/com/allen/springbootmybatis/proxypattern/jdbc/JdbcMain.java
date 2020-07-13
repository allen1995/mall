package com.allen.springbootmybatis.proxypattern.jdbc;

import com.allen.springbootmybatis.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/7/10 16:57
 * @Description:
 */
public class JdbcMain {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //建立连接
        String url = "jdbc:mysql://192.168.181.140:3306/sakila?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);

        //执行sql查询
        PreparedStatement ps = conn.prepareStatement("select * from book");
        //ps.setLong(1,1L);


        //获取结果
        ResultSet resultSet = ps.executeQuery();
        List<Book> books = new ArrayList<>();
        while ( resultSet.next()){
            Book book =new Book();
            book.setId(resultSet.getInt("id"));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString("author"));
            books.add(book);
        }

        System.out.println(books);

        conn.close();
    }
}
