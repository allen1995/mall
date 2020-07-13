package com.allen.springbootmybatis.proxypattern.jdbc;

import java.lang.reflect.Proxy;

/**
 * @Auther: 20190598
 * @Date: 2020/7/13 10:35
 * @Description:
 */
public class SqlSesseionFactory {

    private SqlSesseionFactory(){}

    public static SqlSession build(Class classFile) throws IllegalAccessException, InstantiationException {

        SqlSession sqlSession = (SqlSession) classFile.newInstance();

        SqlSessionHandler advice = new SqlSessionHandler(sqlSession);

        SqlSession $proxy = (SqlSession) Proxy.newProxyInstance(sqlSession.getClass().getClassLoader(), sqlSession.getClass().getInterfaces(),
                advice);

        return $proxy;
    }
}
