package test.prac.examples;

import java.util.PriorityQueue;

public class PriorityQueue_NaturalOrder {

	public static void main(String[] args) {
		
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.offer("Z");
		pq.offer("D");
		pq.offer("H");
		pq.offer("A");
		pq.offer("M");
		pq.offer("E");
		pq.offer("A");
		pq.offer("a");
		pq.offer("aA");
		pq.offer("Aa");
		pq.offer("12");
		pq.offer("@#");
		
		System.out.println(pq);
		
		while(pq.size()>0) {
			System.out.println("Removed Element : " + pq.poll());
			//System.out.println(pq);
		}
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		pq2.offer(10);
		pq2.offer(100);
		pq2.offer(2);
		pq2.offer(555);
		pq2.offer(88);
	
		
		System.out.println("\n" + pq2);
		
		while(pq2.size()>0) {
			System.out.println("Removed Element : " + pq2.poll());
			//System.out.println(pq);
		}

	}

}
