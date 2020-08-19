package com.ds.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(-8>>1);
//		System.out.println(-8>>>1);
		List<String> l = new ArrayList<>();
		l.add("Hello");
		l.add("World");
		l.add("Howdy");
		
		Iterator< String> it = l.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
//		l.forEach(action);
		
//		HashMap<String,String> map = new HashMap<>();
//		System.out.println(map.put("name", "natwar"));
//		System.out.println(map.put("name", "natwar123"));
	}

}
