package com.crm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MessageProxyJDK implements InvocationHandler {
	private Object targetObject;
	public static Object newInstance(Object obj){
		MessageProxyJDK proxy = new MessageProxyJDK();
		proxy.targetObject =obj;
		Class clazz = obj.getClass();
		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),proxy);
	}
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object obj = null;
		System.out.println("MessageProxyJDK代理开始。。。。");
		obj = method.invoke(targetObject, args);
		System.out.println("MessageProxyJDK代理结束。。。。");
		return obj;
	}

}
