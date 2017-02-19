package com.jerry.frame.demo.dao.common.gds;

import com.jerry.frame.demo.model.common.gds.GdsShop2Catg;
import com.jerry.frame.demo.model.common.gds.GdsShop2CatgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GdsShop2CatgMapper {
    int countByExample(GdsShop2CatgExample example);

    int deleteByExample(GdsShop2CatgExample example);

    int insert(GdsShop2Catg record);

    int insertSelective(GdsShop2Catg record);

    List<GdsShop2Catg> selectByExample(GdsShop2CatgExample example);

    int updateByExampleSelective(@Param("record") GdsShop2Catg record, @Param("example") GdsShop2CatgExample example);

    int updateByExample(@Param("record") GdsShop2Catg record, @Param("example") GdsShop2CatgExample example);

    void insertBatch(List<GdsShop2Catg> recordLst);
}