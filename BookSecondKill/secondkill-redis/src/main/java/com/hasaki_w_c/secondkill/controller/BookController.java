package com.hasaki_w_c.secondkill.controller;

import com.hasaki_w_c.secondkill.entity.Book;
import com.hasaki_w_c.secondkill.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/2/28 15:52
 */
@Controller
public class BookController {

    Logger logger = LoggerFactory.getLogger(BookController.class);

    @Resource
    private BookService bookService;

    @GetMapping("/book")  //http://localhost/book?bid=xx
    public ModelAndView showBook(Integer bid) {
        logger.info("bid" + bid);
        ModelAndView mav = new ModelAndView("book");
        Book book = bookService.getBook(bid);
        mav.addObject("book",book);
        return mav;
    }
}
