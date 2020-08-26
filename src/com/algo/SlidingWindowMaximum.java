package com.algo;

public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return null;
        if(k == 1) return nums;
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        int index = 0;
        
        int previous = getMax(nums, 0, k);
        ans[index++] = previous;
        for(int i=1; i<=n-k; i++) {
            if(previous == nums[i-1]) {
                previous = getMax(nums, i, i+k);
            } else {
                previous = Math.max(previous, nums[i+k-1]);
            }
            
            ans[index++] = previous;
        }
        
        return ans;
    }
    
    public int getMax(int[] nums, int start, int end) {
        int max = nums[start];
        
        for(int i=start+1; i< end; i++) {
            max = Math.max(max, nums[i]);
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		SlidingWindowMaximum s = new SlidingWindowMaximum();
		int[] ans = s.maxSlidingWindow(arr, k);
		
		for(int a: ans) {
			System.out.print(a + "  ");
		}
	}

}
