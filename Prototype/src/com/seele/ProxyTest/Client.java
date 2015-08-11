package com.seele.ProxyTest;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Subject sub = new RealSubject();
        InvocationHandler handler = new ProxyHandler(sub);
        
/*        Subject proxy = (Subject) DynamicProxy.getNewProxyInstance(
        		sub.getClass().getClassLoader(), 
        		sub.getClass().getInterfaces(), 
        		handler);*/
        Subject proxy = (Subject) Proxy.newProxyInstance(sub.getClass().getClassLoader(), 
        		sub.getClass().getInterfaces(), 
        		handler);
        
        proxy.doSomething();
	}
	
	 public static void createProxyClassFile()   
	  {   
	    String name = "ProxySubject";   
	    byte[] data = ProxyGenerator.generateProxyClass( name, new Class[] { Subject.class } );   
	    try  
	    {   
	      FileOutputStream out = new FileOutputStream( name + ".class" );   
	      out.write( data );   
	      out.close();   
	    }   
	    catch( Exception e )   
	    {   
	      e.printStackTrace();   
	    }   
	  }   

}
