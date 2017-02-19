package com.jerry.frame.demo.dao.common.gds;

import com.jerry.frame.demo.model.common.gds.GdsEvalReply;
import com.jerry.frame.demo.model.common.gds.GdsEvalReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdsEvalReplyMapper {
    int countByExample(GdsEvalReplyExample example);

    int deleteByExample(GdsEvalReplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdsEvalReply record);

    int insertSelective(GdsEvalReply record);

    List<GdsEvalReply> selectByExample(GdsEvalReplyExample example);

    GdsEvalReply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GdsEvalReply record, @Param("example") GdsEvalReplyExample example);

    int updateByExample(@Param("record") GdsEvalReply record, @Param("example") GdsEvalReplyExample example);

    int updateByPrimaryKeySelective(GdsEvalReply record);

    int updateByPrimaryKey(GdsEvalReply record);

    void insertBatch(List<GdsEvalReply> recordLst);
}