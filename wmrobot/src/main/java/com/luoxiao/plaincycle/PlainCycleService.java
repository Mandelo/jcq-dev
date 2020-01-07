package com.luoxiao.plaincycle;

import com.alibaba.fastjson.JSON;
import com.luoxiao.common.constant.UrlAddressConstant;
import com.luoxiao.common.util.UrlUtils;
import com.luoxiao.plaincycle.Entity.CetusCycleEntity;
import com.luoxiao.plaincycle.Entity.EarthCycleEntity;

import java.util.Map;

/**
 * @Classname PlainCycleService
 * @Description TODO
 * @Date 2020/1/7
 * @Created by luox
 */
public class PlainCycleService {


    public static String getEarthCycle() {
        String url = UrlAddressConstant.EARTH_CYCLE_URL;
        Map<String, Object> resMap = UrlUtils.getData(url);
        boolean isSuccess = (boolean) resMap.get("res");
        if (isSuccess) {
            String dataStr = (String) resMap.get("data");
            EarthCycleEntity entity = JSON.parseObject(dataStr,EarthCycleEntity.class);
            if (null != entity) {
                StringBuffer sb = new StringBuffer();
                entity.getState().equals("day");
                String day = entity.getState().equals("day") ? "白天" : "晚上";
                String next = "白天".equals(day) ? "晚上" : "白天";
                String timeLeft = entity.getTimeLeft();
                String timeLeftCh = timeLeft
                        .replace("h", "小时")
                        .replace("m", "分钟")
                        .replace("s", "秒");

                sb
                        .append("当前地球时间为: ")
                        .append(day)
                        .append("\n")
                        .append("距离 ").append(next).append(" : ").append(timeLeftCh);
                return sb.toString();
            }
        }
        return "未查询到任何信息";
    }

    public static String getCetusCycle() {
        String url = UrlAddressConstant.CETUS_CYCLE_URL;
        Map<String, Object> resMap = UrlUtils.getData(url);
        boolean isSuccess = (boolean) resMap.get("res");
        if (isSuccess) {
            String dataStr = (String) resMap.get("data");
            CetusCycleEntity entity = JSON.parseObject(dataStr, CetusCycleEntity.class);
            if (null != entity) {
                StringBuffer sb = new StringBuffer();
                entity.getState().equals("day");
                String day = entity.getState().equals("day") ? "白天" : "晚上";
                String next = "白天".equals(day) ? "晚上" : "白天";
                String timeLeft = entity.getTimeLeft();
                String timeLeftCh = timeLeft
                        .replace("h", "小时")
                        .replace("m", "分钟")
                        .replace("s", "秒");

                sb
                        .append("当前希图斯时间为: ")
                        .append(day)
                        .append("\n")
                        .append("距离 ").append(next).append(" : ").append(timeLeftCh);
                return sb.toString();
            }
        }
        return "未查询到任何信息";
    }
}
