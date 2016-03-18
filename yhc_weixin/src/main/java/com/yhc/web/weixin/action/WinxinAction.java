package com.yhc.web.weixin.action;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.yhc.common.utils.EncryptUtil;
import com.yhc.common.utils.Md5Util;
import com.yhc.web.weixin.service.AccTokenService;
import com.yhc.web.weixin.service.WeixinFromApiService;
import com.yhc.weixin.api.MessageAPI;
import com.yhc.weixin.api.SnsAPI;
import com.yhc.weixin.model.AccessToken;
import com.yhc.weixin.model.BaseResult;
import com.yhc.weixin.model.SnsToken;
import com.yhc.weixin.model.TextMessage;
import com.yhc.weixin.model.WeiXinUserFromApi;
import com.yhc.weixin.util.CommingLoansUtil;
import com.yhc.weixin.util.Encryptor;
import com.yhc.weixin.util.JsUtil;
import static com.yhc.common.config.BlGlobalVariable.WEIXIN_APPID;
import static com.yhc.common.config.BlGlobalVariable.SITE_URL;
import static com.yhc.common.config.BlGlobalVariable.WEIXIN_SECRET;

@Controller
public class WinxinAction {
	
	
	private SnsAPI snsAPI = new SnsAPI();
	
	private MessageAPI messageAPI = new MessageAPI();
	
	@Resource(name = "weixinEncryptor")
	private Encryptor encryptor;
	
	private final static String M_KEY = "7AHOEZ0daT7Qu2W5x4hA";
	private final static String RESPCODE_ALREADYBIND="";
	private final static String RESPCODE_BINDSUCC="";
	private final static String RESPCODE_BINDFAIL="";
	private final static String SITE_MOBILE_URL="";
	@Resource(name = "weixinFromApiService")
	private WeixinFromApiService weixinFromApiService;
	
	@Resource(name = "accTokenService")
	private AccTokenService accTokenService;
	
	@RequestMapping(value = "/weixinbind.bl",method=RequestMethod.GET)
	public ModelAndView bindGet(@RequestParam(value = "openId", required = false)String openId ,@RequestParam(value = "code", required = false)String code){
		ModelAndView mav = new ModelAndView();
		SnsToken token = null;
		try {
			if(StringUtils.isBlank(openId)&&StringUtils.isBlank(code)){
				mav.setView(new RedirectView(snsAPI.buildOAuthUrl(WEIXIN_APPID, (SITE_URL+"/weixinbind.bl"), false)));
				return mav;
			}
			if(StringUtils.isBlank(openId)&&StringUtils.isNotBlank(code)){
				token = snsAPI.oauth2AccessToken(WEIXIN_APPID, WEIXIN_SECRET, code);
				if(token==null){
					return exception(mav);
				}
				openId = token.getOpenid();
			}else if(StringUtils.isNotBlank(openId)){
				openId=encryptor.decryptWithBase64(openId);
			}
			if(weixinFromApiService.isBind(openId)){
				return exception(mav,"该账号已绑定");
			}
			mav.setViewName("weixin/bind");
			openId=URLEncoder.encode(encryptor.encryptAndBase64(openId),"UTF-8");
			System.out.println(openId);
			mav.addObject("openId", openId);
			return mav;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return exception(mav);
		}
	}
	
