package com.yhc.web.userRole.dao;

import com.yhc.common.model.SysUserRole;

public interface SysUserRoleDao {
    int deleteByPrimaryKey(SysUserRole key);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}