package com.hasaki_w_c.secondkill.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/2/28 20:23
 */
public class Order implements Serializable {
    private String orderId;
    private Date createTime;
    private BigDecimal price;
    /**
     * 0表示未发货，1表示已发货，2表示已签收
     */
    private Integer status = 0;
    private Integer userId;

    public Order() {
    }

    public Order(String orderId, Date createTime, BigDecimal price, Integer status, Integer userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        if (status == 0 || status == 1 || status == 2) {
            this.status = status;
        }else {
            System.out.println("状态码不正确！");
        }
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
