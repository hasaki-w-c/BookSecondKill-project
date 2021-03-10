package com.hasaki_w_c.secondkill.commons.web;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/3/8 19:44
 * 拦截器
 */
@Component
public class AntiRefreshInterceptor implements HandlerInterceptor {

    @Resource
    /**
     * RedisTemplate 用于简化 Redis 操作，在 IOC 容器中自动被初始化
     */
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        System.out.println("preHandle");
        String clientIP = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        System.out.println(userAgent);
        //commons.codec.digest.DigestUtils.md5Hex 进行摘要，对字符串长度缩减
        String key = "anti:refresh:" + DigestUtils.md5Hex(clientIP + "_" + userAgent);


        response.setContentType("text/html;charset=utf-8");

        if (redisTemplate.hasKey("anti:refresh:blacklist")) {
            if (redisTemplate.opsForSet().isMember("anti:refresh:blacklist" , clientIP)) {
                response.getWriter().println("检测到您的IP访问异常，已被加入到黑名单！");
                return false;
            }
        }

        Integer num = (Integer) redisTemplate.opsForValue().get(key);
        if (num == null) {  //第一次访问
            redisTemplate.opsForValue().set(key, 1L, 60, TimeUnit.SECONDS);
        }else {

            if (num > 30 && num < 100) {
                response.getWriter().println("请求过于频繁，请稍后再试！");
                redisTemplate.opsForValue().increment(key, 1);
                return false;
            }else if (num >= 100) {
                response.getWriter().println("检测到您的IP访问异常，已被加入到黑名单！");
                redisTemplate.opsForSet().add("anti:refresh:blacklist", clientIP);
                return false;
            }else {
                redisTemplate.opsForValue().increment(key, 1);
            }

        }
        return true;
    }
}
