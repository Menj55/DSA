package com.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public String minWindowHashMap(String s, String t) {
        int n = s.length();
        int nt = t.length();
        int ansStart = -1;
        int ansEnd = -1;
        int ans = Integer.MAX_VALUE;
        boolean matched = false;
        int start = 0;
        Map<Character, Integer> map = new HashMap();
        Map<Character, Integer> submap = new HashMap();
        for(int i=0; i<nt; i++) {
            Character temp = t.charAt(i);
            map.put(temp,map.getOrDefault(temp,0) + 1);
        }
        
        for(int i=0; i<n; i++) {
            Character temp = s.charAt(i);
            submap.put(temp, submap.getOrDefault(temp,0)+1);
            
            if(!matched && compareMap(t,map,submap)) {
                matched = true;
            }
            
            if(matched) {
                while(compareMap(t,map,submap)) {
                    if(ans > i - start + 1) {
                        ans = i - start + 1;
                        ansStart = start;
                        ansEnd = i;
                    }
                    Character tempstart = s.charAt(start);
                    submap.put(tempstart, submap.get(tempstart) - 1);
                    start++;
                }
            }
        }
        
        String result = "";
        System.out.println(ansStart + "  -  " + ansEnd);
        if(ansStart >=0 && ansEnd >=0) {
            for(int i = ansStart; i<= ansEnd; i++) {
                result += s.charAt(i);
            }
        }
        
        return result;
    }
	
	public String minWindow(String s, String t) {
        int n = s.length();
        int nt = t.length();
        int ansStart = -1;
        int ansEnd = -1;
        int ans = Integer.MAX_VALUE;
        int matched = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap();
        for(int i=0; i<nt; i++) {
            Character temp = t.charAt(i);
            map.put(temp,map.getOrDefault(temp,0) + 1);
        }
        
        for(int i=0; i<n; i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                
                if(map.get(s.charAt(i)) >= 0) {
                    matched++;
                }
            }
            
            if(matched == t.length()) {
                if(ans > i - start + 1) {
                    ans = i -start + 1;
                    ansStart = start;
                    ansEnd = i;
                }
            }
            
            while(matched >= t.length()) {
                if(map.containsKey(s.charAt(start))) {
                    if(map.get(s.charAt(start)) == 0) {
                        if(ans > i - start + 1) {
                            ans = i -start + 1;
                            ansStart = start;
                            ansEnd = i;
                        }
                        matched --;
                    }
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                }
                start++;
            }
        }
        
        String result = "";
        if(ansStart >=0 && ansEnd >=0) {
            for(int i = ansStart; i<= ansEnd; i++) {
                result += s.charAt(i);
            }
        }
        
        return result;
    }
    
    public static boolean compareMap(String s1, Map<Character,Integer> map, Map<Character, Integer> submap) {
        int n = s1.length();
        
        for(int i=0; i<n ;i++) {
            Character ch = s1.charAt(i);
            if(submap.get(ch) == null || (int)map.get(ch) > (int)(submap.get(ch))) {
            	return false;
            }
                
        }
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MinimumWindowSubstring m = new MinimumWindowSubstring();
		System.out.println(m.minWindow("AODEBFBANC", "ABC"));;
	}

}
