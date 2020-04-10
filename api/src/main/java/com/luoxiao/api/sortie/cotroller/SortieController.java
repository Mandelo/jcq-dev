package com.luoxiao.api.sortie.cotroller;

import com.luoxiao.api.sortie.service.SortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname SortieController
 * @Description TODO
 * @Date 2020/4/10
 * @Created by luox
 */
@Controller
public class SortieController {

    @Autowired
    SortieService sortieService;

    @RequestMapping("/sortie")
    @ResponseBody
    public String getSortie(){
        return sortieService.getSortie();
    }

}
