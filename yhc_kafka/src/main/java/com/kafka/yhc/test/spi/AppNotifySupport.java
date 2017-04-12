package com.kafka.yhc.test.spi;

public class AppNotifySupport {
	
	private static AppNotify appNotify = SPILoader.getSPILoader(AppNotify.class).getSPI("umeng");
	
	public static void send(String message){
		try {
			System.out.println(message+"--9--appNotify"+message);
			appNotify.notify(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendIosNotifyToUser(String userId,String content,String action){
		try {
			send("11111111111");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendAndroidNotifyToUser(String userId,String content,String action){
		try {
			appNotify.notify("2222222222");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendMessageToDevice(String deviceType,String notifyToken,String action){
		try {
			appNotify.notify("3333333333333");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		sendIosNotifyToUser("2108130b43d048c0b3df00d8b7053b2b","服务器发送的别名alias测试消息11","wodetouzi");
//		sendAndroidNotifyToUser("2108130b43d048c0b3df00d8b7053b2b","服务器发送的别名alias测试消息11","wodetouzi");
//		sendMessageToDevice("2108130b43d048c0b3df00d8b7053b2b","服务器发送的别名alias测试消息11","wodetouzi");
	}
	

}
