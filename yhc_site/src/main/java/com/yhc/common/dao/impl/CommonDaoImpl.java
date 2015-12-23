package com.yhc.common.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.yhc.common.dao.CommonDao;
import com.yhc.common.model.CommonCd;

public class CommonDaoImpl extends CommonDao{
	@Resource
	private SqlSessionTemplate sqlSession;
	@SuppressWarnings("unchecked")
	public List<CommonCd> getAllCommonCode() throws Exception {
		return sqlSession.selectList(PREFIX + "getAllCommonCode");
	}
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
}
