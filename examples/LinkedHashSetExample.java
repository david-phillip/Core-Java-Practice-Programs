package test.prac.examples;

import java.util.LinkedHashSet;

public class LinkedHashSetExample {

	public static void main(String[] args) {

		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		lhs.add("India");
		lhs.add("France");
		lhs.add("US");
		lhs.add("China");
		lhs.add("India");

		System.out.println(lhs);
		
		LinkedHashSet<Country> lhs2 = new LinkedHashSet<>();
		lhs2.add(new Country("India"));
		lhs2.add(new Country("France"));
		lhs2.add(new Country("US"));
		lhs2.add(new Country("China"));
		lhs2.add(new Country("India"));

		System.out.println(lhs2);


	}

}
