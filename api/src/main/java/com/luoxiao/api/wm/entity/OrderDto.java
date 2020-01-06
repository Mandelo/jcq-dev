package com.luoxiao.api.wm.entity;

import lombok.Data;

/**
 * @Classname OrderDto
 * @Description
 * @Date 2020/1/3
 * @Created by luox
 */

@Data
public class OrderDto {
    private String ingame_name;
    private double platinum;
    private String itemEngName;
    private String itemChnName;
}
