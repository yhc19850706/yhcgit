package com.yhc.common.dao;

import java.util.List;

import com.yhc.common.model.CommonCd;

public abstract class CommonDao{
	public static String PREFIX = "com.yhc.common.";
	public abstract List<CommonCd> getAllCommonCode() throws Exception;
}
