package com.allen.springbootmybatisinterview;

import com.allen.springbootmybatisinterview.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2022/2/10 11:43
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testJdbcTemplate() {
        List<Book> books =jdbcTemplate.query("select * from book", new BeanPropertyRowMapper<>(Book.class));
        System.out.println(books);
    }
}
