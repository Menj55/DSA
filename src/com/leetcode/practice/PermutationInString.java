package com.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PermutationInString {

	public static List<Integer> checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null)
            return null;
        int n1 = s1.length();
        int n2 = s2.length();
        int start = 0;
        Map<Character,Integer> map = new HashMap();
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n1; i++) {
            Integer temp = map.getOrDefault(s1.charAt(i),0);
            map.put(s1.charAt(i), temp+1);
        }
        Map<Character, Integer> submap = new HashMap();
        for(int i=0; i<n2; i++) {
            Character ch = s2.charAt(i);
            Integer temp = submap.getOrDefault(ch, 0);
            if(i < n1) {
                submap.put(ch, temp + 1);
            } else if(i >= n1) {
                if(compareMap(s1, map, submap, false)) {
                    ans.add(start);
                }
                Character startch = s2.charAt(start);
                Integer startint = submap.getOrDefault(startch, 0);
                submap.put(startch, startint - 1);
                start++;
                temp = submap.getOrDefault(ch, 0);
                submap.put(ch, temp + 1);
            }
        }
        
        if(compareMap(s1, map, submap, true))
            ans.add(start);
        
        return ans;
    }
    
    public static boolean compareMap(String s1, Map<Character,Integer> map, Map<Character, Integer> submap, boolean print) {
        int n = s1.length();
        
        for(int i=0; i<n ;i++) {
            Character ch = s1.charAt(i);
            if(!map.get(ch).equals(submap.get(ch))) {
            	return false;
            }
                
        }
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i = 11;
		int b = (int)i;
//		Arrays.equals(a, a2)
		String str2 = "cbaebabacd";
		str2.length();
		String str = "abc";
//		String sorted = Stream.of(str.split("")).sorted().collect(Collectors.joining());
		List<Integer> ans = checkInclusion(str, str2);
		ans.forEach(x -> {
			System.out.print(x + ", ");
		});
		
		System.out.println();
	}

}
