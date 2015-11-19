package com.yhc.web.role.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yhc.common.model.SysRole;
import com.yhc.web.role.dao.SysRoleDao;
import com.yhc.web.role.service.SysRoleService;
@Service("roleService")
public class SysRoleServiceImpl implements SysRoleService {

	@Resource(name="roleDao")
	private SysRoleDao roleDao;

	@Override
	public List<SysRole> selectRolesByUserId(String id) {
		// TODO Auto-generated method stub
		return roleDao.selectRolesByUserId(id);
	}
}
