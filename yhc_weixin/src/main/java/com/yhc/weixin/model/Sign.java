package com.yhc.weixin.model;

public class Sign extends BaseResult{
	
	private String totalPoint;
	
	private String point ="1";
	
	private String conDays;
	
	private String rank;

	public String getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(String totalPoint) {
		this.totalPoint = totalPoint;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getConDays() {
		return conDays;
	}

	public void setConDays(String conDays) {
		this.conDays = conDays;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
}
