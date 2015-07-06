package com.seele.concurrency;

public class InvokeRun extends Thread {

	private int i;
	
	public void run(){
		for(;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i == 20){
				new InvokeRun().run();;
				new InvokeRun().run();;
			}
		}
	}

}
