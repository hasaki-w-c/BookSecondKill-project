package com.hasaki_w_c.secondkill.dao;

import com.hasaki_w_c.secondkill.entity.Order;

import java.util.List;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/2/28 20:26
 */
public interface OrderDAO {
    public Order findOrder(String orderId);
    public List<Order> findAllOrder();
}
