package com.hasaki_w_c.secondkill.controller;

import com.hasaki_w_c.secondkill.entity.Order;
import com.hasaki_w_c.secondkill.entity.OrderItem;
import com.hasaki_w_c.secondkill.service.OrderItemService;
import com.hasaki_w_c.secondkill.service.OrderService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
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
 * @date 2021/2/28 20:33
 */
@Controller
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private OrderItemService orderItemService;

    @Resource
    private Configuration freemarkerConfig;

    @GetMapping("/order")
    public ModelAndView showOrder(String oid) {
        ModelAndView mav = new ModelAndView("order");
        Order order = orderService.getOrder(oid);
        List<OrderItem> list = orderItemService.getOrderItem(oid);
        mav.addObject("order",order);
        mav.addObject("orderItemList",list);
        return mav;
    }

    @GetMapping("/static/order={oid}")
    @ResponseBody
    public String doStatic(@PathVariable("oid") String oid) throws IOException, TemplateException {
        //获取模板对象
        Template template = freemarkerConfig.getTemplate("order.ftl");
        Map param = new HashMap();
        param.put("order", orderService.getOrder(oid));
        param.put("orderItemList", orderItemService.getOrderItem(oid));
        File targetFile = new File("G:/secondKillStatic/order/" + oid + ".html");
        FileWriter out = new FileWriter(targetFile);
        template.process(param, out);
        out.close();
        return targetFile.getPath();
    }

    @GetMapping("/static_all_order")
    @ResponseBody
    public String doStatic() throws IOException, TemplateException {
        //获取模板对象
        Template template = freemarkerConfig.getTemplate("order.ftl");
        List<Order> allOrder = orderService.getAllOrder();
        for (Order o : allOrder) {
            String oid = o.getOrderId();
            Map param = new HashMap();
            param.put("order", orderService.getOrder(oid));
            param.put("orderItemList", orderItemService.getOrderItem(oid));
            File targetFile = new File("G:/secondKillStatic/order/" + oid + ".html");
            FileWriter out = new FileWriter(targetFile);
            template.process(param, out);
            out.close();
        }
        return "SUCCESS";
    }
}
