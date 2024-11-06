package com.keboda.eomsback.system.service;

import com.keboda.eomsback.system.pojo.AzpFile;

import java.util.List;

public interface IAzpService {

    List<AzpFile> searchAzpList(String azp01);

    AzpFile selectByPrimaryKey(String azp01);
}
