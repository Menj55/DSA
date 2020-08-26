package com.algo;

public class RotateKTimes {

	public static void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    
    public static void reverse(int[] nums, int start, int end) {
        int n = nums.length;
        while(start < end) {
        	int temp = nums[start];
        	nums[start] = nums[end];
        	nums[end] = temp;
        	start++;
        	end--;
        }
    }
    
	public static void main(String args[]) {
		int arr[] = {1,2,3,4,5,6,7,8,9};
		
		rotate(arr, 3);
		
		for(int a : arr) {
			System.out.print(a + "  ");
		}
	}
}
