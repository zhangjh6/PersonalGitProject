package com.jerry.frame.demo.dao.common.gds;

import com.jerry.frame.demo.model.common.gds.GdsCatg2Prop;
import com.jerry.frame.demo.model.common.gds.GdsCatg2PropExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdsCatg2PropMapper {
    int countByExample(GdsCatg2PropExample example);

    int deleteByExample(GdsCatg2PropExample example);

    int insert(GdsCatg2Prop record);

    int insertSelective(GdsCatg2Prop record);

    List<GdsCatg2Prop> selectByExample(GdsCatg2PropExample example);

    int updateByExampleSelective(@Param("record") GdsCatg2Prop record, @Param("example") GdsCatg2PropExample example);

    int updateByExample(@Param("record") GdsCatg2Prop record, @Param("example") GdsCatg2PropExample example);

    void insertBatch(List<GdsCatg2Prop> recordLst);
}