package test.prac.examples;

import java.util.HashMap;

public class HMTest3 {

	public static void main(String[] args) {

		HashMap<String, String> hm = new HashMap<>();
		hm.put("india", "new delhi");
		hm.put("japan", "tokyo");
		hm.put("france", "paris");
		hm.put("US", "washington");
		hm.put("UK", "england");
		
		System.out.println(hm);
		
		String val = hm.remove("india");
		System.out.println(val);
		String val2= hm.remove("canada");
		System.out.println(val2);
		
		System.out.println(hm);
		Boolean bol = hm.remove("france", "paris");
		System.out.println(bol);
		Boolean bol2= hm.remove("china", "bejing");
		System.out.println(bol2);
	
		System.out.println(hm);
		
		HashMap<String, Integer> hm2 = new HashMap<>();
		hm2.put("india", 1);
		hm2.put("japan", 2);
		System.out.println(hm2);
		Integer val3= hm2.remove("canada");
		System.out.println(val3);
		
		hm2.compute("india", (c, p) -> p+10);
		System.out.println(hm2);
		
		hm2.computeIfPresent("japan", (c, p) -> p+3);
		System.out.println(hm2);
		
		hm2.computeIfAbsent("india", value -> +1);
		System.out.println(hm2);
		
	}

}