package com.dp;

//Given a 2D boolean array, find the largest square subarray of
//true values. The return value should be the side length of the
//largest square subarray subarray.

public class MaxSquareSubmatrix {

	private int maxSubmatrixBottomUp(boolean[][] arr) {
		int max = 0;
		int n = arr.length;
		if(n == 0) return -1;
		int m = arr[0].length;
		int dp[][] = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]) {
					if(i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
					}
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		
		
		return max;
	}
	
	private int maxSubmatrixTopDown(boolean[][] arr, int i, int j, int[][] dp) {
		if(i == arr.length || j == arr[0].length)
			return 0;
		if(!arr[i][j])
			return 0;
		
		if(dp[i][j] > 0)
			return dp[i][j];
		
		dp[i][j] = 1 + Math.min(maxSubmatrixTopDown(arr, i+1, j,dp), 
				Math.min(maxSubmatrixTopDown(arr, i, j+1,dp), maxSubmatrixTopDown(arr, i+1, j+1,dp)));
		
		return dp[i][j];
	}
	
	private int maxSubmatrixTopDown(boolean[][] arr) {
		int n = arr.length;
		if(n==0)
			return -1;
		int m = arr[0].length;
		int[][] dp = new int[n][m];
		
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]) {
					max = Math.max(max, maxSubmatrixTopDown(arr,i,j,dp));
				}
			}
		}
		return max;
	}
	
	private int maxSubmatrix(boolean[][] arr) {
		int n = arr.length;
		if(n==0)
			return -1;
		int m = arr[0].length;
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]) {
					max = Math.max(max, maxSubmatrix(arr,i,j));
				}
			}
		}
		return max;
	}
	
	private int maxSubmatrix(boolean[][] arr,int i,int j) {
		if(i == arr.length || j == arr[0].length)
			return 0;
		if(!arr[i][j])
			return 0;
		
		return 1 + Math.min(maxSubmatrix(arr, i+1, j), 
				Math.min(maxSubmatrix(arr, i, j+1), maxSubmatrix(arr, i+1, j+1)));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] arr = {
				{false,true,false,false},
				{true,true,true,true},
				{false,true,true,true},
				{false,true,true,true}
		};
		MaxSquareSubmatrix m = new MaxSquareSubmatrix();
		System.out.println(m.maxSubmatrix(arr));
		System.out.println(m.maxSubmatrixTopDown(arr));
		System.out.println(m.maxSubmatrixBottomUp(arr));
	}

}
