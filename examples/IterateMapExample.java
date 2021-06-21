package test.prac.examples;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class IterateMapExample {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		map.put("kohli", "ind");
		map.put("steve", "aus");
		map.put("root", "eng");
		map.put("willamson", "nz");
		
		//Using keyset and for
		Set<String> set = map.keySet();
		for(String s: set)
			System.out.println("Key:"+ s +":" + "Value:" + map.get(s));
		
		//Using keyset and iterator
		System.out.println("\n");
		Iterator<String> itr = map.keySet().iterator();
		while(itr.hasNext()) {
			String k = itr.next();
			System.out.println("Key:"+ k +":" + "Value:" + map.get(k));
		}
		
		//Using entrySet and for
		System.out.println("\n");
		for(Entry<String, String> entry : map.entrySet()) {
			System.out.println("Key:"+ entry.getKey() +":" + "Value:" + entry.getValue());
		}
		
		//Using entrySet and iterator
		System.out.println("\n");
		Iterator<Entry<String, String>> itr2 = map.entrySet().iterator();
		while(itr2.hasNext()) {
			Entry<String, String> es = itr2.next();
			System.out.println("Key:"+ es.getKey() +":" + "Value:" + es.getValue());
		}
		
	}

}
