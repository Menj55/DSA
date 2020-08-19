package com.algo;

public class MinCoin {

	private int makeChange(int []coins, int n) {
		int mem[] = new int[n+1];
		
		for(int i=0; i<=n; i++) {
			mem[i] = Integer.MAX_VALUE;
		}
		
		for(int coin : coins) {
			
			if(coin <= n )
				mem[coin] = 1;
		}
		
		mem[0] = 0;
		for(int i=1; i<=n; i++) {
			for(int coin: coins) {
				if(i-coin >= 0 && mem[i] > 1 + mem[i-coin]) {
					mem[i] = 1 + mem[i-coin];
				}
			}
		}
		for(int i=0; i<n; i++) {
			
		}
		
		return mem[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int coins[] = {2};
		MinCoin m = new MinCoin();
		System.out.println(m.makeChange(coins, 4));
		
	}

}
