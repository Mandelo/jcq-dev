package com.luoxiao.api.plaincycle.entity;

import lombok.Data;

/**
 * @Classname EarthCycleEntity
 * @Description TODO
 * @Date 2020/1/6
 * @Created by luox
 */

@Data
public class EarthCycleEntity {

    private Integer id;
    private String expiry;
    private String activation;
    private boolean isDay;
    private String state;
    private String timeLeft;

}
