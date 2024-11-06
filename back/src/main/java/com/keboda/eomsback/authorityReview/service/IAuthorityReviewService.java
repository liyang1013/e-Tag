package com.keboda.eomsback.authorityReview.service;

import com.github.pagehelper.Page;
import com.keboda.eomsback.authorityReview.pojo.AuthorityRecordsVo;
import com.keboda.eomsback.authorityReview.pojo.PersonalPosition;
import com.keboda.eomsback.entity.SearchVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IAuthorityReviewService {
    Page<AuthorityRecordsVo> searchPositionRecordsListPageHelper(SearchVo searchVo);

    String importPositionRecords(MultipartFile file, String year) throws IOException;

    void deletePositionRecords(List<AuthorityRecordsVo> authorityRecordsVoList);

    Map<String,List<AuthorityRecordsVo>> positionContrastRecords(SearchVo searchVo);

    void currentPermission2Excel(HttpServletResponse response) throws IOException;

    void positionContrastRecords2Excel(HttpServletResponse response,SearchVo searchVo);

    Page<PersonalPosition> searchPersonalPositionRecordsListPageHelper(SearchVo searchVo);

    String importPersonalPositionRecords(MultipartFile file, String year) throws IOException;

    void deletePersonalPositionRecords(List<PersonalPosition> personalPositions);

    Page<PersonalPosition> searchPersonalPositionContrastRecordsListPageHelper(SearchVo searchVo);

    void PersonalPositionContrastRecords2Excel(HttpServletResponse response, String year);
}
