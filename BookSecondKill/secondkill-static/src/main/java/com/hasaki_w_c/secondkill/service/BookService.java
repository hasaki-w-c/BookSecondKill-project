package com.hasaki_w_c.secondkill.service;

import com.hasaki_w_c.secondkill.dao.BookDAO;
import com.hasaki_w_c.secondkill.dao.EvaluateDAO;
import com.hasaki_w_c.secondkill.entity.Book;
import com.hasaki_w_c.secondkill.entity.Evaluate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/2/28 17:28
 */
@Service
public class BookService {

    @Resource
    private BookDAO bookDAO;

    @Resource
    private EvaluateDAO evaluateDAO;

    //view -> controller -> service -> dao

    public Book getBook(Integer id) {
        return bookDAO.findById(id);
    }

    public List<Book> getAllBook() {
        return bookDAO.findAll();
    }

    public List<Book> getLast5M() {
        return bookDAO.findLast5M();
    }

    public List<Evaluate> getEvaluates(Integer bid) {
        return evaluateDAO.findByBookId(bid);
    }
}
