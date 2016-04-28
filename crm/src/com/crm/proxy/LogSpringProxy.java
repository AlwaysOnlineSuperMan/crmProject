package com.crm.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogSpringProxy implements MethodInterceptor {

	public Object invoke(MethodInvocation method) throws Throwable {
			Object obj = null;
			System.out.println("在执行"+method.getMethod().getName()+"方法");
			obj = method.proceed();
			System.out.println("执行"+method.getMethod().getName()+"已结束");
		return obj;
	}

}
