package com.ds.suffixarray;

import java.util.Arrays;

class Suffix implements Comparable<Suffix>{
	int index;
	String text;
	
	Suffix(int index, String text) {
		this.index = index;
		this.text = text;
	}
	
	public int compareTo(Suffix s) {
		return this.text.compareTo(s.text);
	}
}

public class SuffixArray {

	
	public int[] getSuffixArray(String s) {
		int n = s.length();
		Suffix[] suffixes = new Suffix[n];
		int[] suffixArray = new int[n];
		for(int i=0; i<n; i++) {
			suffixes[i] = new Suffix(i,s.substring(i));
		}
		
		Arrays.sort(suffixes);
		
		for(int i=0; i<suffixes.length; i++) {
			suffixArray[i] = suffixes[i].index;
		}
		
		return suffixArray;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuffixArray s = new SuffixArray();
		int[] arr = s.getSuffixArray("banana");
		
		for(int a: arr) {
			System.out.print(a + "  ");
		}
	}

}
