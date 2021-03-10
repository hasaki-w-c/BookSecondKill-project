package com.hasaki_w_c.secondkillseckill.service;

import com.hasaki_w_c.secondkillseckill.dao.KillDAO;
import com.hasaki_w_c.secondkillseckill.dao.KillOrderDao;
import com.hasaki_w_c.secondkillseckill.entity.Kill;
import com.hasaki_w_c.secondkillseckill.entity.KillOrder;
import com.hasaki_w_c.secondkillseckill.service.exception.SecKillException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/3/4 18:44
 */
@Service
public class KillService {
    @Resource
    private KillDAO killDAO;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource  //RabbitMQ 客户端
    private RabbitTemplate rabbitTemplate;

    @Resource
    private KillOrderDao killOrderDao;

    public void processSecKill(Integer kid, Integer userid, Integer num) throws SecKillException {
        Kill k = killDAO.findById(kid);
        if (k == null) {
            //秒杀活动不存在
            throw new SecKillException("该商品秒杀活动不存在");
        }
        if (k.getStatus() == 0) {
            throw new SecKillException("该商品秒杀活动还未开始");
        }else if (k.getStatus() == 2) {
            throw new SecKillException("该商品秒杀活动已经结束");
        }

        Integer bookId = (Integer) redisTemplate.opsForList().leftPop("seckill:count:" + k.getKid());

        if (bookId != null) {
            // 判断是否已经抢购过
            Boolean isExisted = redisTemplate.opsForSet().isMember("seckill:users:" + k.getKid(), userid);
            if (!isExisted) {
                System.out.println("恭喜您抢到该商品了，快去下单吧!");
                redisTemplate.opsForSet().add("seckill:users:" + k.getKid(), userid);
            }else {
                redisTemplate.opsForList().rightPush("seckill:count:" + k.getKid(), k.getBookId());
                throw new SecKillException("抱歉，您已经参加过此活动了，请勿重复抢购");
            }
        }else {
            throw new SecKillException("抱歉，商品已被抢光啦,下次快来哦！");
        }
    }

    public String sendKillOrderToQueue(Integer userid) {
        System.out.println("准备向队列发送信息");
        //订单基本信息
        Map data = new HashMap();
        data.put("userid", userid);
        //UUID ： 不变的通用唯一标识符（UUID）的类
        String konum = UUID.randomUUID().toString();
        data.put("konum", konum);
        //附加额外订单信息

        // 将信息发送给 exchange-killOrder 交换器
        rabbitTemplate.convertAndSend("exchange-killOrder", null, data);
        return konum;
    }

    public KillOrder checkKillOrder(String konum) {
        KillOrder killOrder = killOrderDao.findBykonum(konum);
        return killOrder;
    }
}
