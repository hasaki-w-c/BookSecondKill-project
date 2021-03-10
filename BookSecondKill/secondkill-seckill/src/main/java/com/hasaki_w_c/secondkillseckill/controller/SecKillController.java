package com.hasaki_w_c.secondkillseckill.controller;

import com.hasaki_w_c.secondkillseckill.entity.KillOrder;
import com.hasaki_w_c.secondkillseckill.service.KillService;
import com.hasaki_w_c.secondkillseckill.service.exception.SecKillException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/3/4 19:07
 */
@Controller
public class SecKillController {
    @Resource
    private KillService killService;

    @RequestMapping("/seckill")
    @ResponseBody
    public Map processSecKill(Integer kid, Integer userid) {
        Map result = new HashMap(2);
        try {
            killService.processSecKill(kid,userid,1);
            String konum = killService.sendKillOrderToQueue(userid);
            Map data = new HashMap();
            data.put("konum",konum);
            // 1 代表操作成功
            result.put("code","1");
            result.put("message","success");
            result.put("data",data);
        } catch (SecKillException e) {
            result.put("code","0");
            result.put("message",e.getMessage());
        }
        return result;
    }

    @GetMapping("/checkKillOrder")
    public ModelAndView checkKillOrder(String konum) {
        KillOrder killOrder = killService.checkKillOrder(konum);
        ModelAndView mav = new ModelAndView();
        if (killOrder != null) {
            mav.addObject("killOrder",killOrder);
            mav.setViewName("/killOrder");
        }else {
            mav.addObject("konum", konum);
            mav.setViewName("/waiting");
        }
        return mav;
    }
}
