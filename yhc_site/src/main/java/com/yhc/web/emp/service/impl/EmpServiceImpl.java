package com.yhc.web.emp.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhc.common.model.AuthMenu;
import com.yhc.web.emp.dao.EmpDao;
import com.yhc.web.emp.service.EmpService;
@Service("empService")
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDao empDao;
	@Override
	public List<AuthMenu> getAuthMenuList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return empDao.getAuthMenuList(map);
	}

}
