package com.hasaki_w_c.secondkill.controller;

import com.hasaki_w_c.secondkill.entity.Order;
import com.hasaki_w_c.secondkill.entity.OrderItem;
import com.hasaki_w_c.secondkill.service.OrderItemService;
import com.hasaki_w_c.secondkill.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

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

    @GetMapping("/order")
    @ResponseBody
    public ModelAndView showOrder(String oid) {
        ModelAndView mav = new ModelAndView("order");
        Order order = orderService.getOrder(oid);
        List<OrderItem> list = orderItemService.getOrderItem(oid);
        mav.addObject("order",order);
        mav.addObject("orderItemList",list);
        return mav;
    }
}
