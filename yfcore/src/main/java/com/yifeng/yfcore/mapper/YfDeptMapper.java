package com.yifeng.yfcore.mapper;

import com.yifeng.yfcore.model.YfDept;

public interface YfDeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YfDept record);

    int insertSelective(YfDept record);

    YfDept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YfDept record);

    int updateByPrimaryKey(YfDept record);
}