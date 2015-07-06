package com.seele.Test;

public class ClosureTest {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        final String str = "Java";
        new Thread(new Runnable(){
        	public void run(){
        		for(int i=0;i<100;i++){
                     System.out.println(str + "" + i);
                     try{
                    	 Thread.sleep(100);
                     }catch(Exception e){
                    	 e.printStackTrace();
                     }
        		}
        	}
        }).start();
	}

}
