package com.yhc.web.weixin.service.handler.support;

import static com.yhc.common.config.BlGlobalVariable.SITE_URL;
import static com.yhc.common.config.BlGlobalVariable.WEIXIN_APPID;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;
import com.yhc.weixin.api.SnsAPI;
import com.yhc.weixin.api.YinhuAPI;
import com.yhc.weixin.model.Loan;
import com.yhc.weixin.model.Personal;
import com.yhc.weixin.model.Sign;
import com.yhc.weixin.model.WeixinMessage;
import com.yhc.weixin.model.XMLCustservMessage;
import com.yhc.weixin.model.XMLMessage;
import com.yhc.weixin.model.XMLNewsMessage;
import com.yhc.weixin.model.XMLNewsMessage.Article;
import com.yhc.weixin.model.XMLTextMessage;

public class YihuMsgSupport {
	
	protected SnsAPI snsAPI = new SnsAPI();
	
	protected YinhuAPI yinhuAPI = new YinhuAPI();
	
	
	public static int getHour(){
		Calendar cal=Calendar.getInstance();
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 *默认回复
	 * 
	 **/
	public  XMLMessage defaultReply(WeixinMessage msg){
		int hour = getHour();
		if(hour>=9&&hour<18){
			return new XMLCustservMessage(msg.getFromUserName(),  msg.getToUserName());
		}
		return new XMLTextMessage(msg.getFromUserName(),  msg.getToUserName(), "感谢您的留言，我们会尽快为您解答。（银湖网客服时间为9:00~18:00）");
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
		String bindUrl = SITE_URL+"/weixinbind.bl";
		article.setDescription(desc);
		article.setTitle("账号绑定");
		article.setPicurl(SITE_URL+"/images/wx/zhbd.jpg");
		article.setUrl(snsAPI.buildOAuthUrl(WEIXIN_APPID, bindUrl, false));
		List<Article> articles = Lists.newArrayList(article);
		return new XMLNewsMessage(msg.getFromUserName(),msg.getToUserName(), articles);
	}
	
	/**
	 *关注
	 * 
	 **/
	public XMLMessage follow(WeixinMessage msg){
		
		String respMsg = "值得信赖的互联网财富专家——银湖网。\n"
					   + "感谢您关注银湖网官方微信！在这里，您可以：\n"
					   + "￥：绑定账号，查询账户、收益等信息。\n"
					   + "￥：每日签到，获得银湖网积分。\n"
					   + "￥：查询最新理财标的预告。\n"
					   + "￥：查询常见问题，享受在线客服服务。\n"
					   + "￥：了解银湖网，查看银湖网最新动态。\n"
					   + "￥：关注银湖网订阅号“银湖资讯”，获取银湖网一手信息，参加最新活动。";
		return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(),respMsg);
	}
	
	/**
	 *取消关注
	 * 
	 **/
	public  XMLMessage unFollow(WeixinMessage msg){
		//取消关注
		String open_Id = msg.getFromUserName();
		yinhuAPI.weixinUnBind(open_Id);
		return null;
	}
	
