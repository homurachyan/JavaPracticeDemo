package com.seele.ClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.seele.Serialized.Client;

public class FileSystemClassLoader extends ClassLoader { 
    //自定义类加载器
    private String rootDir; 

    public FileSystemClassLoader(String rootDir) { 
        this.rootDir = rootDir; 
    } 
    //findClass
    protected Class<?> findClass(String name) throws ClassNotFoundException { 
        byte[] classData = getClassData(name); 
        if (classData == null) { 
            throw new ClassNotFoundException(); 
        } 
        else { 
            return defineClass(name, classData, 0, classData.length); 
        } 
    } 
    //根据文件路径获取.class文件的2进制字节流
    private byte[] getClassData(String className) { 
        String path = classNameToPath(className); 
        try { 
            InputStream ins = new FileInputStream(path); 
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
            int bufferSize = 4096; 
            byte[] buffer = new byte[bufferSize]; 
/*            int bytesNumRead = 0; 
            while ((bytesNumRead = ins.read(buffer)) != -1) { 
                baos.write(buffer, 0, bytesNumRead); 
            } */
            int bytesNumRead = 0; 
            bytesNumRead = ins.read(buffer);
            byte[] byteA = new byte[bytesNumRead];
            System.arraycopy(buffer, 0, byteA, 0, bytesNumRead);
            return byteA;//baos.toByteArray(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
        return null; 
    } 

    private String classNameToPath(String className) { 
        return rootDir + File.separatorChar + className.replace('.', File.separatorChar) + ".class"; 
    } 
    
    
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, Throwable {
		FileSystemClassLoader cl = new FileSystemClassLoader("M:\\");
		Class clz = cl.findClass("Test");
		clz.getMethod("main", String[].class).invoke(null, (Object) new String[]{});
		System.out.println(clz.getName());
	}
}
