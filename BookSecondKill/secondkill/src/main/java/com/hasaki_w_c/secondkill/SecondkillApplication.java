package com.hasaki_w_c.secondkill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hasaki_w_c
 */
@SpringBootApplication
@MapperScan("com.hasaki_w_c.secondkill")  //mybatis 在 SB 启动的时候自动扫描 Mybatis 实现的接口
public class SecondkillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondkillApplication.class, args);
    }

}
