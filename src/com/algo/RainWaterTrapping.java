package com.algo;

public class RainWaterTrapping {

	public int optimised(int arr[]) {
		int result = 0;
		int n = arr.length;
		int prev = arr[0];
		int index = 0;
		int temp = 0;
		
		for(int i=0; i< n; i++) {
			if(arr[i] >= prev) {
				temp = 0;
				prev = arr[i];
				index = i;
			} else {
				result += prev - arr[i];
				temp += prev - arr[i];
			}
		}
		
		if(index < n-1) {
			result -= temp;
			
			prev = arr[n-1];
			
			for(int i=n-1; i>= index; i--) {
				if(arr[i] >= prev) {
					prev = arr[i];
				} else {
					result += prev - arr[i];
				}
			}
		}
		
		return result;
	}
	
	public int solution(int arr[]) {
		int result = 0;
		int n = arr.length;
		int[] left = new int[n];
		int[] right = new int[n];
		int max = arr[0];
		for(int i=0; i<n; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
			left[i] = max;
		}
		max = arr[n-1];
		for(int j=n-1;j>=0; j--) {
			if(arr[j] > max) {
				max = arr[j];
			}
			
			right[j] = max;
		}
		
		for(int i=0; i<n; i++) {
			result += Math.min(left[i], right[i]) - arr[i];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RainWaterTrapping r = new RainWaterTrapping();
		int arr[] = {3,0,0,2,0,4,0,0,2,0,0,3,0,2};
		
		System.out.println(r.solution(arr));
		
		System.out.println(r.optimised(arr));
	}

}
