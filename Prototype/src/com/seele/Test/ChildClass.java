package com.seele.Test;

public class ChildClass extends FatherClass {

    public static void doPost(){
    	System.out.println("invoke child methed");
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildClass cc = new ChildClass();
		cc.doPost();
	}

}
