package com.algo;

public class MaxSumDiff {

	private static int findMax(int[] arr, int k) {
		int n = arr.length;
		
		int maxSum = -1;
		int minSum = 99;
		int currSum = 0;
		for(int i=0; i<k; i++) {
			currSum += arr[i];
		}
		
		maxSum = currSum;
		minSum = currSum;
		
		for(int i=k; i<n; i++) {
			currSum += arr[i] - arr[i-k];
			if(currSum < minSum) minSum = currSum;
			if(currSum > maxSum) maxSum = currSum;
		}
		System.out.println("minSum = "+ minSum +" maxSum = "+ maxSum);
		return Math.abs(maxSum - minSum);
	}
	
	public static void main(String args[]) {
		System.out.println("Hello");
		int arr[] = {2, 5, -1, 7, -3, -1, -2};
		
		System.out.println(MaxSumDiff.findMax(arr, 4));
	}
}
