package com.hasaki_w_c.secondkill.scheduler;

import com.hasaki_w_c.secondkill.entity.Book;
import com.hasaki_w_c.secondkill.service.BookService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 任务调度
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/3/2 15:35
 */
@Component  //组件类，IOC 容器扫描到后会自动加载
public class StaticTask {

    @Resource
    private BookService bookService;

    @Resource
    private Configuration freemarkerConfig;

    /**
     * public void xxx(){}
     *         cron表达式 ：    * * * * * ?     代表每秒钟执行一次
     *                       秒 分 时 日 月 星期
     *                       * 代表所有时间
     *               例：0,15,30,45 0 2 1 * ?  表示 每个月一号两点整的时候 0,15,30,45 秒各执行一次
     */
    @Scheduled(cron = "0 0/5 * * * ? ")
    public void doStatic() throws IOException, TemplateException {
        //获取模板对象
        Template template = freemarkerConfig.getTemplate("book.ftl");
        List<Book> allBook = bookService.getLast5M();
        for (Book b : allBook) {
            Integer bid = b.getId();
            Map param = new HashMap();
            param.put("book", bookService.getBook(bid));
            File targetFile = new File("G:/secondKillStatic/book/" + bid + ".html");
            FileWriter out = new FileWriter(targetFile);
            template.process(param, out);
            System.out.println(targetFile + "已生成！");
            out.close();
        }
    }
}
