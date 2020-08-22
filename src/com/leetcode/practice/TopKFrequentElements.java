package com.leetcode.practice;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopKFrequentElements {

	public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        Map<Integer,Integer> map= new HashMap();
        for(int i=0; i<n; i++) {
            Integer temp = map.get(nums[i]);
            
            if(temp == null)
                temp = 1;
            else
                temp++;
            map.put(nums[i],temp);
        }
        
        Map<Integer, Integer> sorted = sortMapByValues(map);
        int i = 0;
        Iterator<Map.Entry<Integer, Integer> > it = map.entrySet().iterator();
		
		return getTopKElements(sorted, k);
}
    
    private Map<Integer, Integer> sortMapByValues(Map<Integer, Integer> unsorted) {
		Map<Integer, Integer> sorted = new LinkedHashMap<>();
		List<Map.Entry<Integer,Integer>> keys = new LinkedList(unsorted.entrySet());
		
		Collections.sort(keys, new Comparator<Map.Entry<Integer,Integer>>() {
			public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2){
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		for (Map.Entry<Integer, Integer> entry : keys)
        {
			sorted.put(entry.getKey(), entry.getValue());
        }		
		return sorted;
	}
    
    private int[] getTopKElements(Map<Integer, Integer> map, int k) {
		
		Iterator<Map.Entry<Integer, Integer> > it = map.entrySet().iterator();
		int arr[] = new int[k];
		int i = 0;
		while(it.hasNext()) {
			Map.Entry<Integer, Integer> entry = it.next();
			if(k-- > 0) {
				arr[i++] = entry.getKey();
			} else {
				break;
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,1,-1,2,-1,2,3};
		int k =	2;
		TopKFrequentElements t = new TopKFrequentElements();
		
		int temp[] = t.topKFrequent(arr, k);
		
		for(int a : temp) {
			System.out.print(a + "  ");
		}
	}

}
