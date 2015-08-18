package com.bl.web.common.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

public class JdbcSeachData {



	protected static ApplicationContext ctx = null;
	protected static SqlMapClientTemplate sqlMapClientTemplate=null;
	
	public static void main(String[] args) throws Exception{
		
		ctx  = new ClassPathXmlApplicationContext("applicationContext-datasource.xml");
		JdbcTemplate jt = (JdbcTemplate)ctx.getBean("jdbcTemplate");
        String monthStr="201508";
        String endDayStr="2015081624";
        String fpdate="";
        String mobileNo="";
		StringBuffer sqlBuffer=new StringBuffer();
		
//		 System.out.println(sqlBuffer.toString());
		File testFile = new File("userinfo2.txt");
        List<String> lines = Files.readLines(testFile, Charsets.UTF_8);
        File csvFile = new File("D:\\work\\dxyj\\20150802\\week_20150817_02.csv");
        if(csvFile.isFile()){
        	csvFile.delete();
        }
        csvFile.createNewFile();
        BufferedWriter csvFileOutputStream = null;
        
        csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(csvFile), "GB2312"), 1024);
        for (String line : lines) {
        	 String empLine = CharMatcher.WHITESPACE.collapseFrom(line,' ');
        	 Iterable<String> values = Splitter.on(' ').split(empLine);
        	 List<String> vs = Lists.newArrayList(values);
        	 mobileNo=(String) vs.toArray()[1];
        	 fpdate=(String) vs.toArray()[4];
        	sqlBuffer.append("select a.user_id as userId, a.mobile_no as mobileNo,");
     		sqlBuffer.append(" (select user_real_nm from tb_user_base_info where user_id = a.user_id) as userRealNm,");
     		sqlBuffer.append(" (select ifnull(sum(j.origin_amt),0)  from tb_credit j, tb_loan k");
     		sqlBuffer.append(" where j.user_id =  a.user_id and j.loan_id=k.loan_id and j.credit_status = 'CREDST02' and j.from_credit_id is null");
     		sqlBuffer.append(" and j.create_dts >'"+fpdate+"'");
     		sqlBuffer.append(" and j.create_dts >'"+monthStr+"'");
     		sqlBuffer.append(" and j.create_dts <='"+endDayStr+"'");
     		sqlBuffer.append(" and k.quota_yn ='N') as totalAmt,");
     		sqlBuffer.append(" (select IFNULL(SUM(CASE WHEN k.loan_period_days>0 AND k.loan_period_days <= 365 THEN ROUND(j.origin_amt/365 * k.loan_period_days,2)");
     		sqlBuffer.append(" WHEN k.loan_period_days>365 THEN j.origin_amt");
     		sqlBuffer.append(" WHEN k.loan_period_days=0 AND l.appr_period<=12 THEN ROUND(j.origin_amt/12 * l.appr_period,2)");
     		sqlBuffer.append(" WHEN k.loan_period_days=0 AND l.appr_period>12 THEN j.origin_amt ELSE 0.00 END),0)");
     		sqlBuffer.append(" from tb_credit j, tb_loan k, tb_final_approve l");
     		sqlBuffer.append(" where j.user_id =  a.user_id  and j.loan_id = k.loan_id and j.loan_id = l.loan_id and k.quota_yn ='N'");
     		sqlBuffer.append(" and l.appr_rslt = 'APPRRSLT01'  and j.credit_status = 'CREDST02' and j.from_credit_id is null");
     		sqlBuffer.append(" and j.create_dts >'"+fpdate+"'");
     		sqlBuffer.append(" and j.create_dts >'"+monthStr+"'");
     		sqlBuffer.append(" and j.create_dts <='"+endDayStr+"'");
     		sqlBuffer.append(" ) as yearlyAmt,");
     		sqlBuffer.append(" (select ifnull(sum(j.origin_amt),0) from tb_credit j, tb_loan k");
     		sqlBuffer.append(" where j.user_id =  a.user_id  and j.loan_id=k.loan_id and j.credit_status = 'CREDST02' and j.from_credit_id is null");
     		sqlBuffer.append(" and j.create_dts >'"+fpdate+"'");
     		sqlBuffer.append(" and j.create_dts >'"+monthStr+"'");
     		sqlBuffer.append(" and j.create_dts <='"+endDayStr+"'");
     		sqlBuffer.append(" and k.quota_yn ='Y') as totalAmt_19,");
     		sqlBuffer.append(" (select IFNULL(SUM(CASE WHEN k.loan_period_days>0 AND k.loan_period_days <= 365 THEN ROUND(j.origin_amt/365 * k.loan_period_days,2)");
     		sqlBuffer.append(" WHEN k.loan_period_days>365 THEN j.origin_amt");
     		sqlBuffer.append(" WHEN k.loan_period_days=0 AND l.appr_period<=12 THEN ROUND(j.origin_amt/12 * l.appr_period,2)");
     		sqlBuffer.append(" WHEN k.loan_period_days=0 AND l.appr_period>12 THEN j.origin_amt ELSE 0.00 END),0)");
     		sqlBuffer.append(" from tb_credit j, tb_loan k, tb_final_approve l");
     		sqlBuffer.append(" where j.user_id =  a.user_id  and j.loan_id = k.loan_id and j.loan_id = l.loan_id and k.quota_yn ='Y'");
     		sqlBuffer.append(" and l.appr_rslt = 'APPRRSLT01'  and j.credit_status = 'CREDST02' and j.from_credit_id is null");
     		sqlBuffer.append(" and j.create_dts >'"+fpdate+"'");
     		sqlBuffer.append(" and j.create_dts >'"+monthStr+"'");
     		sqlBuffer.append(" and j.create_dts <='"+endDayStr+"'");
     		sqlBuffer.append(" ) as yearlyAmt_19");
     		sqlBuffer.append(" From tb_user a");
     		sqlBuffer.append(" where mobile_no ='"+mobileNo+"'");
//     		System.out.println(sqlBuffer.toString());
     		
//     		System.out.println("-----"+sqlBuffer.toString());
        	 List<Map<String, Object>> result =jt.queryForList(sqlBuffer.toString());
        	 csvFileOutputStream.write(vs.toArray()[0]+",");
         	 csvFileOutputStream.write(vs.toArray()[1]+",");
         	 csvFileOutputStream.write(vs.toArray()[2]+",");
         	 csvFileOutputStream.write(vs.toArray()[3]+",");
         	 csvFileOutputStream.write(vs.toArray()[4]+",");
         	//csvFileOutputStream.write(vs.toArray()[5]+",");
        	 if(result.size()>0){
        		 for(Map<String, Object> one:result){
          			String originAmt=String.valueOf(one.get("totalAmt"));
          			String yeartradeamt = String.valueOf(one.get("yearlyAmt"));
          			String bigOriginAmt=String.valueOf(one.get("totalAmt_19"));
          			String bigYeartradeamt = String.valueOf(one.get("yearlyAmt_19"));
          			String userId=String.valueOf(one.get("userId"));
          			 
                 	 csvFileOutputStream.write(originAmt+",");
                 	 csvFileOutputStream.write(yeartradeamt+",");
                 	csvFileOutputStream.write(bigOriginAmt+",");
                	 csvFileOutputStream.write(bigYeartradeamt+",");
                 	 csvFileOutputStream.write(userId);
                 	 csvFileOutputStream.newLine();
          		}
        	 }else{
       	
              	 csvFileOutputStream.write("0,");
              	 csvFileOutputStream.write("0,");
              	 csvFileOutputStream.write("0");
              	 csvFileOutputStream.newLine();
        	 }
        	 sqlBuffer.delete(0, sqlBuffer.length());
        }
        csvFileOutputStream.close();
        System.out.println("完成！");
	}

}
