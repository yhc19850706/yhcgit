package com.bl.web.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class RepayFormula {

	/**
	 * 计算 每月 月供
	 * @param oriAmt： 贷款本金
	 * @param rate：月利率
	 * @param cnt： 还款月数
	 *  每月月供额=〔贷款本金×月利率×(1＋月利率)＾还款月数〕/〔(1＋月利率)＾还款月数-1〕
	 */
	public static BigDecimal getMonthTotalPay(BigDecimal oriAmt, BigDecimal monthRate, int cnt) {
		BigDecimal rslt = new BigDecimal(0);
		double realRate = Math.pow(monthRate.add(new BigDecimal(1)).doubleValue(), cnt);
		rslt = oriAmt.multiply(monthRate).multiply(new BigDecimal(realRate)).divide(new BigDecimal(realRate).subtract(new BigDecimal(1)), 2, RoundingMode.HALF_UP);
		return rslt;
	}
	
	/**
	 * 计算 每月 月供
	 * @param oriAmt： 贷款本金
	 * @param rate：月利率
	 * @param cnt： 还款月数
	 *  每月月供额=〔贷款本金×月利率×(1＋月利率)＾还款月数〕/〔(1＋月利率)＾还款月数-1〕
	 */
	public static BigDecimal getMonthTotalPay(BigDecimal oriAmt, BigDecimal monthRate, int cnt, int seq) {
		BigDecimal rslt = new BigDecimal(0);
		double realRate = Math.pow(monthRate.add(new BigDecimal(1)).doubleValue(), cnt);
		rslt = oriAmt.multiply(monthRate).multiply(new BigDecimal(realRate)).divide(new BigDecimal(realRate).subtract(new BigDecimal(1)), 2, RoundingMode.HALF_UP);
//		if(cnt == seq){
//			rslt = rslt.subtract(getWucha(oriAmt, monthRate, cnt));
//		}
		return rslt;
	}
	
	/**
	 * 计算 每月 应还 本金
	 * @param oriAmt： 贷款本金
	 * @param rate：月利率
	 * @param cnt： 还款月数
	 * @param seq: 还款月序号
	 * 每月应还本金=贷款本金×月利率×(1+月利率)^(还款月序号-1) ／〔(1+月利率)^还款月数-1〕
	 */
	public static BigDecimal getMonthlyOrigin(BigDecimal oriAmt, BigDecimal monthRate, int cnt, int seq){
		BigDecimal rslt = new BigDecimal(0);
		
		double realRate = Math.pow(monthRate.add(new BigDecimal(1)).doubleValue(), cnt);
		double payRate = Math.pow(monthRate.add(new BigDecimal(1)).doubleValue(), (seq - 1 ));
		
		rslt = oriAmt.multiply(monthRate).multiply(new BigDecimal(payRate)).divide(new BigDecimal(realRate).subtract(new BigDecimal(1)), 2, RoundingMode.HALF_UP);
		return rslt;
	}
	
	/**
	 * 计算 每月 应还 利息
	 * @param oriAmt： 贷款本金
	 * @param rate：月利率
	 * @param cnt： 还款月数
	 * @param seq: 还款月序号
	 * 每月应还利息=贷款本金×月利率×〔(1+月利率)^还款月数-(1+月利率)^(还款月序号-1)〕/〔(1+月利率)^还款月数-1〕
	 */
	public static BigDecimal getMonthlyInterest(BigDecimal oriAmt, BigDecimal monthRate, int cnt, int seq){
//		
//		double realRate = Math.pow(monthRate.add(new BigDecimal(1)).doubleValue(), cnt);
//		double payRate = Math.pow(monthRate.add(new BigDecimal(1)).doubleValue(), (seq - 1 ));;
//		return oriAmt.multiply(monthRate).multiply(new BigDecimal(realRate-payRate)).divide(new BigDecimal(realRate).subtract(new BigDecimal(1)), 2, RoundingMode.HALF_UP);
		
		BigDecimal montylyTotalPay = getMonthTotalPay(oriAmt, monthRate, cnt);
		BigDecimal monthlyOrigin = getMonthlyOrigin(oriAmt, monthRate, cnt, seq);
		return montylyTotalPay.subtract(monthlyOrigin);
	}
	
	/**
	 * 计算 月利率
	 * @param yearRate： 年利率
	 */
	public static BigDecimal calcMonthlyRate(BigDecimal yearRate){
		return yearRate.divide(new BigDecimal(1200), 8, RoundingMode.UP);
//		double mRt=Math.pow(yearRate.divide(new BigDecimal(100),4,RoundingMode.HALF_UP).add(new BigDecimal(1)).doubleValue(),(new BigDecimal(1).divide(new BigDecimal(12),4,RoundingMode.HALF_UP)).doubleValue());
//		mRt = mRt - 1;
//		return new BigDecimal(mRt);
	}
	
	/**
	 * 计算 误差
	 * @param oriAmt： 贷款本金
	 * @param rate：月利率
	 * @param cnt： 还款月数
	 * @return
	 */
	public static BigDecimal getWucha(BigDecimal oriAmt, BigDecimal monthRate, int cnt){
		BigDecimal sumOriAmt = new BigDecimal(Double.valueOf(0));
		for(int i = 0; i < cnt; i++){
			BigDecimal tmp =getMonthlyOrigin(oriAmt, monthRate, cnt, i+1);
			sumOriAmt = sumOriAmt.add(tmp);
		}
		return sumOriAmt.subtract(oriAmt);
	}
	
	/**
	 * 
	 * @param apprAmt
	 * @param lnlvl
	 * @return
	 */
	public static BigDecimal getLoanServiceAmt(BigDecimal apprAmt,String lnlvl) {
		BigDecimal loanServiceAmt = new BigDecimal(0);
        if("A".equals(lnlvl)) {
        	loanServiceAmt = apprAmt.multiply(new BigDecimal(0.01));
		}
        else  if("B".equals(lnlvl)) {
        	loanServiceAmt = apprAmt.multiply(new BigDecimal(0.015));
		}
        else  if("C".equals(lnlvl)) {
        	loanServiceAmt = apprAmt.multiply(new BigDecimal(0.02));
		}
        else  if("D".equals(lnlvl)) {
        	loanServiceAmt = apprAmt.multiply(new BigDecimal(0.025));
		}else {
			loanServiceAmt = apprAmt.multiply(new BigDecimal(0.03));
		}
        return loanServiceAmt;
	}
	
	public static BigDecimal getOnethPayAmt(BigDecimal oriAmt, BigDecimal monthRate, int cnt) {
		BigDecimal rslt = new BigDecimal(0);
		BigDecimal interestAmt = oriAmt.multiply(monthRate).multiply(new BigDecimal(cnt));
		rslt = oriAmt.add(interestAmt);
		return rslt;
	}

	public static void main(String[] args) {
		double yearRate = 20;
		int oriAmt = 100000;
		int cnt = 12;
		int seq = 0;
		
		
		BigDecimal monthlyRate = calcMonthlyRate(new BigDecimal(yearRate));
		System.out.println("月利率 ： " + monthlyRate);
		DecimalFormat df = new DecimalFormat("0.00");
		
		System.out.println(df.format(getOnethPayAmt(new BigDecimal(oriAmt), monthlyRate, 12).doubleValue()));
		
		/*
		BigDecimal wucha = getWucha(new BigDecimal(oriAmt), monthlyRate, cnt);
		System.out.println("误差 ： " + getWucha(new BigDecimal(oriAmt), monthlyRate, cnt));
//		monthlyRate = new BigDecimal(0.00834);
		for(int i = 0;i < cnt;i++){
			seq = i + 1;
			BigDecimal mtp = getMonthTotalPay(new BigDecimal(oriAmt), monthlyRate, cnt, seq);
			BigDecimal mo = getMonthlyOrigin(new BigDecimal(oriAmt), monthlyRate, cnt, seq);
			BigDecimal mi = getMonthlyInterest(new BigDecimal(oriAmt), monthlyRate, cnt, seq);
			if(cnt == seq){
				mtp = mtp.subtract(wucha);
				mo = mo.subtract(wucha);
			}
			System.out.print("月还本息 ： " + mtp );
			System.out.print("   月还本金 ： " + mo );
			System.out.println("   月还利息 ： " + mi);
			
//			System.out.println(mtp);
//			System.out.println(mo);
//			System.out.println(mi);
		}
		*/
		
		
	}

}
