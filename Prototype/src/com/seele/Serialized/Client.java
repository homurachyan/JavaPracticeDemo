package com.seele.Serialized;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client {

	public static void main(String[] args) {
		new Client().go();
	}
	
	private void go(){
		Student student = new Student(new Book(2011),"kevin");
		
		try {
			ObjectOutputStream out  = new ObjectOutputStream(new FileOutputStream("seria"));
			out.writeObject(student); //
			System.out.println("object has been written..");
			out.reset(); //作用是清除流中保存的写入对象的记录
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("seria"));
			Student studentRead = (Student) in.readObject();
			System.out.println("object read here:");
			System.out.println(studentRead);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
