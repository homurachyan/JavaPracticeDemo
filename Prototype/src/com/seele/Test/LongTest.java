package com.seele.Test;

public class LongTest {

	public static void main(String[] args) {
		int a = 1;		
		long b = 2;
        System.out.println(a+b>Long.parseLong("2"));
        
        int c = new Integer(1);
        System.out.println(c);
        double x = new Integer(3600);
        double y = 31536000;
        double score = Math.min( 20.0 * (Math.min(2*x/y,1)*0.7+(1-Math.min((3600/31536000),1))*0.3),20);
        System.out.println(score);
	}
}
