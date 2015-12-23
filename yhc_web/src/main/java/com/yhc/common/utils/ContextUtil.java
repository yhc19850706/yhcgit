package com.yhc.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.yhc.common.dao.CommonDao;
import com.yhc.common.model.AuthMenu;
import com.yhc.common.model.CommonCd;


public class ContextUtil {
	private Logger logger = Logger.getLogger(this.getClass());
	private static ContextUtil instance = new ContextUtil();
	private static Long serverStartTimeMili = -1L;
	private static Map<String, String> commonCodeMap = new HashMap<String, String>();
	private static Map<String, List<CommonCd>> commonCodeMapList = new HashMap<String, List<CommonCd>>();
	public static ContextUtil getInstance() {
		return instance;
	}
	private CommonDao commonDao;
	//初始化map缓存数据 
	public void init() throws Exception {
		logger.debug(">>>>>>>>>>>>>>>>>> init start <<<<<<<<<<<<<<<<<<<<");
		instance.setServerStartTimeMili(System.currentTimeMillis());
		initCommonCode();
		logger.debug(">>>>>>>>>>>>>>>>>> init end <<<<<<<<<<<<<<<<<<<<");
	}

	@SuppressWarnings("static-access")
	public void initCommonCode() throws Exception {
		logger.debug("******** initCommonCodestart ***********");
		Map<String, String> commonCodeMap = new HashMap<String, String>();
		Map<String, List<CommonCd>> commonCodeMapList = new HashMap<String, List<CommonCd>>();
		List<CommonCd> list = commonDao.getAllCommonCode();
		String parentCd = null;
		if (list != null && list.size() > 0) {
			List<CommonCd> list2 = new ArrayList<CommonCd>();
			for (int i = 0; i < list.size(); i++) {
				CommonCd code = list.get(i);
				commonCodeMap.put(code.getChildCd(), code.getChildCodeNm());
				if (StringUtils.isBlank(code.getParentCd())) {
					continue;
				}
				if (parentCd != null && !parentCd.equals(code.getParentCd())) {
					commonCodeMapList.put(parentCd, list2);
					list2 = new ArrayList<CommonCd>();
					list2.add(code);
				} else {
					list2.add(code);
				}
				parentCd = code.getParentCd();
				if (i == list.size() - 1) {
					commonCodeMapList.put(parentCd, list2);
				}
			}
		}

		instance.setCommonCodeMap(commonCodeMap);
		instance.setCommonCodeMapList(commonCodeMapList);
		logger.debug("******** initCommonCode end ***********");
	}
	
	/**
	 * @return the serverStartTimeMili
	 */
	public static Long getServerStartTimeMili() {
		return serverStartTimeMili;
	}

	/**
	 * @param serverStartTimeMili the serverStartTimeMili to set
	 */
	public void setServerStartTimeMili(Long serverStartTimeMili) {
		ContextUtil.serverStartTimeMili = serverStartTimeMili;
	}
	/**
	 * @param commonCodeMap the commonCodeMap to set
	 */
	public static void setCommonCodeMap(Map<String, String> commonCodeMap) {
		ContextUtil.commonCodeMap = commonCodeMap;
	}

	public static Map<String, List<CommonCd>> getCommonCodeMapList() {
		return commonCodeMapList;
	}

	public static void setCommonCodeMapList(Map<String, List<CommonCd>> commonCodeMapList) {
		ContextUtil.commonCodeMapList = commonCodeMapList;
	}

	public static Map<String, String> getCommonCodeMap() {
		return commonCodeMap;
	}

	public CommonDao getCommonDao() {
		return commonDao;
	}

	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}
}
