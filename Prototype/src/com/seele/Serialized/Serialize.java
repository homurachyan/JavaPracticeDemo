package com.seele.Serialized;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialize implements Serializable {
   private static final long serialVersionUID = -1L;
   
   public int num = 1390;
   
   public void writeObject(Serialize s){
	   System.out.println("lalala");
   }
   
   public static void main(String[] args) throws Exception {
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
	   try{
		   FileInputStream fos = new FileInputStream("s.txt");
		   ObjectInputStream ois = new ObjectInputStream(fos);
		   Serialize s1 = (Serialize) ois.readObject();
		   System.out.println(s1.num);  
		   
	   } catch(IOException e){
		   e.printStackTrace();  
	   }
   }
}
