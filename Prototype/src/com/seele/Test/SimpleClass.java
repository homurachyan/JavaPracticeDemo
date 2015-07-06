package com.seele.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class SimpleClass {
	 public void sayHello(String words) {
			System.out.println(words);
			System.getProperty("java.class.path");
	}
	 
	public SimpleClass(){
	}	 
	
	public SimpleClass(String name){
		System.out.println(name);
	}
	 
    public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, Exception, Exception, Exception{
    	SimpleClass sc = new SimpleClass();
    	Class clz = sc.getClass();
    	SimpleClass scc = (SimpleClass)clz.getConstructor(String.class).newInstance("kukuku");
    	Method[] ms = clz.getDeclaredMethods();
    	ms[0].invoke(sc,"Acfun");
    	System.out.println(Modifier.isPublic(ms[0].getModifiers()));
    	scc.sayHello("Bilibili");
  	
    }
}
