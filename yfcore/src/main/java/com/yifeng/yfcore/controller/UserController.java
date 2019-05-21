package com.yifeng.yfcore.controller;

import com.yifeng.yfcore.model.YfUser;
import com.yifeng.yfcore.service.YfUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author: Kevin
 * @Description:<br>
 * @Date Created in 14:47 2019/3/25
 * @Modified By
 * @Version 1.0
 */
@Validated
@RestController
public class UserController {
    @Autowired
    private YfUserService userService;
    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String login(YfUser user) throws Exception{
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try{
            subject.login(token);
        }catch(Exception e){
            return "密码错误";
        }
        return "登录成功";
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(@RequestBody YfUser user) throws Exception{
        userService.registUser(user);
        return "注册成功";
    }
}
