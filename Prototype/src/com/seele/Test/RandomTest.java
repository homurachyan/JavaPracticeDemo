package com.seele.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		 String[] beforeShuffle = new String[] { "0","1","2","3","4","5","6","7","8","9" };  
	     List list = Arrays.asList(beforeShuffle);  
	     Collections.shuffle(list);  
	     StringBuilder sb = new StringBuilder();  
	     for (int i = 0; i < list.size(); i++) {  
	         sb.append(list.get(i));  
	     }  
	     String afterShuffle = sb.toString();  
	     String result = afterShuffle.substring(5, 9);  
	     System.out.println(result) ;
         
	     Random rand = new Random();//创建Random类的对象rand  
	     String vcode = "";
	     for(int i=0;i<4;i++){
	    	 vcode += rand.nextInt(10);	    	 
	     }
	     System.out.println(vcode) ;
	}

}
