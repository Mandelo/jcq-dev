package com.luoxiao.api.wm.entity;

import lombok.Data;

/**
 * @Classname User
 * @Description
 * @Date 2020/1/3
 * @Created by luox
 */

@Data
public class User {

    private String id;
    private String ingame_name; //昵称
    private String last_seen;
    private String reputation_bonus;
    private String reputation;
    private String region;
    private String status;
    private String avatar;//头像

}