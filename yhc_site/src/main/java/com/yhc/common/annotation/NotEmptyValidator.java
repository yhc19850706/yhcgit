/**   
 * NotEmptyValidator.java 
 * com.common.annotation 
 * @Description:
 * @author Yhc yinhc@yinhu.com
 * 2015年10月27日 下午4:35:49 
 * @version V1.0   
 */

package com.yhc.common.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;

public class NotEmptyValidator implements ConstraintValidator<NotEmpty, String> {

	@Override
	public void initialize(NotEmpty constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return StringUtils.isNotEmpty(value);
	}
}
