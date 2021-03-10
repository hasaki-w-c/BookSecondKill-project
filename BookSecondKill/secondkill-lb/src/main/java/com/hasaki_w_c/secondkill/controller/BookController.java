package com.hasaki_w_c.secondkill.controller;

import com.hasaki_w_c.secondkill.entity.Book;
import com.hasaki_w_c.secondkill.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
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

    @Value("${server.port}")
    private String port;

    @Resource
    private BookService bookService;

    @GetMapping("/book-{bid}.html")  //伪静态页面
    public ModelAndView showBook(@PathVariable("bid") Integer bid) {
        logger.info("port" + port);
        ModelAndView mav = new ModelAndView("book");
        Book book = bookService.getBook(bid);
        mav.addObject("book",book);
        return mav;
    }

    @GetMapping("/book1")  //http://localhost/book?bid=xx
    public ModelAndView showBook1(Integer bid) {
        logger.info("port" + port);
        ModelAndView mav = new ModelAndView("book1");
        Book book = bookService.getBook(bid);
        mav.addObject("book",book);
        return mav;
    }

    @GetMapping("/login")
    @ResponseBody
    public String login(String u, WebRequest request) {
        request.setAttribute("user", u ,WebRequest.SCOPE_SESSION);
        return "port:" + port +":SUCCESS";
    }

    @GetMapping("/check")
    @ResponseBody
    public String checkUser(WebRequest request) {
        String user = (String) request.getAttribute("user", WebRequest.SCOPE_SESSION);
        if (user != null) {
            return "port:" + port + ":user=" + user;
        }else {
            return "port:" + port + ":redirect to login";
        }
    }
}
