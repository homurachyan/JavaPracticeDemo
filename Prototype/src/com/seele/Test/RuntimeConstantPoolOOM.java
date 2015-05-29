package com.seele.Test;

import java.util.Random;

public class RuntimeConstantPoolOOM{

	static final int MAX = 1000 * 10000;
	static final String[] arr = new String[MAX];
	
	public static void main(String[] args) {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
		

	    Integer[] DB_DATA = new Integer[10];
	    Random random = new Random(10 * 10000);
	    for (int i = 0; i < DB_DATA.length; i++) {
	        DB_DATA[i] = random.nextInt();
	    }
	    long t = System.currentTimeMillis();
	    for (int i = 0; i < MAX; i++) {
	        arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length]));
	         //arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length])).intern();
	    }

	    System.out.println((System.currentTimeMillis() - t) + "ms");
	    System.gc();
	}

}
