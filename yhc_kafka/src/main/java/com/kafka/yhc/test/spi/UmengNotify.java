package com.kafka.yhc.test.spi;


public class UmengNotify implements AppNotify{
	
	private final static String IOS_APPKEY = "54b5e0cbfd98c5287b001045";
	
	private final static String IOS_APPSECRET = "h9guc4eqvzonhspoazti34u7cer9v6nt";
	
	private final static String ANDROID_APPKEY = "54b5e15cfd98c559db000dc0";
	
	private final static String ANDROID_APPSECRET = "kfbmsqoq4fydac89jwvrbotj2xxin8ia";
	
//	private final static boolean IS_REAL_MODE = "real".equals(BlGlobalVariable.NOTIFY_MODE)?true:false;

	@Override
	public void notify(String message) throws Exception {
		System.out.println("UmengNotify==10==="+message);
	}
	

}
