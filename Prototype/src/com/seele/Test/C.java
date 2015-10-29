package com.seele.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class C {

	public static void main(String[] args) {
        Set<String> s = new HashSet<String>();
        s.add("A");
        A(s,10);
        for(Iterator<String> iterator = s.iterator();iterator.hasNext();){
			System.out.println(iterator.next()); //所有下家
		}
	}
    
	public static void A(Set s,int count){
		s.add("A"+count);
		if(count>0){
			A(s,count-1);
		}
	}
}
