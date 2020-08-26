package com.algo;

public class SmallestContigiousSubarraySum {

	private static void printMinSubarrays(int[] arr, int sum) {

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
	
	private static int minSubarray(int[] arr, int sum) {

		int n = arr.length;
		
		int start = 0;
		
		int end = 0;
		
		int currSum = 0;
		
		int minSize = Integer.MAX_VALUE;
		
//		for(end = start; end <n; end++) {
//			currSum += arr[end];
//			
//			if(currSum >= sum)
//				break;
//		}
//		minSize = end - start + 1;
//		System.out.println("MinSize = " + minSize);
		for(end = 0; end<n;end++) {
			currSum += arr[end];
			
			while(currSum >= sum) {
				minSize = Math.min(minSize, end-start+1);
				currSum -= arr[start];
				start++;
			}
			
			
			
//			System.out.println("Start = " + start +" End = "+ end);
//			if(minSize > end-start+1) {
//				minSize = end-start+1;
//			}
		}
		
		return minSize;
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {3, 4, 1, 1, 6};
		int sum = 8;
		printMinSubarrays(arr, sum);
		System.out.println();
		
		System.out.println("Min Sisze is :");
		System.out.println(minSubarray(arr, sum));
		
	}

}
