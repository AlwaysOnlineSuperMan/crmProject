package com.crm.proxy;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	public void beforeInvoke(JoinPoint jp){
		String method =  jp.getSignature().getName();
		System.out.println(new Date(System.currentTimeMillis())+"开始调用了"+method);
	}
	public void afterInvoke(JoinPoint jp){
		String method =  jp.getSignature().getName();
		System.out.println(new Date(System.currentTimeMillis())+"结束调用了"+method);
	}
	public void aroundInvork(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("事务开启");
		pjp.proceed();
		System.out.println("事务开启");
	}
	
}
