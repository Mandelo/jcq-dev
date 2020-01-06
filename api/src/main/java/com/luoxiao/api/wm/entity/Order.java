package com.luoxiao.api.wm.entity;

import lombok.Data;

/**
 * @Classname Order
 * @Description
 * @Date 2020/1/3
 * @Created by luox
 */

@Data
public class Order {

    private String id;
    private User user;
    private String platform;
    private String region;
    private String order_type;
    private double platinum;
    private String last_update;
    private String quantity;
    private String visible;
    private String create_date;
    private String status;//在线状态


}
