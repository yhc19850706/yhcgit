package com.bl.web.emp.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bl.web.common.dao.BaseDao;
import com.bl.web.common.model.Emp;
import com.bl.web.common.model.Performance;
import com.bl.web.common.model.RegistMobile;
import com.bl.web.common.model.Store;
import com.bl.web.common.model.Trade;
import com.bl.web.common.model.User;
import com.bl.web.common.model.UserInfo;
import com.bl.web.common.model.XmphAuth;
import com.bl.web.common.model.XmphAuthMenu;
import com.bl.web.emp.dao.EmpDao;
@Repository("empDao")
public class EmpDaoImpl extends BaseDao implements EmpDao {

	public static String PREFIX = "com.bl.web.emp.";

	@SuppressWarnings("unchecked")
	public Map<String, Object> getEmpList(Map<String,Object> pMap) throws Exception {
		List<Emp> empList = (ArrayList<Emp>)this.getSqlMapClientTemplate().queryForList(PREFIX + "getEmpList",pMap);
		int empCnt = (Integer)this.getSqlMapClientTemplate().queryForObject(PREFIX + "getEmpListCnt",pMap);
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		if(empList == null ){
			empList = new ArrayList<Emp>();
		} 
		rsltMap.put("list", empList);
		rsltMap.put("cnt", empCnt);
		return rsltMap;
	}

	@Override
	public Emp getEmployeById(String employeId) throws Exception {
		// TODO Auto-generated method stub
		return (Emp) this.getSqlMapClientTemplate().queryForObject(PREFIX+"getEmployeById", employeId);
	}

	@Override
	public void insertEmploye(Emp employe) throws Exception {
		// TODO Auto-generated method stub
		this.getSqlMapClientTemplate().insert(PREFIX+"insertEmploye", employe);
	}

	@Override
	public void updateEmploye(Emp employe) throws Exception {
		// TODO Auto-generated method stub
		this.getSqlMapClientTemplate().update(PREFIX+"updateEmploye", employe);
	}

	@Override
	public List<XmphAuth> getXmphAuthList(String authType) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp checkEmp(Emp emp) throws Exception {
		// TODO Auto-generated method stub
	 return (Emp) this.getSqlMapClientTemplate().queryForObject(PREFIX+"checkEmp", emp);
	}

