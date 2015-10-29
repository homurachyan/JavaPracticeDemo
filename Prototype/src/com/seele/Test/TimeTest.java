package com.seele.Test;

import java.text.SimpleDateFormat;

public class TimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        long unix_timestamp = 1444284527;
        SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
        String dateString = formatter.format(new java.util.Date(unix_timestamp*1000));
        
        System.out.println(dateString.substring(0, 2));
        
        printWithHex(10);
        printWithHex(255);
        
	}
	public static void printWithHex(int num) {
        for (int i = 0; i < 32; i++) {
            System.out.print(num < 0 ? '1' : '0');
            num <<= 1;
            System.out.println(num);
        }
        System.out.println();
    }
}
