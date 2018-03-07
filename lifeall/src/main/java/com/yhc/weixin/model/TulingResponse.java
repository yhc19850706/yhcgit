package com.yhc.weixin.model;

import org.apache.commons.lang.StringUtils;

import java.util.List;

public class TulingResponse {

	private String code;
	private String text;
	private String url;
	private String textUrl;
	private List<TulingList> list;
	private List<TulingFunction> functions;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTextUrl() {
		if(StringUtils.isNotBlank(text)&& StringUtils.isNotBlank(url)){
			textUrl="<a href='"+getUrl()+"'>"+getText()+"</a>";
		}
		return textUrl;
	} 
	public List<TulingList> getList() {
		return list;
	}
	public void setList(List<TulingList> list) {
		this.list = list;
	}
	public List<TulingFunction> getFunctions() {
		return functions;
	}
	public void setFunctions(List<TulingFunction> functions) {
		this.functions = functions;
	}
	
	
}
