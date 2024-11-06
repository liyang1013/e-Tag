package com.keboda.eomsback.produce.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import com.keboda.eomsback.produce.pojo.SfaFile;
import com.keboda.eomsback.produce.pojo.SfbFile;
import com.keboda.eomsback.produce.pojo.vo.SfbModify;
import com.keboda.eomsback.produce.pojo.vo.SfbStatusVo;
import com.keboda.eomsback.produce.service.ISfbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/sfb")
public class SfbController {

    @Autowired
    private ISfbService iSfbService;

    @RequestMapping("/searchSfbList")
    public BaseResult searchSfbList(@RequestBody SearchVo searchVo){
        List<SfbFile> list = iSfbService.searchSfbList(searchVo);
        return BaseResult.success(list);
    }

    @RequestMapping("/searchSfbStatus")
    public BaseResult searchSfbStatus(@RequestBody SearchVo searchVo){
        SfbStatusVo sfbStatus = iSfbService.searchSfbStatus(searchVo);
        return BaseResult.success(sfbStatus);
    }

    @RequestMapping("/searchSfbListPageHelper")
    public BaseResult searchSfbListPageHelper(@RequestBody SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getSize());
        Page<SfbFile> page = iSfbService.searchSfbListPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());

    }

    @RequestMapping("/searchSfaList")
    public BaseResult searchSfaList(@RequestBody SearchVo searchVo){
        List<SfaFile> list = iSfbService.searchSfaList(searchVo);
        return BaseResult.success(list);
    }

    @RequestMapping("/modifySfbDate")
    public BaseResult modifySfbDate(@RequestBody SfbModify sfbModify, HttpServletRequest request){
        iSfbService.modifySfbDate(sfbModify,request);
        return BaseResult.success("修改工单日期成功");
    }

    @RequestMapping("/updateDepartment")
    public BaseResult updateDepartment(@RequestBody SfbFile sfbFile){
        iSfbService.updateDepartment(sfbFile);
        return BaseResult.success("成本中心修改成功");
    }


    @RequestMapping("/updateProductionLine")
    public BaseResult updateProductionLine(@RequestBody SfbFile sfbFile){
        iSfbService.updateProductionLine(sfbFile);
        return BaseResult.success("产线修改成功");
    }

    @RequestMapping("/updateFL")
    public BaseResult updateFL(@RequestBody SfbFile sfbFile){
        iSfbService.updateFL(sfbFile);
        return BaseResult.success("发料数量修改成功");
    }

    @RequestMapping("/updateRK")
    public BaseResult updateRK(@RequestBody SfbFile sfbFile){
        iSfbService.updateRK(sfbFile);
        return BaseResult.success("入库数量修改成功");
    }

    @RequestMapping("/updateBF")
    public BaseResult updateBF(@RequestBody SfbFile sfbFile){
        iSfbService.updateBF(sfbFile);
        return BaseResult.success("报废数量修改成功");
    }

    @RequestMapping("/isFQC")
    public BaseResult isFQC(@RequestBody SfbFile sfbFile){
        iSfbService.isFQC(sfbFile);
        return BaseResult.success("FQC修改成功");
    }

    @RequestMapping("/closeOut")
    public BaseResult closeOut(@RequestBody List<SfbFile> sfbFiles){
        iSfbService.closeOut(sfbFiles);
        return BaseResult.success("工单结案成功");
    }

    @RequestMapping("/updateByExcel")
    public BaseResult updateByExcel(MultipartFile file, String centre) throws IOException {
        int count = iSfbService.updateByExcel(file,centre);
        return BaseResult.success("工单批量修改成功: " + count);
    }
}
