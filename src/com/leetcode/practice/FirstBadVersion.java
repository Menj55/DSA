package com.leetcode.practice;

public class FirstBadVersion {

	
	
	public boolean isBadVersion(int i) {
		if(i >= 1702766719)
			return true;
		return false;
	}
	
	public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid = -1;
        while(left <= right) {
            mid = left + ( right - left ) / 2;
//            System.out.println(mid);
            if(!isBadVersion(mid)) {
            	left = mid + 1;
            } else {
            	if(!isBadVersion(mid-1)) {
            		return mid;
            	} else {
            		right = mid - 1;
            	}
            }
        }
        return mid;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] ans = new int[n+1];
		System.out.println(ans[n]);;
		FirstBadVersion f = new FirstBadVersion();
		System.out.println(f.firstBadVersion(2126753390));
	}

}
