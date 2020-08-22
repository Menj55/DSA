package com.algo;

public class MaxSumSubarray {

	private static int maxSum(int [] arr, int k) {
		int ans = Integer.MIN_VALUE;
		int curr = 0;
		
		for(int i=0; i<k; i++) {
			curr += arr[i];
		}
		
		ans = Math.max(curr, ans);
		
		for(int i=0; i<arr.length - k; i++) {
			curr = curr - arr[i] + arr[i+k];
			
			ans = Math.max(ans, curr);
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {2,3,4,1,5};
		int k = 2;
		
		System.out.println(maxSum(arr,k));
	}

}
