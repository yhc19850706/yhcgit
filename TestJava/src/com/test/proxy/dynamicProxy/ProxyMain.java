package com.test.proxy.dynamicProxy;

import net.sf.cglib.proxy.Enhancer;

public class ProxyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(ConcreteClassNoInterface.class);
		enhancer.setCallback(new ConcreteClassInterceptor());
		ConcreteClassNoInterface ccni=(ConcreteClassNoInterface)enhancer.create();
		ccni.getConcreteMethodA("shensy");
		ccni.getConcreteMethodB(0);
	}

}
