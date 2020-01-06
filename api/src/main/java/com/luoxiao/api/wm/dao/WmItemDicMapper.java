package com.luoxiao.api.wm.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.luoxiao.api.wm.entity.WmItemDic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Classname WmItemMapper
 * @Description
 * @Date 2020/1/3
 * @Created by luox
 */

@Component
@Mapper
public interface WmItemDicMapper extends BaseMapper<WmItemDic> {
}
