package com.yhc.weixin.model;

public class PointRule {
	protected int ruleId;
	protected String pointType;
	protected String duplicateYn;
	protected int rulePointVal;

	public int getRuleId() {
		return ruleId;
	}

	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}

	public String getPointType() {
		return pointType;
	}

	public void setPointType(String pointType) {
		this.pointType = pointType;
	}

	public String getDuplicateYn() {
		return duplicateYn;
	}

	public void setDuplicateYn(String duplicateYn) {
		this.duplicateYn = duplicateYn;
	}

	public int getRulePointVal() {
		return rulePointVal;
	}

	public void setRulePointVal(int rulePointVal) {
		this.rulePointVal = rulePointVal;
	}

}