	@Override
	public List<XmphAuthMenu> getXmphAuthMenuList(Map<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList(PREFIX+"getXmphAuthMenuList", map);
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
		return this.getSqlMapClientTemplate().queryForList(PREFIX+"getAllAuthList");
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
	public List<Emp> getAllStoreEmpListByTeamId(Map map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getEmpIdListByEmp(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Store> getInitAllStore() throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList(PREFIX+"getInitAllStore");
	}

	@Override
	public String getMaxInviteCode() throws Exception {
		// TODO Auto-generated method stub
		return (String) this.getSqlMapClientTemplate().queryForObject(PREFIX+"getMaxInviteCode");
	}

	@Override
	public Performance getEmpPerformance(Map<String, Object> pMap) throws Exception {
		// TODO Auto-generated method stub
		return (Performance) this.getSqlMapClientTemplate().queryForObject(PREFIX+"getEmpPerformance", pMap);
	}

	@Override
	public Map<String, Object> getRegistUserList(Map<String, Object> pMap)
			throws Exception {
		// TODO Auto-generated method stub
		List<UserInfo> userList = (ArrayList<UserInfo>)this.getSqlMapClientTemplate().queryForList(PREFIX + "getRegistUserList",pMap);
		int userCnt = (Integer)this.getSqlMapClientTemplate().queryForObject(PREFIX + "getRegistUserListCnt",pMap);
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		if(userList == null ){
			userList = new ArrayList<UserInfo>();
		} 
		rsltMap.put("list", userList);
		rsltMap.put("cnt", userCnt);
		return rsltMap;
	}

	@Override
	public Map<String, Object> getVisitorUserList(Map<String, Object> pMap)
			throws Exception {
		// TODO Auto-generated method stub
		List<RegistMobile> userList = (ArrayList<RegistMobile>)this.getSqlMapClientTemplate().queryForList(PREFIX + "getVisitorUserList",pMap);
		int userCnt = (Integer)this.getSqlMapClientTemplate().queryForObject(PREFIX + "getVisitorUserListCnt",pMap);
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		if(userList == null ){
			userList = new ArrayList<RegistMobile>();
		} 
		rsltMap.put("list", userList);
		rsltMap.put("cnt", userCnt);
		return rsltMap;
	}

	@Override
	public Map<String, Object> getBindingUserList(Map<String, Object> pMap)
			throws Exception {
		// TODO Auto-generated method stub
		List<UserInfo> userList = (ArrayList<UserInfo>)this.getSqlMapClientTemplate().queryForList(PREFIX + "getBindingUserList",pMap);
		int userCnt = (Integer)this.getSqlMapClientTemplate().queryForObject(PREFIX + "getBindingUserListCnt",pMap);
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		if(userList == null ){
			userList = new ArrayList<UserInfo>();
		} 
		rsltMap.put("list", userList);
		rsltMap.put("cnt", userCnt);
		return rsltMap;
	}

	@Override
	public Map<String, Object> getMonthExpireRepay(Map<String, Object> pMap)
			throws Exception {
		// TODO Auto-generated method stub
		List<Trade> tradeList = (ArrayList<Trade>)this.getSqlMapClientTemplate().queryForList(PREFIX + "getMonthExpireRepay",pMap);
		int userCnt = (Integer)this.getSqlMapClientTemplate().queryForObject(PREFIX + "getMonthExpireRepayCnt",pMap);
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		if(tradeList == null ){
			tradeList = new ArrayList<Trade>();
		} 
		rsltMap.put("list", tradeList);
		rsltMap.put("cnt", userCnt);
		return rsltMap;
	}

	@Override
	public UserInfo getUserInfoById(String userId) throws Exception {
		// TODO Auto-generated method stub
		return (UserInfo) this.getSqlMapClientTemplate().queryForObject(PREFIX + "getUserInfoById",userId);
	}

	@Override
	public Map<String, Object> getEmpPerformanceList(Map<String, Object> pMap)
			throws Exception {
		// TODO Auto-generated method stub
		List<Performance> tradeList = (ArrayList<Performance>)this.getSqlMapClientTemplate().queryForList(PREFIX + "getEmpPerformanceList",pMap);
		int userCnt = (Integer)this.getSqlMapClientTemplate().queryForObject(PREFIX + "getEmpPerformanceListCnt",pMap);
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		if(tradeList == null ){
			tradeList = new ArrayList<Performance>();
		} 
		rsltMap.put("list", tradeList);
		rsltMap.put("cnt", userCnt);
		return rsltMap;
	}

	@Override
	public void removeVistor(RegistMobile rgm) throws Exception {
		// TODO Auto-generated method stub
		this.getSqlMapClientTemplate().update(PREFIX+"removeVistor", rgm);
	}

	@Override
	public List<Emp> getStoreEmpList(Map<String, Object> pMap) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList(PREFIX+"getStoreEmpList",pMap);
	}

	@Override
	public void pointEmp(RegistMobile rgm) throws Exception {
		// TODO Auto-generated method stub
		this.getSqlMapClientTemplate().update(PREFIX+"pointEmp", rgm);
	}

	@Override
	public List<Store> getAllStoreList(Map<String, Object> pMap)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList(PREFIX+"getAllStoreList",pMap);
	}

	@Override
	public List<Emp> getAllEmpList(Map<String, Object> pMap)
			throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList(PREFIX+"getAllEmpList",pMap);
	}

	@Override
	public User getUserInfoByParam(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return (User) this.getSqlMapClientTemplate().queryForObject(PREFIX+"getUserInfoByParam",param);
	}

	@Override
	public void updateUserInvideCode(Map<String, Object> param)
			throws Exception {
		// TODO Auto-generated method stub
		this.getSqlMapClientTemplate().update(PREFIX+"updateUserInvideCode", param);
	}

}
