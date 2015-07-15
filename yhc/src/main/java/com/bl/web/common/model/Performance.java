package com.bl.web.common.model;

import java.math.BigDecimal;

public class Performance extends Emp {

	private int visitors;//访问客户数量
	private int registers;//注册客户数量
	private int bindings;//绑定客户数量
	private BigDecimal prepaidTotalAmt;
	private BigDecimal tradeTotalAmt;//客户总交易额
	private BigDecimal yearTradeAmt;//客户总年化交易额
	private BigDecimal monthTradeAmt;//客户本月年化交易额
	
	public int getVisitors() {
		return visitors;
	}
	public void setVisitors(int visitors) {
		this.visitors = visitors;
	}
	public int getRegisters() {
		return registers;
	}
	public void setRegisters(int registers) {
		this.registers = registers;
	}
	public int getBindings() {
		return bindings;
	}
	public void setBindings(int bindings) {
		this.bindings = bindings;
	}
	public BigDecimal getPrepaidTotalAmt() {
		return prepaidTotalAmt;
	}
	public void setPrepaidTotalAmt(BigDecimal prepaidTotalAmt) {
		this.prepaidTotalAmt = prepaidTotalAmt;
	}
	public BigDecimal getTradeTotalAmt() {
		return tradeTotalAmt;
	}
	public void setTradeTotalAmt(BigDecimal tradeTotalAmt) {
		this.tradeTotalAmt = tradeTotalAmt;
	}
	public BigDecimal getYearTradeAmt() {
		return yearTradeAmt;
	}
	public void setYearTradeAmt(BigDecimal yearTradeAmt) {
		this.yearTradeAmt = yearTradeAmt;
	}
	public BigDecimal getMonthTradeAmt() {
		return monthTradeAmt;
	}
	public void setMonthTradeAmt(BigDecimal monthTradeAmt) {
		this.monthTradeAmt = monthTradeAmt;
	}
	
	
	
}
