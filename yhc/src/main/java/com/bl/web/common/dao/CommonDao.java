package com.bl.web.common.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.bl.web.common.model.CommonCd;
import com.bl.web.common.model.XmphMenu;

public abstract class CommonDao extends SqlMapClientDaoSupport{
	public static String PREFIX = "com.bl.web.common.";
	
	public abstract List<CommonCd> getAllCommonCode() throws Exception;
	public abstract List<XmphMenu> getMenuList() throws Exception;
}
