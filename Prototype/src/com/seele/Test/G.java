package com.seele.Test;
/**
 * 引用逃逸测试
 * */
public class G {
	public static B2 b;
	
	public void globalVariablePointerEscape(){//给全局变量赋值，发生逃逸
		b=new B2();
	}
	
	public B2 methodPointerEscape(){//方法返回值，发生逃逸
		return new B2();
	}
	
	public void instancePassPointerEscape(){
		methodPointerEscape().printClassName(this);//实例引用发生逃逸
	}
	
	
}

class B2{
	public void printClassName(G g){
		System.out.println(g.getClass().getName());
	}
}
