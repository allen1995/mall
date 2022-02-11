package com.allen.springbootmybatisinterview;

import com.allen.springbootmybatisinterview.entity.Book;
import com.allen.springbootmybatisinterview.mapper.BookMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
//@MapperScan(basePackages = "com.allen.springbootmybatisinterview.mapper")
public class SpringbootMybatisInterviewApplicationTests {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test_BookMapper_selectAllBook() {
        List<Book> books = bookMapper.queryAllBook();
        System.out.println(books);
    }

    @Test
    public void test_BookMapper_selectByName() {
        List<Book> books = bookMapper.queryByName("三国");
        System.out.println(books);
    }

    @Test
    public void test_BookMapper_page() {
        //开启分页插件
        PageHelper.startPage(1,2);

        List<Book> books = bookMapper.pageAllBook();
        //封装分页后的数据
        PageInfo<Book> pageInfoBook = new PageInfo<>(books);
        System.out.println(pageInfoBook);
    }

    @Test
    public void test_BookMapper_query_TestIf() {
        List<Book> books = bookMapper.queryByName("三国");
        System.out.println(books);
    }

    @Test
    public void test_BookMapper_update_testTrim() {

        Map<String,String> map = new HashMap<>();
        map.put("name","三国演义1");
        map.put("author", "罗贯中1");
        int result = bookMapper.update(map);
        System.out.println(result);
    }
}
