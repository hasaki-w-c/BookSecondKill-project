package com.hasaki_w_c.secondkill.controller;

import com.hasaki_w_c.secondkill.entity.Book;
import com.hasaki_w_c.secondkill.entity.Evaluate;
import com.hasaki_w_c.secondkill.service.BookService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * Freemarker 的核心配置类，用于动态生成模板对象
     * 在 SpringBoot IOC 容器初始化的时候，自动 Configuration 就被实例化了
     */
    @Resource
    private Configuration freemarkerConfig;

    @GetMapping("/book")  //http://localhost/book?bid=xx
    public ModelAndView showBook(Integer bid) {
        logger.info("bid" + bid);
        ModelAndView mav = new ModelAndView("book");
        Book book = bookService.getBook(bid);
        mav.addObject("book",book);
        return mav;
    }

    @GetMapping("/static/book={bid}")
    @ResponseBody
    public String doStatic(@PathVariable("bid") Integer bid) throws IOException, TemplateException {
        //获取模板对象
        Template template = freemarkerConfig.getTemplate("book.ftl");
        Map param = new HashMap();
        param.put("book", bookService.getBook(bid));
        File targetFile = new File("G:/secondKillStatic/book/" + bid + ".html");
        FileWriter out = new FileWriter(targetFile);
        template.process(param, out);
        out.close();
        return targetFile.getPath();
    }

    @GetMapping("/static_all_book")
    @ResponseBody
    public String doStatic() throws IOException, TemplateException {
        //获取模板对象
        Template template = freemarkerConfig.getTemplate("book.ftl");
        List<Book> allBook = bookService.getAllBook();
        for (Book b : allBook) {
            Integer bid = b.getId();
            Map param = new HashMap();
            param.put("book", bookService.getBook(bid));
            File targetFile = new File("G:/secondKillStatic/book/" + bid + ".html");
            FileWriter out = new FileWriter(targetFile);
            template.process(param, out);
            out.close();
        }
        return "SUCCESS";
    }

    @GetMapping("/evaluate/{bid}")
    @ResponseBody
    public List<Evaluate> findEvaluates(@PathVariable Integer bid) {
        return bookService.getEvaluates(bid);
    }
}
