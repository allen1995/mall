package com.allen.springbootmybatis;

import com.allen.springbootmybatis.entity.Book;
import com.allen.springbootmybatis.util.MyObjectFactory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/7/9 17:13
 * @Description:
 */
@SpringBootTest
public class MyObjectFactoryTest {

    @Test
    public void testCreatewithArgs(){
        MyObjectFactory myObjectFactory = new MyObjectFactory();
        List constructArgTypes = new ArrayList();
        constructArgTypes.add(Integer.class);
        constructArgTypes.add(String.class);
        constructArgTypes.add(String.class);
        constructArgTypes.add(String.class);

        List constructArgs = new ArrayList();
        constructArgs.add(2);
        constructArgs.add("三国演义");
        constructArgs.add(null);
        constructArgs.add("罗贯中");

        Book book = myObjectFactory.create(Book.class, constructArgTypes, constructArgs);

        Assert.assertEquals("新三国演义", book.getAliaseName());
    }
}
