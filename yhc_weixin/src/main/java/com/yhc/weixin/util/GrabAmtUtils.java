package com.yhc.weixin.util;

public class GrabAmtUtils {
	
	private static String[] GRAB_FOR_ME = {"10","8","15","18","6"};
	
	private static String[] FIRST_GRAB_FOR_FRIEND = {"1","3","6","8","9"};
	
	private static String[] NOT_FIRST_GRAB_FOR_FRIEND = {"1","3","6","8","9","-1","-5","-6"};

	
	public static String getRandomAmtForMe() {
		String rtn = "";
		double randomNumber = Math.random();
		if(randomNumber>=0 && randomNumber<=0.30){
			rtn = GRAB_FOR_ME[0];
		}else if(randomNumber>0.30 && randomNumber<=0.60){
			rtn = GRAB_FOR_ME[1];
		}else if(randomNumber>0.60 && randomNumber<=0.80){
			rtn = GRAB_FOR_ME[2];
		}else if(randomNumber>0.80 && randomNumber<=0.90){
			rtn = GRAB_FOR_ME[3];
		}else if(randomNumber>0.90 && randomNumber<=1.00){
			rtn = GRAB_FOR_ME[4];
		}else{
			rtn = String.valueOf(randomNumber);
		}
		return rtn;
	}
	public static String getRandomAmtForFriend(String firstFlag) {
		String rtn = "";
		double randomNumber = Math.random();
		if("Y".equals(firstFlag)){
			if(randomNumber>=0 && randomNumber<=0.40){
				rtn = FIRST_GRAB_FOR_FRIEND[0];
			}else if(randomNumber>0.40 && randomNumber<=0.65){
				rtn = FIRST_GRAB_FOR_FRIEND[1];
			}else if(randomNumber>0.65 && randomNumber<=0.80){
				rtn = FIRST_GRAB_FOR_FRIEND[2];
			}else if(randomNumber>0.80 && randomNumber<=0.90){
				rtn = FIRST_GRAB_FOR_FRIEND[3];
			}else if(randomNumber>0.90 && randomNumber<=1.00){
				rtn = FIRST_GRAB_FOR_FRIEND[4];
			}
		}else{
			if(randomNumber>=0 && randomNumber<=0.50){
				rtn = NOT_FIRST_GRAB_FOR_FRIEND[0];
			}else if(randomNumber>0.50 && randomNumber<=0.72){
				rtn = NOT_FIRST_GRAB_FOR_FRIEND[1];
			}else if(randomNumber>0.72 && randomNumber<=0.82){
				rtn = NOT_FIRST_GRAB_FOR_FRIEND[2];
			}else if(randomNumber>0.82 && randomNumber<=0.87){
				rtn = NOT_FIRST_GRAB_FOR_FRIEND[3];
			}else if(randomNumber>0.87 && randomNumber<=0.92){
				rtn = NOT_FIRST_GRAB_FOR_FRIEND[4];
			}else if(randomNumber>0.92 && randomNumber<=0.97){
				rtn = NOT_FIRST_GRAB_FOR_FRIEND[5];
			}else if(randomNumber>0.97 && randomNumber<=0.99){
				rtn = NOT_FIRST_GRAB_FOR_FRIEND[6];
			}else if(randomNumber>0.99 && randomNumber<=1.00){
				rtn = NOT_FIRST_GRAB_FOR_FRIEND[7];
			}
		}
		return rtn;
	}
	
	public static void main(String[] args) {
		
		for (int i=0; i<100; i++) {
			System.out.println("===============>" + getRandomAmtForFriend("N"));
		}
	}
}
