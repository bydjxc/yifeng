package com.yifeng.yfcore.mapper;

import com.yifeng.yfcore.model.YfUser;

import java.util.List;

/**
 * @Author: Kevin
 * @Description:<br>
 * @Date Created in 12:35 2019/3/18
 * @Modified By
 * @Version 1.0
 */
public interface UserMapper {
    YfUser findUserById(int id);
    List<YfUser> findUserListByName();
    void insertUser(YfUser cfUser);
    void updateUser(YfUser cfUser);
    void deleteUserById(int id);
}
