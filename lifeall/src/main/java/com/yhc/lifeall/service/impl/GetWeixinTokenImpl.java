package com.yhc.lifeall.service.impl;

import com.google.common.collect.Maps;
import com.yhc.lifeall.service.GetWeixinToken;
import com.yhc.lifeall.system.redis.RedisUtil;
import com.yhc.weixin.api.TokenAPI;
import com.yhc.weixin.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class GetWeixinTokenImpl implements GetWeixinToken {
    @Value("${weixin.Token}")
    private String token;
    @Value("${weixin.EncodingAESKey}")
    private String encodingAESKey;
    @Value("${weixin.appid}")
    private String appid;
    @Value("${weixin.appsecret}")
    private String appSecret;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Token getToken() {
        Map<String,String> wxtokenMap= Maps.newHashMap();
        Token token=null;
        wxtokenMap=redisUtil.hmget("myweixin");
        if(wxtokenMap==null||wxtokenMap.size()==0||!wxtokenMap.containsKey("access_token")){
            TokenAPI tokenAPI=new TokenAPI();
            token=tokenAPI.token(appid,appSecret);
            wxtokenMap.put("access_token",token.getAccess_token());
            redisUtil.hmset("myweixin",wxtokenMap);
            redisUtil.setExpire("myweixin",1, TimeUnit.HOURS);
            return token;
        }
        token=new Token();
        token.setAccess_token(wxtokenMap.get("access_token"));
        return token;
    }
}
