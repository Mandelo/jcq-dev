package com.luoxiao.api.wm.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @Classname Wm_items_dic
 * @Description
 * @Date 2020/1/3
 * @Created by luox
 */
@Data
@TableName("wm_items_dic")
public class WmItemDic {

    @TableField("id")
    private Integer id;
    @TableField("search_key")
    private String searchKey;
    @TableField("item_wm_name")
    private String wmName;
    @TableField("item_eng_name")
    private String itemEngName;
    @TableField("item_chn_name")
    private String itemChnName;

}
