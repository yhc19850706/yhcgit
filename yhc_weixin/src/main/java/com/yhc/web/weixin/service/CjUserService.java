package com.yhc.web.weixin.service;

import com.yhc.weixin.model.CjUser;
public interface CjUserService {
	public void insertCjUser(CjUser cjUser) throws Exception;
	public Integer getCjUserByMobileNo(String mobileNo)throws Exception;
	
}
