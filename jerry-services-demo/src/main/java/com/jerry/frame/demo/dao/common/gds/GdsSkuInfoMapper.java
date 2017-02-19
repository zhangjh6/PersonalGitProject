package com.jerry.frame.demo.dao.common.gds;

import com.jerry.frame.demo.model.common.gds.GdsSkuInfo;
import com.jerry.frame.demo.model.common.gds.GdsSkuInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdsSkuInfoMapper {
    int countByExample(GdsSkuInfoExample example);

    int deleteByExample(GdsSkuInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdsSkuInfo record);

    int insertSelective(GdsSkuInfo record);

    List<GdsSkuInfo> selectByExample(GdsSkuInfoExample example);

    GdsSkuInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GdsSkuInfo record, @Param("example") GdsSkuInfoExample example);

    int updateByExample(@Param("record") GdsSkuInfo record, @Param("example") GdsSkuInfoExample example);

    int updateByPrimaryKeySelective(GdsSkuInfo record);

    int updateByPrimaryKey(GdsSkuInfo record);

    void insertBatch(List<GdsSkuInfo> recordLst);
}