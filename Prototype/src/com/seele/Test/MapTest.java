package com.seele.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
   
	public static void main(String[] args) {
		//测试map.put的返回值，如果被覆盖则会打印出旧值
        Map map = new HashMap();
        map.put("key", "123");
        Object oldValue = map.put("key", "456");
        System.out.println(oldValue);
	}

}
