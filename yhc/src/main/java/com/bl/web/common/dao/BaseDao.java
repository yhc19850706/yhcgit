/*
 * TempDao.java  2011-2-21 
 * 
 * Copyright (c) 2011, NHN All Rights Reserved. 
 *
 * (Description about the file)
 */

package com.bl.web.common.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

/**
 * (Description about the type)
 *
 * @date  2011-2-21
 * @author   Administrator
 */

@Repository
public class BaseDao {
	@Autowired
	public SqlMapClientTemplate sqlMapClientTemplate;

	@Autowired
	private SqlMapClientTemplate bankLakeSqlMapClientTemplate;
	
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}
	
	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}

	public SqlMapClientTemplate getBankLakeSqlMapClientTemplate() {
		return bankLakeSqlMapClientTemplate;
	}

	public void setBankLakeSqlMapClientTemplate(
			SqlMapClientTemplate bankLakeSqlMapClientTemplate) {
		this.bankLakeSqlMapClientTemplate = bankLakeSqlMapClientTemplate;
	}
}