	@RequestMapping(value = "/weixinbind.bl",method=RequestMethod.POST)
	public ModelAndView bindPost(@RequestParam("openId") String openId,@RequestParam("username") String username,@RequestParam("password") String password){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("weixin/bind");
		mav.addObject("username", username);
		mav.addObject("password", password);
		System.out.println(openId);
		BaseResult result = new BaseResult();
		try {
			openId=encryptor.decryptWithBase64(URLDecoder.decode(openId));
			if(weixinFromApiService.isBind(openId)){
				//已经绑定过
				result.setErrcode(RESPCODE_ALREADYBIND);
			}else{
				WeiXinUserFromApi user = new WeiXinUserFromApi();
				user.setLoginId(username);
				String encryptPwd = EncryptUtil.encrypt(password);
				user.setPassword(encryptPwd);
				user.setWxUid(openId);
				
				WeiXinUserFromApi checkUser = weixinFromApiService.checkUser(user);
				if(checkUser==null){
					//用户名密码错
					result.setErrcode(RESPCODE_BINDFAIL);
				}else{
					if(StringUtils.isNotEmpty(checkUser.getWxUid())){
						//该账号已经被绑定过
						result.setErrcode(RESPCODE_ALREADYBIND);
					}else{
						checkUser.setWxUid(openId);
						weixinFromApiService.updateUserBind(checkUser);
						result.setErrcode(RESPCODE_BINDSUCC);
					}
				}
			}
			openId=URLEncoder.encode(encryptor.encryptAndBase64(openId),"UTF-8");
			if(result.getErrcode().equals("101")){
				TextMessage message = new TextMessage(openId, "您当前微信账号已经与银湖网账号绑定，如果您要重新绑定，请取消并重新关注银湖网微信账号。");
				try { messageAPI.messageCustomSend(accTokenService.addCurrentAccessToken().getAccessToken(), message); } catch (Exception e) {}
				mav.setViewName("weixin/bind_success");
				return mav;
			}else if(result.getErrcode().equals("102")){
				return fail(mav,"该账号已绑定，请不要重复绑定",openId);
			}else if(result.getErrcode().equals("104")){
				return fail(mav,"绑定失败，用户名或密码错",openId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return fail(mav,"绑定失败",openId);
		}
		
		return mav;
	}
	@RequestMapping(value = "/commingLoans.bl",method=RequestMethod.GET)
	public ModelAndView commingLoans(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("weixin/loan_list");
		mav.addObject("loanList", CommingLoansUtil.getCommingLoans());
		return mav;
	}

	@RequestMapping(value = "/gosite.bl",method=RequestMethod.GET)
	public ModelAndView gosite(String view,@RequestParam(value = "code", required = false)String code) throws Exception{
		ModelAndView mav = new ModelAndView();
		String url = "";
		if(StringUtils.isBlank(code)){
			url = snsAPI.buildOAuthUrl(WEIXIN_APPID, (SITE_URL+"/gosite.bl?view="+view), false);
			mav.setView(new RedirectView(url));
			return mav;
		}
		
		SnsToken token = null;
		try{
			token = snsAPI.oauth2AccessToken(WEIXIN_APPID, WEIXIN_SECRET, code);
		}catch(Exception e){
			return exception(mav);
		}
		
		if(token==null){
			return exception(mav);
		}
		String openId = token.getOpenid();
		WeiXinUserFromApi user = weixinFromApiService.getUser(openId);
		if(user == null){
			//转跳至绑定页面
			url = SITE_URL+"/weixinbind.bl?openId="+openId;
			mav.setView(new RedirectView(url));
		}
		String tokenStr = URLEncoder.encode(encryptor.encryptAndBase64(user.getUserId()),"UTF-8");
		String sign = Md5Util.getMD5Lower(view+"."+M_KEY+"."+user.getUserId());
		url = SITE_MOBILE_URL+"/weixin/gosite.bl?view="+view+"&token="+tokenStr+"&sign="+sign;
		mav.setView(new RedirectView(url));
		return mav;
	}
	
	@RequestMapping(value = "/shareInvite.bl",method=RequestMethod.GET)
	public ModelAndView shareInvite(@RequestParam(value = "hashId", required = false)String hashId,@RequestParam(value = "code", required = false)String code,HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();
		String url = "";
		if(StringUtils.isBlank(code)){
			url = snsAPI.buildOAuthUrl(WEIXIN_APPID, (SITE_URL+"/shareInvite.bl"+(StringUtils.isNotBlank(hashId)?("?hashId="+URLEncoder.encode(hashId,"UTF-8")):"")), false);
			mav.setView(new RedirectView(url));
			return mav;
		}
		SnsToken token = null;
		try{
			token = snsAPI.oauth2AccessToken(WEIXIN_APPID, WEIXIN_SECRET, code);
		}catch(Exception e){
			return exception(mav);
		}
		
		if(token==null){
			return exception(mav);
		}
		String openId = token.getOpenid();
		
		if(StringUtils.isBlank(hashId)){
			//首次进入
			WeiXinUserFromApi user = weixinFromApiService.getUser(openId);
			if(user == null){
				//未绑定用户转跳至绑定页面
				url = SITE_URL+"/weixinbind.bl?openId="+URLEncoder.encode(encryptor.encryptAndBase64(openId),"UTF-8");
				mav.setView(new RedirectView(url));
				return mav;
			}
			//已绑定用户 生成个人活动主页链接
			String newHashId = URLEncoder.encode(encryptor.encryptAndBase64(openId),"UTF-8");
			mav.addObject("shareUrl",SITE_URL+"/shareInvite.bl?hashId="+newHashId);
			mav.addObject("sharePicUrl",SITE_URL+"/img/registShare.jpg");
			String wxJSConfig  = getJSSDKConfig(request);
			mav.addObject("wxJSConfig", wxJSConfig);
			mav.setViewName("weixin/share_invite");
			return mav;
		}else{
			String profileId = encryptor.decryptWithBase64((hashId));
			if(openId.equals(profileId)){
				//相同用户进入个人主页
				String newHashId = URLEncoder.encode(encryptor.encryptAndBase64(openId),"UTF-8");
				mav.addObject("shareUrl",SITE_URL+"/shareInvite.bl?hashId="+newHashId);
				mav.addObject("sharePicUrl",SITE_URL+"/img/registShare.jpg");
				String wxJSConfig  = getJSSDKConfig(request);
				mav.addObject("wxJSConfig", wxJSConfig);
				mav.setViewName("weixin/share_invite");
				return mav;
			}else{
				//不同用户，带上邀请码直接转跳到注册页
				WeiXinUserFromApi user = weixinFromApiService.getUser(profileId);
				String inviteCode = "";
				if(user != null){
					inviteCode = StringUtils.isNotBlank(user.getInviteCode())?user.getInviteCode():"";
				}
				url = SITE_MOBILE_URL+"/regist/go_regist.bl?inviteCode2="+inviteCode+"&clientSide=wechat";
				mav.setView(new RedirectView(url));
				return mav;
			}
			

		}

	}
	
	private String getJSSDKConfig(HttpServletRequest request) throws Exception{
		String queryStr = request.getQueryString();
		StringBuffer ub = request.getRequestURL();
		if(StringUtils.isNotBlank(queryStr)){
			ub = ub.append("?").append(queryStr);
		}
		AccessToken accessToken = accTokenService.addCurrentAccessToken();
		String ticket =accessToken.getJsapiTicket();
		return JsUtil.generateConfigJson(ticket, false, WEIXIN_APPID, ub.toString(), "onMenuShareTimeline","onMenuShareAppMessage");
	}
	
	private ModelAndView exception(ModelAndView mav,String exmsg){
		mav.addObject("exmsg",exmsg);
		return mav;
	}
	
	private ModelAndView exception(ModelAndView mav){
		mav.addObject("exmsg","服务正忙，请稍后再试");
		return mav;
	}
	
	public ModelAndView fail(ModelAndView mav,String error,String openId){
		mav.addObject("openId",openId);
		mav.addObject("error",error);
		return mav;
	}
	
	public ModelAndView success(ModelAndView mav){
		mav.addObject("succ","1");
		return mav;
	}

}
