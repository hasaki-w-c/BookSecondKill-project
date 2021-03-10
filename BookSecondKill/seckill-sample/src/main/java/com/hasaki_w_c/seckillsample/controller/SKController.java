package com.hasaki_w_c.seckillsample.controller;

import com.hasaki_w_c.seckillsample.service.SkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/3/3 21:29
 */
@Controller
public class SKController {
    @Resource
    private SkService skService = null;

    @GetMapping("/seckill")
    @ResponseBody
    public String doSecKill() {
        skService.processSecKill();
        return "OK";
    }
}
