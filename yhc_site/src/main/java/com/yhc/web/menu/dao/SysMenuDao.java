package com.yhc.web.menu.dao;

import java.util.List;
import java.util.Map;

import com.yhc.common.model.AuthMenu;
import com.yhc.common.model.SysMenu;

public interface SysMenuDao {
    int deleteByPrimaryKey(String id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
    public List<SysMenu> selectPermissionsByRoleId(String id);
    public List<SysMenu> selectMenusByRoleId(String userId) throws Exception;
    public List<AuthMenu> getAuthMenuList(Map<String, Object> map);
}