package com.keboda.eomsback.stock.mapper;

import com.keboda.eomsback.stock.pojo.TcWiaFile;

public interface TcWiaFileMapper {

    int insertSelective(TcWiaFile record);

    int updateByPrimaryKeySelective(TcWiaFile record);
}