package com.seele.concurrency;

public class StaticThreadInit {

	static {
		Thread t = new Thread(){
			public void run(){
				System.out.println("进入run方法");
				System.out.println(website);
				website = "www.acfun.com";
				System.out.println("退出run方法");
			}
		};
		t.start();
		try{
			//加入t线程,main线程等待
			//t.join();//此语句会导致死锁
			Thread.sleep(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	static String website = "www.bilibili.com";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main线程:"+StaticThreadInit.website);
	}

}
