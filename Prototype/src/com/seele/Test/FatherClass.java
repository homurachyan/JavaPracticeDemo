package com.seele.Test;

public class FatherClass {

	public int x = 0;
	
	static int i = 1;
	String name;
	
	public FatherClass(){
		System.out.println("father构造函数·····");
	}
	
	static {
		System.out.println("father静态初始化块1·····"+i);
	}
	
    public static void doPost(){
    	System.out.println("invoke father methed");
    }
    
	{
		System.out.println("father非静态初始化块·····");
	}
	static {
		System.out.println("father静态初始化块2·····");
	}
	

}
