/**
 * 由于Springboot 只能生效一个配置类，所以只能合并去别的配置类
 */

//package com.hasaki_w_c.secondkill.commons.web;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.annotation.Resource;
//
///**
// * @author hasaki_w_c
// * @version 1.0
// * @date 2021/3/8 19:45
// */
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Resource
//    AntiRefreshInterceptor antiRefreshInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(antiRefreshInterceptor).addPathPatterns("/book");
//    }
//}
