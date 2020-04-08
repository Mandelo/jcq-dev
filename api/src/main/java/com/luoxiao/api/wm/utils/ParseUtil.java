package com.luoxiao.api.wm.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.luoxiao.api.wm.entity.Order;
import com.luoxiao.api.wm.entity.OrderDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ParseUtil
 * @Description
 * @Date 2020/1/3
 * @Created by luox
 */
@Component
public class ParseUtil {
    public static List<OrderDto> handleData(String jsonStr) {
        //提取order的JSON数组
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        String orderStr = jsonObject.getString("payload");
        JSONObject jsonObject1 = JSON.parseObject(orderStr);
        String orderStr1 = jsonObject1.getString("orders");
        List<Order> orders = JSON.parseArray(orderStr1, Order.class);
        List<OrderDto> onLineOrder = new ArrayList<>();
        List<OrderDto> top5 = new ArrayList<>();
        //仅返回在线玩家
        for (Order o : orders) {
            if ("ingame".equals(o.getUser().getStatus()) && "pc".equals(o.getPlatform())&&"sell".equals(o.getOrder_type()) ) {
                OrderDto dto = new OrderDto();
                dto.setPlatinum(o.getPlatinum());
                dto.setIngame_name(o.getUser().getIngame_name());
                onLineOrder.add(dto);
            }
        }
        int maxCount;
        //仅仅返回五条3条数据
        List<OrderDto> priceSortList = priceSort(onLineOrder);
        List<OrderDto> resList = new ArrayList<>();
        if (onLineOrder.size() > 3) {
            maxCount = 3;
        } else {
            maxCount = onLineOrder.size();
        }
        for (int i = 0; i < maxCount; i++) {
            resList.add(priceSortList.get(i));
        }
        return resList;
    }

    //按照价格从低到高排序
    private static List<OrderDto> priceSort(List<OrderDto> orderList) {
        for (int i = 0; i < orderList.size(); i++) {
            for (int j = 0; j < orderList.size() - i - 1; j++) {
                if (new Double(orderList.get(j).getPlatinum()).intValue() > new Double(orderList.get(j + 1).getPlatinum()).intValue()) {
                    OrderDto temp = new OrderDto();
                    temp.setPlatinum(orderList.get(j).getPlatinum());
                    temp.setIngame_name(orderList.get(j).getIngame_name());
                    orderList.get(j).setPlatinum(orderList.get(j + 1).getPlatinum());
                    orderList.get(j).setIngame_name(orderList.get(j + 1).getIngame_name());
                    orderList.get(j + 1).setPlatinum(temp.getPlatinum());
                    orderList.get(j + 1).setIngame_name(temp.getIngame_name());
                }
            }

        }
        return orderList;
    }
}
