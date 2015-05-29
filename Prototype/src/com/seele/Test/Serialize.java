package com.seele.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialize implements Serializable {
   private static final long serialVersionUID = -1L;
   
   public int num = 1390;
   
   public void writeObject(Serialize s){
	   System.out.println("lalala");
   }
   
   public static void main(String[] args) {
	   try{
		   FileOutputStream fos = new FileOutputStream("s.txt");
		   ObjectOutputStream oos = new ObjectOutputStream(fos);
		   Serialize s = new Serialize();
		   oos.writeObject(s);
		   oos.flush();
		   oos.close();
		   
		   
	   } catch(IOException e){
		   e.printStackTrace();  
	   }
   }
}
