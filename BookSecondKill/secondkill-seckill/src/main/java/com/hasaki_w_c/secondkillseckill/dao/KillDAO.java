package com.hasaki_w_c.secondkillseckill.dao;

import com.hasaki_w_c.secondkillseckill.entity.Kill;

import java.util.List;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/3/4 15:04
 */
public interface KillDAO {
    List<Kill> findUnstartKill();

    void update(Kill kill);

    Kill findById(Integer kid);

    List<Kill> findFinishKill();
}