	/**
	 *签到
	 * 
	 **/
	public  XMLMessage sign(WeixinMessage msg){
		String open_Id = msg.getFromUserName();
		if(!yinhuAPI.userIsBind(open_Id)){
			return returnBindMsg(msg);
		}
		String errMsg = "";
		Sign sign = null;
		try {
			sign = yinhuAPI.sign(open_Id);
			if(sign.getErrcode().equals("202")){
				errMsg = "您今日已经签到过了";
			}else if(sign.getErrcode().equals("204")){
				errMsg = "签到失败。";
			}
		} catch (Exception e) {
			
		}
		if(sign == null){
			errMsg = "签到失败。";
		}
		if(errMsg.length()>0){
			return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(), errMsg);
		}
		Article articlePic = new Article();
		articlePic.setPicurl(SITE_URL+"/images/wx/mrqd.jpg");
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
		if(!yinhuAPI.userIsBind(open_Id)){
			return returnBindMsg(msg);
		}
		Personal personal= null;
		try {
			personal = yinhuAPI.getIncome(open_Id);
		} catch (Exception e) {
			return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(), "查询失败");
		}
		if(personal==null || "4".equals(StringUtils.trimToEmpty(personal.getErrcode()))){
			return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(), "查询失败");
		}
		Article articlePic = new Article();
		//articlePic.setTitle("收益查询");
		articlePic.setPicurl(SITE_URL+"/images/wx/sycx.jpg");
		Article articleText = new Article();
		String template = "今日预期收益：%s元\n" 
						+ "历史总收益：%s元\n";
		articleText.setTitle(String.format(template, personal.getDayIncome(),personal.getHistoryIncome()));
		List<Article> articles = Lists.newArrayList(articlePic,articleText);
		return new XMLNewsMessage(msg.getFromUserName(),msg.getToUserName(), articles);
	}
	
	/**
	 *账户查询
	 * 
	 **/
	public XMLMessage account(WeixinMessage msg){
		String open_Id = msg.getFromUserName();
		if(!yinhuAPI.userIsBind(open_Id)){
			return returnBindMsg(msg);
		}
		Personal personal=null;
		try {
			personal = yinhuAPI.getAccount(open_Id);
		} catch (Exception e) {
			return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(), "查询失败");
		}
		if(personal==null || "4".equals(StringUtils.trimToEmpty(personal.getErrcode()))){
			return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(), "查询失败");
		}
		Article articlePic = new Article();
		//articlePic.setTitle("账户详情");
		articlePic.setPicurl(SITE_URL+"/images/wx/zhxq.jpg");
		
		Article articleText = new Article();
		String template = "账户等级：%s \n" 
						+ "账户总积分：%s分\n"
						+ "待投资金额：%s元\n"
						+ "已投资金额：%s元\n"
						+ "生利宝余额：%s元\n"
						+ "总资产：%s元\n";
		articleText.setTitle(String.format(template, personal.getLevel(),personal.getTotalPoint(),personal.getToBeInvest(),personal.getInvested(),personal.getSlbAmt(),personal.getTotalAssets()));
		List<Article> articles = Lists.newArrayList(articlePic,articleText);
		return new XMLNewsMessage(msg.getFromUserName(),msg.getToUserName(), articles);
	}
	/**
	 *项目预告
	 * 
	 **/
	public XMLMessage itemNotice(WeixinMessage msg){
		try {
			List<Loan> commingLoans =Lists.newArrayList(); //getCommingLoans();
			if(commingLoans==null || commingLoans.size()==0){
				return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(), "暂无可投资项目，请稍后进行查询");
			}
			int num = 2;
			if(commingLoans.size()<2){
				num = commingLoans.size();
			}
			String respStr = "";
			for(int i=0;i<num;i++){
				Loan loan = commingLoans.get(i);
				String template = "【%s】%s\n" 
								+ "信用等级    ：%s\n"
								+ "本期借款总额：%s元\n"
								+ "年化利率    ：%s％\n"
								+ "投资周期    ：%s\n\n";
				respStr+=String.format(template,loan.getLoanType(),loan.getTitle(),loan.getLevel(),loan.getAmount(),loan.getRate(),loan.getCycle());
			}
			respStr+="点击【阅读全文】查看更多投资项目。";
			Article article = new Article();
			article.setDescription(respStr);
			article.setTitle("项目预告");
			article.setPicurl(SITE_URL+"/images/wx/xmyg.jpg");
			article.setUrl(SITE_URL+"/commingLoans.bl");
			List<Article> articles = Lists.newArrayList(article);
			return new XMLNewsMessage(msg.getFromUserName(),msg.getToUserName(), articles);
		} catch (Exception e) {
			e.printStackTrace();
			return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(), "查询失败");
		}
	}
	/**
	 *平台简介
	 * 
	 **/
	public XMLMessage platInfo(WeixinMessage msg){
		String platInfo = "银湖网（yinhu.com）是银湖网络科技有限公司旗下的互联网金融平台，注册资本1亿元人民币。在成立之初，公司便得到了北京市政府的大力支持。银湖网依托实力雄厚的股东背景（A股上市公司熊猫金控集团），行业领先的精英团队，管理健全的风控体系，以互联网技术和创新的模式为广大用户提供安全、高效的投融资服务。";
		return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(), platInfo);
	}
	
	/**
	 *公司背景
	 * 
	 **/
	public XMLMessage background(WeixinMessage msg){
		String backGround = "熊猫金控股份有限公司是国内享有盛誉的烟花生产、燃放企业。熊猫金控于2001年8月28日在上海证券交易所正式挂牌上市，是行业内唯一一家在A股上市的公司。\n上市以后，熊猫金控实行多元化的发展战略，在地产、影视、互联网、金融等众多领域进行了积极布局，银湖网正是熊猫金控在互联网金融领域的重要投资项目。";
		return new XMLTextMessage(msg.getFromUserName(),msg.getToUserName(), backGround);
	}
	
	/**
	 *联系我们
	 * 
	 **/
	public XMLMessage contact(WeixinMessage msg){
		//联系我们
		Article article = new Article();
		article.setDescription("银湖网——值得信赖的互联网理财专家");
		article.setTitle("联系我们");
		article.setPicurl(SITE_URL+"/images/wx/contact.jpg");
		article.setUrl("http://mp.weixin.qq.com/s?__biz=MzA3MDY5NjUwNw==&mid=200276197&idx=1&sn=f0c8371d3c06ac8556f0b3277b3841ce#rd");
		List<Article> articles = Lists.newArrayList(article);
		return new XMLNewsMessage(msg.getFromUserName(),msg.getToUserName(), articles);
	}

}
