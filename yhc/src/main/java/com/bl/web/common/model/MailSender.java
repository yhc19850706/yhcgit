package com.bl.web.common.model;

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

import java.io.Serializable;
import java.util.Properties;

import com.bl.web.common.config.BlGlobalVariable;




public class MailSender implements Serializable {

	private static final long serialVersionUID = 1L;
	public MailSender() {

	}

	public void init() {
		this.fromAddress = BlGlobalVariable.MAIL_SERVER_USERNAME;
		this.mailServerHost = BlGlobalVariable.MAIL_SERVER_HOST;
		this.mailServerPort = BlGlobalVariable.MAIL_SERVER_PORT;
		this.userName = BlGlobalVariable.MAIL_SERVER_USERNAME;
		this.password = BlGlobalVariable.MAIL_SERVER_PASSWORD;
		this.validate = true;

	}

	// 发送邮件的服务器的IP和端口
	private String mailServerHost;
	private String mailServerPort = "25";
	// 邮件发送者的地址
	private String fromAddress;
	// 邮件接收者的地址
	private String toAddress;
	// 登陆邮件发送服务器的用户名和密码
	private String userName;
	private String password;
	// 是否需要身份验证
	private boolean validate = false;
	// 邮件主题
	private String subject;
	// 邮件的文本内容
	private String content;
	// 邮件附件的文件名
	private String[] attachFileNames;
	/** */
	/**
	 * 获得邮件会话属性
	 */
	public Properties getProperties() {
		Properties p = new Properties();

		p.put("mail.smtp.host", this.mailServerHost);
		p.put("mail.smtp.port", this.mailServerPort);
		p.put("mail.smtp.auth", validate ? "true" : "false");
		//mail.smtp.starttls.enable
		p.put("mail.smtp.starttls.enable", "true");
		//mail.smtp.ssl.enable
		p.put("mail.smtp.ssl.enable", "true");
		//mailProps.put("mail.smtp.auth.plain.disable" ,"true";
		//p.put("mail.smtp.socketFactory.fallback", "false");

		System.setProperty("javax.net.debug", "ssl");

		return p;
	}

	public String getMailServerHost() {
		return mailServerHost;
	}

	public void setMailServerHost(String mailServerHost) {
		this.mailServerHost = mailServerHost;
	}

	public String getMailServerPort() {
		return mailServerPort;
	}

	public void setMailServerPort(String mailServerPort) {
		this.mailServerPort = mailServerPort;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public String[] getAttachFileNames() {
		return attachFileNames;
	}

	public void setAttachFileNames(String[] fileNames) {
		this.attachFileNames = fileNames;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String textContent) {
		this.content = textContent;
	}
}
