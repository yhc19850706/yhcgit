package com.bl.web.common.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bl.web.common.dao.CommonDao;
import com.bl.web.common.model.CommonCd;
import com.bl.web.common.model.XmphMenu;

@Repository("commonDao")
public class CommonDaoImpl extends CommonDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<CommonCd> getAllCommonCode() throws Exception {
		return (List<CommonCd>)this.getSqlMapClientTemplate().queryForList(PREFIX + "getAllCommonCode");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<XmphMenu> getMenuList() throws Exception {
		return (List<XmphMenu>)this.getSqlMapClientTemplate().queryForList(PREFIX + "getMenuList");
	}

}
