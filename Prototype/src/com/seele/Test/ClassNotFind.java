package com.seele.Test;

public class ClassNotFind {
	
	public String getClassPath(){
		return this.getClass().getClassLoader().getResource("").toString();
	}
	public static void main(String[] args) {
		//Class.forName("notFountClass");
		ClassNotFind cnf = new ClassNotFind();
		String url = cnf.getClassPath();
		System.out.print(url);
	}
}
