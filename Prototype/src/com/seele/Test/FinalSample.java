package com.seele.Test;

public class FinalSample {
	public int var;
	 
    public FinalSample(int var) {
       this.var = var;
    }
 
    public static void main(String[] args) {
       final FinalSample s = new FinalSample(1);
       //s.var = 2;
       //System.out.println(s.var);
 
       // 出错，不能改变引用变量s所引用的FinalSample类的对象
       // s=new FinalSample(2);
       
       int oldArray[] = new int[]{1,2,3,4,5}; 
       
       int newArray[] = new int[oldArray.length+1];
       
       System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
       
       newArray[oldArray.length] = 6;
       
    	   System.out.println(System.getProperty("user.dir"));
       
       
    }
}
