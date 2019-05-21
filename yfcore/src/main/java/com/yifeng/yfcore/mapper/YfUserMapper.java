package com.yifeng.yfcore.mapper;

import com.yifeng.yfcore.model.YfUser;

import java.util.List;
import java.util.Set;

public interface YfUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YfUser record);

    int insertSelective(YfUser record);

    YfUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YfUser record);

    int updateByPrimaryKey(YfUser record);

    List<YfUser> findUserByName(String username);
}