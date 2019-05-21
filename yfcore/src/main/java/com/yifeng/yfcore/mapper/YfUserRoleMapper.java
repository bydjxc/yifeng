package com.yifeng.yfcore.mapper;

import com.yifeng.yfcore.model.YfRole;
import com.yifeng.yfcore.model.YfUserRole;

import java.util.Set;

public interface YfUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YfUserRole record);

    int insertSelective(YfUserRole record);

    YfUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YfUserRole record);

    int updateByPrimaryKey(YfUserRole record);

}