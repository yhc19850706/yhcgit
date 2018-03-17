package com.yhc.lifeall.mapper.netcrawl;

import com.yhc.lifeall.model.netcrawl.ExpressLogistics;
import com.yhc.lifeall.model.netcrawl.ExpressLogisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpressLogisticsMapper {
    int countByExample(ExpressLogisticsExample example);

    int deleteByExample(ExpressLogisticsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExpressLogistics record);

    int insertSelective(ExpressLogistics record);

    List<ExpressLogistics> selectByExample(ExpressLogisticsExample example);

    ExpressLogistics selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExpressLogistics record, @Param("example") ExpressLogisticsExample example);

    int updateByExample(@Param("record") ExpressLogistics record, @Param("example") ExpressLogisticsExample example);

    int updateByPrimaryKeySelective(ExpressLogistics record);

    int updateByPrimaryKey(ExpressLogistics record);
}