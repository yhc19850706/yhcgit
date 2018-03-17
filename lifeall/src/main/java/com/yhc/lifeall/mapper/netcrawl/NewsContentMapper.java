package com.yhc.lifeall.mapper.netcrawl;

import com.yhc.lifeall.model.netcrawl.NewsContent;
import com.yhc.lifeall.model.netcrawl.NewsContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsContentMapper {
    int countByExample(NewsContentExample example);

    int deleteByExample(NewsContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NewsContent record);

    int insertSelective(NewsContent record);

    List<NewsContent> selectByExampleWithBLOBs(NewsContentExample example);

    List<NewsContent> selectByExample(NewsContentExample example);

    NewsContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NewsContent record, @Param("example") NewsContentExample example);

    int updateByExampleWithBLOBs(@Param("record") NewsContent record, @Param("example") NewsContentExample example);

    int updateByExample(@Param("record") NewsContent record, @Param("example") NewsContentExample example);

    int updateByPrimaryKeySelective(NewsContent record);

    int updateByPrimaryKeyWithBLOBs(NewsContent record);

    int updateByPrimaryKey(NewsContent record);
}