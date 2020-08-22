package com.algo;

public class SmallestContigiousSubarraySum {

	private static void minSubarray(int[] arr, int sum) {

		int n = arr.length;
		int curr = 0;
		
	
		
		for(int k=0; k<n; k++) {
			curr  = 0;
			for(int i=0; i<arr.length - k; i++) {
				curr += arr[i];
				
				if(i >= k) {
					if(curr >= sum) {
						System.out.println("Start = " + (i-k) + " End = " + i);
						break;
					}
					curr -= arr[i-k];
				}
			}
		}
		
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {3, 4, 1, 1, 6};
		int sum = 8;
		
//		int ans[] = 
				minSubarray(arr, sum);
	}

}
