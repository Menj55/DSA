package com.algo;

public class HeapSort {

	public void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	public void heapSort(int[] arr) {
		int n = arr.length;
		
		for(int i=n/2-1; i>=0; i--) {
			heapify(arr, i, n);
		}
		
		for(int i=n-1; i>0; i--) {
			swap(arr, 0, i);
			heapify(arr, 0, i);
		}
	}
	
	public void heapify(int arr[], int start, int n) {
		int largest = start;
		int left = 2*start+1;
		int right = 2*start+2;
		
		if(left < n && arr[left] > arr[largest]) {
			largest = left;
		}
		
		if(right < n && arr[right] > arr[largest]) {
			largest = right;
		}
		
		if(largest != start) {
			swap(arr,largest,start);
			heapify(arr, largest, n);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 23, 12, 9, 30, 2, 50};
		for(int a : arr) {
			System.out.print(a + "  ");
		}
		System.out.println();
		HeapSort h = new HeapSort();
		h.heapSort(arr);
				
		for(int a : arr) {
			System.out.print(a + "  ");
		}
		System.out.println();
	}

}
