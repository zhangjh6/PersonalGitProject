package com.jerry.frame.demo.dao.common.gds;

import com.jerry.frame.demo.model.common.gds.GdsGds2Prop;
import com.jerry.frame.demo.model.common.gds.GdsGds2PropExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdsGds2PropMapper {
    int countByExample(GdsGds2PropExample example);

    int deleteByExample(GdsGds2PropExample example);

    int insert(GdsGds2Prop record);

    int insertSelective(GdsGds2Prop record);

    List<GdsGds2Prop> selectByExample(GdsGds2PropExample example);

    int updateByExampleSelective(@Param("record") GdsGds2Prop record, @Param("example") GdsGds2PropExample example);

    int updateByExample(@Param("record") GdsGds2Prop record, @Param("example") GdsGds2PropExample example);

    void insertBatch(List<GdsGds2Prop> recordLst);
}