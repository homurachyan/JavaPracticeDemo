package com.seele.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SimpleClass {
	 public void sayHello(String words) {
			System.out.println(words);
			System.getProperty("java.class.path");
	}
	 
    public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
    	SimpleClass sc = new SimpleClass();
    	Class clz = sc.getClass();
    	Method[] ms = clz.getDeclaredMethods();
    	ms[0].invoke(sc,"Acfun");
  	
    }
}
