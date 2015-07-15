package com.bl.web.common.utils;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2011</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.bl.web.common.config.BlGlobalVariable;
import com.bl.web.common.model.Feedback;
import com.bl.web.common.model.MailAuthenticator;
import com.bl.web.common.model.MailSender;


//import org.apache.commons.mail.SimpleEmail;
//import org.apache.commons.mail.*;

/** */

/**
 * 简单邮件（不带附件的邮件）发送器
 */
public class MailUtil {
	/** */
	/**
	 * 以文本格式发送邮件
	 *
	 * @param mailInfo 待发送的邮件的信息
	 */
	public static boolean sendTextMail(MailSender mailInfo) {
		// 判断是否需要身份认证
		MailAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			// 如果需要身份认证，则创建一个密码验证器
			authenticator = new MailAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中
			Address to = new InternetAddress(mailInfo.getToAddress());
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			// 设置邮件消息的主题
			mailMessage.setSubject(mailInfo.getSubject());
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// 设置邮件消息的主要内容
			String mailContent = mailInfo.getContent();
			mailMessage.setText(mailContent);
			// 发送邮件
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/** */
	/**
	 * 以HTML格式发送邮件
	 *
	 * @param mailInfo 待发送的邮件信息
	 */
	public static boolean sendHtmlMail(MailSender mailInfo) {
		// 判断是否需要身份认证
		MailAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		//如果需要身份认证，则创建一个密码验证器
		if (mailInfo.isValidate()) {
			authenticator = new MailAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中
			Address to = new InternetAddress(mailInfo.getToAddress());
			// Message.RecipientType.TO属性表示接收者的类型为TO
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			// 设置邮件消息的主题
			mailMessage.setSubject(mailInfo.getSubject());
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
			Multipart mainPart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			BodyPart html = new MimeBodyPart();
			// 设置HTML内容
			html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			// 将MiniMultipart对象设置为邮件内容
			mailMessage.setContent(mainPart);
			// 发送邮件
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param email
	 * @param code
	 * @return
	 */
	public static boolean sendEmailCode(String email,String code) {
		MailSender mailInfo = new MailSender();
		mailInfo.init();
		mailInfo.setToAddress(email);
		mailInfo.setSubject("银湖网邮箱验证");
		mailInfo.setContent("尊贵的用户：您使用的邮箱获取验证码为："+code+".请在60秒内将邮箱验证码输入验证，如过期请返回页面再次点击“邮箱获取验证码”按钮，获取一次。————银湖网(这是一封自动产生的email，请勿回复。)");
	    return MailUtil.sendTextMail(mailInfo);
	}
	/**
	 * 
	 * @param email
	 * @param code
	 * @return
	 */
	public static boolean sendEmailCodeHtml(String email,Feedback feedback) {
		MailSender mailInfo = new MailSender();
		String content = "<!DOCTYPE HTML><html lang=\"zh\">"
		         + "<head>"
			         + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">"
			         + "<meta name=\"description\" content=\"理财,科技\">"
                    +"<title>熊猫金融</title>"
                        +"<style type=\"text/css\">"
                        +"html,body{height:100%;color:#666}"
                        +"body,p,h1,h2,h3,h4,h5,h6,ul,ol,li,dl,dt,dd,table,th,td,form,fieldset,legend,input,textarea,button,select{margin:0;padding:0}"
                        +"body,input,textarea,select,button,table{font-family:YDI-WebG,'微软雅黑',applegothic,sans-serif;font-size:13px}"
                        +"img,fieldset{border:0;vertical-align:top}"
                        +"ul,ol{list-style:none}"
                        +"em,address{font-style:normal}"
                        +"a{display:inline-block;text-decoration:none;color:#666}"
                        +"a:hover,a:active,a:focus{text-decoration:none;color:#ff6800}"
                        +"container{border:1px solid #ddd;border-top:2px solid #ee0000;width:700px}"
                        +".header{padding:12px 30px;background:#fafafa;border-bottom:1px solid #ddd;}"
                        +".content{padding:10px 30px 0; line-height:40px;}"
                        +".user_info{color:#464646;}"
                        +".user_info .tit{display:inline-block;width:90px; text-align:right; padding-right:10px;}"
                        +".ser_mail{margin-top:30px;border-top:1px solid #ddd;text-align:center;}"
                        +".ser_mail a{color:blue;}"
                        +"caption{overflow:hidden;position:relative;top:0;left:0;width:0;height:0;font-size:0;line-height:0;text-indent:-1000px}"
                        +"</style>"
                +"</head>"
                +"<body>"
                +"<div class=\"container\">"
                +"<div class=\"header\">"
                +"<img src=\"http://"+BlGlobalVariable.SITE_DOMAIN+"/img/mail-logo.jpg\" alt=\"\" height=\"50\" />"
                +"</div>"
                +"<div class=\"content\">"
                +"<p>反馈意见：</p>"
                +"<p style=\"text-indent: 28px;\">"+feedback.getContent()+"</p>"
                +"<p class=\"user_info\"><span class=\"tit\">客户手机：</span>"+feedback.getMobileNo()+"</p>"
                +"<p class=\"user_info\"><span class=\"tit\">客户QQ：</span>"+feedback.getQq()+"</p>"
                +"<p class=\"user_info\"><span class=\"tit\">客户邮箱：</span>"+feedback.getEmail()+"</p>"
                +"<p class=\"ser_mail\">客服邮箱：<a href=\"mailto:kefu@xmfin.com\">kefu@xmfin.com</a></p>"
                +"</div></div></body></html>";
		mailInfo.init();
		mailInfo.setToAddress(email);
		mailInfo.setSubject("客户反馈信息");
		mailInfo.setContent(content);
	    return MailUtil.sendHtmlMail(mailInfo);
	}
	
	
	

	public static void main(String[] args) {
		System.out.println("start");
		try {
			String content = "<html lang=\"zh\">"
					         + "<head>"
						         + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">"
						         + "<meta name=\"description\" content=\"理财,科技\">"
	                             +"<title>银湖网</title>"
		                             +"<style type=\"text/css\">"
		                             +"html,body{height:100%;color:#666}"
		                             +"body,p,h1,h2,h3,h4,h5,h6,ul,ol,li,dl,dt,dd,table,th,td,form,fieldset,legend,input,textarea,button,select{margin:0;padding:0}"
		                             +"body,input,textarea,select,button,table{font-family:YDI-WebG,'微软雅黑',applegothic,sans-serif;font-size:13px}"
		                             +"img,fieldset{border:0;vertical-align:top}"
		                             +"ul,ol{list-style:none}"
		                             +"em,address{font-style:normal}"
		                             +"a{display:inline-block;text-decoration:none;color:#666}"
		                             +"a:hover,a:active,a:focus{text-decoration:none;color:#ff6800}"
		                             +"button{margin:0;padding:0;border:0;background:none}"
		                             +".blind,legend{overflow:hidden;position:absolute;top:0;left:0;width:0;height:0;font-size:0;line-height:0}"
		                             +"caption{overflow:hidden;position:relative;top:0;left:0;width:0;height:0;font-size:0;line-height:0;text-indent:-1000px}"
		                             +"</style>"
                             +"</head>"
                             +"<body>"
                             +"<table style=\"border-collapse:collapse;border:1px solid #ddd;border-top:2px solid #ee0000\">"
                             +"<tbody>"
                             + "<tr>"
                             +"<td colspan=\"4\" style=\"height:10px;background-color:#fbfbfb;font-size:0\"></td>"
                             +"</tr>"
                             +"<tr>"
                             +"<td style=\"width:30px;background-color:#fbfbfb\">&nbsp;</td>"
                             +"<td style=\"width:490px;background-color:#fbfbfb;text-align:left\"><a href=\""+BlGlobalVariable.SITE_URL+"\"><img src=\"img/yx_logo.png\" width=\"168\" height=\"62\" alt=\"银湖网logo\" style=\"border:0;vertical-align:top\"></a></td>"
                             +"<td style=\"background-color:#fbfbfb;\"><img src=\"img/img_tex.png\" width=\"186\" height=\"20\" alt=\"银湖网客户服务中心\" style=\"border:0;vertical-align:top\"></td>"
                             +"<td style=\"width:30px;background-color:#fbfbfb\">&nbsp;</td>"
                             +"</tr>"
                             +"<tr>"
                             +"<td colspan=\"4\" style=\"height:10px;background-color:#fbfbfb;font-size:0;border-bottom:1px solid #ddd\"></td>"
                             +"</tr>"
                             +"<tr>"
                             +"<td colspan=\"4\" style=\"height:10px;font-size:0\"></td>"
                             +"</tr>"
                             +"<tr>"
                             +"<td style=\"width:30px\"></td>"
                             +"<td colspan=\"2\" style=\"height:40px;font-size:13px\">亲爱的用户：</td>"
                             +"<td style=\"width:30px\"></td>"
                             +"</tr>"
                             +"<tr>"
                             +"<td style=\"width:30px\"></td>"
                             +"<td colspan=\"2\" style=\"height:40px;font-size:13px\">您的邮箱验证码为：<strong>"+123456+"</strong>.</td>"
                             +"<td style=\"width:30px\"></td>"
                             +"</tr>"
                             +"<tr>"
                             +"<td style=\"width:30px\"></td>"
                             +"<td colspan=\"2\" style=\"height:40px;font-size:13px\">请在60秒内使用验证码进行验证，如果验证码过期请返回页面再次点击\"<span style=\"color:#0066ff\">邮箱获取验证码</span>\"重新获取。</td>"
                             +"<td style=\"width:30px\"></td>"
                             +"</tr>"
                             +"<tr>"
                             +"<td style=\"width:30px\"></td>"
                             +"<td colspan=\"2\" style=\"height:40px;font-size:13px\">(这是一封自动产生的email，请勿回复。)</td>"
                             +"<td style=\"width:30px\"></td>"
                             +"</tr>"
                             +"<tr>"
                             +"<td colspan=\"4\" style=\"height:110px;font-size:0\"></td>"
                             +"</tr>"
                             +"<tr>"
                             +"<td style=\"width:30px\"></td>"
                             +"<td colspan=\"2\" style=\"width:640px;border-top:1px solid #ddd\">"
	                         +"<table style=\"width:640px;border-collapse:collapse\">"
	                         +"<tbody><tr>"
	                         +"<td style=\"width:40px;height:40px\"></td>"
	                         +"<td style=\"width:70px;text-align:right;font-size:13px\">客服热线：</td>"
	                         +"<td style=\"width:110px;text-align:left;font-size:13px\"><strong>4001-598-598</strong></td>"
	                         +"<td style=\"width:70px;text-align:right;font-size:13px\">官方微博：</td>"
	                         +"<td style=\"width:60px;text-align:left;font-size:13px\">@银湖网</td>"
	                         +"<td style=\"width:60px;text-align:right;font-size:13px\">微信：</td>"
	                         +"<td style=\"width:50px;text-align:left;font-size:13px\">银湖网</td>"
	                         +"<td style=\"width:100px;text-align:right;font-size:13px\">投资人QQ群：</td>"
	                         +"<td style=\"width:90px;text-align:left;font-size:13px\"><strong>335170529</strong></td>"
	                         +"</tr>"
	                         +"</tbody></table>"
                             +"</td>"
                             +"<td style=\"width:30px\"></td>"
                             +"</tr>"
                             +"</tbody></table>"
                             +"</body></html>";
			MailSender mailInfo = new MailSender();
			mailInfo.setFromAddress("service@yinhu.com");
			mailInfo.setMailServerHost("smtp.exmail.qq.com");
			mailInfo.setMailServerPort("25");
			mailInfo.setUserName("service@yinhu.com");
			mailInfo.setPassword("123456yh");
			mailInfo.setValidate(true);
			mailInfo.setToAddress("yssun@yinhu.com");
			mailInfo.setSubject("银湖网邮箱验证");
			mailInfo.setContent(content);
			MailUtil.sendHtmlMail(mailInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}


