package com.hasaki_w_c.secondkill.service;

import com.hasaki_w_c.secondkill.dao.OrderItemDAO;
import com.hasaki_w_c.secondkill.entity.OrderItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/3/1 10:18
 */
@Service
public class OrderItemService {
    @Resource
    private OrderItemDAO orderItemDAO;

    public List<OrderItem> getOrderItem(String orderId) {
        return orderItemDAO.findOrderItem(orderId);
    }
}
