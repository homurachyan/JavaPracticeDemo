package com.seele.concurrency;

public class Lock {

	private Boolean locked = Boolean.FALSE;

	public void lock() throws InterruptedException {
        synchronized (this){
            while (locked){ // 自旋转，防止假唤醒
                this.wait();
            }
            locked = Boolean.TRUE;
        }
    }

    public void unlock(){
        synchronized (this){
            if (!Thread.holdsLock(this)){
                throw new IllegalMonitorStateException("current thread not locked me.");
            }
            locked = Boolean.FALSE;
            this.notify();
        }
    }
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Lock lock = new Lock();
		lock.lock();
		try{
		    // do sth.
		} finally {
		    lock.unlock();
		}
	}

}
