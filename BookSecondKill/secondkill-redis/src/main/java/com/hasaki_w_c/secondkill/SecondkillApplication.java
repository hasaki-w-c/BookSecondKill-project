package com.hasaki_w_c.secondkill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author hasaki_w_c
 */
@SpringBootApplication
@MapperScan("com.hasaki_w_c.secondkill")  //mybatis 在 SB 启动的时候自动扫描 Mybatis 实现的接口
@EnableCaching  //开启声明式缓存，利用注解来控制缓存的读写
public class SecondkillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondkillApplication.class, args);
    }

    /**
     * 修改默认的 redisTemplate 持久化方式。
     */
    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        //设置 value 的序列化方式为 JOSON
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        //设置 key 的序列化方式为 String
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

}
