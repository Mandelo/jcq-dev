package com.luoxiao.wm.entity;

import lombok.Data;

/**
 * @Classname UserEntity
 * @Description TODO
 * @Date 2019/12/25
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
