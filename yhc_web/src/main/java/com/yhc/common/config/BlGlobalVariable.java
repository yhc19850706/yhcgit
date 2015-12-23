package com.yhc.common.config;

public class BlGlobalVariable extends GlobalVariable{
	
	public static final String IMG_HEADFILE_TEMP_DIR = getPropertyConfig().getString("img.headFile.temp.dir");
	public static final String IMG_HEADFILE_REAL_DIR = getPropertyConfig().getString("img.headFile.real.dir");
	public static final String IMG_HEADFILE_WIDTH = getPropertyConfig().getString("img.headFile.width");
	public static final String IMG_HEADFILE_HEIGHT = getPropertyConfig().getString("img.headFile.height");
	public static final String IMG_HEADFILE_ALLOWSELECT = getPropertyConfig().getString("img.headFile.allowSelect");
	public static final String IMG_HEADFILE_ALLOWRESIZE = getPropertyConfig().getString("img.headFile.allowResize");
	public static final String IMG_QRCODE_STORE_DIR = getPropertyConfig().getString("img.qrcode.store.dir");
	public static final String IMG_QRCODE_EMP_DIR = getPropertyConfig().getString("img.qrcode.emp.dir");
	
	public static final String MAIL_SERVER_HOST = getPropertyConfig().getString( "mail.server.host" );
	public static final String MAIL_SERVER_PORT = getPropertyConfig().getString( "mail.server.port" );
	public static final String MAIL_SERVER_USERNAME = getPropertyConfig().getString( "mail.server.username" );
	public static final String MAIL_SERVER_PASSWORD = getPropertyConfig().getString( "mail.server.password" );
	
	public static final String SITE_URL = getPropertyConfig().getString( "site.url" );
	public static final String SITE_DOMAIN = getPropertyConfig().getString( "site.domain" );
	public static final String IMG_SITE_URL = getPropertyConfig().getString( "img.site.url" );
	public static final String DOWNLOAD_SITE_URL = getPropertyConfig().getString( "download.site.url" );
	
	public static final String PNR_URL = getPropertyConfig().getString( "pnr.url" );
	public static final int PNR_PORT = getPropertyConfig().getInt( "pnr.port" );
	public static final String PNR_PATH = getPropertyConfig().getString( "pnr.path" );
	public static final String PNR_MERCHANTNO = getPropertyConfig().getString( "pnr.merchantNo" );
	public static final String PNR_CLIENTNO = getPropertyConfig().getString( "pnr.clientNo" );
	public static final String PNR_CALLBACK_SITE_URL = getPropertyConfig().getString( "pnr.callback.site.url" );
	public static final String PNR_MERPRKEY = getPropertyConfig().getString( "pnr.merPrKey" );
	public static final String PNR_PRPUBKEY = getPropertyConfig().getString( "pnr.pgPubKey" );
	
	public static final String USER_VERIFY_TEMP_DIR = getPropertyConfig().getString("user.verify.temp.dir");
	public static final String USER_VERIFY_REAL_DIR = getPropertyConfig().getString("user.verify.real.dir");
	public static final String USER_VERIFY_BACKUP_DIR = getPropertyConfig().getString("user.verify.backup.dir");
	
	
	public static final String ISIGNATURE_YHWL_KEY = getPropertyConfig().getString("isignature.yhwl.key");
	public static final String ISIGNATURE_RXT_KEY = getPropertyConfig().getString("isignature.rxt.key");
	public static final String ISIGNATURE_ZHENGXUE_XIE_KEY = getPropertyConfig().getString("isignature.zhengxue.xie.key");
	public static final String ISIGNATURE_ZHENGXUE_YIN_KEY = getPropertyConfig().getString("isignature.zhengxue.yin.key");
	public static final String ISIGNATURE_YHWL_SIGN = getPropertyConfig().getString("isignature.yhwl.sign");
	public static final String ISIGNATURE_RXT_SIGN = getPropertyConfig().getString("isignature.rxt.sign");
	public static final String ISIGNATURE_ZHENGXUE_SIGN = getPropertyConfig().getString("isignature.zhengxue.sign");
	public static final String ISIGNATURE_UPLOAD_ZITI = getPropertyConfig().getString("isignature.upload.ziti");
	public static final String USER_CONTRACT_TEMP_DIR = getPropertyConfig().getString("user.contract.temp.dir");
	public static final String USER_CONTRACT_REAL_DIR = getPropertyConfig().getString("user.contract.real.dir");
	
	public static final int CS_QUE_CNT = 5;
	
	public static final String OFFLINE_CUSTID = getPropertyConfig().getString("offline.custId");
	public static final String OFFLINE_CUSTNM = getPropertyConfig().getString("offline.custNm");
	public static final String OFFLINE_USERID = getPropertyConfig().getString("offline.userId");
	
	public static final String CONTRACT_TEMPLATE_OFF2OFF = getPropertyConfig().getString("contract.template.off2off");
	public static final String CONTRACT_TEMPLATE_OFF2ON = getPropertyConfig().getString("contract.template.off2on");
	public static final String CONTRACT_TEMPLATE_YANHUA_XINYONG = getPropertyConfig().getString("contract.template.yanhua.xinyong");
	public static final String CONTRACT_TEMPLATE_YANHUA_DIYA = getPropertyConfig().getString("contract.template.yanhua.diya");
	public static final String CONTRACT_TEMPLATE_YANHUA_DANBAO = getPropertyConfig().getString("contract.template.yanhua.danbao");
	public static final String CONTRACT_TEMPLATE_YANHUA_TUIJIAN = getPropertyConfig().getString("contract.template.yanhua.tuijian");
	
	public static final String IMG_CONTRACT_TEMP_DIR = getPropertyConfig().getString("img.contract.temp.dir");
	public static final String IMG_CONTRACT_REAL_DIR = getPropertyConfig().getString("img.contract.real.dir");
	
	public static final String IMG_LOAN_TEMP_DIR = getPropertyConfig().getString("img.loan.temp.dir");
	public static final String IMG_LOAN_REAL_DIR = getPropertyConfig().getString("img.loan.real.dir");

	public static final String REDIS_VIP= getPropertyConfig().getString("redis_vip");
}
