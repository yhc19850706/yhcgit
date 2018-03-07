package com.yhc.lifeall.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "weixin")
@PropertySource("classpath:config/weixin.properties")
@Component
public class WeixinConfig {
    private String TOKEN_KEY;
    private String WEIXIN_SECRET;
    private String WEIXIN_APPID;

    public String getTOKEN_KEY() {
        return TOKEN_KEY;
    }

    public void setTOKEN_KEY(String TOKEN_KEY) {
        this.TOKEN_KEY = TOKEN_KEY;
    }

    public String getWEIXIN_SECRET() {
        return WEIXIN_SECRET;
    }

    public void setWEIXIN_SECRET(String WEIXIN_SECRET) {
        this.WEIXIN_SECRET = WEIXIN_SECRET;
    }

    public String getWEIXIN_APPID() {
        return WEIXIN_APPID;
    }

    public void setWEIXIN_APPID(String WEIXIN_APPID) {
        this.WEIXIN_APPID = WEIXIN_APPID;
    }
}
