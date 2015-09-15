package com.test.proxy.dynamicProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ConcreteClassInterceptor implements MethodInterceptor{
	public Object intercept(Object obj, Method method, Object[] arg, MethodProxy proxy) throws Throwable {
		System.out.println("Before:"+method);  
		Object object=proxy.invokeSuper(obj, arg);
		System.out.println("After:"+method); 
		return object;
	}
}
