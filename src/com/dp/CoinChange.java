package com.dp;


//Given an integer representing a given amount of change, write a
//function to compute the total number of coins required to make
//that amount of change

public class CoinChange {

	private int coinChangeTopDown(int[] coins, int value, int[] dp) {
		if(value == 0)
			return 0;
		if(coins.length == 0)
			return 0;
		if(dp[value] > 0) return dp[value];
		int minCoins = Integer.MAX_VALUE;
		for(int coin : coins) {
			if(value - coin >= 0) {
				minCoins = Math.min(minCoins, coinChangeTopDown(coins, value - coin, dp));
			}
		}
		
		dp[value] = minCoins + 1;
		return dp[value];
	}
	
	private int coinChangeBottomUp(int[] coins, int value) {
		int dp[] = new int[value+1];
		
		dp[0] = 0;
		
		for(int i=0; i<=value; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		for(int coin : coins) {
			if(coin <= value)
				dp[coin] = 1;
		}
		
		for(int i=1; i<=value; i++) {
			for(int coin : coins) {
				if(i - coin > 0) {
					if(dp[i-coin] < dp[i]) {
						dp[i] = 1 + dp[i-coin];
					}
				}
			}
		}
		
		return dp[value];
	}
	
	private int coinChangeRecursive(int[] coins, int value) {
		if(value == 0)
			return 0;
		if(coins.length == 0)
			return 0;
		int minCoins = Integer.MAX_VALUE;
		for(int coin : coins) {
			if(value - coin >= 0) {
				minCoins = Math.min(minCoins, coinChangeRecursive(coins, value - coin));
			}
		}
		
		return minCoins + 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[] = {1,6,2,10};
		CoinChange c = new CoinChange();
		int value = 9;
		int[] dp = new int[value+1];
		System.out.println(c.coinChangeRecursive(coins, value));
		System.out.println(c.coinChangeBottomUp(coins, value));
		System.out.println(c.coinChangeTopDown(coins, value, dp));
	}

}
