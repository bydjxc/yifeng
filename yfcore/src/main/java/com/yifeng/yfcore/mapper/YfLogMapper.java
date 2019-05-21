package com.yifeng.yfcore.mapper;

import com.yifeng.yfcore.model.YfLog;
import com.yifeng.yfcore.model.YfLogWithBLOBs;

public interface YfLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YfLogWithBLOBs record);

    int insertSelective(YfLogWithBLOBs record);

    YfLogWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YfLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(YfLogWithBLOBs record);

    int updateByPrimaryKey(YfLog record);
}