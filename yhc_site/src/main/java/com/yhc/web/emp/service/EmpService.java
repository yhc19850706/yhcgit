package com.yhc.web.emp.service;

import java.util.List;
import java.util.Map;

import com.yhc.common.model.AuthMenu;

public interface EmpService {

	public List<AuthMenu> getAuthMenuList(Map<String, Object> map);

}
