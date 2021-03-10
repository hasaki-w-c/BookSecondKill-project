package com.hasaki_w_c.secondkill.service;

import com.hasaki_w_c.secondkill.dao.BookDAO;
import com.hasaki_w_c.secondkill.entity.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/2/28 17:28
 */
@Service
public class BookService {

    @Resource
    private BookDAO bookDAO;

    //view -> controller -> service -> dao

    /**
     * 注解 Cacheable 的含义: @Cacheable是声明式缓存的核心注解
     * 第一次访问的时候将方法的返回结果放入缓存
     * 第二次访问时不再执行方法内部的代码，而是从缓存中直接提取。
     * @param id id
     * @return 查询结果
     */
    @Cacheable(value = "book", key = "#id")  //key:  book::1  book::2  key中的值要和参数名对应
    public Book getBook(Integer id) {
        return bookDAO.findById(id);
    }
}
