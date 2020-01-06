package com.luoxiao.wm.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.luoxiao.wm.entity.Order;
import com.luoxiao.wm.entity.OrderDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname DataHandler
 * @Description TODO
 * @Date 2019/12/26
 * @Created by luox
 */
public class DataHandler {

    public static String handleData(String jsonStr) {
        //提取order的JSON数组
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        String res = jsonObject.getString("res");
        if (null == res) {
            return "服务器错误";
        } else if ("true".equals(res)) {
            String orderDtoStr = jsonObject.getString("data");
            String itemEngName = jsonObject.getString("itemEngName");
            String itemChnName =  jsonObject.getString("itemChnName");
            List<OrderDto> dtoList = JSON.parseArray(orderDtoStr, OrderDto.class);
            StringBuffer sb = new StringBuffer();
            int total = dtoList.size();
            if (total < 1) return null;
            sb.append("您查询的物品为:").append(itemChnName).append("\n");
            sb.append("一共为您获取" + total + "条低价数据").append("\n");
            for (OrderDto dto : dtoList) {
                sb.append("昵称:" + dto.getIngame_name()).
                        append("\t").
                        append("价格:" + new Double(dto.getPlatinum()).intValue() + "白金").append("\n")
                        .append("联系TA      /w " + dto.getIngame_name() + " Hi! I want to buy "+itemEngName+" for:" + dto.getPlatinum() + " platinum. (warframe.market)").append("\n");
            }
            return sb.toString();
        }else{
            return "什么都没查到";
        }
    }


    //按照价格排序
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
