package com.hasaki_w_c.secondkill.dao;

import com.hasaki_w_c.secondkill.entity.Evaluate;

import java.util.List;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/3/2 19:51
 */
public interface EvaluateDAO {
    public List<Evaluate> findByBookId(Integer bid);
}
