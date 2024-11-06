package com.keboda.eomsback.authorityReview.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.keboda.eomsback.authorityReview.pojo.AuthorityRecordsVo;
import com.keboda.eomsback.authorityReview.pojo.PersonalPosition;
import com.keboda.eomsback.authorityReview.service.IAuthorityReviewService;
import com.keboda.eomsback.entity.BaseResult;
import com.keboda.eomsback.entity.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/authorityReview")
public class AuthorityReviewController {

    @Autowired
    private IAuthorityReviewService iAuthorityReviewService;


    @RequestMapping("/searchPositionRecordsListPageHelper")
    private BaseResult searchPositionRecordsListPageHelper(@RequestBody SearchVo searchVo){
        Page<AuthorityRecordsVo> page = iAuthorityReviewService.searchPositionRecordsListPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());
    }


    @RequestMapping("/importPositionRecords")
    public BaseResult importPositionRecords(MultipartFile file, String year) throws IOException {
        String message = iAuthorityReviewService.importPositionRecords(file,year);
        return BaseResult.success(message);
    }



    @RequestMapping("/deletePositionRecords")
    public BaseResult deletePositionRecords(@RequestBody List<AuthorityRecordsVo> authorityRecordsVoList){
        iAuthorityReviewService.deletePositionRecords(authorityRecordsVoList);
        return BaseResult.success("删除记录成功");
    }


    @RequestMapping("/positionContrastRecords")
    public BaseResult positionContrastRecords(@RequestBody SearchVo searchVo){
        return BaseResult.success(iAuthorityReviewService.positionContrastRecords(searchVo));
    }

    @RequestMapping("/currentPermission2Excel")
    public void currentPermission2Excel(HttpServletResponse response) throws IOException {
        iAuthorityReviewService.currentPermission2Excel(response);
    }


    @RequestMapping("/positionContrastRecords2Excel")
    public void positionContrastRecords2Excel(@RequestBody SearchVo searchVo, HttpServletResponse response) {
        iAuthorityReviewService.positionContrastRecords2Excel(response,searchVo);
    }




    @RequestMapping("/searchPersonalPositionRecordsListPageHelper")
    private BaseResult searchPersonalPositionRecordsListPageHelper(@RequestBody SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getSize());
        Page<PersonalPosition> page = iAuthorityReviewService.searchPersonalPositionRecordsListPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());
    }


    @RequestMapping("/importPersonalPositionRecords")
    public BaseResult importPersonalPositionRecords(MultipartFile file, String year) throws IOException {
        String message = iAuthorityReviewService.importPersonalPositionRecords(file,year);
        return BaseResult.success(message);
    }


    @RequestMapping("/deletePersonalPositionRecords")
    public BaseResult deletePersonalPositionRecords(@RequestBody List<PersonalPosition> personalPositions){
        iAuthorityReviewService.deletePersonalPositionRecords(personalPositions);
        return BaseResult.success("删除记录成功");
    }


    @RequestMapping("/searchPersonalPositionContrastRecordsListPageHelper")
    public BaseResult searchPersonalPositionContrastRecordsListPageHelper(@RequestBody SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getSize());
        Page<PersonalPosition> page = iAuthorityReviewService.searchPersonalPositionContrastRecordsListPageHelper(searchVo);
        return BaseResult.success(page,page.getTotal());
    }

    @RequestMapping("/PersonalPositionContrastRecords2Excel")
    public void PersonalPositionContrastRecords2Excel(@RequestParam("year") String year, HttpServletResponse response) {
        iAuthorityReviewService.PersonalPositionContrastRecords2Excel(response,year);
    }

}
