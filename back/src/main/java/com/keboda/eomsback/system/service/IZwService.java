package com.keboda.eomsback.system.service;

import com.keboda.eomsback.system.pojo.ZwFile;

import java.util.List;

public interface IZwService {
    List<ZwFile> searchZwList(String query);

    ZwFile selectByPrimaryKey(String zw01);
}
