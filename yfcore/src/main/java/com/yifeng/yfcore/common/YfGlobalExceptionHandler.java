package com.yifeng.yfcore.common;

import com.yifeng.yfcore.exception.ParamException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: Kevin
 * @Description:<br>
 * @Date Created in 12:13 2019/4/2
 * @Modified By
 * @Version 1.0
 */
@RestControllerAdvice
public class YfGlobalExceptionHandler {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //得到入参
        Object target = binder.getTarget();
        // System.out.println("initBinder");
    }

    /**
     * 参数异常处理
     *
     * @return
     */
    @ExceptionHandler({ParamException.class})
    @ResponseBody
    public Object handParamException(ParamException e) {
        YfBaseData success = YfBaseData.success(e.getCode(), e.getMessage(), null);
        return success;
    }
    /**
     * 异常处理
     *
     * @return
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Object handException(Exception e) {
        YfBaseData success = YfBaseData.success(e.getMessage());
        return success;
    }

}
