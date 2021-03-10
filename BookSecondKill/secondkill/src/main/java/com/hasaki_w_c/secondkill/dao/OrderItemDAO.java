package com.hasaki_w_c.secondkill.dao;

import com.hasaki_w_c.secondkill.entity.OrderItem;

import java.util.List;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/3/1 10:16
 */
public interface OrderItemDAO {
    public List<OrderItem> findOrderItem(String orderId);
}
