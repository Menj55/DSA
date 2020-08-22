package com.algo;

public class AllSubarray {

	private static void printAllSubarray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				for(int z=i; z<=j; z++) {
					System.out.print(arr[z] + " ");
					if(z == j) {
						System.out.println();
					}
						
				}
			}
		}
	}
	
	static public  void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3,4,1,5};
		
		printAllSubarray(arr);
	}

}
