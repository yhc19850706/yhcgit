package com.bl.web.common.templatemethod;

import java.util.List;

import com.bl.web.common.utils.Constants;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

public class PhoneFormat implements TemplateMethodModel{

	@Override
	public Object exec(List arg0) throws TemplateModelException {
		String inputStr = (String)arg0.get(0);
		String outStr = formatPhoneNo(inputStr);
		return outStr;
	}
	
	public String formatPhoneNo(String phoneNo) {
		String returnPhoneNo = null;
		
		if(phoneNo.length()==11 || phoneNo.length()==12) {
			if(!"1".equals(phoneNo.substring(0,1))) {
				if(Constants.THREE_BGIN_LIST.contains(phoneNo.substring(0, 3))) {
					returnPhoneNo = phoneNo.substring(0,3)+"-"+phoneNo.substring(3,phoneNo.length());			
					} else {
						returnPhoneNo = phoneNo.substring(0,4)+"-"+phoneNo.substring(4,phoneNo.length());		
					}
			} else {
				StringBuffer sb = new StringBuffer();
				sb.append(phoneNo.subSequence(0, 3));
				sb.append("-");
				sb.append(phoneNo.subSequence(3, 7));
				sb.append("-");
				sb.append(phoneNo.subSequence(7, 11));
				returnPhoneNo = sb.toString();
			}
			
		} else {
			returnPhoneNo = phoneNo;
		}
		return returnPhoneNo;
	}
	
	public static void main(String[] args) {
		PhoneFormat a = new PhoneFormat();
		System.out.println(a.formatPhoneNo("13983593311"));
	}
	
}
