package com.seele.Serialized;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {
	private transient Book book;
	private String name;

	public Student(Book book, String name) {
		super();
		this.book = book;
		this.name = name;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//下面这两个方法就是那组特殊的私有方法，它们会在序列化、反序列化的过程 中被自动调用 
	//我们必须保证方法的签名和下面的两个方法完全相同
	
	//这个方法会在序列化的过程中被调用 
	private void writeObject(ObjectOutputStream out){
		try {
			out.defaultWriteObject(); //这个方法会把这当前中非静态变量和非transient变量写到流中
									  //在这里我们就把name写到了流中。
			//因为我们要保存Book的状态，所以我们还要想办法把其状态写入流中
			out.writeInt(book.getIsbn());//ObjectOutputStream中提供了写基本类型数据的方法
			//out.close();//注意，这句千万不能有，否刚将直接导致写入失败
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	//这个方法会在反序列化的过程中被调用
	private void readObject(ObjectInputStream in){
		try {
			in.defaultReadObject(); //和defaultWriteObject()方法相对应，默认的反序列化方法，会从流中读取
									//非静态变量和非transient变量
			int isbn  = in.readInt(); //用这个方法来读取一个int型值，这里我们是读取书号
			book  = new Book(isbn); //这里我们就通过读取的 保存的状态构造 了一个和原来一样的Book对象
			//in.close();同样的这句也不能有
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
	
	@Override
	public String toString() {
		return "Student [book=" + book + ", name=" + name + "]";
	}

}
