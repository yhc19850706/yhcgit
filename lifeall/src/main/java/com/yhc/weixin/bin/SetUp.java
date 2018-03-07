package com.yhc.weixin.bin;

import com.google.common.collect.Lists;
import com.yhc.weixin.api.MenuAPI;
import com.yhc.weixin.api.TokenAPI;
import com.yhc.weixin.model.BaseResult;
import com.yhc.weixin.model.MenuButtons;
import com.yhc.weixin.model.MenuButtons.Button;
import com.yhc.weixin.model.Token;

import java.util.List;

public class SetUp {
	
	private static String ACCESS_TOKEN = "";
	
	private static final String WEIXIN_APPID ="wxddb82e235d1c9a23"; //测试手机
	
	private static final String WEIXIN_SECRET = "d4624c36b6795d1d99dcf0547af5443d";
	
	private static TokenAPI token_api = new TokenAPI();
	
	static {
		if(ACCESS_TOKEN.equals("")){
			Token token = token_api.token(WEIXIN_APPID, WEIXIN_SECRET);
			ACCESS_TOKEN = token.getAccess_token();
			System.out.println(ACCESS_TOKEN);
		}
	}
	
	public static void setUpMenu(){
		//设置一级菜单
		/**个人中心菜单 每日签到，收益查询，标的预告，人工咨询，常见问题*/
		Button personalButton = new Button();
		personalButton.setName("门店中心");
		List<Button> personalSubButton = Lists.newArrayList();
		Button signButton = new Button();
		signButton.setType("click");
		signButton.setName("窗帘种类");
		signButton.setKey("curtain");
		Button incomeButton = new Button();
		incomeButton.setType("click");
		incomeButton.setName("产品预览");
		incomeButton.setKey("preview");
		Button accountButton = new Button();//拍照
		accountButton.setType("pic_photo_or_album");
		accountButton.setName("拍照");
		accountButton.setKey("photo");
		Button siteButton = new Button();//访问网站
		siteButton.setType("view");
		siteButton.setName("访问网站");
		siteButton.setUrl("http://baidu.com");
		personalSubButton.add(signButton);
		personalSubButton.add(incomeButton);
		personalSubButton.add(accountButton);
		personalSubButton.add(siteButton);
		personalButton.setSub_button(personalSubButton);
		
 
		Button dynamicButton = new Button();
		dynamicButton.setName("门店动态");
		List<Button> dynamicSubButton = Lists.newArrayList();
		Button itemButton = new Button();
		itemButton.setType("click");
		itemButton.setName("新产品公告");
		itemButton.setKey("notice");
		Button mediaButton = new Button();
		mediaButton.setType("view");
		mediaButton.setName("客户案例");
		mediaButton.setUrl("http://baidu.com");
		Button noticeButton = new Button();
		noticeButton.setType("click");
		noticeButton.setName("门店公告");
		noticeButton.setKey("announcement");
		dynamicSubButton.add(itemButton);
		dynamicSubButton.add(mediaButton);
		dynamicSubButton.add(noticeButton);
		dynamicButton.setSub_button(dynamicSubButton);
		
		
		Button[] buttons = {personalButton,dynamicButton};
		MenuButtons mbs = new MenuButtons();
		mbs.setButton(buttons);
		
		MenuAPI menuApi = new MenuAPI();
		BaseResult result = menuApi.menuCreate(ACCESS_TOKEN, mbs);
		System.out.println("errorCode:"+result.getErrcode());
		System.out.println("errMsg:"+result.getErrmsg());
		if(result.getErrcode().equals("0")){
			System.out.println("设置成功");
		}
	}
	

	public static void main(String[] args) {
		//System.out.println(ACCESS_TOKEN);
		setUpMenu();
		//setUpGroup();
	}

}
