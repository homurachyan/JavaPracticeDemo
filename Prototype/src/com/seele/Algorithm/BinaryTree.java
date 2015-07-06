package com.seele.Algorithm;

public class BinaryTree {
    //数组实现
	Object[] datas; //实际数据存放区
	int size;
	int deep;
	
	static final int DEFAULT_DEEP = 8;
	
	public BinaryTree(){
		this.deep = DEFAULT_DEEP;
		this.size = (int) (Math.pow(2, this.deep)-1); //2的deep次方-1 
		datas = new Object[size];
	}
	
	public void add(){
		
	}
}
