package com.dp;

//Find the n'th Fibonnaci number
//fibonacci(int num) -> time complexity: O(2^n) , Space Complexity: O(depth + width)
//fibonacciTopDown(int num, int[] dp) -> time complexity: O(n) , Space Complexity: O(n)
//fibonacciBottomUp(int num, int[] dp) -> time complexity: O(n) , Space Complexity: O(n)

public class FibonacciNumber {

	private int fibonacci(int num) {
		if(num == 0)
			return 0;
		if(num == 1)
			return 1;
		
		return fibonacci(num-1) + fibonacci(num-2);
	}
	
	private int fibonacciTopDown(int num, int[] dp) {
		if(num == 0)
			return 0;
		if(dp[num] > 0)
			return dp[num];
		
		dp[num] = fibonacciTopDown(num-1, dp) + fibonacciTopDown(num-2, dp);
		return dp[num];
	}
	
	private int fibonacciBottomUp(int num) {
		int[] dp = new int[num+1];
		dp[1] = 1;
		for(int i=2; i<=num; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[num];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 10;
		FibonacciNumber f = new FibonacciNumber();
		System.out.println(f.fibonacci(num));
		
		int[] dp = new int[num+1]; //Since array is 0 indexed
		dp[1] = 1;
		
		System.out.println(f.fibonacciTopDown(num,dp));
		System.out.println(f.fibonacciBottomUp(num));
	}

}
