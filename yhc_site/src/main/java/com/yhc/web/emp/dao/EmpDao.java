package com.yhc.web.emp.dao;

import java.util.List;
import java.util.Map;

import com.yhc.common.model.AuthMenu;
import com.yhc.common.model.Emp;

public interface EmpDao {
    int deleteByPrimaryKey(String empId);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(String empId);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

	List<AuthMenu> getAuthMenuList(Map<String, Object> map);
}