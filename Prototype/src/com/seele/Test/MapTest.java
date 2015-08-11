package com.seele.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Map map = new HashMap();
        map.put("key", "123");
        Object oldValue = map.put("key", "456");
        System.out.println(oldValue);
	}

}
