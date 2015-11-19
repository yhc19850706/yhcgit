package com.yhc.web.role.dao;

import java.util.List;

import com.yhc.common.model.SysRole;

public interface SysRoleDao {
    int deleteByPrimaryKey(String id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
    
    List<SysRole> selectRolesByUserId(String id);
}