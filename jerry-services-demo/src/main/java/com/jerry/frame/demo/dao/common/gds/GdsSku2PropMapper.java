package com.jerry.frame.demo.dao.common.gds;

import com.jerry.frame.demo.model.common.gds.GdsSku2Prop;
import com.jerry.frame.demo.model.common.gds.GdsSku2PropExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdsSku2PropMapper {
    int countByExample(GdsSku2PropExample example);

    int deleteByExample(GdsSku2PropExample example);

    int insert(GdsSku2Prop record);

    int insertSelective(GdsSku2Prop record);

    List<GdsSku2Prop> selectByExample(GdsSku2PropExample example);

    int updateByExampleSelective(@Param("record") GdsSku2Prop record, @Param("example") GdsSku2PropExample example);

    int updateByExample(@Param("record") GdsSku2Prop record, @Param("example") GdsSku2PropExample example);

    void insertBatch(List<GdsSku2Prop> recordLst);
}