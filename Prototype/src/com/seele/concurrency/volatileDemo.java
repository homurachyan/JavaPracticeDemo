package com.seele.concurrency;

import java.util.concurrent.CountDownLatch;

public class volatileDemo {
    //volatile can not guarantee thread safety
	//volatile适合在对变量的写操作不依赖于当前值的情况
	private volatile static int counter = 0;
	
	private static CountDownLatch countDownLatch = new CountDownLatch(1000);
	
	public synchronized static void inc(){
		 try{
	            Thread.sleep(1);
	     } catch (InterruptedException e) {
	        
	     }
		 
		 counter++;
		 
		 countDownLatch.countDown();
	}
	
	public static void main(String[] args) throws Exception {
		//同时启动1000个线程，去进行i++计算，看看实际结果
		 
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                public void run() {
                	volatileDemo.inc();
                }
            }).start();
        }
        //Thread.join();
        //CountDownLatch最重要的方法是countDown()和await()，前者主要是倒数一次，后者是等待倒数到0，如果没有到达0，就只有阻塞等待了
        countDownLatch.await();
        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + volatileDemo.counter);

	}

}
