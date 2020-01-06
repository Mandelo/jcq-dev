package com.luoxiao.api.wm.service.Impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.luoxiao.api.wm.constant.WmSearchConstant;
import com.luoxiao.api.wm.dao.WmItemDicMapper;
import com.luoxiao.api.wm.entity.WmItemDic;
import com.luoxiao.api.wm.service.WmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname WmServiceImpl
 * @Description
 * @Date 2020/1/3
 * @Created by luox
 */

@Service
public class WmServiceImpl implements WmService {

    @Autowired
    WmItemDicMapper wmItemDicMapper;

    @Override
    public Map<String, Object> getItemStr(String kw) {
        Map<String, Object> map = new HashMap<>();
        String prefix = "https://api.warframe.market/v1/items/";
        String suffix = "/orders?include=item";
        String k = kw.replace("wm", "");
        String k1 = k.replaceAll(" ", "");
//        String itemName = wmItemDicMapper.
        EntityWrapper<WmItemDic> wrapper = new EntityWrapper<>();
        wrapper.like("search_key", k1);
        List<WmItemDic> wmItemDics = wmItemDicMapper.selectList(wrapper);
        if (wmItemDics.size() > 0) {
            WmItemDic res = wmItemDics.get(0);
            String itemWmName = res.getWmName();
            String itemChnName = res.getItemChnName();
            String itemEngName = res.getItemEngName();
            String u = prefix + itemWmName + suffix;
            StringBuffer content = null;
            try {
                URL url = new URL(u);
                BufferedReader in = null;
                URLConnection connection = url.openConnection();
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36)");
                InputStreamReader reader = new InputStreamReader(connection.getInputStream(), "UTF-8");
                in = new BufferedReader(reader);
                String line = null;
                content = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                }
                if (content.length() < 1) {
                    map.put("res", false);
                    map.put("msg", WmSearchConstant.NOT_FOUND.getValue());
                    return map;
                }
                map.put("res", true);
                map.put("itemChnName",itemChnName);
                map.put("itemEngName",itemEngName);
                map.put("data", content.toString());
                return map;
            } catch (IOException e) {
                e.printStackTrace();
            }
            map.put("res", false);
            map.put("msg", WmSearchConstant.ERROR.getValue());
            return map;
        } else {
            map.put("res", false);
            map.put("msg", WmSearchConstant.NOT_FOUND.getValue());
            return map;
        }
    }
}
