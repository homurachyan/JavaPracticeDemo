package com.seele.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.seele.Test.FatherClass;
import com.seele.Test.SimpleClass;

public class ReflectTest {
	
    //通用数组增长method
	static Object ArrayGrow(Object array){
		Class clz = array.getClass();
		if(!clz.isArray()) return null;
		int newLength = Array.getLength(array)*2;
		Object newArray = Array.newInstance(clz.getComponentType(), newLength);
		System.arraycopy(array, 0, newArray, 0, Array.getLength(array));
		return newArray;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, Throwable {
		String classpath = System.getProperty("java.class.path");
		
		System.out.println(classpath);
		
		Class classType = Class.forName("java.lang.String");
		
		String str = "abc";
        Class clz = str.getClass();
        System.out.println(Double[].class.getName());
        //动态field访问
        FatherClass fc = new FatherClass();
        clz = fc.getClass();
        Field f = clz.getDeclaredField("x");
        //f.setAccessible(true);
        f.setInt(fc, 12);
        System.out.println(fc.x);
        
        //数组类型转换
        int[] a = {1,2,3,4,5};
        System.out.println("数组类型" + a.getClass().getComponentType().getName());
        
        
		Method methods[]=classType.getDeclaredMethods();
		for(int i=0;i<methods.length;i++){
			//System.out.println(methods[i].toString());
		}
		System.out.println(System.getProperty("java.ext.dirs"));
		
/*    	SimpleClass sc = new SimpleClass();
    	Class clz = sc.getClass();
    	SimpleClass scc = (SimpleClass)clz.getConstructor(String.class).newInstance("kukuku");
    	Method[] ms = clz.getDeclaredMethods();
    	ms[0].invoke(sc,"Acfun");
    	scc.sayHello("Bilibili");*/
	}

}
