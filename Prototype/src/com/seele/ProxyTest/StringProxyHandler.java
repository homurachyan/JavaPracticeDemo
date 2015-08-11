package com.seele.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StringProxyHandler implements InvocationHandler {
	//private Object targetobj; //被代理的实例
	
	public StringProxyHandler(){

    }
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		//Object result = ;
		System.out.println("lalala");
		IAdvice a = new BeforeAdvice();
		return method.invoke(a, args);
	}

}
