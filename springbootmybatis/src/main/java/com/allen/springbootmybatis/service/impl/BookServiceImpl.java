//package com.allen.springbootmybatis.service.impl;
//
//import com.allen.springbootmybatis.entity.Book;
//import com.allen.springbootmybatis.dao.BookDao;
//import com.allen.springbootmybatis.mapper1.BookMapper1;
//import com.allen.springbootmybatis.service.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
// * (Book)表服务实现类
// *
// * @author makejava
// * @since 2020-06-30 14:50:37
// */
//@Service("bookService")
//public class BookServiceImpl implements BookService {
//    @Autowired
//    private BookMapper1 bookDao;
//
//    /**
//     * 通过ID查询单条数据
//     *
//     * @param id 主键
//     * @return 实例对象
//     */
//    @Override
//    public Book queryById(Integer id) {
//        return this.bookDao.queryById(id);
//    }
//
//    /**
//     * 查询多条数据
//     *
//     * @param offset 查询起始位置
//     * @param limit 查询条数
//     * @return 对象列表
//     */
//    @Override
//    public List<Book> queryAllByLimit(int offset, int limit) {
//        return this.bookDao.queryAllByLimit(offset, limit);
//    }
//
//    /**
//     * 新增数据
//     *
//     * @param book 实例对象
//     * @return 实例对象
//     */
//    @Override
//    public Book insert(Book book) {
//        this.bookDao.insert(book);
//        return book;
//    }
//
//    /**
//     * 修改数据
//     *
//     * @param book 实例对象
//     * @return 实例对象
//     */
//    @Override
//    public Book update(Book book) {
//        this.bookDao.update(book);
//        return this.queryById(book.getId());
//    }
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param id 主键
//     * @return 是否成功
//     */
//    @Override
//    public boolean deleteById(Integer id) {
//        return this.bookDao.deleteById(id) > 0;
//    }
//}