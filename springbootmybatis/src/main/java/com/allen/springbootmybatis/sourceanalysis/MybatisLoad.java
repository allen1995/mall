package com.allen.springbootmybatis.sourceanalysis;

import com.allen.springbootmybatis.entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: 20190598
 * @Date: 2020/7/7 09:38
 * @Description:
 */
public class MybatisLoad {

    public static void main(String[] args) throws IOException {
        String resource = "com/allen/springbootmybatis/sourceanalysis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        Book book = sqlSession.selectOne("com.allen.springbootmybatis.sourceanalysis.selectBook", 1L);
        //Book book = sqlSession.selectOne("com.allen.springbootmybatis.mapper1.BookMapper1.queryById", 1L);
        System.out.println(book);

        sqlSession.close();
    }
}
