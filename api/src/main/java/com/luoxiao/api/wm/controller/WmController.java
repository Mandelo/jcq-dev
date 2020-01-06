package com.luoxiao.api.wm.controller;

import com.luoxiao.api.wm.entity.OrderDto;
import com.luoxiao.api.wm.service.WmService;
import com.luoxiao.api.wm.utils.ParseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname WmController
 * @Description
 * @Date 2020/1/3
 * @Created by luox
 */

@RequestMapping("/wm")
@Controller
public class WmController {

    @Resource
    WmService wmService;

    @ResponseBody
    @RequestMapping("/price")
    public Map<String, Object> getPrice(String itemName) {
        Map<String, Object> res = new HashMap<>();
        Map<String,Object> itemStrMap = wmService.getItemStr(itemName);
        Boolean isSuccess = (Boolean) itemStrMap.get("res");
        if(isSuccess){
            String dataStr = (String) itemStrMap.get("data");
            String itemChnName = (String) itemStrMap.get("itemChnName");
            String itemEngName = (String) itemStrMap.get("itemEngName");
            List<OrderDto> orderDtos = ParseUtil.handleData(dataStr);
            res.put("data", orderDtos);
            res.put("itemChnName",itemChnName);
            res.put("itemEngName",itemEngName);
            res.put("res", "true");
            return res;
        }else{
            String _msg = (String) itemStrMap.get("msg");
            res.put("res", "false");
            res.put("msg",_msg);
            return res;
        }

//        if (WmSearchConstant.ERROR.getCode().equals(itemStr)) {
//            res.put("res", "false");
//            res.put("msg", WmSearchConstant.ERROR.getValue());
//            return res;
//        } else if (WmSearchConstant.NOT_FOUND.getCode().equals(itemStr)) {
//            res.put("res", "false");
//            res.put("msg", WmSearchConstant.NOT_FOUND.getValue());
//            return res;
//        } else {
//            List<OrderDto> orderDtos = ParseUtil.handleData(itemStr);
//            res.put("data", orderDtos);
//            res.put("res", "true");
//            return res;
//        }

    }

}
