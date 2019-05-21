package com.yifeng.yfcore.common;

import com.yifeng.yfcore.utils.JsonMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author: Kevin
 * @Description:<br>
 * @Date Created in 16:13 2019/3/28
 * @Modified By
 * @Version 1.0
 */
@RestControllerAdvice
public class YfBaseApiResult implements ResponseBodyAdvice{
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //返回JSON格式数据
        serverHttpResponse.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        YfBaseData baseData;

        if (o instanceof  YfBaseData){
            baseData = (YfBaseData) o;
        }else {
            baseData = YfBaseData.success(o);
        }
        return JsonMapper.obj2String(baseData);
    }
}
