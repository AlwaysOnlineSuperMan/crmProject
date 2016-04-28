package com.crm.proxy;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	public void beforeInvoke(JoinPoint jp){
		String method =  jp.getSignature().getName();
		System.out.println(new Date(System.currentTimeMillis())+"��ʼ������"+method);
	}
	public void afterInvoke(JoinPoint jp){
		String method =  jp.getSignature().getName();
		System.out.println(new Date(System.currentTimeMillis())+"����������"+method);
	}
	public void aroundInvork(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("������");
		pjp.proceed();
		System.out.println("������");
	}
	
}
