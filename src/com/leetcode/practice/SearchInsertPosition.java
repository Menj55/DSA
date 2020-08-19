package com.leetcode.practice;

public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		if(nums.length < 1) return 0;
		if(target < nums[0]) return 0;
		if(target > nums[nums.length-1]) return nums.length;
		return binarySearch(nums,0,nums.length-1, target);
    }
	
	public int binarySearch(int [] nums, int start, int end, int target) {
		if(start > end) return -1;
		int mid = (start + end)/2;
		if(nums[mid] == target) {
			return mid;
		}
		if(mid < nums.length+2 && nums[mid] < target && nums[mid+1] > target) {
			return mid+1;
		}
		if(mid - 1 > 0 && nums[mid-1] < target && nums[mid] > target) {
			return mid;
		}
		if(nums[mid] > target)
			return binarySearch(nums, start, mid-1, target);
		return binarySearch(nums, mid+1, end, target);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInsertPosition s = new SearchInsertPosition();
		int nums[] = {1,3,5,7};
		System.out.println(s.searchInsert(nums, 6));
	}

}
