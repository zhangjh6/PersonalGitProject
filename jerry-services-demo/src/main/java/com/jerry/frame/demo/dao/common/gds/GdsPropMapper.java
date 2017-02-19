package com.jerry.frame.demo.dao.common.gds;

import com.jerry.frame.demo.model.common.gds.GdsProp;
import com.jerry.frame.demo.model.common.gds.GdsPropExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdsPropMapper {
    int countByExample(GdsPropExample example);

    int deleteByExample(GdsPropExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdsProp record);

    int insertSelective(GdsProp record);

    List<GdsProp> selectByExample(GdsPropExample example);

    GdsProp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GdsProp record, @Param("example") GdsPropExample example);

    int updateByExample(@Param("record") GdsProp record, @Param("example") GdsPropExample example);

    int updateByPrimaryKeySelective(GdsProp record);

    int updateByPrimaryKey(GdsProp record);

    void insertBatch(List<GdsProp> recordLst);
}