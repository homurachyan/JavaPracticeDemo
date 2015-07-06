package com.seele.Algorithm;

import java.util.Arrays;

public class SequenceList<T> {
	
    private final static int DEFAULT_SIZE = 16;
    Object[] elementData;
    int size;
    int capacity;
    
    public SequenceList(){
    	capacity = DEFAULT_SIZE;
    	elementData = new Object[capacity];
    }
	
    public SequenceList(int capacity){
    	this.capacity = capacity;
    	elementData = new Object[capacity];
    }	
	
    public int getSize(){
    	return this.size;
    }
    
    public void add(T element){
    	//检查size大小
    	
    	if(element!=null){
    		if(this.size==this.capacity){
    			//数组已满
    			capacity = capacity * 2;
    			Object[] copy =  new Object[capacity];
    			System.out.println(copy.length);
    			System.arraycopy(elementData, 0, copy, 0, elementData.length);
    			elementData = copy;
    			//elementData = Arrays.copyOf(elementData, capacity);
    		}
    			elementData[size] = element;
    			size++;
    	}else{
    		System.out.println("不能插入为空的元素");
    	}
    }
    
    public void ensureCapatity(int needcapatity){
    	
    }
    
    public void remove(){
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SequenceList<String> list = new SequenceList<String>();
		for(int i=0;i<20;i++){
			if(i==15){
				System.out.println(list.capacity);
			}
			list.add("a" + i);		
		}
		//System.out.println(list.capacity);
	}

}
