package com.yifeng.yfcore.mapper;

import com.yifeng.yfcore.model.YfAclModel;

public interface YfAclModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YfAclModel record);

    int insertSelective(YfAclModel record);

    YfAclModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YfAclModel record);

    int updateByPrimaryKey(YfAclModel record);
}