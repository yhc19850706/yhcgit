package com.bl.web.common.templatemethod;

import java.util.List;
import com.bl.web.common.utils.CnUpperCaseUtils;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

public class UpCnStr implements TemplateMethodModel{

	@Override
	public Object exec(List arg0) throws TemplateModelException {
		String inputStr = (String)arg0.get(0);
		String outStr = CnUpperCaseUtils.changeToBig(inputStr);
		return outStr;
	}
}
