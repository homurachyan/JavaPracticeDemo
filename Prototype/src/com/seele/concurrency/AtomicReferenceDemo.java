package com.seele.concurrency;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
	
	private volatile static AtomicReference<Integer> ar = new AtomicReference<Integer>(0);
	
	public synchronized static void inc(){
		 try{
	            Thread.sleep(1);
	     } catch (InterruptedException e) {
	        
	     }
		 
		 while(true){
              Integer temp=ar.get();
              if(ar.compareAndSet(temp, temp+1)){
            	  break;
              }
         }
		 
	}	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//同时启动1000个线程，去进行i++计算，看看实际结果		 
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                public void run() {
                	AtomicReferenceDemo.inc();
                }
            }).start();
        }
        Thread.sleep(10000);
        System.out.println("运行结果:Counter.count=" + ar.get().toString());
	}

}
