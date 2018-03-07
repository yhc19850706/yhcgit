package com.yhc.weixin.model;

public class XMLCustservMessage extends XMLMessage{


	
	public XMLCustservMessage(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, "transfer_customer_service");
	}


	@Override
	public String subXML() {
		return "";
	}

	
}
