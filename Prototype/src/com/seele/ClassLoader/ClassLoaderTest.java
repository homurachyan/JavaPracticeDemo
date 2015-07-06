package com.seele.ClassLoader;

import java.net.URL; 
import java.net.URLClassLoader; 

public class ClassLoaderTest { 
	
    private static int count = -1; 
    
    public static void testClassLoader(Object obj) { 
        if (count < 0 && obj == null) { 
           System.out.println("Input object is NULL"); 
           return; 
        } 
        ClassLoader cl = null; 
        if (obj != null && !(obj instanceof ClassLoader)) { 
            cl = obj.getClass().getClassLoader(); 
        } else if (obj != null) { 
            cl = (ClassLoader) obj; 
        } 
        count++; 
        String parent = ""; 
        for (int i = 0; i < count; i++) { 
            parent += "Parent "; 
        } 
        if (cl != null) { 
            System.out.println(parent + "ClassLoader name = " + cl.getClass().getName()); 
            testClassLoader(cl.getParent()); 
        } else { 
           System.out.println(parent + "ClassLoader name = BootstrapClassLoader"); 
           count = -1; 
        } 
   } 
    
   public static void main(String[] args) throws Throwable { 
	   
	   ClassLoader cl = ClassLoaderTest.class.getClassLoader();
	   if(cl!=null){
		   System.out.println(cl.toString());
		   System.out.println(cl.getParent().toString());
		   //System.out.println(cl.getParent().getParent().toString());
	   }
	   Class clz = Class.forName("java.lang.String");  
	   System.out.println(clz.getClassLoader()); 
	   
        URL[] urls = new URL[1]; 
        URLClassLoader urlLoader = new URLClassLoader(urls); 
        //ClassLoaderTest.testClassLoader(urlLoader); 
   } 
}  
