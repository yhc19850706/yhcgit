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
    public static final String SALT = getPropertyConfig().getString("password.salt");
    
    public static final String REDIS_VIP= getPropertyConfig().getString("redis_vip");
    public static final String REDIS_TARGETNAMES= getPropertyConfig().getString("targetNames");
    public static final String REDIS_METHODNAMES= getPropertyConfig().getString("methodNames");
    public static final String REDIS_RECORD_MANAGER= getPropertyConfig().getString("com.service.impl.xxxRecordManager");
    public static final String REDIS_SET_RECORD_MANAGER= getPropertyConfig().getString("com.service.impl.xxxSetRecordManager");
    public static final String REDIS_DEFAULT_CACHE_EXPIRETIME= getPropertyConfig().getString("defaultCacheExpireTime");
    public static final String REDIS_LOCAL_CACHE_CAPACITY= getPropertyConfig().getString("fep.local.cache.capacity");
}
