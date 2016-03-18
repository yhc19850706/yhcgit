package com.yhc.common.config;

public class BlGlobalVariable extends GlobalVariable{
	
	public static final String MAIL_SERVER_HOST = getPropertyConfig().getString( "mail.server.host" );
	public static final String MAIL_SERVER_PORT = getPropertyConfig().getString( "mail.server.port" );
	public static final String MAIL_SERVER_USERNAME = getPropertyConfig().getString( "mail.server.username" );
	public static final String MAIL_SERVER_PASSWORD = getPropertyConfig().getString( "mail.server.password" );
	
	public static final String SITE_URL = getPropertyConfig().getString( "site.url" );
	public static final String SITE_DOMAIN = getPropertyConfig().getString( "site.domain" );
	public static final String IMG_SITE_URL = getPropertyConfig().getString( "img.site.url" );
	public static final String DOWNLOAD_SITE_URL = getPropertyConfig().getString( "download.site.url" );
	public static final String YHC_URI = getPropertyConfig().getString("yhc.uri");
    public static final String WEIXIN_TOKEN = getPropertyConfig().getString("weixin.token");
	
	public static final String WEIXIN_APPID = getPropertyConfig().getString("weixin.appid");
	
	public static final String WEIXIN_SECRET = getPropertyConfig().getString("weixin.secret");
}
