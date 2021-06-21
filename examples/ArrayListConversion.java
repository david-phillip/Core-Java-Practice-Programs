package test.prac.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ArrayListConversion {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("abc");
		list.add("def");
		list.add("xyz");
		
		//Arraylist to Array 
		String[] str_array = list.toArray(new String[list.size()]);
		for(String s: str_array)
			System.out.println(s);
		
		//Array to ArrayList
		List<String> list2 = Arrays.asList(str_array);
		System.out.println(list2);
	}
}
