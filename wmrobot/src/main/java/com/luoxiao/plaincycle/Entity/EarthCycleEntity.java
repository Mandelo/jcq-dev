package com.luoxiao.plaincycle.Entity;

import lombok.Data;

/**
 * @Classname EarthCycleEntity
 * @Description TODO
 * @Date 2020/1/6
 * @Created by luox
 */

@Data
public class EarthCycleEntity {

    private String id;
    private String expiry;
    private String activation;
    private boolean isDay;
    private String state;
    private String timeLeft;

}
