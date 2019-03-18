package com.yifeng.yfcore.controller;

import com.yifeng.yfcore.mapper.UserMapper;
import com.yifeng.yfcore.model.YfUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Kevin
 * @Description:<br>
 * @Date Created in 12:34 2019/3/18
 * @Modified By
 * @Version 1.0
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserMapper mapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<YfUser> getUserList(){
        List<YfUser> list = mapper.findUserListByName();
        return list;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public YfUser getUserById(@PathVariable int id){
        YfUser user = mapper.findUserById(id);
        return user;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public YfUser postUser(){
        YfUser user = YfUser.builder().name("张三").age(23).addr("北京").build();
        mapper.insertUser(user);
        return user;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable int id){
        YfUser user = YfUser.builder().id(id).name("王五").age(24).addr("广州").build();
        mapper.updateUser(user);
        return "put success";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int id){
        mapper.deleteUserById(id);
        return "delete success";
    }

}
