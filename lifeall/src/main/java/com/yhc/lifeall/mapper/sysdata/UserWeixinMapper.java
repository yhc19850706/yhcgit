package com.yhc.lifeall.mapper.sysdata;

import com.yhc.lifeall.model.sysdata.UserWeixin;
import com.yhc.lifeall.model.sysdata.UserWeixinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserWeixinMapper {
    int countByExample(UserWeixinExample example);

    int deleteByExample(UserWeixinExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserWeixin record);

    int insertSelective(UserWeixin record);

    List<UserWeixin> selectByExample(UserWeixinExample example);

    UserWeixin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserWeixin record, @Param("example") UserWeixinExample example);

    int updateByExample(@Param("record") UserWeixin record, @Param("example") UserWeixinExample example);

    int updateByPrimaryKeySelective(UserWeixin record);

    int updateByPrimaryKey(UserWeixin record);
}