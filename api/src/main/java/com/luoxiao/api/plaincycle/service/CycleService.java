package com.luoxiao.api.plaincycle.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.luoxiao.api.common.config.UrlConstant;
import com.luoxiao.api.common.util.UrlUtils;
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
     * @return: java.lang.String
     */
   public String getEarthCycle(){
       String url = UrlConstant.WARFRAME_STAT_URL;
        Map<String,Object> resMap = UrlUtils.getData(url);
        Boolean isSuccess = (Boolean) resMap.get("res");
        if(isSuccess){
            String dataStr = (String) resMap.get("data");
            JSONObject jsonObject = JSON.parseObject(dataStr);
           return jsonObject.getString("earthCycle");
        }
            return null;
    }

    public String getCetusCycle(){
        String url = UrlConstant.WARFRAME_STAT_URL;
        Map<String,Object> resMap = UrlUtils.getData(url);
        Boolean isSuccess = (Boolean) resMap.get("res");
        if(isSuccess){
            String dataStr = (String) resMap.get("data");
            JSONObject jsonObject = JSON.parseObject(dataStr);
            return jsonObject.getString("cetusCycle");
        }
        return null;
    }

}
