package com.keboda.eomsback.system.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.keboda.eomsback.authorityReview.pojo.AuthorityRecordsVo;
import com.keboda.eomsback.authorityReview.service.IActionMenuService;
import com.keboda.eomsback.system.mapper.ZxwFileMapper;
import com.keboda.eomsback.system.service.IZxwService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@DS("tiptop")
public class ZxwServiceImpl implements IZxwService {

    @Resource
    private ZxwFileMapper zxwFileMapper;
    @Resource
    private IActionMenuService iActionMenuService;


    @Override
    public List<AuthorityRecordsVo> searchRecordsList(String code) {

        String[] exclude = iActionMenuService.selectByPrimaryKey("exclude").getAction().split(",");
        String[] amountTags = iActionMenuService.selectByPrimaryKey("amount").getAction().split(",");
        String[] createTags = iActionMenuService.selectByPrimaryKey("create").getAction().split(",");
        String[] deleteTags = iActionMenuService.selectByPrimaryKey("delete").getAction().split(",");
        String[] updateTags = iActionMenuService.selectByPrimaryKey("update").getAction().split(",");
        String[] readTags = iActionMenuService.selectByPrimaryKey("read").getAction().split(",");
        String[] confirmTags = iActionMenuService.selectByPrimaryKey("confirm").getAction().split(",");
        String[] unConfirmTags = iActionMenuService.selectByPrimaryKey("unConfirm").getAction().split(",");
        String[] postTags = iActionMenuService.selectByPrimaryKey("post").getAction().split(",");
        String[] unPostTags = iActionMenuService.selectByPrimaryKey("unPost").getAction().split(",");
        String[] voidTags = iActionMenuService.selectByPrimaryKey("void").getAction().split(",");
        String[] unVoidTags = iActionMenuService.selectByPrimaryKey("unVoid").getAction().split(",");

        return zxwFileMapper.searchRecordsList(code,amountTags,createTags,deleteTags,updateTags,readTags,confirmTags,unConfirmTags,voidTags,unVoidTags,postTags,unPostTags,exclude);
    }

}
