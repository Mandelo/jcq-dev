package com.luoxiao.api.common.entity;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Classname CommonDicMapper
 * @Description TODO
 * @Date 2020/4/10
 * @Created by luox
 */
@Mapper
@Component
public interface CommonDicMapper extends BaseMapper<CommonDicEntity> {
}
