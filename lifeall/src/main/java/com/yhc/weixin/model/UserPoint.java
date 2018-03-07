package com.yhc.weixin.model;


public class UserPoint extends PointRule {
	private int pointId;
	private String userId;
	private int pointVal;
	private String createId;
	private String createDts;
	private String updateId;
	private String updateStr;

	public int getPointId() {
		return pointId;
	}

	public void setPointId(int pointId) {
		this.pointId = pointId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPointVal() {
		return pointVal;
	}

	public void setPointVal(int pointVal) {
		this.pointVal = pointVal;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getCreateDts() {
		return createDts;
	}

	public void setCreateDts(String createDts) {
		this.createDts = createDts;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getUpdateStr() {
		return updateStr;
	}

	public void setUpdateStr(String updateStr) {
		this.updateStr = updateStr;
	}

}
