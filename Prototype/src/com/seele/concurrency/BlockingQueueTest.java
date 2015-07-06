package com.seele.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {

	public static class Product{
		String productName;
		public Product(String productName){
			this.productName = productName;
		}	   	
	}	
	//生产者线程	
	public static class Producter implements Runnable{
		BlockingQueue queue;
		
		public Producter(BlockingQueue queue){
			this.queue = queue;
		}
		
		public void run() {
			try {
				while(true){
					System.out.println("生产者线程开始放入数据···");	
					String name = String.valueOf(Math.random());
					queue.put(new Product(name));
					System.out.println("生产者线程开始放入:"+name);	
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	//消费者线程
	public static class Customer implements Runnable{
		BlockingQueue queue;
		
		public Customer(BlockingQueue queue){
			this.queue = queue;
		}		
		
		public void run() {
			try {
				while(true){
					System.out.println("消费者线程开始消费数据···");	
					queue.take();	
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        BlockingQueue queue = new LinkedBlockingQueue(10);
        
        Producter p1 = new Producter(queue);
        Producter p2 = new Producter(queue);
        Customer c1 = new Customer(queue);
        
        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(c1).start();
	}

}
