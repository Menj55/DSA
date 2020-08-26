package com.algo;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket {

	private static int maxFruits(char[] fruits) {
		int basket = 2;
		int max = Integer.MIN_VALUE;
		int distinct = 0;
		Map<Character, Integer> map = new HashMap();
		int start = 0;
		
		for(int i=0; i<fruits.length; i++) {
			
			Integer fruit = map.get(fruits[i]);
			
			if(fruit == null || fruit < 1) {
				map.put(fruits[i], 1);
				distinct++;
			} else {
				map.put(fruits[i], fruit + 1);
			}
			
			while(distinct > basket) {
				Integer startFruit = map.get(fruits[start]);
				
				if(startFruit == 1) {
					map.put(fruits[start], startFruit - 1);
					distinct--;
					start++;
				} else {
					map.put(fruits[start], startFruit - 1);
					start++;
				}
			}
			
			max = Math.max(max, i - start + 1);
		}
		
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] fruits = {'A', 'B', 'C', 'B', 'B', 'C'};
		System.out.println(maxFruits(fruits));
	}

}
