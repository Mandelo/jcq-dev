package com.luoxiao.api.plaincycle.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.luoxiao.api.common.util.UrlUtils;
import com.luoxiao.api.plaincycle.entity.EarthCycleEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Classname CycleService
 * @Description TODO
 * @Date 2020/1/6
 * @Created by luox
 */
@Service
public class CycleService {

    /**
     * @description : earth time
     * @param url:
     * @return: java.lang.String
     */
    String getEarthCycle(String url){
        Map<String,Object> resMap = UrlUtils.getData(url);
        Boolean isSuccess = (Boolean) resMap.get("res");
        if(isSuccess){
            String dataStr = (String) resMap.get("data");
            JSONObject jsonObject = JSON.parseObject(dataStr);
            String earthCycleStr = jsonObject.getString("earthCycle");
            EarthCycleEntity earthCycleEntity = JSON.parseObject(earthCycleStr,EarthCycleEntity.class);        }
            return null;
    }

}
