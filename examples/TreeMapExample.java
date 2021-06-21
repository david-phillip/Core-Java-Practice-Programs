package test.prac.examples;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class TreeMapExample {
	
	public static void main(String[] args) {

		//By Default sorts in Natural sorting order
		TreeMap<String, Integer> tm = new TreeMap<>();
		tm.put("India", 10000);
		tm.put("France", 40000);
		tm.put("US", 80000);
		tm.put("Japan", 20000);
		tm.put("India", 40000);
		
		System.out.println("TreeMap : " +  tm);
		
		
		//Sort Key using key sorting by name order descending
		Comparator<Object> comparatorByNameDescending=new Comparator<Object>() {
			 
	        @Override
	        public int compare(Object obj1, Object obj2) {
	        	Country c1 = (Country) obj1;
	    		Country c2 = (Country) obj2;
	    		return c2.getName().compareTo(c1.getName());
	        }
	    };
		
		TreeMap<Country, Integer> tm2 = new TreeMap<>(comparatorByNameDescending);
		tm2.put(new Country("India"),10000);
		tm2.put(new Country("France"), 40000);
		tm2.put(new Country("US"), 80000);
		tm2.put(new Country("Japan"), 20000);
		tm2.put(new Country("India"), 30000);

		System.out.println("\nTreeMap2 : " +  tm2);
		
		
		//passing HM to TreeMap to sort based on keys
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("India", 10000);
		hm.put("France", 40000);
		hm.put("US", 80000);
		hm.put("Japan", 20000);
		hm.put("China", 40000);
		
		TreeMap<String, Integer> tm3 = new TreeMap<>(hm);
		
		System.out.println("\nTreeMap3 : " +  tm3);
	}
}
