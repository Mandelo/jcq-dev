package com.luoxiao.sortie.service;

import com.alibaba.fastjson.JSON;
import com.luoxiao.common.constant.UrlAddressConstant;
import com.luoxiao.common.util.UrlUtils;
import com.luoxiao.sortie.entity.SortieEntity;

import java.util.List;
import java.util.Map;

/**
 * @Classname SortieService
 * @Description 突击查询服务
 * @Date 2020/4/10
 * @Created by luox
 */

public class SortieService {

    public static String getSortie(){
        String url = UrlAddressConstant.SORTIE_URL;
        Map<String, Object> resMap = UrlUtils.getData(url);
        boolean isSuccess = (boolean) resMap.get("res");
        if(isSuccess){
            String dataStr = (String) resMap.get("data");
            if(null != dataStr){
                dataStr = dataStr.replaceAll("&","\n");
                return dataStr;
            }
        }
        return "突击获取失败";
    }

}
