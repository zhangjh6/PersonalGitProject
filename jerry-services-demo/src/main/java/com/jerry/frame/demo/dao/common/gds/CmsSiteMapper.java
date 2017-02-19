package com.jerry.frame.demo.dao.common.gds;

import com.jerry.frame.demo.model.common.gds.CmsSite;
import com.jerry.frame.demo.model.common.gds.CmsSiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsSiteMapper {
    int countByExample(CmsSiteExample example);

    int deleteByExample(CmsSiteExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsSite record);

    int insertSelective(CmsSite record);

    List<CmsSite> selectByExample(CmsSiteExample example);

    CmsSite selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsSite record, @Param("example") CmsSiteExample example);

    int updateByExample(@Param("record") CmsSite record, @Param("example") CmsSiteExample example);

    int updateByPrimaryKeySelective(CmsSite record);

    int updateByPrimaryKey(CmsSite record);

    void insertBatch(List<CmsSite> recordLst);
}