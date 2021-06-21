package test.prac.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class HMToArrayList {

	public static void main(String[] args) {
		
		HashMap<Country, Integer> hm = new HashMap<>();
		hm.put(new Country("India"), 100);
		hm.put(new Country("US"), 200);
		hm.put(new Country("UK"), 300);
		
		System.out.println("\nHashmap: " + hm);
		
		//Using stream
		List<Country> ls = hm.keySet().stream().collect(Collectors.toList());
		List<Integer> ls2 = hm.values().stream().collect(Collectors.toList());
		List<Entry<Country, Integer>> ls3 = hm.entrySet().stream().collect(Collectors.toList());

		System.out.println(ls);
		System.out.println(ls2);
		System.out.println(ls3);

		//Using Arraylist constructor
		List<Country> ls4 = new ArrayList<>(hm.keySet());
		List<Integer> ls5 = new ArrayList<>(hm.values());
		List<Entry<Country, Integer>> ls6 = new ArrayList<>(hm.entrySet());
		
		System.out.println(ls4);
		System.out.println(ls5);
		System.out.println(ls6);
		
		
		int[] i = new int[10];
	}

}
