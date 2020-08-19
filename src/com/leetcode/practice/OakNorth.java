package com.leetcode.practice;

public class OakNorth {

	private int findSolution(int[] arr) {
		int n = arr.length;
		int ans = 0;
		int completedGlobal = 0;
		int completedLocal = 0;
		int count = -1;
		int[] temp = arr;
		for(int i=0;i<n;i++) {
			for(int p=0;p<n;p++) {
				temp[p] = arr[p];
			}
			count = -1;
			completedLocal = 0;
			for(int j=i;j<n;j++) {
				System.out.println("J = "+j);
				count = count + 1;
				temp[j] = temp[j] - count;
			}
			for(int z=0;z<i;z++) {
				System.out.println("Z = "+z);
				count = count + 1;
				temp[z] = temp[z] - count;
			}
			for(int l=0 ; l<n; l++) {
				System.out.print(temp[l] + "  ");
			}
			System.out.println();
			for(int j=0; j<n;j++) {
				if(temp[j] < 1) {
					completedLocal++;
				}
			}
//			System.out.println(completedGlobal + "  - "+ completedLocal);
			if(completedLocal > completedGlobal) {
				completedGlobal = completedLocal;
				ans = i;
			}
			System.out.println("End-----");
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {2,0,1};
		OakNorth o = new OakNorth();
		System.out.println(o.findSolution(arr));
	}

}
