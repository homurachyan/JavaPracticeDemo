package com.seele.Caller;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Caller caller = new Caller();  
	    caller.setCallFunc(new Client());  
	    caller.call();  
	}

}
