package com.jerry.frame.demo.dao.common.gds;

import com.jerry.frame.demo.model.common.gds.GdsProp2Group;
import com.jerry.frame.demo.model.common.gds.GdsProp2GroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdsProp2GroupMapper {
    int countByExample(GdsProp2GroupExample example);

    int deleteByExample(GdsProp2GroupExample example);

    int insert(GdsProp2Group record);

    int insertSelective(GdsProp2Group record);

    List<GdsProp2Group> selectByExample(GdsProp2GroupExample example);

    int updateByExampleSelective(@Param("record") GdsProp2Group record, @Param("example") GdsProp2GroupExample example);

    int updateByExample(@Param("record") GdsProp2Group record, @Param("example") GdsProp2GroupExample example);

    void insertBatch(List<GdsProp2Group> recordLst);
}