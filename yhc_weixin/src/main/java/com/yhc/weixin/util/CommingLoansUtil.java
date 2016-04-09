package com.yhc.weixin.util;


import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.yhc.weixin.api.YinhuAPI;
import com.yhc.weixin.model.Loan;

public class CommingLoansUtil {

	private static final String LOAN_CACHE_KEY = "LOAN"; 
	
	private static Cache<String, List<Loan>> loansCache =CacheBuilder
			.newBuilder()
			.expireAfterWrite(1800, TimeUnit.SECONDS)
			.build();


	private static YinhuAPI yinhuAPI = new YinhuAPI();

	public static List<Loan> getCommingLoans(){
		try {
			return loansCache.get(LOAN_CACHE_KEY,new Callable<List<Loan>>() {
				@Override
				public List<Loan> call() throws Exception {
					List<Loan> loans = yinhuAPI.commingLoans();
					if(loans==null||loans.size()==0){
						return null;
					}
					return yinhuAPI.commingLoans();
				}
			});
		} catch (Exception e) {
			return null;
		}
	}
	
}
