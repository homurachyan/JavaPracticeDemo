package com.seele.Test;

import java.util.HashMap;
import java.util.Map;

public class MapPointTest {

	public static void main(String[] args) {
		Map map = new HashMap();
        String s = "1";
        map.put("str", s);
        System.out.println(map.get("str").toString());
        s  = "2";
        System.out.println(map.get("str").toString());
	}

}
