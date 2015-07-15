package com.bl.web.common.templatemethod;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bl.web.common.utils.MaskUtils;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

public class MaskStr implements TemplateMethodModel {

	@Override
	public Object exec(List arg0) throws TemplateModelException {
		String inputStr = (String)arg0.get(0);
		String outStr = MaskUtils.maskStr(inputStr, "-");
		return outStr;
	}

	public String mask(String inputStr){
		StringBuffer maskStr = new StringBuffer();
		if(StringUtils.isNotEmpty(inputStr)){
			for(int i=0;i<inputStr.length();i++){
			
				maskStr.append("*");
			}
		}
		
		return maskStr.toString();
	}
}
