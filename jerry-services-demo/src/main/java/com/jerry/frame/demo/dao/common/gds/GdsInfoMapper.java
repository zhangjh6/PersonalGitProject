package com.jerry.frame.demo.dao.common.gds;

import com.jerry.frame.demo.model.common.gds.GdsInfo;
import com.jerry.frame.demo.model.common.gds.GdsInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdsInfoMapper {
    int countByExample(GdsInfoExample example);

    int deleteByExample(GdsInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdsInfo record);

    int insertSelective(GdsInfo record);

    List<GdsInfo> selectByExample(GdsInfoExample example);

    GdsInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GdsInfo record, @Param("example") GdsInfoExample example);

    int updateByExample(@Param("record") GdsInfo record, @Param("example") GdsInfoExample example);

    int updateByPrimaryKeySelective(GdsInfo record);

    int updateByPrimaryKey(GdsInfo record);

    void insertBatch(List<GdsInfo> recordLst);
}