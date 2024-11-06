package com.keboda.eomsback.stock.service.impl;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.github.pagehelper.Page;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.stock.mapper.ImaFileMapper;
import com.keboda.eomsback.stock.pojo.ImaFile;
import com.keboda.eomsback.stock.service.IImaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class ImaServiceImpl implements IImaService {
    @Resource
    private ImaFileMapper imaFileMapper;

    @Override
    public Page<ImaFile> searchListPageHelper(SearchVo searchVo) {
        return imaFileMapper.searchListPageHelper(searchVo);
    }

    @Override
    @Transactional
    public void updateUnit(ImaFile imaFile) {
        imaFile.setIma31(imaFile.getIma25());
        imaFile.setIma44(imaFile.getIma25());
        imaFile.setIma55(imaFile.getIma25());
        imaFile.setIma63(imaFile.getIma25());
        imaFile.setIma86(imaFile.getIma25());
        imaFile.setIma908(imaFile.getIma25());
        imaFileMapper.updateByPrimaryKeySelective(imaFile);
    }

    @Override
    @Transactional
    public int updateByExcel(MultipartFile file, String centre) throws IOException {
        ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
        List<Map<String, Object>> read = reader.readAll();
        int count = 0;
        for (Map<String, Object> map : read) {
            ImaFile imaFile = new ImaFile();
            imaFile.setCentre(centre);
            imaFile.setIma01(map.get("料号").toString());
            if(map.get("人工工时") != null) imaFile.setIma58(new BigDecimal(map.get("人工工时").toString()));
            if(map.get("安全库存") != null) imaFile.setIma27(new BigDecimal(map.get("安全库存").toString()));
            if(map.get("最低库存") != null) imaFile.setImaud09(new BigDecimal(map.get("最低库存").toString()));
            if(map.get("最高库存") != null) imaFile.setIma271(new BigDecimal(map.get("最高库存").toString()));
            if(map.get("产品分类编码") != null) imaFile.setIma131(map.get("产品分类编码").toString());//9999
            if(map.get("采购员") != null) imaFile.setIma43(map.get("采购员").toString());
            count = count + imaFileMapper.updateByPrimaryKeySelective(imaFile);
        }
        return count;
    }
}
