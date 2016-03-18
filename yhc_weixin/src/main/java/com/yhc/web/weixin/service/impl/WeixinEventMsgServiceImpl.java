package com.yhc.web.weixin.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.yhc.common.config.BlGlobalVariable;
import com.yhc.web.weixin.service.AccTokenService;
import com.yhc.web.weixin.service.WeixinEventMsgService;
import com.yhc.web.weixin.service.WeixinFromApiService;
import com.yhc.weixin.api.SnsAPI;
import com.yhc.weixin.model.Loan;
import com.yhc.weixin.model.Personal;
import com.yhc.weixin.model.Sign;
import com.yhc.weixin.model.UserAccount;
import com.yhc.weixin.model.UserSignin;
import com.yhc.weixin.model.WeiXinUserFromApi;
import com.yhc.weixin.model.WeixinMessage;
import com.yhc.weixin.model.XMLCustservMessage;
import com.yhc.weixin.model.XMLMessage;
import com.yhc.weixin.model.XMLNewsMessage;
import com.yhc.weixin.model.XMLNewsMessage.Article;
import com.yhc.weixin.model.XMLTextMessage;
import com.yhc.weixin.util.XMLConverUtil;

@Service("weixinEventMsgService")
public class WeixinEventMsgServiceImpl implements WeixinEventMsgService{
	protected Log logger = LogFactory.getLog(WeixinEventMsgServiceImpl.class);
		
	protected SnsAPI snsAPI = new SnsAPI();
	
	@Resource(name = "weixinFromApiService")
	private WeixinFromApiService weixinFromApiService;
	@Resource(name = "accTokenService")
	private AccTokenService accTokenService;
	public static int getHour(){
		Calendar cal=Calendar.getInstance();
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	//http://mp.weixin.qq.com/s?__biz=MzI0NDE4OTQ0Ng==&mid=401658360&idx=1&sn=e1e34f19a41468c925d0aea89cfde046#rd
	/**
	 *默认回复
	 * 
	 **/
	public  XMLMessage defaultReply(WeixinMessage msg){
		int hour = getHour();
		if(hour>=9&&hour<18){
			return new XMLCustservMessage(msg.getFromUserName(),  msg.getToUserName());
		}
		return new XMLTextMessage(msg.getFromUserName(),  msg.getToUserName(), "感谢您的留言，我们会尽快为您解答。（小蚂蚁窗帘客服时间为9:00~18:00）");
	}
	
	/**
	 *绑定信息回复
	 * 
	 **/
	public XMLMessage returnBindMsg(WeixinMessage msg){
		Article article = new Article();
		String desc = "您尚未绑定银湖网账号，绑定后可以轻松查询以下信息：\n"
					+"-收益信息：当日收益及历史总收益。\n"
					+"-账户详情：等级、积分、资金等信息。\n"
					+"-项目预告：查看目前待投资项目。\n\n"
					+"点击【阅读全文】继续完成绑定。";
		String bindUrl =BlGlobalVariable.SITE_URL+"/weixinbind.bl";
		article.setDescription(desc);
		article.setTitle("账号绑定");
		article.setPicurl(BlGlobalVariable.SITE_URL+"/images/wx/zhbd.jpg");
		article.setUrl(snsAPI.buildOAuthUrl(BlGlobalVariable.WEIXIN_APPID, bindUrl, false));
		List<Article> articles = Lists.newArrayList(article);
		return new XMLNewsMessage(msg.getFromUserName(),msg.getToUserName(), articles);
	}
	
	/**
	 *关注
	 * 
	 **/
	public XMLMessage follow(WeixinMessage msg){
		
		String respMsg = "欢迎进入小蚂蚁窗帘之家。我们将竭诚为你提供高品质的窗帘和售后服务\n";
		return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(),respMsg);
	}
	
	/**
	 *取消关注
	 * 
	 **/
	public  XMLMessage unFollow(WeixinMessage msg){
		//取消关注
		String open_Id = msg.getFromUserName();
//		weixinFromApiService.updateUserUnBind(open_Id);

		return null;
	}
	
