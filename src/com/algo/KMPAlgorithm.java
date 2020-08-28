package com.algo;

public class KMPAlgorithm {

	public int searchPattern(int[] lps, String s, String p) {
		int stringIndex = 0;
		int patIndex = 0;
		
		while(stringIndex < s.length()) {
			if(s.charAt(stringIndex) == p.charAt(patIndex)) {
				stringIndex++;
				patIndex++;
			} 
			
			if(patIndex == p.length()) {
				System.out.println("Pattern Found at " + (stringIndex - patIndex));
				patIndex = lps[patIndex-1];
			} else if (stringIndex < s.length() && p.charAt(patIndex) != s.charAt(stringIndex)){
				if(patIndex != 0) {
					patIndex=lps[patIndex-1];
				} else {
					stringIndex++;
				}
				
			}
		}
			
		return -1;
	}
	
	public int[] getLPS(String s) {
		int n = s.length();
		int lps[] = new int[n];
		lps[0] = 0;
		int i=0;
		int j = i+1;
		
		while(i < n && j<n && i >= 0 && j >= 0) {
			if(s.charAt(i) == s.charAt(j)) {
				lps[j] = i+1;
				i++;
				j++;
			} else {
				i = lps[j-1];
				
				while(i > 0 && i < n && s.charAt(i) != s.charAt(j)) {
					if(i > 0)
						i = lps[i-1];
				}
				if(s.charAt(i) == s.charAt(j)) {
					lps[j] = i+1;
				} else {
					lps[j] = lps[i];
				}
				j++;
			}
		}
		
		return lps;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s= "abalmadecdebhabalmanaabalm";
		String pattern = "abalm";
		
		KMPAlgorithm kmp = new KMPAlgorithm();
		int[] lps = kmp.getLPS(s);
		
		for(int a : lps) {
			System.out.print(a + "  ");
		}
		System.out.println();
		System.out.println(kmp.searchPattern(lps, s, pattern));
	}

}
