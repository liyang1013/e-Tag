package com.keboda.eomsback.stock.mapper;

import com.keboda.eomsback.stock.pojo.ImnFile;
import com.keboda.eomsback.stock.pojo.ImnFileKey;

public interface ImnFileMapper {
    int deleteByPrimaryKey(ImnFileKey key);

    int insert(ImnFile record);

    int insertSelective(ImnFile record);

    ImnFile selectByPrimaryKey(ImnFileKey key);

    int updateByPrimaryKeySelective(ImnFile record);

    int updateByPrimaryKey(ImnFile record);
}