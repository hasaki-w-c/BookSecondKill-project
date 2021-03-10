package com.hasaki_w_c.secondkillseckill.service;

import com.hasaki_w_c.secondkillseckill.dao.KillOrderDao;
import com.hasaki_w_c.secondkillseckill.entity.KillOrder;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/3/6 14:26
 */
@Component
public class KillOrderConsumer {
    @Resource
    private KillOrderDao killOrderDao;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "queue-killOrder") ,
                    exchange = @Exchange(value = "exchange-killOrder", type = "direct")
            )
    )
    @RabbitHandler
    public void handleMessage(@Payload Map data, Channel channel, @Headers Map<String, Object> header) {
        System.out.println("------------获取到订单数据：" + data + "-------------");
        try {

            //对接支付宝、对接物流系统、日志登记。。。
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //对接支付宝、对接物流系统、日志登记。。。
            KillOrder killOrder = new KillOrder();
            killOrder.setKonum(data.get("konum").toString());
            killOrder.setKostatus(0);
            killOrder.setUserid((Integer) data.get("userid"));
            killOrder.setName("xxx");
            killOrder.setMobile("12345678910");
            killOrder.setAddress("xxx市xxx街道xxx号");
            killOrder.setPay(9.9f);
            killOrder.setPostage(0f);
            killOrder.setCreateTime(new Date());
            killOrderDao.insert(killOrder);
            Long tag = (Long) header.get(AmqpHeaders.DELIVERY_TAG);
            //消息确认 第一个参数是消息在当前 channel 中的 id 号，第二个参数表示是否进行批量接收
            channel.basicAck(tag, false);
            System.out.println(data.get("konum") + " 订单已创建");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
