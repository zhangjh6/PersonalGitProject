package com.jerry.frame.demo.dao.common.gds;

import com.jerry.frame.demo.model.common.gds.GdsCatg2Site;
import com.jerry.frame.demo.model.common.gds.GdsCatg2SiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdsCatg2SiteMapper {
    int countByExample(GdsCatg2SiteExample example);

    int deleteByExample(GdsCatg2SiteExample example);

    int insert(GdsCatg2Site record);

    int insertSelective(GdsCatg2Site record);

    List<GdsCatg2Site> selectByExample(GdsCatg2SiteExample example);

    int updateByExampleSelective(@Param("record") GdsCatg2Site record, @Param("example") GdsCatg2SiteExample example);

    int updateByExample(@Param("record") GdsCatg2Site record, @Param("example") GdsCatg2SiteExample example);

    void insertBatch(List<GdsCatg2Site> recordLst);
}