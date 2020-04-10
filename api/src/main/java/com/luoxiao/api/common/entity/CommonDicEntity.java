package com.luoxiao.api.common.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @Classname CommonDicEntity
 * @Description TODO
 * @Date 2020/4/10
 * @Created by luox
 */
@Data
@TableName("common_dic")
public class CommonDicEntity {

    private Integer id;

    private String engName;

    private String cnName;

    private String typeName;


}
