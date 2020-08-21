package com.algo;

//Sort an array of 0'1, 1's and 2's
public class DutchNationalFlag {

	private void swap(int []arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	private void dutchFlagAlgo(int arr[]) {
		int n = arr.length;
		int low = 0;
		int mid = 0;
		int high = n-1;
		
		while(mid <= high) {
			if(arr[mid] == 0) {
				swap(arr,low,mid);
				low++; mid++;
			}
			
			if(arr[mid] == 1) {
				mid++;
			}
			
			if(arr[mid] == 2) {
				swap(arr,mid,high);
				high--;
			}
			
			
		}
	}
	
	private void byCount(int arr[]) {
		int n = arr.length;
		int countZero = 0;
		int countOne = 0;
		for(int i=0; i<n; i++) {
			if(arr[i] == 0) {
				countZero++;
			}
			if(arr[i] == 1) {
				countOne++;
			}
		}
		System.out.println("zero = "+countZero + " one = "+countOne + " two = "+ (n-countZero-countOne));
		int i = 0;
		while(countZero-- > 0) {
			arr[i++] = 0;
		}
		System.out.println("i = "+i);
		while(countOne-- > 0) {
			arr[i++] = 1;
		}
		System.out.println("i = "+i);
		while(i < n) {
			arr[i++] = 2;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,1,2,0,1,2,0,0,1,2,2,1,0,2,0,1,2,1};
		DutchNationalFlag d = new DutchNationalFlag();
		d.byCount(arr);
		for(int a: arr) {
			System.out.print(a + "  ");
		}
		System.out.println();
		d.dutchFlagAlgo(arr);
		for(int a: arr) {
			System.out.print(a + "  ");
		}
	}

}
