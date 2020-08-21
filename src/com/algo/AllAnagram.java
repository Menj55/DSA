package com.algo;

import java.util.ArrayList;
import java.util.List;

//Find All Anagrams/Permutaations of a Given String and Array
public class AllAnagram {

	private String swap(String str, int x, int y) {
		char[] arr = str.toCharArray();
		char temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		return String.valueOf(arr);
	}
	
	private void swapInt(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	private void findAllAnagramArr(int arr[], int start, int end) {
		if(start == end) {
			for(int a : arr) {
				System.out.print(a + " ");
			}
			System.out.println();
		} else {
			for(int i=start; i<= end; i++) {
				swapInt(arr,start,i);
				findAllAnagramArr(arr, start + 1, end);
				swapInt(arr, start, i);
			}
		}
	}
	
	private void findAllAnagram(String str, int start, int end, List<String> list) {
		if(start == end) {
			if(!list.contains(str))
				list.add(str);
		} else {
			for(int i=start; i<=end; i++) {
				str = swap(str, start,i);
				findAllAnagram(str, start+1, end, list);
				str = swap(str,start,i);
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "123";
		AllAnagram a = new AllAnagram();
		List<String> list = new ArrayList<>();
		a.findAllAnagram(str,0,str.length()-1, list);
		list.forEach(x -> {
			System.out.println(x);
		});
		System.out.println(list.size());
		int arr[] = {1,2,3};
		a.findAllAnagramArr(arr, 0, arr.length-1);
	}

}
