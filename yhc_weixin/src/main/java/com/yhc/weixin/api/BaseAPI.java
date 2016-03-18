package com.yhc.weixin.api;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.yhc.common.utils.HttpClientUtils;


public abstract class BaseAPI {
	protected static final String BASE_URI = "https://api.weixin.qq.com";
	protected static final String MEDIA_URI = "http://file.api.weixin.qq.com";
	protected static final String QRCODE_DOWNLOAD_URI = "https://mp.weixin.qq.com";
	protected static final String OAUTH_URI = "https://open.weixin.qq.com/connect/oauth2";
	
	CloseableHttpClient httpClient = HttpClientUtils.acceptsUntrustedCertsHttpClient();
    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
	
}
