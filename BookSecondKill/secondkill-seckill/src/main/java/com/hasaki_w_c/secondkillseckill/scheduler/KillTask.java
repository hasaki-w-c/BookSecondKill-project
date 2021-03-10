package com.hasaki_w_c.secondkillseckill.scheduler;

import com.hasaki_w_c.secondkillseckill.dao.KillDAO;
import com.hasaki_w_c.secondkillseckill.entity.Kill;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/3/4 15:07
 */
@Component
public class KillTask {

    @Resource
    private KillDAO killDAO;

    /**
     * RedisTemplate 是 Spring 封装的操作类，提供了一系列操作 Redis 的模板方法
     */
    @Resource
    private RedisTemplate redisTemplate;

    @Scheduled(cron = "0/5 * * * * ?")
    public void startKill() {
        List<Kill> ukList = killDAO.findUnstartKill();
        for (Kill k : ukList) {
            System.out.println(k.getKid() + "秒杀活动已启动");
            //删除以前重复的活动任务
            redisTemplate.delete("seckill:count:" + k.getKid());
            //有几个库存商品则初始化几个 List 对象
            for (int i = 0; i < k.getCount(); i ++) {
                redisTemplate.opsForList().rightPush("seckill:count:" + k.getKid(),k.getBookId());
            }
            k.setStatus(1);
            killDAO.update(k);
        }
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void endKill() {
        List<Kill> fList = killDAO.findFinishKill();
        for (Kill k : fList) {
            System.out.println(k.getKid() + "秒杀活动已结束");
            k.setStatus(2);
            killDAO.update(k);
            redisTemplate.delete("seckill:count:" + k.getKid());
        }
    }
}
