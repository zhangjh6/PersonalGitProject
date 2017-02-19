package com.jerry.frame.demo.dao.common.gds;

import com.jerry.frame.demo.model.common.gds.GdsCategory;
import com.jerry.frame.demo.model.common.gds.GdsCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdsCategoryMapper {
    int countByExample(GdsCategoryExample example);

    int deleteByExample(GdsCategoryExample example);

    int deleteByPrimaryKey(String catgCode);

    int insert(GdsCategory record);

    int insertSelective(GdsCategory record);

    List<GdsCategory> selectByExample(GdsCategoryExample example);

    GdsCategory selectByPrimaryKey(String catgCode);

    int updateByExampleSelective(@Param("record") GdsCategory record, @Param("example") GdsCategoryExample example);

    int updateByExample(@Param("record") GdsCategory record, @Param("example") GdsCategoryExample example);

    int updateByPrimaryKeySelective(GdsCategory record);

    int updateByPrimaryKey(GdsCategory record);

    void insertBatch(List<GdsCategory> recordLst);
}