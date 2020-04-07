package com.luoxiao.api.plaincycle.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.luoxiao.api.common.config.UrlConstant;
import com.luoxiao.api.common.util.UrlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Classname CycleService
 * @Description 时间查询
 * @Date 2020/1/6
 * @Created by luox
 */
@Service
public class CycleService {

    Logger logger = LoggerFactory.getLogger(CycleService.class);


    /**
     * @description : 获取地球时间
     * @param :
     * @return: java.lang.String
     */
    public String getEarthCycle() {
        String url = UrlConstant.WARFRAME_STAT_URL;
        Map<String, Object> resMap = UrlUtils.getData(url);
        Boolean isSuccess = (Boolean) resMap.get("res");
        if (isSuccess) {
            String dataStr = (String) resMap.get("data");
            JSONObject jsonObject = JSON.parseObject(dataStr);
            return jsonObject.getString("earthCycle");
        }
        return null;
    }

    /**
     * @description : 获取希图斯时间
     * @param :
     * @return: java.lang.String
     */
    public String getCetusCycle() {
        String url = UrlConstant.WARFRAME_STAT_URL;
        Map<String, Object> resMap = UrlUtils.getData(url);
        Boolean isSuccess = (Boolean) resMap.get("res");
        if (isSuccess) {
            String dataStr = (String) resMap.get("data");
            JSONObject jsonObject = JSON.parseObject(dataStr);
            return jsonObject.getString("cetusCycle");
        }
        return null;
    }

}
