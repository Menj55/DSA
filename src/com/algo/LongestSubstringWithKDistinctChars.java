package com.algo;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctChars {

	private static int printSubstringSize(String str, int k) {
		int n = str.length();
		
		int start = 0;
		int max = Integer.MIN_VALUE;
		Map<Character,Integer> isPresent = new HashMap();
		int length = 0;
		int distinct = 0;
		for(int i=0; i<n; i++) {
			char ch = str.charAt(i);
			Integer occurence = isPresent.get(ch);
			if(occurence == null || occurence <= 0) {
				isPresent.put(ch, 1);
				distinct++;
			} else if(occurence > 0) {
				isPresent.put(ch, occurence+1);
			}
			while(distinct > k) {
				Integer initial = isPresent.get(str.charAt(start));
				if(initial == 1) {
					isPresent.put(str.charAt(start), initial - 1);
					distinct--;
					start++;
				} else {
					isPresent.put(str.charAt(start), initial - 1);
					start++;
				}
			}
			
			max = Math.max(max, i - start + 1);
//			System.out.println("i = " + i + " start = "+start + " Max : " + max);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "cbbebi";
		int k = 3;
		
		System.out.println(printSubstringSize(str, k));
	}

}
