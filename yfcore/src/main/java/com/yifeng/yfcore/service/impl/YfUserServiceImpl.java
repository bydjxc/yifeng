package com.yifeng.yfcore.service.impl;

import com.yifeng.yfcore.mapper.YfUserMapper;
import com.yifeng.yfcore.model.YfUser;
import com.yifeng.yfcore.service.YfUserService;
import com.yifeng.yfcore.utils.BeanValidator;
import com.yifeng.yfcore.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @Author: Kevin
 * @Description:<br>
 * @Date Created in 16:40 2019/3/22
 * @Modified By
 * @Version 1.0
 */
@Service
public class YfUserServiceImpl implements YfUserService{
    @Autowired
    private YfUserMapper userMapper;
    @Autowired
    private PasswordUtil passwordUtil;
    @Override
    public YfUser findUserByName(String username) {
        List<YfUser> userByName = userMapper.findUserByName(username);
        return userByName.get(0);
    }

    @Override
    public YfUser findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(1);
    }

    @Override
    public void registUser(YfUser user) {
        BeanValidator.check(user);
        String userName = user.getUsername();
        String[] strings = passwordUtil.encryptPassword(user.getPassword(), user.getUsername());
        user.setPassword(strings[0]);
        user.setSalt(strings[1]);
        user.setOperatorTime(new Date());
        userMapper.insert(user);
    }
}
