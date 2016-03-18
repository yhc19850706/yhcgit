package com.yhc.weixin.model;

public class Letter extends UserInfo {
	private int letterId;
	private String letterType;
	private String letterTypeStr;
	private String letterCont;
	private String fromUserId;
	private String letterTitle;
	private String readYn;
	private String fromUserNm;
	private int noReadCount;
	private String receivedYn;//通知，公告 都是 '接收'类型 Y,私信有发送类型,用N表示
	private String contactUserNm;//私信联系人用户名

	public int getLetterId() {
		return letterId;
	}

	public void setLetterId(int letterId) {
		this.letterId = letterId;
	}

	public String getLetterType() {
		return letterType;
	}

	public void setLetterType(String letterType) {
		this.letterType = letterType;
	}

	public String getLetterCont() {
		return letterCont;
	}

	public void setLetterCont(String letterCont) {
		this.letterCont = letterCont;
	}

	public String getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getLetterTypeStr() {
		return letterTypeStr;
	}

	public String getLetterTitle() {
		return letterTitle;
	}

	public void setLetterTitle(String letterTitle) {
		this.letterTitle = letterTitle;
	}

	public String getReadYn() {
		return readYn;
	}

	public void setReadYn(String readYn) {
		this.readYn = readYn;
	}

	public void setLetterTypeStr(String letterTypeStr) {
		this.letterTypeStr = letterTypeStr;
	}

	public String getFromUserNm() {
		return fromUserNm;
	}

	public void setFromUserNm(String fromUserNm) {
		this.fromUserNm = fromUserNm;
	}

	public int getNoReadCount() {
		return noReadCount;
	}

	public void setNoReadCount(int noReadCount) {
		this.noReadCount = noReadCount;
	}

	public String getReceivedYn() {
		return receivedYn;
	}

	public void setReceivedYn(String receivedYn) {
		this.receivedYn = receivedYn;
	}

	public String getContactUserNm() {
		return contactUserNm;
	}

	public void setContactUserNm(String contactUserNm) {
		this.contactUserNm = contactUserNm;
	}
   
}
