package com.jerry.frame.demo.dao.common.gds;

import com.jerry.frame.demo.model.common.gds.GdsEval;
import com.jerry.frame.demo.model.common.gds.GdsEvalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdsEvalMapper {
    int countByExample(GdsEvalExample example);

    int deleteByExample(GdsEvalExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdsEval record);

    int insertSelective(GdsEval record);

    List<GdsEval> selectByExample(GdsEvalExample example);

    GdsEval selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GdsEval record, @Param("example") GdsEvalExample example);

    int updateByExample(@Param("record") GdsEval record, @Param("example") GdsEvalExample example);

    int updateByPrimaryKeySelective(GdsEval record);

    int updateByPrimaryKey(GdsEval record);

    void insertBatch(List<GdsEval> recordLst);
}