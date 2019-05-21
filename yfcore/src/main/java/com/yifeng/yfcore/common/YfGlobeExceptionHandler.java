package com.yifeng.yfcore.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Kevin
 * @Description:<br>
 * @Date Created in 15:46 2019/4/1
 * @Modified By
 * @Version 1.0
 */
@Slf4j
public class YfGlobeExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        log.info("异常类型"+e.getClass().getName());
        log.info(e.getMessage());
        System.out.println("异常类型");
        return null;
    }
}
