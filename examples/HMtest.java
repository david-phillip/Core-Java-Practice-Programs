package test.prac.examples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HMtest {
	
	public static void main(String args[]) {
		
		HashMap<String, String> hm = new HashMap<>();
		hm.put("John", "India");
		hm.put("Matt", "US");
		hm.put("David", "UK");
		
		Set<Entry<String, String>> entrySet = hm.entrySet();
		System.out.println(entrySet);
		
		Set<String> keySet = hm.keySet();
		System.out.println(keySet);
		
		Collection<String> values = hm.values();
		System.out.println(values);
	}

}
