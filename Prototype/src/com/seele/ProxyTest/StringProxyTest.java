package com.seele.ProxyTest;

import java.lang.reflect.Proxy;
import java.util.Map;

public class StringProxyTest {

	public static void main(String[] args) {

		IAdvice str = (IAdvice) Proxy.newProxyInstance(StringProxyTest.class.getClassLoader(),  new Class[] { IAdvice.class }, new StringProxyHandler());
        System.out.println(str instanceof IAdvice);
        str.exec();
	}

}
