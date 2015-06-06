package com.seele.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxy {
	
	public static Object getNewProxyInstance(
			ClassLoader loader,
			Class[] interfaces,
			InvocationHandler h){
/*		if(true){
			//执行前置通知
			(new BeforeAdvice()).exec();
		}*/
	      //以下是分解步骤  
		  
	      /* 
	 
	      Class c = Proxy.getProxyClass(cls.getClassLoader(),cls.getInterfaces()) ; 
	 
	      Constructor ct=c.getConstructor(new Class[]{InvocationHandler.class}); 
	 
	      Subject subject =(Subject) ct.newInstance(new Object[]{ds}); 
	 
	     */  
		return Proxy.newProxyInstance(loader, interfaces, h);	
	}
//	  public static void main( String args[] )   
//	  {   
//	    RealSubject real = new RealSubject();   
//	    Subject proxySubject = (Subject)Proxy.newProxyInstance(
//	    		Subject.class.getClassLoader(), 
//	    		new Class[]{Subject.class}, 
//	    		new ProxyHandler(real));
//	         
//	    proxySubject.doSomething();
//	  }    
}
