package com.seele.Test;

public class TraditionalThreadSynchronized {
	public static void main(String[] args) {
		new TraditionalThreadSynchronized().init();
	}

	public void init() {
		final Outputer outputer = new Outputer();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.output("lixiangmao");
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.output("shenjinsheng");
				}
			}
		}).start();
	}

	class Outputer {
		public synchronized void output(String name) {
			int len = name.length();
			//synchronized (this) {
				for (int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}				
			//}
			System.out.println();
		}
	}
}