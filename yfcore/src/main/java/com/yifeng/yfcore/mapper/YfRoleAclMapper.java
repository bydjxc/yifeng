package com.yifeng.yfcore.mapper;

import com.yifeng.yfcore.model.YfRoleAcl;

public interface YfRoleAclMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YfRoleAcl record);

    int insertSelective(YfRoleAcl record);

    YfRoleAcl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YfRoleAcl record);

    int updateByPrimaryKey(YfRoleAcl record);
}