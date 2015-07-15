package com.bl.web.emp.service;

import java.util.List;
import java.util.Map;

import com.bl.web.common.model.Emp;
import com.bl.web.common.model.Performance;
import com.bl.web.common.model.RegistMobile;
import com.bl.web.common.model.Store;
import com.bl.web.common.model.User;
import com.bl.web.common.model.UserInfo;
import com.bl.web.common.model.XmphAuth;
import com.bl.web.common.model.XmphAuthMenu;

public interface EmpService {

	public Map<String, Object> getEmpList(Map<String,Object> pMap) throws Exception;
	
	public Emp getEmployeById(String employeId) throws Exception;
	
	public void insertEmploye(Emp employe)throws Exception;
	
	public void updateEmploye(Emp employe) throws Exception;
	
	public List<XmphAuth> getXmphAuthList(String authType) throws Exception;
	public Emp checkEmp(Emp emp) throws Exception;
	public List<XmphAuthMenu> getXmphAuthMenuList(Map<String,Object> map) throws Exception;
	public List<String> getEmpAuthTeamIdListByEmpId(String empId) throws Exception;
	public List<String> getUnderMngTeamIdListByEmpId(String empId) throws Exception;
	public List<String> getUnderMngTeamIdListByMap(Map<String, String> pMap) throws Exception;
	public Emp getXmphEmpByUserId(String userId) throws Exception;
	public List<XmphAuth> getAllAuthList() throws Exception;
	public List<XmphAuthMenu> getAllAuthMenuList() throws Exception;
	public void updateAuthMenu(int authId, Integer[] menuIds)throws Exception;
	List<String> getEmpIdListByEmp(Emp emp) throws Exception;

	public String getMaxInviteCode() throws Exception;

	public Performance getEmpPerformance(Map<String, Object> pMap) throws Exception;

	public Map<String, Object> getRegistUserList(Map<String, Object> pMap) throws Exception;

	public Map<String, Object> getVisitorUserList(Map<String, Object> pMap) throws Exception;

	public Map<String, Object> getBindingUserList(Map<String, Object> pMap) throws Exception;

	public Map<String, Object> getMonthExpireRepay(Map<String, Object> pMap) throws Exception;

	public UserInfo getUserInfoById(String userId) throws Exception;

	public Map<String, Object> getEmpPerformanceList(Map<String, Object> pMap)throws Exception;

	public void removeVistor(RegistMobile rgm)throws Exception;

	public List<Emp> getStoreEmpList(Map<String, Object> pMap) throws Exception;

	public void pointEmp(RegistMobile rgm) throws Exception;

	public List<Store> getAllStoreList(Map<String, Object> pMap) throws Exception;

	public List<Emp> getAllEmpList(Map<String, Object> pMap) throws Exception;
	
	public User getUserInfoByParam(Map<String, Object> param) throws Exception;

	public void updateUserInvideCode(Map<String, Object> param) throws Exception;
}
