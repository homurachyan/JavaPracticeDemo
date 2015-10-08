package com.seele.Test;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

public class CommonUtils {
	public static Object mapToEntity(Map paramMap, Class<?> clazz) {
		Object obj = null;
		try {
			obj = clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			Iterator keyValuePairs = paramMap.entrySet().iterator();
			while(keyValuePairs.hasNext()){
	            Map.Entry entry = (Map.Entry) keyValuePairs.next();
	            //Method method = clazz.getMethod("set" + key.substring(0,1).toUpperCase() + key.substring(1));
	            Field field = clazz.getDeclaredField((String) entry.getKey());
	            field.setAccessible(true);
	            field.set(obj, entry.getValue());
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
