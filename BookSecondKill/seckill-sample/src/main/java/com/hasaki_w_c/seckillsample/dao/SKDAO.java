package com.hasaki_w_c.seckillsample.dao;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/3/3 21:21
 */
public class SKDAO {
    public static Integer count = 10;

    public Integer getCount() {
        return SKDAO.count;
    }

    public void updateCount(Integer count) {
        SKDAO.count = count;
    }
}
