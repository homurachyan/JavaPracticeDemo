package com.seele.Test;

import java.util.HashMap;
import java.util.Map;

public class MapToPOJOTest {

	public static void main(String[] args) {
         Map map = new HashMap();
         map.put("userName", "homurachyan");
         map.put("mobile", "13709017780");
         User user = (User) CommonUtils.mapToEntity(map, User.class);
         System.out.println(user.toString());
	}

}