	/**
	 *签到
	 * 
	 **/
	public  XMLMessage sign(WeixinMessage msg){
		String open_Id = msg.getFromUserName();
		logger.debug("###############    sign start!   openId=["+open_Id+"]     ###############");
		if(!weixinFromApiService.isBind(open_Id)){
			return returnBindMsg(msg);
		}
		String errMsg = "";
		Sign sign = null;
		try {
			if(weixinFromApiService.hasSign(open_Id)){
				sign = new Sign();
				errMsg = "您今日已经签到过了";
			}else{
				WeiXinUserFromApi user = weixinFromApiService.getUser(open_Id);
				if(user == null){
					sign = new Sign();
					logger.info("###############    user is null.   openId=["+open_Id+"]       ###############");
					errMsg = "签到失败。";
				}
//				else{
//					logger.debug("#####    user is exist   openId=["+open_Id+"]     userId=["+user.getUserId()+"]      ###############");
//					UserSignin usi = weixinFromApiService.getUserSignin(user.getUserId());
//					UserSignin rsltUsi = weixinFromApiService.insertUserSignin(usi, user.getUserId());
//					if(rsltUsi.getContinueSigninCnt() == 0){
//						//重复签到
//						errMsg = "您今日已经签到过了";
//					}else{
//						sign = weixinFromApiService.getSign(user.getUserId());
//					}
//				}
			}

		} catch (Exception e) {
			
		}
		
		if(errMsg.length()>0){
			return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(), errMsg);
		}
		Article articlePic = new Article();
		articlePic.setPicurl(BlGlobalVariable.SITE_URL+"/images/wx/mrqd.jpg");
		Article articleText = new Article();
		String template = "本次获得积分：%s分\n" 
						+ "您的总积分为：%s分\n"
						+ "您已连续签到：%s天\n";
		articleText.setTitle(String.format(template, sign.getPoint(),sign.getTotalPoint(),sign.getConDays()));
		List<Article> articles = Lists.newArrayList(articlePic,articleText);
		return new XMLNewsMessage(msg.getFromUserName(),msg.getToUserName(), articles);
	}
	
	/**
	 *收益查询
	 * 
	 **/
	public XMLMessage income(WeixinMessage msg){
		String open_Id = msg.getFromUserName();
		if(!weixinFromApiService.isBind(open_Id)){
			return returnBindMsg(msg);
		}
		Personal personal= null;
		try {
			personal = weixinFromApiService.getIncome(open_Id);
			
		} catch (Exception e) {
			return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(), "查询失败");
		}
		if(personal==null || "4".equals(StringUtils.trimToEmpty(personal.getErrcode()))){
			return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(), "查询失败");
		}
		Article articlePic = new Article();
		//articlePic.setTitle("收益查询");
		articlePic.setPicurl(BlGlobalVariable.SITE_URL+"/images/wx/sycx.jpg");
		Article articleText = new Article();
		String template = "今日预期收益：%s元\n" 
						+ "历史总收益：%s元\n";
		articleText.setTitle(String.format(template, personal.getDayIncome(),personal.getHistoryIncome()));
		List<Article> articles = Lists.newArrayList(articlePic,articleText);
		return new XMLNewsMessage(msg.getFromUserName(),msg.getToUserName(), articles);
	}

	/**
	 *平台简介
	 * 
	 **/
	public XMLMessage platInfo(WeixinMessage msg){
		
		String platInfo = "小蚂蚁窗帘是一家专门从事窗帘销售和安装的店面，以互联网技术和创新的模式为广大用户提供安全、高效的投融资服务。";
		return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(), platInfo);
	}
	
	/**
	 *公司背景
	 * 
	 **/
	public XMLMessage background(WeixinMessage msg){
		String backGround = "熊猫烟花股份有限公司是国内享有盛誉的烟花生产、燃放企业。熊猫烟花于2001年8月28日在上海证券交易所正式挂牌上市，是行业内唯一一家在A股上市的公司。\n上市以后，熊猫烟花实行多元化的发展战略，在地产、影视、互联网、金融等众多领域进行了积极布局，银湖网正是熊猫烟花在互联网金融领域的重要投资项目。";
		return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(), backGround);
	}
	
	/**
	 *联系我们
	 * 
	 **/
	public XMLMessage contact(WeixinMessage msg){
		//联系我们
		try {
			accTokenService.addCurrentAccessToken();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Article article = new Article();
		article.setDescription("小蚂蚁窗帘是一家专门从事窗帘销售和安装的店面");
		article.setTitle("小蚂蚁窗帘");
		article.setPicurl(BlGlobalVariable.SITE_URL+"/images/banner.jpg");
		article.setUrl(BlGlobalVariable.SITE_URL+"/mgz/home_page.wx");
		List<Article> articles = Lists.newArrayList(article);
		return new XMLNewsMessage(msg.getFromUserName(),msg.getToUserName(), articles);
	}

	@Override
	public XMLMessage template(WeixinMessage msg) {
		// TODOAuto-generated method stub
		String xmlString=XMLConverUtil.convertToXML(msg);
		logger.info("<<<<<< TemplateMessage Send Rusl:"+xmlString+">>>>>>");
		return null;
			
	}

}
