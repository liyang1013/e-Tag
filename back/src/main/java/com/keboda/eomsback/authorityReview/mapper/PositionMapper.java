package com.keboda.eomsback.authorityReview.mapper;

import com.github.pagehelper.Page;
import com.keboda.eomsback.authorityReview.pojo.AuthorityRecordsVo;
import com.keboda.eomsback.authorityReview.pojo.Position;
import com.keboda.eomsback.entity.SearchVo;
import org.apache.ibatis.annotations.Param;


public interface PositionMapper {

    int insertSelective(Position record);

    int updateByPrimaryKeySelective(Position record);

    Page<AuthorityRecordsVo> searchPositionRecordsListPageHelper(@Param("searchVo") SearchVo searchVo,@Param("exclude") String[] exclude);

    Position selectByPrimaryKey(@Param("year") String year,@Param("positionCode") String positionCode);
}