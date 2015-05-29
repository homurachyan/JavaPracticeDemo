package com.seele.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

	private Object targetobj; //被代理的实例
	
	public ProxyHandler(Object targetobj){
		
		this.targetobj = targetobj;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		//在转调具体目标对象之前，可以执行一些功能处理
	    //转调具体目标对象的方法
	    return method.invoke(targetobj, args);  
	    
	    //在转调具体目标对象之后，可以执行一些功能处理
	}

}
