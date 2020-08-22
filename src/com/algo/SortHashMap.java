package com.algo;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortHashMap {

	private static Map<Integer, Integer> sortByComparator(Map<Integer, Integer> unsortMap)
    {
		Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
		List<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Entry<Integer, Integer>>()
        {
            public int compare(Entry<Integer, Integer> o1,
                    Entry<Integer, Integer> o2)
            {
                   return o2.getValue().compareTo(o1.getValue());
            }
        });

        // Maintaining insertion order with the help of LinkedList
        
        for (Entry<Integer, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
	
	private Map<Integer, Integer> sortMapByValues(Map<Integer, Integer> unsorted) {
		Map<Integer, Integer> sorted = new LinkedHashMap<>();
		List<Entry<Integer,Integer>> keys = new LinkedList(unsorted.entrySet());
		
		Collections.sort(keys, new Comparator<Entry<Integer,Integer>>() {
			public int compare(Entry<Integer,Integer> o1, Entry<Integer,Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		for (Entry<Integer, Integer> entry : keys)
        {
			sorted.put(entry.getKey(), entry.getValue());
        }		
		return sorted;
	}
	
	private void printMap(Map<Integer, Integer> map) {
		
		Iterator<Entry<Integer, Integer> > it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Entry<Integer, Integer> entry = it.next();
			System.out.println(entry.getKey() + "  --  "+ entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> unsorted = new HashMap();
		
		SortHashMap sort = new SortHashMap();
		
		unsorted.put(1, 4);
		unsorted.put(2, 2);
		unsorted.put(3, 1);
		unsorted.put(4, 4);
		unsorted.put(5, 3);
		
		System.out.println("Unsorted Map ->");
		sort.printMap(unsorted);
		
		Map<Integer, Integer> sorted = sort.sortMapByValues(unsorted);//sortByComparator(unsorted);
		
		System.out.println("Sorted Map ->");
		sort.printMap(sorted);
	}

}
