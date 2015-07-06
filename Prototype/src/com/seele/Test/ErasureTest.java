package com.seele.Test;

import java.util.ArrayList;
import java.util.List;

public class ErasureTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple<Integer> a = new Apple<Integer>(6);
		Integer as = a.getSize();
		Apple b = a;
		Number size1 = b.getSize();
		//Integer size2 = b.getSize();//找不到原始类型Number的实现子类
		for(String apple : a.getApple()){
			System.out.println(apple);
		}
		Apple c = a;
		for(Object apple : c.getApple()){
			System.out.println(apple.toString());
		}		
	}

}
class Apple<T extends Number>{
	T size;
	public Apple(){
		
	}
	public Apple(T size){
		this.size = size;
	}
	public void setSize(T size){
		this.size = size;
	}
	public T getSize(){
		return this.size;
	}
	public List<String> getApple(){
		List<String> list = new ArrayList<String>();
		for(int i=0;i<3;i++){
			list.add(new Apple<Integer>(10*i).toString());
		}
		return list;
	}
	public String toString(){
		return "Apple's size="+ size;
	}
}