package com.seele.cache;

import java.util.Map;
import java.util.Map.Entry;

public class LRUtest {

	 public static void main(String[] args) {
	        LRUCache<String, String> lruCache = new LRUCache<String, String>(5);
	        lruCache.size();
	        lruCache.put("1", "1");
	        lruCache.put("2", "2");
	        lruCache.put("3", "3");
	        lruCache.put("4", "4");
	        
	        lruCache.get("2");
	        lruCache.put("6", "6");
	        //lruCache.put("5", "5");
	        System.out.println(lruCache.size());
	        for(Map.Entry<String, String> entry : lruCache.entrySet()){
	        	System.out.println(entry.getValue());
	        }
	 }

}
