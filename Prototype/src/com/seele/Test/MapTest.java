package com.seele.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapTest {
   
	public static void main(String[] args) {
		//测试map.put的返回值，如果被覆盖则会打印出旧值
        Map map = new HashMap();
        map.put("key", "123");
        Object oldValue = map.put("key", "456");
        System.out.println(oldValue);
        
        List<String> strs = new ArrayList<String>();
        strs.add("1");
        strs.add("2");
        strs.add("3");
        map.put("strs", new ArrayList<String>());
        ((List)map.get("strs")).add("4");
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
        	Map.Entry entry = (Map.Entry) iter.next();
        	System.out.println(entry.getValue());
        }
        
        System.out.println(Integer.MAX_VALUE);
	}

}
