package com.hasaki_w_c.secondkill.service;

import com.hasaki_w_c.secondkill.dao.BookDAO;
import com.hasaki_w_c.secondkill.entity.Book;
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

    public Book getBook(Integer id) {
        return bookDAO.findById(id);
    }
}
