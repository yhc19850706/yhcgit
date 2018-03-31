package com.yhc.weixin.response;

/**
 * 空白回复
 * 
 * @className BlankResponse
 * @author jinyu(foxinmy@gmail.com)
 * @date 2015年5月7日
 * @since JDK 1.6
 * @see
 */
public class BlankResponse extends SingleResponse {

	public static final BlankResponse global = new BlankResponse();

	private BlankResponse() {
		super("success");
	}
}
