package com.hasaki_w_c.secondkill.service;

import com.hasaki_w_c.secondkill.dao.OrderDAO;
import com.hasaki_w_c.secondkill.entity.Order;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/2/28 20:30
 */
@Service
public class OrderService {

    @Resource
    private OrderDAO orderDAO;

    @Cacheable(value = "order", key = "#orderId")
    public Order getOrder(String orderId) {
        return orderDAO.findOrder(orderId);
    }
}
