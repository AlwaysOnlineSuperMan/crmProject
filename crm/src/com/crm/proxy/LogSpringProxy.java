package com.crm.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogSpringProxy implements MethodInterceptor {

	public Object invoke(MethodInvocation method) throws Throwable {
			Object obj = null;
			System.out.println("��ִ��"+method.getMethod().getName()+"����");
			obj = method.proceed();
			System.out.println("ִ��"+method.getMethod().getName()+"�ѽ���");
		return obj;
	}

}
