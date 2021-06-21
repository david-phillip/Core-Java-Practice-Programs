package test.prac.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class HashMapSort {

	public static void main(String[] args) {

		HashMap<Country, Integer> hm = new HashMap<>();
		hm.put(new Country("India"), 10);
		hm.put(new Country("France"), 40);
		hm.put(new Country("Japan"), 30);
		hm.put(new Country("US"), 20);
		
		System.out.println("HM : " + hm);
		
		//Sort by Key
		TreeMap<Country, Integer> tm = new TreeMap<>(hm);
		System.out.println("HM sorted by key: " + tm);
		
		//Sort by Key using comparator
		List<Entry<Country, Integer>> list2 = new ArrayList<>(hm.entrySet());
		Collections.sort(list2, new Comparator<Entry<Country, Integer>>(){
			 @Override
		        public int compare(Entry<Country, Integer> obj1, Entry<Country, Integer> obj2) {
		    		return obj1.getKey().getName().compareTo(obj2.getKey().getName());
		        }
		});
		
		LinkedHashMap<Country, Integer> lhm2 = new LinkedHashMap<>(); 
		for(Entry<Country, Integer> l : list2){
			lhm2.put(l.getKey(), l.getValue());
		}
		System.out.println("HM sorted by keys comparator: " + lhm2);
		
		
		//Sort by Value
		List<Entry<Country, Integer>> list = new ArrayList<>(hm.entrySet());
		
		Collections.sort(list, new Comparator<Entry<Country, Integer>>(){
			 @Override
		        public int compare(Entry<Country, Integer> obj1, Entry<Country, Integer> obj2) {
		    		return obj1.getValue().compareTo(obj2.getValue());
		        }
		});
		
		LinkedHashMap<Country, Integer> lhm = new LinkedHashMap<>(); 
		for(Entry<Country, Integer> l : list){
			lhm.put(l.getKey(), l.getValue());
		}
		System.out.println("HM sorted by values: " + lhm);
		
		}
}
