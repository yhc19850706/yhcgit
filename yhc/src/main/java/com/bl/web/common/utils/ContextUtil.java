package com.bl.web.common.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.bl.web.common.dao.CommonDao;
import com.bl.web.common.model.CommonCd;
import com.bl.web.common.model.Store;
import com.bl.web.common.model.XmphAuth;
import com.bl.web.common.model.XmphAuthMenu;
import com.bl.web.common.model.XmphMenu;
import com.bl.web.emp.dao.EmpDao;
import com.google.common.collect.Maps;

public class ContextUtil {
	private Logger logger = Logger.getLogger(this.getClass());
	private static ContextUtil instance = new ContextUtil();
	private static Long serverStartTimeMili = -1L;

	private static Map<String, String> commonCodeMap = new HashMap<String, String>();
	private static Map<String, List<CommonCd>> commonCodeMapList = new HashMap<String, List<CommonCd>>();
	
	private static Map<String, XmphAuthMenu> xmphAuthMenuMap = new HashMap<String, XmphAuthMenu>();
	private static Map<String, List<XmphAuthMenu>> xmphAuthMenuMapList = new HashMap<String, List<XmphAuthMenu>>();
	private static Map<String, List<XmphAuthMenu>> xmphAuthUriMapList = new HashMap<String, List<XmphAuthMenu>>();
	
	private static Map<String, Integer> uriMenuId = new HashMap<String, Integer>();

	private static Map<Integer, BigDecimal> periodRateMap = new HashMap<Integer, BigDecimal>();
	
	private static Map<String,List<Store>> xmphStoreMapList=new HashMap<String, List<Store>>();
	private static Map<String,Store> xmphStoreCodeList=new HashMap<String,Store>();

