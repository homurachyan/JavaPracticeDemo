package com.seele.Test;

import java.lang.reflect.Method;

public class TestMethod {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class classType = Class.forName("java.lang.String");
		
		String str = "abc";
        Class c1 = str.getClass();
        System.out.println(c1);
        
		Method methods[]=classType.getDeclaredMethods();
		for(int i=0;i<methods.length;i++){
			//System.out.println(methods[i].toString());
		}
		System.out.println(System.getProperty("java.ext.dirs"));

	}

}