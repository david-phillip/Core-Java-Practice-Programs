package test.prac.examples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class FrequencyCharStr {

	public static void main(String[] args) {

		//get char from the string
		String str = "Hello david phillip";
		char[] charArray = str.toCharArray();
		HashMap<Character, Integer> hm = new HashMap<>();
		
		//put the char in HM, with count 1
		//increment the count if already present
//		for(int i=0; i<charArray.length; i++) {
//			
//			if(hm.containsKey(charArray[i])) {
//				hm.put(charArray[i], hm.get(charArray[i])+1);
//			}
//			else {
//				hm.put(charArray[i], 1);
//			}
//		}
		
		//Using compute
		for(int i=0; i<charArray.length; i++) {
			hm.computeIfPresent(charArray[i], (c, count) -> count+1);
			hm.computeIfAbsent(charArray[i], value -> 1);
		}
		
		Set<Entry<Character, Integer>> entry_set = hm.entrySet();
		System.out.println("entry_set : " + entry_set);
		
		Set<Character> keys = hm.keySet();
		System.out.println("key set : " + keys);
		
		Collection<Integer> vals = hm.values();
		System.out.println("vals : " + vals + "\n");
		
		//iterate thru HM and print the key/value count
		Iterator<Entry<Character, Integer>> itr = hm.entrySet().iterator();
		while(itr.hasNext()) {
			Entry<Character, Integer> entrySet = (Entry<Character, Integer>) itr.next();
			System.out.println("Char: " + entrySet.getKey() + 
								", Val: " + entrySet.getValue());
		}
		
		System.out.println("\n");
		hm.entrySet().forEach((entry) -> {
										 System.out.println(entry.getKey() + ":" + entry.getValue());
									     }
							  );
	}

}
