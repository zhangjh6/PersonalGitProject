package com.jerry.frame.demo.dao.common.gds;

import com.jerry.frame.demo.model.common.gds.GdsType2Prop;
import com.jerry.frame.demo.model.common.gds.GdsType2PropExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdsType2PropMapper {
    int countByExample(GdsType2PropExample example);

    int deleteByExample(GdsType2PropExample example);

    int insert(GdsType2Prop record);

    int insertSelective(GdsType2Prop record);

    List<GdsType2Prop> selectByExample(GdsType2PropExample example);

    int updateByExampleSelective(@Param("record") GdsType2Prop record, @Param("example") GdsType2PropExample example);

    int updateByExample(@Param("record") GdsType2Prop record, @Param("example") GdsType2PropExample example);

    void insertBatch(List<GdsType2Prop> recordLst);
}