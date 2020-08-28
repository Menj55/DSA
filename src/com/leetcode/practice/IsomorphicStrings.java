package com.leetcode.practice;

import java.util.Arrays;
import java.util.HashMap;

public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
        if(s == null && t==null) return true;
        if(s == null || t==null) return false;
        if(s.length() != t.length()) return false;
//        int[] scount = getCount(s);
        int[] tcount = getCount(t);
//        for(int a : scount) {
//            System.out.print(a + " ");
//        }
        System.out.println();
        for(int a : tcount) {
            System.out.print(a + " ");
        }
//        return Arrays.equals(scount,tcount);
        return false;
        
    }
    
    public int[] getCount(String s) {
        int n = s.length();
        int[] counts = new int[n];
        HashMap<Character, Integer> map = new HashMap();
        for(int i=0; i<n; i++) {
            int temp = map.getOrDefault(s.charAt(i),0);
            System.out.println("temp = " + temp);
        	map.put(s.charAt(i), temp + 1);
            counts[i] = map.get(s.charAt(i));
            System.out.println(counts[i]);
        }
        
        return counts;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsomorphicStrings i = new IsomorphicStrings();
		
		System.out.println(i.isIsomorphic("ab", "aa"));
	}

}
