package com.hasaki_w_c.secondkill.dao;

import com.hasaki_w_c.secondkill.entity.Book;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/2/28 17:26
 */
public interface BookDAO {
    public Book findById(Integer id);
}
