package com.yifeng.yfcore.service;

import com.yifeng.yfcore.model.YfUser;

/**
 * @Author: Kevin
 * @Description:<br>
 * @Date Created in 16:40 2019/3/22
 * @Modified By
 * @Version 1.0
 */
public interface YfUserService {
    YfUser findUserByName(String username);
    YfUser findUserById(Integer id);
    //注册
    void registUser(YfUser user);
}
