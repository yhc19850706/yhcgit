package com.yhc.web.role.service;

import java.util.List;

import com.yhc.common.model.SysRole;

public interface SysRoleService {

	List<SysRole> selectRolesByUserId(String id);

}
