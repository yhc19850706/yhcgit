/**   
 * SecurityAspect.java 
 * com.common.aop 
 * @Description:
 * @author Yhc yinhc@yinhu.com
 * 2015年10月27日 下午5:18:11 
 * @version V1.0   
 */

package com.yhc.common.aop;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.yhc.common.action.BaseAction;
import com.yhc.common.annotation.IfNeedSecurity;
import com.yhc.common.exception.TokenException;
import com.yhc.web.token.service.TokenManager;
/**
 * @Project：AngularJs
 * @Package：com.common.aop
 * @ClassName: SecurityAspect
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yhc yinhc@yinhu.com
 * @date 2015年10月27日 下午5:18:11
 */
public class SecurityAspect {

	private static final String	DEFAULT_TOKEN_NAME	= "X-Token";
    @Resource
	private TokenManager		tokenManager;
	private String				tokenName;

	public void setTokenManager(TokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}

	public void setTokenName(String tokenName) {
		if (StringUtils.isEmpty(tokenName)) {
			tokenName = DEFAULT_TOKEN_NAME;
		}
		this.tokenName = tokenName;
	}

	public Object execute(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("AOP begining");
		// 从切点上获取目标方法
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		Method method = methodSignature.getMethod();
		// 若目标方法忽略了安全性检查，则直接调用目标方法
		if (!method.isAnnotationPresent(IfNeedSecurity.class)) {
			System.out.println("AOP ending");
			return pjp.proceed();
		}
		// 从 request header 中获取当前 token
		String token =""; //BaseAction.getRequest().getHeader(tokenName);
		// 检查 token 有效性
		if (!tokenManager.checkToken(token)) {
			String message = String.format("token [%s] is invalid", token);
			throw new TokenException(message);
		}
		System.out.println("AOP ending");
		// 调用目标方法
		return pjp.proceed();
	}
}
