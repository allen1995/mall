package com.allen.springbootmybatisinterview.mapper;

import com.allen.springbootmybatisinterview.entity.Book;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Auther: 20190598
 * @Date: 2022/2/10 13:35
 * @Description:
 */
@Mapper
public interface BookMapper {
    List<Book> queryAllBook();

    Page<Book> pageAllBook();

    List<Book> queryByName(String name);

    List<Book> queryTestIf(String name);

    int update(Map<String,String> map);
}
