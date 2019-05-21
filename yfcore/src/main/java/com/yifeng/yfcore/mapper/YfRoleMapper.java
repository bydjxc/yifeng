package com.yifeng.yfcore.mapper;

import com.yifeng.yfcore.model.YfRole;

public interface YfRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YfRole record);

    int insertSelective(YfRole record);

    YfRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YfRole record);

    int updateByPrimaryKey(YfRole record);
}