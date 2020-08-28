package com.ds.suffixarray;

public class SearchPattern {

	public boolean searchPattern(String s, String pattern, int[] suffixArray) {
//		boolean found = false;
		
		int l = 0; 
		int r = suffixArray.length;
		
		while(l < r) {
			int mid = l + (r-l)/2;
			int compare = s.substring(suffixArray[mid]).compareTo(pattern);
			if( compare == 0 )
				return true;
			if(compare > 0) {
				r = mid-1;
			}
			if(compare < 0) {
				l = mid+1;
			}
		}
		
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuffixArray s = new SuffixArray();
		int[] suffixArray = s.getSuffixArray("banana");
		SearchPattern sp = new SearchPattern();
		System.out.println(sp.searchPattern("banana", "nan", suffixArray));
	}

}
