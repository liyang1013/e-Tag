package com.keboda.eomsback.system.mapper;

import com.keboda.eomsback.system.pojo.ZwFile;

import java.util.List;

public interface ZwFileMapper {
    List<ZwFile> searchZwList(String query);

    ZwFile selectByPrimaryKey(String zw01);
}
