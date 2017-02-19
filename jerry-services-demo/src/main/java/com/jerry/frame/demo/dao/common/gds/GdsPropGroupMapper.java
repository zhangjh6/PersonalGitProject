package com.jerry.frame.demo.dao.common.gds;

import com.jerry.frame.demo.model.common.gds.GdsPropGroup;
import com.jerry.frame.demo.model.common.gds.GdsPropGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdsPropGroupMapper {
    int countByExample(GdsPropGroupExample example);

    int deleteByExample(GdsPropGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdsPropGroup record);

    int insertSelective(GdsPropGroup record);

    List<GdsPropGroup> selectByExample(GdsPropGroupExample example);

    GdsPropGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GdsPropGroup record, @Param("example") GdsPropGroupExample example);

    int updateByExample(@Param("record") GdsPropGroup record, @Param("example") GdsPropGroupExample example);

    int updateByPrimaryKeySelective(GdsPropGroup record);

    int updateByPrimaryKey(GdsPropGroup record);

    void insertBatch(List<GdsPropGroup> recordLst);
}