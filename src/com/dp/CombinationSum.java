package com.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CombinationSum {
	
	public List<List<Integer>> combinationSum(int[] arr, int target) {
		int n = arr.length;
        HashMap<Integer,List<List<Integer>>> map = new HashMap();
        map.put(0, null);
        for(int i=1; i<target; i++) {
        	map.put(i, new ArrayList());
        }
        for(int a : arr) {
        	List temp = new ArrayList();
        	temp.add(a);
        	List<List<Integer>> list = new ArrayList(); 
        	list.add(temp);
        	map.put(a, list);
        }
        
        for(int i=1; i<=target; i++) {
        	for(int a : arr) {
        		if(i-a >= 0) {
        			List<List<Integer>> ans = map.get(i-a);
        			List<List<Integer>> temp = map.get(i);
        			if(ans != null) {
        				for(List<Integer> l : ans) {
            				List arr2 = new ArrayList<>(l);
            				arr2.add(a);
            				Collections.sort(arr2);
            				if(temp != null) {
            					if(!temp.contains(arr2))
                					temp.add(arr2);
            				} else {
            					temp = new ArrayList();
            					temp.add(arr2);
            				}
            			}
            			map.put(i, temp);
        			}
        		}
        	}
        }
		return map.get(target);
	}

//	public List<List<Integer>> combinationSum(int[] arr, int target) {
//		int n = arr.length;
//		List<List<Integer>> ans = new ArrayList<List<Integer>>();
//        List<Integer> curr = new ArrayList<Integer>();
//		
//        for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				curr = checkSum(arr, i, j, target);
//				if(curr != null) {
//					ans.add(curr);
//				}
//			}
//		}
//		
//		return ans;
//	}
	
	public List<Integer> checkSum(int[] arr, int start, int end, int target) {
		int sum = 0;
		List<Integer> curr = new ArrayList<Integer>();
		for(int i=start; i<=end; i++) {
			sum += arr[i];
		}
		if(sum == target) {
			for(int i=start; i<= end; i++) {
				curr.add(arr[i]);
			}
			return curr;
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,5};
		CombinationSum s = new CombinationSum();
		List<List<Integer>> ans = s.combinationSum(arr, 8);
		System.out.println("Size = "+ ans.size());
		for(List<Integer> curr : ans) {
			for(Integer a : curr) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}

}
