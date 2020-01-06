package com.luoxiao.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.luoxiao.api.wm.dao.WmItemDicMapper;
import com.luoxiao.api.wm.entity.WmItemDic;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ApiApplicationTests {

    @Resource
    WmItemDicMapper mapper;

    @Test
    void contextLoads() {
        EntityWrapper<WmItemDic> wrapper = new EntityWrapper<>();
        wrapper.like("search_key","牛p");
        List<WmItemDic> wmItemDics = mapper.selectList(wrapper);
        if(wmItemDics.size() > 0){
            WmItemDic res = wmItemDics.get(0);
            System.out.println(res);
        }
    }

}
