package com.yifeng.yfcore.common;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Kevin
 * @Description: 统一返回数据格式<br>
 * @Date Created in 16:15 2019/3/28
 * @Modified By
 * @Version 1.0
 */
@Getter
@Setter
public class YfBaseData {


    /**
     * 响应码
     * */
    private Integer code;
    /**
     * 响应信息
     * */
    private String message;
    /**
     * 响应数据
     * */
    private Object data;

    public YfBaseData(Integer code){
        this.code = code;
    }

    public static YfBaseData success (String message, Object data){
        YfBaseData baseData = new YfBaseData(ReturnCode.SUCCESS.getCode());
        baseData.message = message;
        baseData.data = data;
        return baseData;
    }

    public static YfBaseData success (Integer code, String message, Object data){
        YfBaseData baseData = new YfBaseData(ReturnCode.SUCCESS.getCode());
        baseData.code = code;
        baseData.message = message;
        baseData.data = data;
        return baseData;
    }

    public static YfBaseData success (Object data){
        YfBaseData baseData = new YfBaseData(ReturnCode.SUCCESS.getCode());
        baseData.data = data;
        return baseData;
    }

    public static YfBaseData success (){
        return new YfBaseData(ReturnCode.SUCCESS.getCode());
    }

    public static YfBaseData failure(String message){
        YfBaseData baseData = new YfBaseData(ReturnCode.FAILURE.getCode());
        baseData.message = message;
        return baseData;
    }

    public Map<String, Object> toMap(){
        Map<String, Object> map =  new HashMap<String, Object>();
        map.put("code",code);
        map.put("data",data);
        map.put("message",message);
        return map;
    }
}
