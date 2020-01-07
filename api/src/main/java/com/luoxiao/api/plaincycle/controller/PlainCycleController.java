package com.luoxiao.api.plaincycle.controller;

import com.luoxiao.api.plaincycle.entity.CetusCycleEntity;
import com.luoxiao.api.plaincycle.entity.EarthCycleEntity;
import com.luoxiao.api.plaincycle.service.CycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname EarthCycleController
 * @Description TODO
 * @Date 2020/1/7
 * @Created by luox
 */

@RequestMapping("/plainStat")
@Controller
public class PlainCycleController {

    @Autowired
    CycleService cycleService;

    @RequestMapping("/earth")
    @ResponseBody
    public String getEarthCycle(){
        return cycleService.getEarthCycle();
    }

    @RequestMapping("/cetus")
    @ResponseBody
    public String getCetusCycle(){
        return cycleService.getCetusCycle();
    }

}
