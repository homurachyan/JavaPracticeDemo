package com.seele.concurrency;

public class CheesyCounter {
    //如果读操作远远超过写操作,可以选择开销较低的读－写锁
	// Employs the cheap read-write lock trick
    // All mutative operations MUST be done with the 'this' lock held
    private volatile int value;

    public int getValue() { return value; }

    public synchronized int increment() {
        return value++;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
