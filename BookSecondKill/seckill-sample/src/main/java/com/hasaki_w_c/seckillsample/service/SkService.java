package com.hasaki_w_c.seckillsample.service;

import com.hasaki_w_c.seckillsample.dao.SKDAO;
import org.springframework.stereotype.Service;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/3/3 21:23
 */
@Service
public class SkService {
    private SKDAO skdao = new SKDAO();

    public void processSecKill() {
        Integer count = skdao.getCount();
        if (count > 0) {
            System.out.println("恭喜您，获得购买的权力");
            count -= 1;
            skdao.updateCount(count);
        }else {
            System.out.println("抱歉，商品已被抢购完");
        }
    }
}
