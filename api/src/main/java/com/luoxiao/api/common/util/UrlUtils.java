package com.luoxiao.api.common.util;

import com.luoxiao.api.wm.constant.WmSearchConstant;
import com.sun.corba.se.impl.encoding.BufferManagerRead;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname UrlUtils
 * @Description TODO
 * @Date 2020/1/6
 * @Created by luox
 */
public class UrlUtils {

    public static Map<String,Object> getData(String u){
        Map<String, Object> map = new HashMap<>();
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
            map.put("data", content.toString());
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            map.put("res", false);
            map.put("msg", WmSearchConstant.NOT_FOUND.getValue());
            return map;
        }
    }

}
