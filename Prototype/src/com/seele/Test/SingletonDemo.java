package com.seele.Test;

public class SingletonDemo {

	//private static SingletonDemo instance = null;
	
	private SingletonDemo(){} //私有构造函数
	
/*	public static SingletonDemo getInstance(){
		if(instance==null){    //线程不安全
			instance = new SingletonDemo();
		}
		return instance;
	}*/
/*	//懒汉式，线程安全，但开销大
	public static synchronized SingletonDemo getInstance(){
		if(instance==null){    
			instance = new SingletonDemo();
		}
		return instance;
	}	*/
	//饿汉式，使用静态内部类加载，仅会被加载一次
    private static class SingletonHolder{
        static SingletonDemo instance = new SingletonDemo();
    }
	
    public static SingletonDemo getInstance() {
        return SingletonHolder.instance;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
