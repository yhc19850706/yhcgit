package com.yhc.web.weixin.action;

import static com.yhc.common.config.BlGlobalVariable.WEIXIN_TOKEN;
import static com.yhc.common.config.BlGlobalVariable.WEIXIN_APPID;
import static com.yhc.common.config.BlGlobalVariable.WEIXIN_SECRET;
import static com.yhc.common.config.BlGlobalVariable.SITE_URL;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.common.collect.Maps;
import com.yhc.common.model.UserInfo;
import com.yhc.common.utils.Constants;
import com.yhc.common.utils.DateUtils;
import com.yhc.common.utils.EncryptUtil;
import com.yhc.common.utils.Md5Util;
import com.yhc.web.weixin.service.AccTokenService;
import com.yhc.web.weixin.service.CjUserService;
import com.yhc.web.weixin.service.StatisticsService;
import com.yhc.weixin.api.SnsAPI;
import com.yhc.weixin.model.AccessToken;
import com.yhc.weixin.model.RedEnvelopes;
import com.yhc.weixin.model.RedEnvelopesUser;
import com.yhc.weixin.model.Sms;
import com.yhc.weixin.model.SnsToken;
import com.yhc.weixin.model.User;
import com.yhc.weixin.model.UserAccount;
import com.yhc.weixin.model.WxUserFriend;
import com.yhc.weixin.model.WxUserProfile;
import com.yhc.weixin.util.Encryptor;
import com.yhc.weixin.util.JsUtil;
import com.yhc.weixin.util.RandomIdUtil;

/** 
 * @Project：banklake_weixin
 * @Package：com.bl.web.weixin.action
 * @ClassName: WeixinExperienceAction 
 * @Description: 体验金活动
 * @author Yhc yinhc@yinhu.com
 * @date 2016年1月27日 下午2:54:15  
 */
