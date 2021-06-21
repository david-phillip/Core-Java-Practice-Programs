package test.prac.examples;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HMtest2 {

	public static void main(String[] args) {
		
		HashMap<String, String> hm = new HashMap<>();
		hm.put("John", "India");
		hm.put("Matt", "US");
		hm.put("David", "UK");

		//forEach and Lambda
		hm.forEach((user, country) -> {
			System.out.println(user + ":" + country);
		});
		
		//Iterator
		System.out.println("--------------------------");
		Iterator<Entry<String, String>> iterator = hm.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey() + "::" + entry.getValue());
		}
		
		//For 
		System.out.println("--------------------------");
		for(Map.Entry<String, String> entry : hm.entrySet()) {
			System.out.println(entry.getKey() + ":::" + entry.getValue());
		}
		
	}

}
