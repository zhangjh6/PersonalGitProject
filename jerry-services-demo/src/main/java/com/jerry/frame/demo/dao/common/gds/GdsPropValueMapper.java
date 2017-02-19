package com.jerry.frame.demo.dao.common.gds;

import com.jerry.frame.demo.model.common.gds.GdsPropValue;
import com.jerry.frame.demo.model.common.gds.GdsPropValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdsPropValueMapper {
    int countByExample(GdsPropValueExample example);

    int deleteByExample(GdsPropValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdsPropValue record);

    int insertSelective(GdsPropValue record);

    List<GdsPropValue> selectByExample(GdsPropValueExample example);

    GdsPropValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GdsPropValue record, @Param("example") GdsPropValueExample example);

    int updateByExample(@Param("record") GdsPropValue record, @Param("example") GdsPropValueExample example);

    int updateByPrimaryKeySelective(GdsPropValue record);

    int updateByPrimaryKey(GdsPropValue record);

    void insertBatch(List<GdsPropValue> recordLst);
}