//@Controller
@RequestMapping(value = "/tyj")
public class WeixinExperienceAction {
//	
//	protected Log logger = LogFactory.getLog(WeixinExperienceAction.class);
//	
//	@Autowired
//	private CjUserService cjUserService;
//	
//	@Resource(name = "weixinEncryptor")
//	private Encryptor encryptor;
//	
//	
//	@Resource(name = "accTokenService")
//	private AccTokenService accTokenService;
//	
//	@Autowired
//	private StatisticsService statisticsService;
//
//	
//	private SnsAPI snsAPI = new SnsAPI();
//	
//	private static String activeEndDate ="20160229235959"; //活动结束时间
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@RequestMapping(value = "/expActive.bl",method=RequestMethod.GET)
//	public ModelAndView profile(@RequestParam(value = "hashId", required = false)String hashId,@RequestParam(value = "code", required = false)String code,HttpServletRequest request) throws Exception{
//		ModelAndView mav = new ModelAndView();
//		
//		String shareUrl = null;
//		String url = null;
//		//1、如果hashId为空，且code为空 表示直接访问URL进入活动的，那么重定向到Oauth认证
//		if(StringUtils.isBlank(hashId)&&StringUtils.isBlank(code)){
//			url = snsAPI.buildOAuthUrl(WEIXIN_APPID, (SITE_URL+"/tyj/expActive.bl"), false);
//			mav.setView(new RedirectView(url));
//			return mav;
//		} else if(StringUtils.isNotBlank(hashId)&&StringUtils.isBlank(code)){
//			//2、如果hashId不为空，但code为空 表示直接访问URL进入活动的，那么重定向到Oauth认证
//			url = snsAPI.buildOAuthUrl(WEIXIN_APPID, (SITE_URL+"/tyj/expActive.bl?hashId="+hashId), false);
//			mav.setView(new RedirectView(url));
//			return mav;
//		} else if(StringUtils.isBlank(hashId)&&StringUtils.isNotBlank(code)){
//			//3、如果hashId为空，但code不为空 获得openId 校验是否存在活动主页,如果不存在，就创建，然后进入个人主页
//			SnsToken token = null;
//			try{
//				token = snsAPI.oauth2AccessToken(WEIXIN_APPID, WEIXIN_SECRET, code);
//			}catch(Exception e){
//				return exception(mav);
//			}
//			
//			if(token==null){
//				return exception(mav);
//			}
//			String currUserWeChatId = token.getOpenid();
//			WxUserProfile currUserProfile = weixinActivityService.getWxUserProfileByOpenId(currUserWeChatId);
//			
//			long activeEnd = DateUtils.dateFormat(activeEndDate);
//			long currentTime = DateUtils.getCurrentMillisecond();
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日"); 
//			String actEndDate=sdf.format(activeEnd);
//			mav.addObject("actEndDate", actEndDate);
//			if(currentTime > activeEnd){
//				mav.addObject("over", "Y");
//			}else{
//				mav.addObject("over", "N");
//			}
//			if(currUserProfile==null){//没有授权的新用户
//				User user = snsAPI.userinfo(token.getAccess_token(), currUserWeChatId, "zh_CN");
//				if(user.getNickname() == null){
//					url = snsAPI.buildOAuthUrl(WEIXIN_APPID, (SITE_URL+"/tyj/expActive.bl"), true);
//					mav.setView(new RedirectView(url));
//					return mav;
//				} else {
//					String nickName = EncryptUtil.base64Encode(user.getNickname());
//					String headImgUrl = user.getHeadimgurl();
//					currUserProfile = new WxUserProfile();
//					String profileId = RandomIdUtil.getRandomCode();
//					currUserProfile.setProfileId(profileId);
//					currUserProfile.setNickName(nickName);
//					currUserProfile.setImgUrl(headImgUrl);
//					currUserProfile.setWechatId(currUserWeChatId);
//					currUserProfile.setCreateDts(DateUtils.getCurDtsStr());
//					currUserProfile.setActivityCode("TYJ");
//					currUserProfile.setGrabYn("Y");
//					
//					WxUserFriend wxUserFriend=new WxUserFriend();//自己抢了第一笔
//					wxUserFriend.setId(RandomIdUtil.getRandomCode());
//					wxUserFriend.setNickName(nickName);
//					wxUserFriend.setImgUrl(headImgUrl);
//					wxUserFriend.setWechatId(currUserWeChatId);
//					wxUserFriend.setProfileId(profileId);
//					wxUserFriend.setSourceProfileId(profileId);
//					wxUserFriend.setGrabAmt(new BigDecimal(0));
//					wxUserFriend.setCreateDts(DateUtils.getCurDtsStr());
//					currUserProfile.setRedAmt(wxUserFriend.getGrabAmt());
//					weixinActivityService.insertWxUserProfile(currUserProfile);
//					weixinActivityService.insertWxUserFriend(wxUserFriend);
//					
//					int  userFriendListCnt = weixinActivityService.getWxUserFriendListCountByUserId(profileId);
//					mav.addObject("userFriendListCnt", userFriendListCnt);
//					if(userFriendListCnt >0){
//						List<WxUserFriend> wxUserFriendList = weixinActivityService.getWxUserFriendListByUserId(profileId);
//						mav.addObject("wxUserFriendList", wxUserFriendList);
//					}
//					mav.addObject("redAmt", currUserProfile.getRedAmt());
//					mav.addObject("firstRedAmt", currUserProfile.getRedAmt());
//					mav.addObject("exchangeYn", "N");
//					mav.addObject("grabYn", "Y");
//					mav.addObject("pageFlag", "me");
//					mav.addObject("hashId", profileId);
//					mav.addObject("openId", currUserWeChatId);
//					mav.addObject("currNickName",  EncryptUtil.base64Encode(currUserProfile.getNickName()));
//					mav.addObject("shareNickName", EncryptUtil.base64Encode(currUserProfile.getNickName()));
//					mav.addObject("headImgUrl", headImgUrl);
//					String wxJSConfig  = getJSSDKConfig(request);
//					mav.addObject("wxJSConfig", wxJSConfig);
//					shareUrl = SITE_URL+"/tyj/expActive.bl?hashId="+profileId;
//					mav.addObject("shareUrl", shareUrl);
//					mav.addObject("siteUrl", SITE_URL);
//					mav.addObject("first", "Y");
//					mav.setViewName("weixin/tiyanjin/experience_profile");
//				}
//				
//			}else{ //已经授权过的用户
//				//进入自己的个人主页
//				
//				if(currUserProfile.getGrabYn().equals("N")){
//					WxUserFriend wxUserFriend=new WxUserFriend();
//					wxUserFriend.setId(RandomIdUtil.getRandomCode());
//					wxUserFriend.setNickName(currUserProfile.getNickName());
//					wxUserFriend.setImgUrl(currUserProfile.getImgUrl());
//					wxUserFriend.setWechatId(currUserProfile.getWechatId());
//					wxUserFriend.setProfileId(currUserProfile.getProfileId());
//					wxUserFriend.setSourceProfileId(currUserProfile.getProfileId());
//					int firstRedAmt = Constants.PERSONAL_TYJ_LIST.get(RandomIdUtil.getTenRandomNumber());
//					wxUserFriend.setGrabAmt(new BigDecimal(firstRedAmt));
//					wxUserFriend.setCreateDts(DateUtil.getCurDtsStr());
//					weixinActivityService.insertWxUserFriend(wxUserFriend);
//					currUserProfile.setRedAmt(currUserProfile.getRedAmt().add(wxUserFriend.getGrabAmt()));//把之前别人那抢的汇总一下
//					currUserProfile.setGrabYn("Y");
//					weixinActivityService.updateWxUserProfile(currUserProfile);
//					mav.addObject("grabYn", "Y");
//					mav.addObject("first", "Y");
//					mav.addObject("firstRedAmt",firstRedAmt);
//				}
//				int  userFriendListCnt = weixinActivityService.getWxUserFriendListCountByUserId(currUserProfile.getProfileId());
//				mav.addObject("userFriendListCnt", userFriendListCnt);
//				if(userFriendListCnt >0){
//					List<WxUserFriend> wxUserFriendList = weixinActivityService.getWxUserFriendListByUserId(currUserProfile.getProfileId());
//					mav.addObject("wxUserFriendList", wxUserFriendList);
//				}
//				mav.addObject("redAmt", currUserProfile.getRedAmt());
//				mav.addObject("pageFlag", "me");
//				mav.setViewName("weixin/tiyanjin/experience_profile");
//				shareUrl = SITE_URL+"/tyj/expActive.bl?hashId="+currUserProfile.getProfileId();
//				mav.addObject("shareUrl", shareUrl);
//				mav.addObject("exchangeYn", currUserProfile.getExchangeYn());
//				String wxJSConfig  = getJSSDKConfig(request);
//				mav.addObject("hashId", currUserProfile.getProfileId());
//				mav.addObject("openId", currUserProfile.getWechatId());
//				mav.addObject("currNickName",  Base64Util.getBase64Decode(currUserProfile.getNickName()));
//				mav.addObject("shareNickName", Base64Util.getBase64Decode(currUserProfile.getNickName()));
//				mav.addObject("headImgUrl", currUserProfile.getImgUrl());
//				mav.addObject("siteUrl", SITE_URL);
//				mav.addObject("wxJSConfig", wxJSConfig);
//			}
//			
//			return mav;
//		}else if(StringUtils.isNotBlank(hashId)&&StringUtils.isNotBlank(code)){//4、如果hashId不为空，且code不为空 获得openId 
//			SnsToken token = null;
//			try{
//				token = snsAPI.oauth2AccessToken(WEIXIN_APPID, WEIXIN_SECRET, code);
//			}catch(Exception e){
//				return exception(mav);
//			}
//			if(token==null){
//				return exception(mav);
//			}
//			String currUserWechatId = token.getOpenid();
//			WxUserProfile shareUserProfile = weixinActivityService.getWxUserProfileById(hashId);
//			if(shareUserProfile==null){
//				url = snsAPI.buildOAuthUrl(WEIXIN_APPID, (SITE_URL+"/tyj/expActive.bl"), true);
//				mav.setView(new RedirectView(url));
//				return mav;
//			}
//			WxUserProfile currUserProfile = weixinActivityService.getWxUserProfileByOpenId(currUserWechatId);//看当前用户是否存在个人主页，不存在则创建
//
//			long activeEnd = DateUtil.dateFormat(activeEndDate);
//			long currentTime = DateUtil.getCurrentMillisecond();
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日"); 
//			String actEndDate=sdf.format(activeEnd);
//			mav.addObject("actEndDate", actEndDate);
//			if(currentTime > activeEnd){
//				mav.addObject("over", "Y");
//			}else{
//				mav.addObject("over", "N");
//			}
//			String shareUserWeChatId = shareUserProfile.getWechatId();
//			if(currUserProfile==null){
//				User user = snsAPI.userinfo(token.getAccess_token(), currUserWechatId, "zh_CN");
//				if(user.getNickname()==null){
//					url = snsAPI.buildOAuthUrl(WEIXIN_APPID, (SITE_URL+"/tyj/expActive.bl?hashId="+hashId), true);
//					mav.setView(new RedirectView(url));
//					return mav;
//				}
//				String nickName = Base64Util.getBase64Encode(user.getNickname());
//				String headImgUrl = user.getHeadimgurl();
//				currUserProfile = new WxUserProfile();
//				String profileId = RandomIdUtil.getRandomCode();
//				currUserProfile.setProfileId(profileId);
//				currUserProfile.setNickName(nickName);
//				currUserProfile.setImgUrl(headImgUrl);
//				currUserProfile.setWechatId(currUserWechatId);
//				currUserProfile.setCreateDts(DateUtil.getCurDtsStr());
//				currUserProfile.setGrabYn("N");
//				currUserProfile.setRedAmt(new BigDecimal(0));
//				currUserProfile.setActivityCode("TYJ");
//				weixinActivityService.insertWxUserProfile(currUserProfile);
//			} // 生成个人主页 end
//
//			mav.addObject("exchangeYn", currUserProfile.getExchangeYn());
//			mav.addObject("redAmt", shareUserProfile.getRedAmt());
//			int  userFriendListCnt = weixinActivityService.getWxUserFriendListCountByUserId(hashId);
//			mav.addObject("userFriendListCnt", userFriendListCnt);
//			if(userFriendListCnt >0){
//				List<WxUserFriend> wxUserFriendList = weixinActivityService.getWxUserFriendListByUserId(hashId);
//				mav.addObject("wxUserFriendList", wxUserFriendList);
//			}
//			
//			if(currUserWechatId.equals(shareUserWeChatId)){//进入了自己的个人主页
//				mav.addObject("pageFlag", "me");
//				if(shareUserProfile.getGrabYn().equals("Y")){
//					mav.addObject("grabYn", "Y");
//				}else{
//					mav.addObject("grabYn", "N");
//				}
//				mav.setViewName("weixin/tiyanjin/experience_profile");
//			}else{//进入了朋友的个人主页
//				mav.addObject("pageFlag", "friend");
//				if(userFriendListCnt >0){
//					Map m = new HashMap();
//					m.put("wechatId", currUserWechatId);
//					m.put("profileId", hashId);
//					m.put("activityCode", "TYJ");
//					int  friendGrabYn = weixinActivityService.checkWxUserFriendGrab(m);
//					if(friendGrabYn>0){
//						mav.addObject("friendGrabYn", "Y");
//					}else{
//						mav.addObject("friendGrabYn", "N");
//					}
//
//				}
//				mav.setViewName("weixin/tiyanjin/experience_profile_friend");
//			}
//			shareUrl = SITE_URL+"/tyj/expActive.bl?hashId="+hashId;
//			mav.addObject("shareUrl", shareUrl);
//			mav.addObject("siteUrl", SITE_URL);
//			String wxJSConfig  = getJSSDKConfig(request);
//			mav.addObject("hashId", hashId);
//			mav.addObject("currNickName",  Base64Util.getBase64Decode(currUserProfile.getNickName()));
//			mav.addObject("shareNickName", Base64Util.getBase64Decode(shareUserProfile.getNickName()));
//			mav.addObject("headImgUrl", currUserProfile.getImgUrl());
//			mav.addObject("openId", currUserWechatId);
//			mav.addObject("wxJSConfig", wxJSConfig);
//			return mav;
//
//		}
//		return mav;
//	}
//	
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@RequestMapping(value = "/robMoney.bl",method=RequestMethod.POST)
//	public @ResponseBody Map<String, String> grabAmt(@RequestParam(value = "hashId", required = false)String hashId,@RequestParam(value = "openId", required = false)String openId) throws Exception{
//		String status ="-1";
//		Map<String, String> result = Maps.newHashMap();
//		if(StringUtils.isNotBlank(hashId)&&StringUtils.isNotBlank(openId)){
//			try {
//				Map m = new HashMap();
//				m.put("wechatId", openId);
//				m.put("profileId", hashId);
//				m.put("activityCode", "TYJ");
//				int  friendGrabYn = weixinActivityService.checkWxUserFriendGrab(m);
//				if(friendGrabYn>0){
//					result.put("status", "-1");
//					result.put("msg", "您已经抢过了！");
//					return result;
//				}
//				WxUserProfile shareUserProfile = weixinActivityService.getWxUserProfileById(hashId);
//				WxUserProfile currUserProfile = weixinActivityService.getWxUserProfileByOpenId(openId);
//				if("Y".equals(currUserProfile.getExchangeYn())){
//					//已经兑换了
//					result.put("status", "-1");
//					result.put("msg", "您已经兑换过了，不能再抢了！");
//					return result;
//				}
//
//				int robAmt = Constants.FRIEND_TYJ_LIST.get(RandomIdUtil.getTenRandomNumber());//100~1000不等，发给当前用户
//				int helpRobAmt = 500;//固定分享用户500;
//
//				int oldCurAmt=currUserProfile.getRedAmt().intValue();
//				int oldShareAmt=shareUserProfile.getRedAmt().intValue();
//				if(oldCurAmt>=20000){
//					//当前用户已经抢够2万,不能再抢了
//					result.put("status", "4");
//					return result;
//				}
//				if((oldCurAmt+robAmt)>=20000){
//					//当前用户已经抢够2万,不能再抢了
//					result.put("status", "4");
//					robAmt = 20000-oldCurAmt;
//					//分享的用户已经抢够2万
//					if((oldShareAmt+helpRobAmt)>=20000){
//						helpRobAmt = 20000-oldShareAmt;
//					}
//					if(robAmt>0){
//						//保存当前用户
//						WxUserFriend currUserFriend = new WxUserFriend();
//						currUserFriend.setId(RandomIdUtil.getRandomCode());
//						currUserFriend.setNickName(currUserProfile.getNickName());
//						currUserFriend.setImgUrl(currUserProfile.getImgUrl());
//						currUserFriend.setWechatId(openId);
//						currUserFriend.setProfileId(currUserProfile.getProfileId());
//						currUserFriend.setSourceProfileId(hashId);
//						currUserFriend.setCreateDts(DateUtil.getCurDtsStr());	
//						currUserFriend.setGrabAmt(new BigDecimal(robAmt));
//
//						currUserProfile.setRedAmt(new BigDecimal(20000));
//						currUserProfile.setUpdateDts(DateUtil.getCurDtsStr());
//						weixinActivityService.saveWeixinActivity(currUserFriend ,currUserProfile);
//					}
//					if(helpRobAmt>0 && !"Y".equals(currUserProfile.getExchangeYn())){
//						//保存邀请用户数据
//						WxUserFriend shareUserFriend = new WxUserFriend();
//						shareUserFriend.setId(RandomIdUtil.getRandomCode());
//						shareUserFriend.setNickName(currUserProfile.getNickName());
//						shareUserFriend.setImgUrl(currUserProfile.getImgUrl());
//						shareUserFriend.setWechatId(openId);
//						shareUserFriend.setProfileId(hashId);
//						shareUserFriend.setSourceProfileId(hashId);
//						shareUserFriend.setCreateDts(DateUtil.getCurDtsStr());	
//						shareUserFriend.setGrabAmt(new BigDecimal(helpRobAmt));
//
//						shareUserProfile.setRedAmt(shareUserProfile.getRedAmt().add(new BigDecimal(helpRobAmt)));
//						shareUserProfile.setUpdateDts(DateUtil.getCurDtsStr());
//						weixinActivityService.saveWeixinActivity(shareUserFriend ,shareUserProfile);
//					}
//
//					return result;
//				}
//				if((oldCurAmt+robAmt)<20000){
//					status = "1";
//					if("Y".equals(shareUserProfile.getExchangeYn())){
//						helpRobAmt =0;
//						status = "2";
//					}else{
//						//分享的用户已经抢够2万
//						if(oldShareAmt>=20000){
//							status = "3";
//							helpRobAmt =0;
//						} else if(oldShareAmt<20000&&(oldShareAmt+helpRobAmt)>=20000){//分享的用户加上帮抢的已经抢够2万
//							helpRobAmt = 20000-oldShareAmt;
//						}
//					}
//
//					if(robAmt>0){
//						//保存当前用户
//						WxUserFriend currUserFriend = new WxUserFriend();
//						currUserFriend.setId(RandomIdUtil.getRandomCode());
//						currUserFriend.setNickName(currUserProfile.getNickName());
//						currUserFriend.setImgUrl(currUserProfile.getImgUrl());
//						currUserFriend.setWechatId(openId);
//						currUserFriend.setProfileId(currUserProfile.getProfileId());
//						currUserFriend.setSourceProfileId(hashId);
//						currUserFriend.setCreateDts(DateUtil.getCurDtsStr());	
//						currUserFriend.setGrabAmt(new BigDecimal(robAmt));
//
//						currUserProfile.setRedAmt(currUserProfile.getRedAmt().add(new BigDecimal(robAmt)));
//						currUserProfile.setUpdateDts(DateUtil.getCurDtsStr());
//						weixinActivityService.saveWeixinActivity(currUserFriend ,currUserProfile);
//					}
//					if(helpRobAmt>0 && !"Y".equals(currUserProfile.getExchangeYn())){
//						//保存邀请用户数据
//						WxUserFriend shareUserFriend = new WxUserFriend();
//						shareUserFriend.setId(RandomIdUtil.getRandomCode());
//						shareUserFriend.setNickName(currUserProfile.getNickName());
//						shareUserFriend.setImgUrl(currUserProfile.getImgUrl());
//						shareUserFriend.setWechatId(openId);
//						shareUserFriend.setProfileId(hashId);
//						shareUserFriend.setSourceProfileId(hashId);
//						shareUserFriend.setCreateDts(DateUtil.getCurDtsStr());	
//						shareUserFriend.setGrabAmt(new BigDecimal(helpRobAmt));
//						shareUserProfile.setRedAmt(shareUserProfile.getRedAmt().add(new BigDecimal(helpRobAmt)));
//						shareUserProfile.setUpdateDts(DateUtil.getCurDtsStr());
//						weixinActivityService.saveWeixinActivity(shareUserFriend ,shareUserProfile);
//					}
//					result.put("status", String.valueOf(status));
//					result.put("robAmt", String.valueOf(robAmt));
//					result.put("helpRobAmt", String.valueOf(helpRobAmt));
//					return result;
//				}
//			} catch (Exception e) {
//				logger.error("error",e);
//				result.put("status", "-1");
//				result.put("msg", "出错了！");
//				return result;
//			}
//
//		}else{
//			result.put("status", "-1");
//			result.put("msg", "出错了！");
//			return result;
//		}
//		return result;
//
//	}
//	
//	/**
//	 * 兑换体验卷
//	 * @param profileId
//	 * @param mobileNo
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/exchange.bl")
//	public @ResponseBody Map<String, String> exchange(String profileId,String mobileNo,String smsCode) throws Exception{
//		Map<String, String> result = Maps.newHashMap();
//	    try {
//			if(StringUtils.isNotBlank(profileId) && StringUtils.isNotBlank(mobileNo)&& StringUtils.isNotBlank(smsCode)){
//				WxUserProfile wxUserProfile = weixinActivityService.getWxUserProfileById(profileId);
//				if(wxUserProfile==null){
//					result.put("result", "fail");
//					result.put("msg", "参数不正确！");
//					return result;
//				}
//				Sms sms = new Sms();
//				sms.setMobileNo(mobileNo);
//				sms.setSoceurCd(smsCode);
//				String re = smsService.checkSmsCode(sms);
//				if (!"ok".equals(re)) {
//					result.put("result", "fail");
//					result.put("msg", "验证码不正确！");
//					return result;
//				}
//				Map<String, String> params = Maps.newHashMap();
//				params.put("mobileNo", mobileNo);
//				params.put("activityCode", "TYJ");
//				int count = weixinActivityService.checkMobileDoExchange(params);
//				if(count>0){
//					result.put("result", "fail");
//					result.put("msg", "该手机号已经参与过本次活动了！");
//					return result;
//				}
//				UserAccount userAccount =userService.getUserAccountByMobilePhone(mobileNo);
//				if(userAccount==null){
//			    	// 没有注册就跳转到注册页面。
//					String param1= URLEncoder.encode(encryptor.encryptAndBase64(mobileNo),"UTF-8");
//					String param2= URLEncoder.encode(encryptor.encryptAndBase64(profileId),"UTF-8");
//					result.put("result", "succ");
//					result.put("msg", "校验通过");
//					result.put("redirectUrl", SITE_URL+"/tyj/go_regist.bl?param1="+param1+"&param2="+param2);
//					return result;
//				}else{
//			        //已存在用户 兑换体验金
//					if("Y".equals(wxUserProfile.getExchangeYn())){
//						result.put("result", "fail");
//						result.put("msg", "对不起，您已经兑换过了！");
//						return result;
//					}
//					
//					wxUserProfile.setExchangeYn("Y");
//					wxUserProfile.setExchangeDts(DateUtil.getCurDtsStr());
//					wxUserProfile.setExchangeMobile(mobileNo);
//					wxUserProfile.setExchangeUserType("1");//微信登录老用户
//					wxUserProfile.setUserId(userAccount.getUserId());
//					wxUserProfile.setUpdateDts(DateUtil.getCurDtsStr());
//					weixinActivityService.updateTiyanjinExchangeProfile(wxUserProfile);
//					result.put("result", "succ");
//					result.put("msg", "领取成功！");
//					result.put("redirectUrl", SITE_URL+"/tyj/exchangeSucc.bl");
//					return result;
//				}
//			}else{
//				result.put("result", "fail");
//				result.put("msg", "参数非法");
//				return result;
//			}
//		} catch (Exception e) {
//			logger.error("error",e);
//			e.printStackTrace();
//			result.put("result", "fail");
//			result.put("msg", "兑换失败！");
//			return result;
//		}
//	}
//	
//	@RequestMapping(value = "/go_regist.bl",method=RequestMethod.GET)
//	public ModelAndView goRegist(String param1,String param2,HttpServletRequest request) throws Exception{
//		ModelAndView mav = new ModelAndView();
//		try {
//			String mobileNo = encryptor.decryptWithBase64(param1);
//			String profileId = encryptor.decryptWithBase64(param2);
//			WxUserProfile wxUserProfile = weixinActivityService.getWxUserProfileById(profileId);
//			if(wxUserProfile==null){
//				return exception(mav);
//			}
//			mav.addObject("mobileNo", mobileNo);
//			mav.addObject("profileId", profileId);
//			mav.addObject("amt", wxUserProfile.getRedAmt());
//		} catch (Exception e) {
//			logger.error("error",e);
//			return exception(mav);
//		}
//		mav.addObject("wxJSConfig", getJSSDKConfigForHideMenu(request));
//		mav.setViewName("weixin/tiyanjin/regist");
//		return mav;
//	}
//	
//	@RequestMapping(value = "/regist.bl",method=RequestMethod.POST)
//	public @ResponseBody Map<String, String> doRegist(String mobileNo,String password,String profileId){
//		Map<String, String> result = Maps.newHashMap();
//		try {
//			WxUserProfile wxUserProfile = weixinActivityService.getWxUserProfileById(profileId);
//			if(wxUserProfile==null){
//				result.put("result", "fail");
//				result.put("msg", "兑换失败！");
//				return result;
//			}
//			if("Y".equals(wxUserProfile.getExchangeYn())){
//				result.put("result", "fail");
//				result.put("msg", "不要重复兑换！");
//				return result;
//			}
//			UserInfo user = new UserInfo();
//
//			String userId = RandomIdUtil.getRandomCode();
//			String encryptUserPw = Md5Util.getMD5(password);
//			user.setUserId(userId);
//			user.setMobileNo(mobileNo);
//			user.setUserPw(encryptUserPw);
//			user.setUserType("USRTP01"); // 我要理财
//			user.setCreateId(userId);
//			user.setCreateDts(DateUtil.getCurDtsStr());
//			user.setClientSide("weixin");
//			userService.insertUser(user);
//			userService.updateUserPoint(userId, "USRPNTTP04");// 注册成功，增加积分
//			// 发送注册成功站内信
//			userService.addInfoSystemLetter("regist", mobileNo, userId);
//			// 发送手机绑定站内信
//			userService.addInfoSystemLetter("mobile", mobileNo, userId);
//
//			// Start modify by yj.zhao@20141208 #784注册成功，生成验证码
//			String currentTime = DateUtil.getCurDtsStr();
//			int index = userService.updateUserInviteCode(user);
//			if (index < Constants.INIVITE_CODE_REQUERY_TIMES) {
//				// 生成邀请码成功，发送短信(站内信)，进入邀请码页面
//				UserInfo userByUserId = userService.getUserByUserId(userId);
//				int inviteCode = userByUserId.getInviteCode();
//				// 得到可用红包
//				Map<String, Object> paraMap2 = new HashMap<String, Object>();
//				paraMap2.put("redEnvelopesType", "RETYPE03");
//				paraMap2.put("today", currentTime);
//				List<RedEnvelopes> reEventList = redEnvelopeService.getRedEnvelopeInfoByType(paraMap2);
//				if (reEventList != null && reEventList.size() > 0) {
//					RedEnvelopes redEnvelope = reEventList.get(0);
//					BigDecimal redEnvelopesAmt = redEnvelope.getRedEnvelopesAmt();
//					if (redEnvelopesAmt != null) {
//						String inviteCodeStr = inviteCode + "";
//						String reAmtStr = redEnvelopesAmt.intValue()+ "";
//						// 站内信
//						Map<String, Object> inviteInfo = new HashMap<String, Object>();
//						inviteInfo.put("inviteCode","恭喜您注册银湖网成功，并获得邀请码:" + inviteCodeStr);
//						inviteInfo.put("reAmt", reAmtStr);
//						userService.addInfoSystemLetter("createInviteCode", mobileNo, userId,inviteInfo);
//						// 短信
//						String code[] = { inviteCodeStr, reAmtStr };
//						SmsUtils.doSend4Invite(mobileNo, code,"reInviteCode");
//					}
//
//				}
//			}
//
//			// 注册送红包活动
//			Map<String, Object> paraMap = new HashMap<String, Object>();
//			paraMap.put("redEnvelopesType", "RETYPE02");
//			paraMap.put("today", currentTime);
//			// modify by yj.zhao@20150114 #
//			// cntLimit用于确认是否需要限定一个结果，当paraMap中cntLimit不为null时为不限定
//			paraMap.put("cntLimit", "cntLimit");
//			List<RedEnvelopes> reEventList = redEnvelopeService.getRedEnvelopeInfoByType(paraMap);
//			if (reEventList != null && reEventList.size() > 0) {
//				for (RedEnvelopes redEnvelope : reEventList) {
//					int effectiveDate = redEnvelope.getEffectiveDate();
//					String reUseStartDts = currentTime;
//					String reUseEndDts = "99991231235959";
//					if (effectiveDate != 9999) {
//						reUseEndDts = DateUtil.getDtStrByIntervalForRedEnvelope(Calendar.DAY_OF_YEAR,effectiveDate);
//					}
//					RedEnvelopesUser reUser = new RedEnvelopesUser();
//					// modify bu yj.zhao@20141211 更改红包id方式
//					String reUserId = RandomIdUtil.getRandomNumber();
//					reUser.setReUserId(reUserId);
//					reUser.setRedEnvelopesId(redEnvelope.getRedEnvelopesId());
//					reUser.setUserId(userId);
//					reUser.setRedEnvelopesAmt(redEnvelope.getRedEnvelopesAmt());
//					reUser.setReUseStartDts(reUseStartDts);
//					reUser.setReUseEndDts(reUseEndDts);
//					reUser.setCreateId(userId);
//					reUser.setCreateDts(currentTime);
//
//					redEnvelopeService.insertRedEnvelope(reUser);
//
//					// 发送赠送红包站内信
//					Map<String, String> reInfo = new HashMap<String, String>();
//					reInfo.put("reAmt",redEnvelope.getRedEnvelopesAmt() + "");
//					reInfo.put("reNm",redEnvelope.getRedEnvelopesNm());
//					userService.addInfoSystemLetter("addReUser",mobileNo, userId, reInfo);
//				}
//			}
//			
//			//WxUserProfile UpdWxUserProfile = new WxUserProfile();
//			wxUserProfile.setProfileId(profileId);
//			wxUserProfile.setExchangeYn("Y");
//			wxUserProfile.setExchangeDts(DateUtil.getCurDtsStr());
//			wxUserProfile.setExchangeMobile(mobileNo);
//			wxUserProfile.setExchangeUserType("2");//微信登录老用户
//			wxUserProfile.setUserId(userId);
//			wxUserProfile.setUpdateDts(DateUtil.getCurDtsStr());
//			weixinActivityService.updateTiyanjinExchangeProfile(wxUserProfile);
//			result.put("result", "succ");
//			result.put("msg", "领取成功！");
//			result.put("redirectUrl", SITE_URL+"/tyj/exchangeSucc.bl");
//			return result;
//		} catch (Exception e) {
//			logger.error("error",e);
//			e.printStackTrace();
//			result.put("result", "fail");
//			result.put("msg", "兑换失败！");
//			return result;
//		}
//	}
//	
//	@RequestMapping(value = "/exchangeSucc.bl",method=RequestMethod.GET)
//	public ModelAndView exchangeSucc(HttpServletRequest request) throws Exception{
//		ModelAndView mav = new ModelAndView();
//		String referer = request.getHeader("referer");
//        if(referer.startsWith("http://" + request.getHeader("host"))) {
//        	mav.addObject("wxJSConfig", getJSSDKConfigForHideMenu(request));
//        	mav.setViewName("weixin/tiyanjin/exchange_succ");
//        }else{
//        	return exception(mav);
//        }
//		return mav;
//	}
//	
//	private String getJSSDKConfig(HttpServletRequest request) throws Exception{
//		String queryStr = request.getQueryString();
//		StringBuffer ub = request.getRequestURL();
//		if(StringUtils.isNotBlank(queryStr)){
//			ub = ub.append("?").append(queryStr);
//		}
//		AccessToken accessToken = accTokenService.addCurrentAccessToken();
//		String ticket =accessToken.getJsapiTicket();
//		return JsUtil.generateConfigJson(ticket, false, WEIXIN_APPID, ub.toString(), "onMenuShareTimeline","onMenuShareAppMessage");
//	}
//	
//	private String getJSSDKConfigForHideMenu(HttpServletRequest request) throws Exception{
//		String queryStr = request.getQueryString();
//		StringBuffer ub = request.getRequestURL();
//		if(StringUtils.isNotBlank(queryStr)){
//			ub = ub.append("?").append(queryStr);
//		}
//		AccessToken accessToken = accTokenService.addCurrentAccessToken();
//		String ticket =accessToken.getJsapiTicket();
//		return JsUtil.generateConfigJson(ticket, false, WEIXIN_APPID, ub.toString(), "hideOptionMenu");
//	}
//	
//	private ModelAndView exception(ModelAndView mav){
//		mav.setViewName("weixin/tiyanjin/error");
//		return mav;
//	}
//	
}

	