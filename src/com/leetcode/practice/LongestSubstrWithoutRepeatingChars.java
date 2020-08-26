package com.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstrWithoutRepeatingChars {

	public static int lengthOfLongestSubstring(String s) {
        if(s == null)
        	return 0;
		
		int n = s.length();
        if(n == 0 || n == 1)
            return n;
        Map<Character, Integer> map = new HashMap();
        int start = 0;
        int distinct = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<n && start < n;i++) {
            Character ch = s.charAt(i);
            Integer count = map.get(ch);
            
            if(count == null || count < 1) {
                map.put(ch,1);
                max = Math.max(max, i - start + 1);
            } else {
                Character startChar = s.charAt(start);
                Integer startCount = map.get(startChar);
                max = Math.max(max, i - start);
                map.put(startChar, startCount - 1);
                i--;
                start++;
            }
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabcbb";
		
		System.out.println(lengthOfLongestSubstring(s));
	}

}
