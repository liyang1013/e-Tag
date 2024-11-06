package com.keboda.eomsback.assets.service.impl;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.keboda.eomsback.assets.mapper.FajFileMapper;
import com.keboda.eomsback.assets.pojo.FajFile;
import com.keboda.eomsback.assets.service.IFajService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class FajServiceImpl implements IFajService {

    @Resource
    private FajFileMapper fajFileMapper;

    @Override
    @Transactional
    public int updateByExcel(MultipartFile file, String centre) throws IOException {
        ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
        List<Map<String, Object>> read = reader.readAll();
        int count = 0;
        for (Map<String, Object> map : read) {
            FajFile fajFile = new FajFile();
            fajFile.setCentre(centre);
            fajFile.setFaj02(map.get("财产编号").toString());
            if(map.get("保管部门") != null) {fajFile.setFaj20(map.get("保管部门").toString());}
            if(map.get("折旧部门") != null) {fajFile.setFaj24(map.get("折旧部门").toString());}
            if(map.get("设备或生产名称") != null) {fajFile.setFaj06(map.get("设备或生产名称").toString());}
            if(map.get("保管人员") != null) {fajFile.setFaj19(map.get("保管人员").toString());}
            if(map.get("保管中心") != null) {fajFile.setFajud03(map.get("保管中心").toString());}
            if(map.get("产线编号") != null) {fajFile.setFaj93(map.get("产线编号").toString());}
            if(map.get("存放位置") != null) {fajFile.setFaj21(map.get("存放位置").toString());}
            count = count + fajFileMapper.updateByPrimaryKeySelective(fajFile);
        }
        return count;
    }
}
