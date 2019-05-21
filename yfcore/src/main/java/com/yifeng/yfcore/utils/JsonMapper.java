package com.yifeng.yfcore.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Kevin
 * @Description: Json转换器<br>
 * @Date Created in 16:44 2019/3/28
 * @Modified By
 * @Version 1.0
 */
@Slf4j
public class JsonMapper {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String obj2String(Object object) {
        if (object == null) {
            return null;
        }
        try {
            return object instanceof String ? (String) object : objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            log.warn("parse object to String exception, error:{}", e);
            return null;
        }
    }

    public static <T> T string2Obj(String str, TypeReference<T> typeReference) {
        if (str == null || typeReference == null) {
            return null;
        }
        try {
            return (T) (typeReference.getType().equals(String.class) ? str : objectMapper.readValue(str, typeReference));
        } catch (Exception e) {
            log.warn("parse String to Object exception, String:{}, TypeReference<T>:{}, error:{}", str, typeReference.getType(), e);
            return null;
        }
    }

    public static <T> T string2Obj(String str, Class<T> clazz) {
        if (str == null || clazz == null) {
            return null;
        }
        try {
            return (T) (clazz == String.class ? str : objectMapper.readValue(str, clazz));
        } catch (Exception e) {
            log.warn("parse String to Object exception, String:{}, Class<T>:{}, error:{}", str, clazz, e);
            return null;
        }
    }

}