	private CommonDao commonDao;
	private EmpDao empDao;

	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}
	
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	public static ContextUtil getInstance() {
		return instance;
	}

	//初始化map缓存数据 
	public void init() throws Exception {
		logger.debug(">>>>>>>>>>>>>>>>>> init start <<<<<<<<<<<<<<<<<<<<");
		instance.setServerStartTimeMili(System.currentTimeMillis());
		initCommonCode();
		initXmphAuthMenu();
		initXmphAuthUri();
		initUriMenu();
		initPeriodRate();
		initXmphStore();
		logger.debug(">>>>>>>>>>>>>>>>>> init end <<<<<<<<<<<<<<<<<<<<");
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
	
	@SuppressWarnings("static-access")
	public void initXmphAuthMenu() throws Exception {
		logger.debug("******** initRmAuthMenu start ***********");
		Map<String, List<XmphAuthMenu>> xmphAuthMenuMapList = new HashMap<String, List<XmphAuthMenu>>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("delYn", "N");
		map.put("menuDelYn", "N");
		map.put("authDelYn", "N");
		map.put("dispYn", "Y");
		
		List<XmphAuthMenu> list = empDao.getXmphAuthMenuList(map);
		if (list != null && list.size() > 0) {
			
			for (int i = 0; i < list.size(); i++) {
				XmphAuthMenu xmphAuthMenu = list.get(i);
				List<XmphAuthMenu> list2 = null;
				if (xmphAuthMenuMapList.get(xmphAuthMenu.getAuthId() + "") != null && xmphAuthMenuMapList.get(xmphAuthMenu.getAuthId()+ "").size() > 0) {
					list2 = xmphAuthMenuMapList.get(xmphAuthMenu.getAuthId() + "");
				} else {
					list2 = new ArrayList<XmphAuthMenu>();
				}
				list2.add(xmphAuthMenu);
				xmphAuthMenuMapList.put(xmphAuthMenu.getAuthId() + "", list2);
			}
		}
		instance.setXmphAuthMenuMapList(xmphAuthMenuMapList);
		logger.debug("******** initRmAuthMenu end ***********");
	}
	
	@SuppressWarnings("static-access")
	public void initXmphAuthUri() throws Exception {
		logger.debug("******** initRxtAuthUri start ***********");
		Map<String, List<XmphAuthMenu>> xmphAuthUriMapList = new HashMap<String, List<XmphAuthMenu>>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("delYn", "N");
		map.put("menuDelYn", "N");
		map.put("authDelYn", "N");
		
		List<XmphAuthMenu> list = empDao.getXmphAuthMenuList(map);
		if (list != null && list.size() > 0) {
			
			for (int i = 0; i < list.size(); i++) {
				XmphAuthMenu xmphAuthMenu = list.get(i);
				List<XmphAuthMenu> list2 = null;
				if (xmphAuthUriMapList.get(xmphAuthMenu.getAuthId() + "") != null && xmphAuthUriMapList.get(xmphAuthMenu.getAuthId()+ "").size() > 0) {
					list2 = xmphAuthUriMapList.get(xmphAuthMenu.getAuthId() + "");
				} else {
					list2 = new ArrayList<XmphAuthMenu>();
				}
				list2.add(xmphAuthMenu);
				xmphAuthUriMapList.put(xmphAuthMenu.getAuthId() + "", list2);
			}
		}

		instance.setXmphAuthUriMapList(xmphAuthUriMapList);
		logger.debug("******** initRxtAuthUri end ***********");
	}
	
	public void initUriMenu() throws Exception {
		logger.debug("******** initUriMenu start ***********");
		
		Map<String, Integer> uriMenuMap = new HashMap<String, Integer>();
		
		List<XmphMenu> menuList = commonDao.getMenuList();
		
		if (menuList != null && menuList.size() > 0) {
			for (XmphMenu rm : menuList) {
				uriMenuMap.put(rm.getMenuUri(), rm.getMenuId());
			}
		}
		
		setUriMenuId(uriMenuMap);
		logger.debug("******** initUriMenu end ***********");
	}
	
	public void initPeriodRate(){
		periodRateMap.put(6, new BigDecimal(12.8));
		periodRateMap.put(12, new BigDecimal(13.8));
		periodRateMap.put(18, new BigDecimal(14.5));
		periodRateMap.put(24, new BigDecimal(15));
		periodRateMap.put(36, new BigDecimal(17));
	}

	public void initXmphStore(){
		logger.debug("******** initXmphStoreCodestart ***********");
		Map<String, List<Store>> storeCodeMapList = new HashMap<String, List<Store>>();
		Map<String,Store> xmphStoreCodeList=new HashMap<String,Store>();
		Map pMap=Maps.newHashMap();
		List<Store> list= new ArrayList<Store>();
		try {
			list = empDao.getInitAllStore();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String parentCode = null;
		if (list != null && list.size() > 0) {
			List<Store> areaList = new ArrayList<Store>();
			List<Store> list2=new ArrayList<Store>();
			for (int i = 0; i < list.size(); i++) {
				Store code = list.get(i);
				xmphStoreCodeList.put(code.getStoreCode(), code);
				if (parentCode != null && !parentCode.equals(code.getParentCode())) {
					storeCodeMapList.put(parentCode, list2);
					list2 = new ArrayList<Store>();
					list2.add(code);
				} else {
					list2.add(code);
				}
				parentCode = code.getParentCode();
				
				if(i==list.size()-1){
					storeCodeMapList.put(parentCode, list2);
				}
			}
			storeCodeMapList.put("area", areaList);
		}
		instance.setXmphStoreCodeList(xmphStoreCodeList);
		instance.setXmphStoreMapList(storeCodeMapList);
		logger.debug("******** initStoreCode end ***********");
		
	}
	public static Map<String, Store> getXmphStoreCodeList() {
		return xmphStoreCodeList;
	}

	public static void setXmphStoreCodeList(Map<String, Store> xmphStoreCodeList) {
		ContextUtil.xmphStoreCodeList = xmphStoreCodeList;
	}

	public static Map<String, XmphAuthMenu> getRxtAuthMenuMap() {
		return xmphAuthMenuMap;
	}

	public static void setRxtAuthMenuMap(Map<String, XmphAuthMenu> rxtAuthMenuMap) {
		ContextUtil.xmphAuthMenuMap = rxtAuthMenuMap;
	}

	public static Map<String, List<XmphAuthMenu>> getXmphAuthMenuMapList() {
		return xmphAuthMenuMapList;
	}

	public static void setXmphAuthMenuMapList(Map<String, List<XmphAuthMenu>> xmphAuthMenuMapList) {
		ContextUtil.xmphAuthMenuMapList = xmphAuthMenuMapList;
	}

	/**
	 * @return the commonCodeMap
	 */
	public static Map<String, String> getCommonCodeMap() {
		return commonCodeMap;
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

	public static Map<Integer, BigDecimal> getPeriodRateMap() {
		return periodRateMap;
	}
	
	public static BigDecimal getRateByPeriod(Integer period){
		BigDecimal rate = new BigDecimal(0);
		if(period != null){
			rate = periodRateMap.get(period);
			if(rate == null){
				rate = new BigDecimal(0);
			}
		}
		return rate;
	}

	public static Map<String, List<XmphAuthMenu>> getXmphAuthUriMapList() {
		return xmphAuthUriMapList;
	}

	public static void setXmphAuthUriMapList(Map<String, List<XmphAuthMenu>> xmphAuthUriMapList) {
		ContextUtil.xmphAuthUriMapList = xmphAuthUriMapList;
	}

	public static Map<String, Integer> getUriMenuId() {
		return uriMenuId;
	}

	public static void setUriMenuId(Map<String, Integer> uriMenuId) {
		ContextUtil.uriMenuId = uriMenuId;
	}
	public static Map<String, List<Store>> getXmphStoreMapList() {
		return xmphStoreMapList;
	}

	public static void setXmphStoreMapList(Map<String, List<Store>> xmphStoreMapList) {
		ContextUtil.xmphStoreMapList = xmphStoreMapList;
	}
}
