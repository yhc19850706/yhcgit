package com.yhc.common.model;

import java.util.Date;

public class Meta {

	private boolean success;
	private String message;

	private Date nowTime;
	public Date getNowTime() {
		return nowTime;
	}

	public Meta(boolean success) {
		this.success = success;
	}

	public Meta(boolean success, String message) {
		this.success = success;
		this.message = null;
		this.nowTime=new Date();
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}
}
