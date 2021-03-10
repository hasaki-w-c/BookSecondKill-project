package com.hasaki_w_c.secondkillseckill.entity;

import java.util.Date;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2021/3/5 14:48
 */
public class KillOrder {
    private Integer koid;
    private String konum;
    private Integer kostatus;
    private Integer userid;
    private String name;
    private String address;
    private String mobile;
    private float postage;
    private float pay;
    private Date createTime;

    public Integer getKoid() {
        return koid;
    }

    public void setKoid(Integer koid) {
        this.koid = koid;
    }

    public String getKonum() {
        return konum;
    }

    public void setKonum(String konum) {
        this.konum = konum;
    }

    public Integer getKostatus() {
        return kostatus;
    }

    public void setKostatus(Integer kostatus) {
        this.kostatus = kostatus;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public float getPostage() {
        return postage;
    }

    public void setPostage(float postage) {
        this.postage = postage;
    }

    public float getPay() {
        return pay;
    }

    public void setPay(float pay) {
        this.pay = pay;
    }

    public Date getCrateTime() {
        return createTime;
    }

    public void setCreateTime(Date crateTime) {
        this.createTime = crateTime;
    }
}
