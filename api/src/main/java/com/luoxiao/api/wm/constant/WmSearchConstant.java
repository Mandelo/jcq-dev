package com.luoxiao.api.wm.constant;

import lombok.Data;
import lombok.Getter;

/**
 * @Classname WmSearchConstant
 * @Description
 * @Date 2020/1/3
 * @Created by luox
 */

public enum WmSearchConstant {

    ERROR("500","服务器错误"),
    NOT_FOUND("404","未找到此物品");

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String code;
    private  String value;

     WmSearchConstant(String code,String value){
        this.code = code;
        this.value = value;
    }






//    public static final String NOT_FOUND = "NOT_FOUND";



}
