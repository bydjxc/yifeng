package com.yifeng.yfcore.mapper;

import com.yifeng.yfcore.model.YfAcl;

public interface YfAclMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YfAcl record);

    int insertSelective(YfAcl record);

    YfAcl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YfAcl record);

    int updateByPrimaryKey(YfAcl record);
}