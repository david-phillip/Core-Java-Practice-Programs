package test.prac.examples;

import java.util.HashSet;

public class HashSetExample {

	public static void main(String[] args) {

		HashSet<String> hs = new HashSet<>();
		hs.add("India");
		hs.add("US");
		hs.add("China");
		hs.add("Srilanka");
		hs.add("India");
		
		System.out.println("Hashset : " + hs);
		
		HashSet<Country> hs2 = new HashSet<>();
		hs2.add(new Country("India"));
		hs2.add(new Country("US"));
		hs2.add(new Country("India"));
		
		System.out.println("\nHashset2 : " + hs2);
	}

}
