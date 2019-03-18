package com.yifeng.yfcore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Kevin
 * @Description:<br>
 * @Date Created in 12:28 2019/3/18
 * @Modified By
 * @Version 1.0
 */
@RestController
@SpringBootApplication
@MapperScan("com.yifeng.yfcore.mapper")
public class YfCore {
    public static void main(String[] args) {
        SpringApplication.run(YfCore.class, args);
    }
    @RequestMapping("/")
    public String hell(){
        return "hello";
    }
}
