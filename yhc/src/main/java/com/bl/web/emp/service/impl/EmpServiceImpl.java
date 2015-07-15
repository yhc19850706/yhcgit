package com.bl.web.emp.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bl.web.common.model.Emp;
import com.bl.web.common.model.Performance;
import com.bl.web.common.model.RegistMobile;
import com.bl.web.common.model.Store;
import com.bl.web.common.model.User;
import com.bl.web.common.model.UserInfo;
import com.bl.web.common.model.XmphAuth;
import com.bl.web.common.model.XmphAuthMenu;
import com.bl.web.common.utils.Md5Util;
import com.bl.web.emp.dao.EmpDao;
import com.bl.web.emp.service.EmpService;
import com.sun.tracing.dtrace.Attributes;
@Service("empService")
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDao empDao;
	@Override
	public Map<String, Object> getEmpList(Map<String, Object> pMap) throws Exception {
		return empDao.getEmpList(pMap);
	}

	@Override
	public Emp getEmployeById(String employeId) throws Exception {
		// TODO Auto-generated method stub
		return empDao.getEmployeById(employeId);
	}

	@Override
	public void insertEmploye(Emp employe) throws Exception {
		// TODO Auto-generated method stub
		empDao.insertEmploye(employe);
	}

	@Override
	public void updateEmploye(Emp employe) throws Exception {
		// TODO Auto-generated method stub
		empDao.updateEmploye(employe);
	}

	@Override
	public List<XmphAuth> getXmphAuthList(String authType) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Emp checkEmp(Emp emp) throws Exception {
		if(StringUtils.isNotEmpty(emp.getEmpPw())){
			emp.setEmpPw(Md5Util.getMD5(emp.getEmpPw()));
		}
		return empDao.checkEmp(emp);
	}

	@Override
	public List<XmphAuthMenu> getXmphAuthMenuList(Map<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		return empDao.getXmphAuthMenuList(map);
	}

	@Override
	public List<String> getEmpAuthTeamIdListByEmpId(String empId)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getUnderMngTeamIdListByEmpId(String empId)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getUnderMngTeamIdListByMap(Map<String, String> pMap)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp getXmphEmpByUserId(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<XmphAuth> getAllAuthList() throws Exception {
		// TODO Auto-generated method stub
		return empDao.getAllAuthList();
	}

	@Override
	public List<XmphAuthMenu> getAllAuthMenuList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAuthMenu(int authId, Integer[] menuIds) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<String> getEmpIdListByEmp(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMaxInviteCode() throws Exception {
		// TODO Auto-generated method stub
		return empDao.getMaxInviteCode();
	}

	@Override
	public Performance getEmpPerformance(Map<String, Object> pMap) throws Exception {
		// TODO Auto-generated method stub
		return empDao.getEmpPerformance(pMap);
	}

	@Override
	public Map<String, Object> getRegistUserList(Map<String, Object> pMap)
			throws Exception {
		// TODO Auto-generated method stub
		return empDao.getRegistUserList(pMap);
	}

	@Override
	public Map<String, Object> getVisitorUserList(Map<String, Object> pMap)
			throws Exception {
		// TODO Auto-generated method stub
		return empDao.getVisitorUserList(pMap);
	}

	@Override
	public Map<String, Object> getBindingUserList(Map<String, Object> pMap)
			throws Exception {
		// TODO Auto-generated method stub
		return empDao.getBindingUserList(pMap);
	}

	@Override
	public Map<String, Object> getMonthExpireRepay(Map<String, Object> pMap)
			throws Exception {
		// TODO Auto-generated method stub
		return empDao.getMonthExpireRepay(pMap);
	}

	@Override
	public UserInfo getUserInfoById(String userId) throws Exception {
		// TODO Auto-generated method stub
		return empDao.getUserInfoById(userId);
	}

	@Override
	public Map<String, Object> getEmpPerformanceList(Map<String, Object> pMap)
			throws Exception {
		// TODO Auto-generated method stub
		return empDao.getEmpPerformanceList(pMap);
	}

	@Override
	public void removeVistor(RegistMobile rgm) throws Exception {
		// TODO Auto-generated method stub
		empDao.removeVistor(rgm);
	}

	@Override
	public List<Emp> getStoreEmpList(Map<String, Object> pMap) throws Exception {
		// TODO Auto-generated method stub
		return empDao.getStoreEmpList(pMap);
	}

	@Override
	public void pointEmp(RegistMobile rgm) throws Exception {
		// TODO Auto-generated method stub
		empDao.pointEmp(rgm);
	}

	@Override
	public List<Store> getAllStoreList(Map<String, Object> pMap)
			throws Exception {
		// TODO Auto-generated method stub
		return empDao.getAllStoreList(pMap);
	}

	@Override
	public List<Emp> getAllEmpList(Map<String, Object> pMap)
			throws Exception {
		// TODO Auto-generated method stub
		return empDao.getAllEmpList(pMap);
	}

	@Override
	public User getUserInfoByParam(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return empDao.getUserInfoByParam(param);
	}

	@Override
	public void updateUserInvideCode(Map<String, Object> param)
			throws Exception {
		// TODO Auto-generated method stub
		empDao.updateUserInvideCode(param);
	}

}
