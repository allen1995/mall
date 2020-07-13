package com.allen.springbootmybatis.proxypattern.jdbc;

import com.allen.springbootmybatis.entity.Book;

import javax.naming.spi.ObjectFactory;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/7/13 09:41
 * @Description:
 */
public class SqlSessionHandler implements InvocationHandler {

    /**
     * JDBC连接URL
     */
    private static final String URL = "jdbc:mysql://192.168.181.140:3306/sakila?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";

    /**
     * 用户名
     */
    private static final String USERNAME = "root";

    /**
     * 密码
     */
    private static final String PASSWORD = "root";

    private SqlSession sqlSession;

    private Connection connection;

    public SqlSessionHandler(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            Class sqlSessionClass = sqlSession.getClass();
            Field[] fields = sqlSessionClass.getDeclaredFields();

            //给SqlSession的connection赋值
            for (int i = 0; i < fields.length; i++) {
                if ( "connection".equals(fields[i].getName())){
                    fields[i].setAccessible(true);
                    fields[i].set(sqlSession, connection);
                }
            }

            List<Book> value = (List<Book>) method.invoke(sqlSession, args);

            return value;
        } finally {
            connection.close();
        }
    }
}
