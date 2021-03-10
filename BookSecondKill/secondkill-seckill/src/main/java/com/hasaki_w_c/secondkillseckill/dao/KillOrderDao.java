package com.hasaki_w_c.secondkillseckill.dao;

import com.hasaki_w_c.secondkillseckill.entity.KillOrder;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/3/6 14:27
 */
public interface KillOrderDao {
    void insert(KillOrder killOrder);

    KillOrder findBykonum(String konum);

}
