package com.luoxiao.api.sortie.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.luoxiao.api.common.config.UrlConstant;
import com.luoxiao.api.common.entity.CommonDicEntity;
import com.luoxiao.api.common.entity.CommonDicMapper;
import com.luoxiao.api.common.util.UrlUtils;
import com.luoxiao.api.sortie.entity.SortieEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Classname SortieService
 * @Description TODO
 * @Date 2020/4/10
 * @Created by luox
 */
@Service
public class SortieService {

    @Resource
    CommonDicMapper dicMapper;

    public String getSortie() {
        String url = UrlConstant.WARFRAME_STAT_URL;
        Map<String, Object> resMap = UrlUtils.getData(url);
        Boolean isSuccess = (Boolean) resMap.get("res");
        if (isSuccess) {
            String dataStr = (String) resMap.get("data");
            JSONObject jsonObject = JSON.parseObject(dataStr);
            JSONObject jsonObject1 = JSON.parseObject(jsonObject.getString("sortie"));
            return translate(jsonObject1.getString("variants"));
        }
        return null;
    }

    public String getCnValue(String engStr) {
        Wrapper<CommonDicEntity> wrapper = new EntityWrapper<>();
        wrapper.eq("eng_name", engStr);
        List<CommonDicEntity> dics = dicMapper.selectList(wrapper);
        if (dics.size() > 0) {
            CommonDicEntity commonDicEntity = dics.get(0);
            return commonDicEntity.getCnName();
        }
        return null;
    }

    public String translate(String dataStr) {
        if (null != dataStr) {
            List<SortieEntity> sortieEntityList = JSON.parseArray(dataStr, SortieEntity.class);
            int total = sortieEntityList.size();
            StringBuffer sbResult = new StringBuffer();
            for (int i = 1; i <= total; i++) {
                SortieEntity sortieEntity = sortieEntityList.get(i - 1);
                //类型
                String missionTypeEng = sortieEntity.getMissionType();
                String cnValue = getCnValue(missionTypeEng);

                if (null != cnValue) {
                    sortieEntity.setSortieName(cnValue);
                }else{
                    sortieEntity.setSortieName(missionTypeEng);
                }


                String modifierEng = sortieEntity.getModifier();
                if (modifierEng.contains(":")) {
                    String[] splitStr = modifierEng.split(":");
                    String resStr0 = splitStr[0].trim();
                    String resStr1 = splitStr[1].trim();
                    String modifierCn0 = getCnValue(resStr0);
                    String modifierCn1 = getCnValue(resStr1);

                    StringBuffer sb1 = new StringBuffer();

                    if (null != modifierCn0) {
                        sb1.append(modifierCn0);
                    } else {
                        sb1.append(resStr0);
                    }
                    if (null != modifierCn1) {
                        sb1.append(":");
                        sb1.append(modifierCn1);
                    } else {
                        sb1.append(":");
                        sb1.append(resStr1);
                    }
                    sortieEntity.setModifier(sb1.toString());
                } else {
                    String modifierCn = getCnValue(modifierEng);
                    if (null != modifierCn) {
                        sortieEntity.setModifier(modifierCn);
                    }
                }

                String nodeEng = sortieEntity.getNode();
                nodeEng = nodeEng.replace("(", "&");
                nodeEng = nodeEng.replace(")", "&");
                String[] splitNode = nodeEng.split("&");
                String nodeCn = getCnValue(splitNode[1]);
                if (null != nodeCn) {
                    nodeEng = sortieEntity.getNode().replace(splitNode[1], nodeCn);
                    sortieEntity.setNode(nodeEng);
                }
                sbResult
                        .append("&")
                        .append("突击").append(i).append(":").append("&")
                        .append("任务:").append(sortieEntity.getSortieName()).append("&")
                        .append("节点:").append(sortieEntity.getNode()).append("&")
                        .append("说明:").append(sortieEntity.getModifier())
                        .append("&");
            }
            return sbResult.toString();
        }
        return null;
    }


}
